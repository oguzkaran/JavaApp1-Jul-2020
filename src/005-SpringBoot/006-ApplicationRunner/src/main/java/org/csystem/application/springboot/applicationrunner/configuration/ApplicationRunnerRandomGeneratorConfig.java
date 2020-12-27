package org.csystem.application.springboot.applicationrunner.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class ApplicationRunnerRandomGeneratorConfig {
    @Autowired
    private Random m_random;

    @Value("${count}")
    private int m_count;

    @Value("${min}")
    private int m_min;

    @Value("${max}")
    private int m_max;

    @Bean
    public ApplicationRunner runRandomGenerator()
    {
        System.out.println("runRandomGenerator");

        return args -> {
            IntStream.generate(() -> m_random.nextInt(m_max - m_min) + m_min).limit(m_count).forEach(val -> System.out.printf("%d ", val));
            System.out.println();
        };
    }
}
