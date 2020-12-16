package org.csystem.springboot.util.datetime.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class DateTimeBeanConfig {
    private final LocalDateTime m_localDateTime;

    public DateTimeBeanConfig(LocalDateTime localDateTime)
    {
        m_localDateTime = localDateTime;
    }

    @Bean("org.csystem.util.datetime.date")
    @Scope("prototype")
    public LocalTime createLocalTime()
    {
        return m_localDateTime.toLocalTime();
    }

    @Bean("org.csystem.util.datetime.time")
    @Scope("prototype")
    public LocalDate createLocalDate()
    {
        return m_localDateTime.toLocalDate();
    }
}
