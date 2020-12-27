package org.csystem.application.springboot.periodicrandomgenerator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;

@Configuration
public class ThirdFileConfig {
    @Value("${thirdfilename}")
    private String m_filename;

    @Value("${thirdfileappend}")
    private boolean m_append;

    @Bean("thirdfiledataoutputstream")
    public DataOutputStream getDataOutputStream() throws IOException
    {
        return new DataOutputStream(new FileOutputStream(m_filename, m_append));
    }
}
