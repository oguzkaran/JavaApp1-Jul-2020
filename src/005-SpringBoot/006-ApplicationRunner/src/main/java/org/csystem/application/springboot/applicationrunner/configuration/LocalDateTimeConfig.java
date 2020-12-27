package org.csystem.application.springboot.applicationrunner.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class LocalDateTimeConfig {
    @Bean
    public LocalDateTime createLocalDateTime()
    {
        return LocalDateTime.now();
    }
}
