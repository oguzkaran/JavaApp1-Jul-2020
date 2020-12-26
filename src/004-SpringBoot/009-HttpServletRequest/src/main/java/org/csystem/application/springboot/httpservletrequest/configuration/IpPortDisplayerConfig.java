package org.csystem.application.springboot.httpservletrequest.configuration;

import org.csystem.util.Console;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class IpPortDisplayerConfig {
    private final HttpServletRequest m_httpServletRequest;

    public IpPortDisplayerConfig(HttpServletRequest httpServletRequest)
    {
        m_httpServletRequest = httpServletRequest;
    }

    @Bean
    public ApplicationRunner runIpDisplayer()
    {
        return args -> Console.writeLine("%s:%d%n", m_httpServletRequest.getRemoteAddr(), m_httpServletRequest.getRemotePort());
    }
}
