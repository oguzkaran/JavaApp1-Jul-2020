package org.csystem.application.springboot.randomgenerator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class RandomGeneratorConfig {
    @Value("${seed}")
    private long m_seed;
    @Bean("random")
    @Scope("prototype")
    public Random createRandom()
    {
        return new Random();
    }

    @Bean("randomSeed")
    @Scope("prototype")
    public Random createRandomViaSeed()
    {
        return new Random(m_seed);
    }
}
