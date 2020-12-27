package org.csystem.application.springboot.requestservletinformation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class DateTimeConfig {
    @Bean
    @Scope("prototype")
    public LocalDateTime createLocalDateTime()
    {
        return LocalDateTime.now();
    }
}
