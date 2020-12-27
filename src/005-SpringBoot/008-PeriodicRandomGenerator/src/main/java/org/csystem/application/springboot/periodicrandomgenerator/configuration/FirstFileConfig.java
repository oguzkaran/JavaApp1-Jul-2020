package org.csystem.application.springboot.periodicrandomgenerator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Configuration
public class FirstFileConfig {
    @Value("${firstfilename}")
    private String m_filename;

    @Value("${firstfileappend}")
    private boolean m_append;

    @Bean("firstfilebufferedwriterbean")
    public BufferedWriter getBufferedWriter() throws IOException
    {
        return new BufferedWriter(new FileWriter(m_filename, m_append));
    }
}
