package org.csystem.springboot.util.datetime.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class DateTimeSingletonBeanConfig {
    private final LocalDateTime m_localDateTime;

    public DateTimeSingletonBeanConfig(LocalDateTime localDateTime)
    {
        m_localDateTime = localDateTime;
    }

    @Bean("org.csystem.util.datetime.time.singleton")
    public LocalTime createLocalTime()
    {
        return m_localDateTime.toLocalTime();
    }

    @Bean("org.csystem.util.datetime.date.singleton")
    public LocalDate createLocalDate()
    {
        return m_localDateTime.toLocalDate();
    }
}
