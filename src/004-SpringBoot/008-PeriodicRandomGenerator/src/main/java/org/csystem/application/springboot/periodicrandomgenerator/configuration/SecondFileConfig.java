package org.csystem.application.springboot.periodicrandomgenerator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Configuration
public class SecondFileConfig {
    @Value("${secondfilename}")
    private String m_filename;

    @Value("${secondfileappend}")
    private boolean m_append;

    @Bean("secondfilebufferedwriter")
    public BufferedWriter getBufferedWriter() throws IOException
    {
        return new BufferedWriter(new FileWriter(m_filename, m_append));
    }
}
