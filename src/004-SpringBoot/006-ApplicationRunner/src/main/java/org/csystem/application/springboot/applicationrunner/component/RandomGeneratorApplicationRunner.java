package org.csystem.application.springboot.applicationrunner.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Component
public class RandomGeneratorApplicationRunner implements ApplicationRunner {
    private final Random m_random;

    @Value("${count}")
    private int m_count;

    @Value("${min}")
    private int m_min;

    @Value("${max}")
    private int m_max;

    public RandomGeneratorApplicationRunner(Random random)
    {
        System.out.println("RandomGeneratorApplicationRunner");
        m_random = random;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        IntStream.generate(() ->
                m_random.nextInt(m_max - m_min) + m_min).limit(m_count).forEach(val -> System.out.printf("%d ", val));
        System.out.println();
    }
}
