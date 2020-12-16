package org.csystem.application.springboot.applicationrunner.configuration;

import org.csystem.springboot.util.datetime.configuration.DateTimeBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationRunnerDateTimeConfig {
    @Autowired
    private LocalDateTime m_localDateTime;
    @Autowired
    @Qualifier(DateTimeBeanName.TIME_SINGLETON)
    private LocalTime m_localTime;

    private String toDateTimeStr()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(m_localDateTime);
    }

    private String toTimeStr()
    {
        return DateTimeFormatter.ofPattern("hh:mm:ss").format(m_localTime);
    }

    @Bean
    public ApplicationRunner runDisplayTime()
    {
        System.out.println("runDisplayTime");
        return args -> {System.out.printf("runDisplayTime:%s%n", toTimeStr()); Thread.sleep(3000);};
    }

    @Bean
    public ApplicationRunner runDisplayDateTime()
    {
        System.out.println("runDisplayDateTime");
        return args -> System.out.printf("runDisplayDateTime:%s%n", toDateTimeStr());
    }
}
