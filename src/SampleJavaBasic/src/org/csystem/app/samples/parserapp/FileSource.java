package org.csystem.app.samples.parserapp;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSource implements ISource, Closeable {
    private final BufferedReader m_bufferedReader;

    public FileSource(String source) throws IOException
    {
        m_bufferedReader = Files.newBufferedReader(Path.of(source));
    }

    @Override
    public int getChar()
    {
        try {
            return m_bufferedReader.read();
        }
        catch (IOException ex) {
            throw new RuntimeException("getChar", ex);
        }
    }

    @Override
    public void close() throws IOException
    {
        m_bufferedReader.close();
    }
}
