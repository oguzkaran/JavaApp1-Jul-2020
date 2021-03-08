package org.csystem.application.randomgeneratortofile.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class RandomConfig {
    @Bean
    @Scope("prototype")
    public ThreadLocalRandom getThreadLocalRandom()
    {
        return ThreadLocalRandom.current(); //ThreadLocalRandom tohum değerinin set edilmesine izin vermez
    }
}
