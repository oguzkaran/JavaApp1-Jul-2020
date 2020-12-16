package org.csystem.util.commandprompt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommandPrompt {
    private Object m_regObject;
    private final Scanner m_kb = new Scanner(System.in);
    private final ArrayList<MethodCallInfo> m_methodCallInfos = new ArrayList<>();
    private Method m_errorMethod;
    private String m_prompt = "csd";
    private String m_promptPostfix = ">";
    private String m_paramsStringTypeErrorMessage = "Method parameters must be a string";
    private String m_wrongNumberOfArgumentsMessage = "Wrong number of Arguments";
    private String m_invalidCommandMessage = "Invalid Command";

    private static class MethodCallInfo {
        public String commandText;
        public Method method;
        public int argCount;

        public MethodCallInfo(String commandText, Method method, int argCount)
        {
            this.commandText = commandText;
            this.method = method;
            this.argCount = argCount;
        }
    }

    private static boolean areAllString(Parameter [] parameters)
    {
        for (Parameter parameter : parameters)
            if (parameter.getParameterizedType() != String.class)
                return false;

        return true;
    }

    private void registerCommands(Command [] commands, Method method)
    {
        for (Command command : commands) {
            String value = command.value();
            String commandText = value.isEmpty() ? method.getName() : value;
            Parameter [] parameters = method.getParameters();

            if (!areAllString(parameters))
                throw new IllegalArgumentException(m_paramsStringTypeErrorMessage);

            m_methodCallInfos.add(new MethodCallInfo(commandText, method, parameters.length));
        }
    }

    private void runCommands(String [] args, String [] params) throws InvocationTargetException, IllegalAccessException
    {
        boolean flag = false;
        boolean argsFlag = false;

        for (var methodCallInfo : m_methodCallInfos) {
            if (methodCallInfo.commandText.equals(args[0])) {
                flag = true;
                argsFlag = true;
                if (methodCallInfo.argCount != params.length) {
                    argsFlag = false;
                    continue;
                }
                methodCallInfo.method.setAccessible(true);
                methodCallInfo.method.invoke(m_regObject, params);
                methodCallInfo.method.setAccessible(false);
                break;
            }
        }
        if (!flag) {
            if (m_errorMethod != null) {
                m_errorMethod.setAccessible(true);
                m_errorMethod.invoke(m_regObject, null);
                m_errorMethod.setAccessible(false);
            }
            else
                System.err.println(m_invalidCommandMessage);
        }
        else if (!argsFlag)
            System.err.println(m_wrongNumberOfArgumentsMessage);
    }

    public String getPrompt()
    {
        return m_prompt;
    }

    public CommandPrompt setPrompt(String prompt)
    {
        m_prompt = prompt;

        return this;
    }

    public String getPromptPostfix()
    {
        return m_promptPostfix;
    }

    public CommandPrompt setPromptPostfix(String promptPostfix)
    {
        m_promptPostfix = promptPostfix;

        return this;
    }

    public String getParamsStringTypeErrorMessage()
    {
        return m_paramsStringTypeErrorMessage;
    }

    public CommandPrompt setParamsStringTypeErrorMessage(String paramsStringTypeErrorMessage)
    {
        m_paramsStringTypeErrorMessage = paramsStringTypeErrorMessage;

        return this;
    }

    public String getWrongNumberOfArgumentsMessage()
    {
        return m_wrongNumberOfArgumentsMessage;
    }

    public CommandPrompt setWrongNumberOfArgumentsMessage(String wrongNumberOfArgumentsMessage)
    {
        m_wrongNumberOfArgumentsMessage = wrongNumberOfArgumentsMessage;

        return this;
    }

    public String getInvalidCommandMessage()
    {
        return m_invalidCommandMessage;
    }

    public CommandPrompt setInvalidCommandMessage(String invalidCommandMessage)
    {
        m_invalidCommandMessage = invalidCommandMessage;

        return this;
    }

    public CommandPrompt register(Object regObject)
    {
        m_regObject = regObject;
        Class<?> regObjectClass = m_regObject.getClass();
        Method [] methods = regObjectClass.getDeclaredMethods();

        for (Method method : methods) {
            Command [] commands = method.getAnnotationsByType(Command.class);

            if (commands.length == 0) {
                if (m_errorMethod == null && method.getDeclaredAnnotation(CommandError.class) != null && method.getParameters().length == 0)
                    m_errorMethod = method;

                continue;
            }

            registerCommands(commands, method);
        }

        return this;
    }

    public void run()
    {
        try {
            for (;;) {
                System.out.print(m_prompt + m_promptPostfix);
                String cmd = m_kb.nextLine().trim();

                if (cmd.isEmpty())
                    continue;

                String [] args = cmd.split("[ \t]+");
                String [] params = Arrays.copyOfRange(args, 1, args.length);

                runCommands(args, params);
            }
        }
        catch (Throwable ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
