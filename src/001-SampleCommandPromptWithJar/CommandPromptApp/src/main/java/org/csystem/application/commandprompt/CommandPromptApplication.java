package org.csystem.application.commandprompt;

public final class CommandPromptApplication {
    private CommandPromptApplication()
    {
    }

    public static void run()
    {
        CommandPrompt commandPrompt = new CommandPrompt("CSD");

        commandPrompt.run();
    }
}
