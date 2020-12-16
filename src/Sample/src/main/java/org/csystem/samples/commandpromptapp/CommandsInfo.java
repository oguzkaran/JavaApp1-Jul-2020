package org.csystem.samples.commandpromptapp;

import org.csystem.util.commandprompt.Command;
import org.csystem.util.commandprompt.CommandError;
import org.csystem.util.commandprompt.CommandPrompt;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CommandsInfo {
    private final CommandPrompt m_commandPrompt;
    private long m_length;

    private void doCopy(Path source, Path destination)
    {
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Throwable ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void calculateLength(File dir)
    {
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                calculateLength(file);

           m_length += file.length();
        }
    }


    private void listAllFiles(File dir)
    {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                System.out.printf("%s <DIR>%n", file.getName());
                listAllFiles(file);
            }

            if (file.isFile())
                System.out.printf("%s%n", file.getName());
        }
    }

    public CommandsInfo(CommandPrompt commandPrompt)
    {
        m_commandPrompt = commandPrompt;
    }

    @Command
    public void clear()
    {
        for (int i = 0; i < 25; ++i)
            System.out.println();
    }

    @Command("ls")
    @Command("dir")
    private void list()
    {
        for (File file : new File(".").listFiles()) {
            String name = file.getName();

            System.out.printf("%s%s%n", name, file.isDirectory() ? " <DIR>" : "");
        }
    }


    @Command("ls")
    @Command("dir")
    private void list(String path)
    {
        var dir = new File(path);
        if (!dir.isDirectory()) {
            System.err.println("Belirtilen yol dizin göstermiyor");
            return;
        }

        for (File file : dir.listFiles()) {
            String name = file.getName();

            System.out.printf("%s%s%n", name, file.isDirectory() ? " <DIR>" : "");
        }
    }

    @Command("ls")
    @Command("dir")
    private void list(String option, String path)
    {
        var dir = new File(path);

        if (!dir.isDirectory()) {
            System.err.println("Belirtilen yol dizin göstermiyor");
            return;
        }

        if (option.equals("-s"))
            listAllFiles(dir);
    }

    @Command
    private void size(String path)
    {
        var dir = new File(path);

        m_length = 0;
        if (dir.exists()) {
            if (dir.isDirectory()) {
                calculateLength(dir);
                System.out.printf("Length:%d%n", m_length);
            }
            else
                System.err.printf("%s bir dizin belirtmiyor%n", dir.getName());
        }
        else
            System.err.println("Geçersiz yol ifadesi");
    }


    @Command("change")
    public void changePrompt(String prompt)
    {
        m_commandPrompt.setPrompt(prompt);
    }

    @Command
    @Command("cp")
    public void copy(String source, String destination)
    {
        doCopy(Path.of(source), Path.of(destination));
    }

    @Command
    @Command("exit")
    @Command("leave")
    public void quit()
    {
        System.out.println("C ve Sistem Programcıları Derneği");
        System.exit(0);
    }

    @CommandError
    private void displayError()
    {
        System.err.println("Geçersiz komut");
    }
}
