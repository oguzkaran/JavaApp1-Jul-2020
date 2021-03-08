package org.csystem.application.randomgeneratortofile.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Configuration
public class FileOutputConfig {
    @Value("${file.textname}")
    private String m_textFilename;

    @Value("${file.binaryname}")
    private String m_binaryFilename;

    @Bean
    public BufferedWriter getBufferedWriter() throws IOException
    {
        return Files.newBufferedWriter(Path.of(m_textFilename), StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }

    @Bean
    public DataOutputStream getDataOutputStream() throws IOException
    {
        return new DataOutputStream(new FileOutputStream(m_binaryFilename, true));
    }
}
