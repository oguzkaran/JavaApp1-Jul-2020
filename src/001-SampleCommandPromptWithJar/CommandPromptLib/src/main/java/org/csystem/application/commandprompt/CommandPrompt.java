package org.csystem.application.commandprompt;

import org.csystem.commandpromptapp.common.TextInfo;
import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;
import org.csystem.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.csystem.application.commandprompt.Global.COMMAND_STRINGS;

public class CommandPrompt {
    private final ArrayList m_textInfoList;
    private final Random m_random = new Random();

    private String m_prompt;

    private static String getCommandByText(String text)
    {
        if (text.length() < 3)
            return "";

        for (String s : COMMAND_STRINGS)
            if (s.startsWith(text))
                return s;

        return "";
    }

    private void lengthProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            Console.writeLine("length bir tane argüman almalıdır");
            return;
        }

        Console.writeLine(commandsStr[1].length());
    }

    private void reverseProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            Console.writeLine("revere bir tane argüman almalıdır");
            return;
        }

        Console.writeLine(StringUtil.reverse(commandsStr[1]));
    }

    private void upperProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            Console.writeLine("upper bir tane argüman almalıdır");
            return;
        }
        Console.writeLine(commandsStr[1].toUpperCase());
    }

    private void lowerProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            Console.writeLine("lower bir tane argüman almalıdır");
            return;
        }
        Console.writeLine(commandsStr[1].toLowerCase());
    }

    private void changeProc(String [] commandsStr)
    {
        if (commandsStr.length != 2) {
            Console.writeLine("change bir tane argüman almalıdır");
            return;
        }
        m_prompt = commandsStr[1];
    }

    private void clsProc(String [] commandsStr)
    {
        for (int i = 0; i < 30; ++i)
            Console.writeLine();
    }

    private void getTextProc(String [] commandsStr)
    {
        if (commandsStr.length != 1) {
            Console.writeLine("gettext hiç argüman almamalıdır");
            return;
        }

        Console.writeLine("Bu menüden çıkmak için quit yazınız");
        for (;;) {
            String text = Console.read("Yazıyı giriniz:");

            if (text.equals("quit"))
                break;

            m_textInfoList.add(new TextInfo(text));
        }
    }

    private ArrayList getTextList()
    {
        var textList = new ArrayList();

        for (Object obj : m_textInfoList)
            textList.add(((TextInfo)obj).getText());

        return textList;
    }

    private void joinProc(String [] commandsStr)
    {
        if (commandsStr.length > 2) {
            Console.writeLine("join en fazla 2(iki) argüman alabilir");
            return;
        }

        if (m_textInfoList.isEmpty()) {
            Console.writeLine("Listede hiç yazı yok");
            return;
        }


        String str = ArrayUtil.join(getTextList(), commandsStr.length == 1 ? " " : commandsStr[1]);

        Console.writeLine(str);
    }

    private void generateProc(String [] commandStr)
    {
        try {
            var arguments = Arrays.copyOfRange(commandStr, 1, commandStr.length);
            var generateCommandController = new GenerateCommandController(m_random, m_textInfoList,  m_prompt + ">", arguments);

            //GenerateController timer kullandığında "gen p 1 10 20" komutu için bekleme yapılmıyor
            generateCommandController.doWork();
        }
        catch (NumberFormatException ex) {
            Console.writeLine("generate komutu için geçersiz argümanlar");
        }
        catch (IllegalArgumentException ex) {
            Console.writeLine("generate komutu için geçersiz argüman sayısı");
        }
        catch (Throwable ex) {
            Console.writeLine("generate komutunda içsel bir hata oluştu:");
        }
    }

    private void listProc(String [] commandStr)
    {
        try {
            var arguments = Arrays.copyOfRange(commandStr, 1, commandStr.length);
            var listCommandController = new ListCommandController(m_textInfoList, arguments);

            listCommandController.doWork();
        }
        catch (NumberFormatException ex) {
            Console.writeLine("list komutu için geçersiz argümanlar");
        }
        catch (IllegalArgumentException ex) {
            Console.writeLine("list komutu için geçersiz argüman sayısı");
        }
        catch (Throwable ex) {
            Console.writeLine("list komutunda içsel bir hata oluştu:");
        }
    }

    private void clearProc(String [] commandsStr)
    {
        if (commandsStr.length > 1) {
            Console.writeLine("join 1(bir) den fazla argüman alamaz");
            return;
        }

        m_textInfoList.clear();
    }

    private void doWorkForCommand(String [] commandInfoStr)
    {
        switch (commandInfoStr[0]) {
            case "length":
                lengthProc(commandInfoStr);
                break;
            case "reverse":
                reverseProc(commandInfoStr);
                break;
            case "upper":
                upperProc(commandInfoStr);
                break;
            case "lower":
                lowerProc(commandInfoStr);
                break;
            case "change":
                changeProc(commandInfoStr);
                break;
            case "cls":
                clsProc(commandInfoStr);
                break;
            case "gettext":
                getTextProc(commandInfoStr);
                break;
            case "join":
                joinProc(commandInfoStr);
                break;
            case "generate":
                generateProc(commandInfoStr);
                break;
            case "list":
                listProc(commandInfoStr);
                break;
            case "clear":
                clearProc(commandInfoStr);
                break;
        }
    }

    private void parseCommand(String [] commandInfoStr)
    {
        String cmd = getCommandByText(commandInfoStr[0]);

        if (!cmd.isEmpty()) {
            commandInfoStr[0] = cmd;
            doWorkForCommand(commandInfoStr);
        }
        else
            Console.writeLine("Geçersiz komut");
    }

    public CommandPrompt(String p)
    {
        m_prompt = p;
        m_textInfoList = new ArrayList();
    }

    public void run()
    {
        Console.writeLine("C ve Sistem Programcıları Derneği");

        for (;;) {
            String cmd = Console.read(m_prompt + ">").trim();

            if (cmd.equals("quit"))
                break;

            parseCommand(cmd.split("[ \t]+"));
        }

        Console.writeLine("C ve Sistem Programcıları Derneği");
        Console.writeLine("Tekrar yapıyor musunuz?");
    }
}
