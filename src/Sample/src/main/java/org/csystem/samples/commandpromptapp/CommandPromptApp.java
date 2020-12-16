package org.csystem.samples.commandpromptapp;

import org.csystem.util.commandprompt.CommandPrompt;

public final class CommandPromptApp {
    private CommandPromptApp()
    {
    }

    public static void run()
    {
        var commandPrompt = new CommandPrompt();

        commandPrompt
                .setPrompt("CSD")
                .setPromptPostfix("$")
                .setWrongNumberOfArgumentsMessage("Komutta hatalı parametre kullanımı")
                .register(new CommandsInfo(commandPrompt))
                .run();
    }
}
