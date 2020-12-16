package org.csystem.application.springboot.randomgenerator.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.ref.WeakReference;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class RandomGenerator {
    private final Random m_random;

    @Value("${min:0}")
    private int m_min;

    @Value("${max:2}")
    private int m_max;

    private class RandomGeneratorTask extends TimerTask { //Örnek amaçlı tek yapılmadı
        @Override
        public void run()
        {
            System.out.printf("RandomGenerator:%d%n", m_random.nextInt(m_max - m_min) + m_min);
        }
    }

    public RandomGenerator(@Qualifier("random") Random random)
    {
        m_random = random;
    }

    @PostConstruct
    public void generateRandomNumbers() throws InterruptedException
    {
        var timer = new Timer();

        timer.schedule(new RandomGeneratorTask(), 0, 1000);
    }
}
