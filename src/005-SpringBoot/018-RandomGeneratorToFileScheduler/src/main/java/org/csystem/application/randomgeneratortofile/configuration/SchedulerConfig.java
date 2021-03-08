package org.csystem.application.randomgeneratortofile.configuration;

import org.csystem.util.scheduler.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;

@Configuration
public class SchedulerConfig {
    @Bean
    @Scope("prototype")
    public Scheduler createScheduler()
    {
        return new Scheduler(1, TimeUnit.SECONDS);
    }
}
