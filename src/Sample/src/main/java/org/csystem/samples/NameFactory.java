package org.csystem.samples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public final class NameFactory {
    private List<String> m_names;
    private String [] m_namesArray;

    private NameFactory()
    {
    }

    public static NameFactory loadFromFile(String path) throws IOException
    {
        var nameFactory = new NameFactory();

        nameFactory.m_names = Files.lines(Path.of(path), StandardCharsets.UTF_8).skip(1).collect(Collectors.toList());

        return nameFactory;
    }

    public static NameFactory loadFromFileAsArray(String path) throws IOException
    {
        var nameFactory = new NameFactory();

        nameFactory.m_namesArray = Files.lines(Path.of(path), StandardCharsets.UTF_8).skip(1).toArray(String[]::new);

        return nameFactory;
    }

    public List<String> getNames()
    {
        return m_names;
    }

    public String [] getNamesAsArray()
    {
        return m_namesArray;
    }
}
