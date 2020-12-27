package org.csystem.application.springboot.randomgenerator.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class RandomGenerator {
    private final Random m_random;

    @Value("${min:0}")
    private int m_min;

    @Value("${max:2}")
    private int m_max;

    public RandomGenerator(@Qualifier("random") Random random)
    {
        m_random = random;
    }

    @PostConstruct
    public void generateRandomNumbers() throws InterruptedException
    {

        for (;;) {
            System.out.printf("RandomGenerator:%d%n", m_random.nextInt(m_max - m_min) + m_min);
            Thread.sleep(1000);
        }
    }
}
