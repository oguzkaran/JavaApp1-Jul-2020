package org.csystem.application.randomgeneratortofile.configuration;

import org.csystem.util.Console;
import org.csystem.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

@Configuration
public class RandomGeneratorToFileScheduleConfig {
    private final BufferedWriter m_bufferedWriter;
    private final DataOutputStream m_dataOutputStream;
    private final Random m_random;
    private final Scheduler m_scheduler;

    @Value("${count}")
    private int m_count;

    @Value("${min}")
    private int m_min;

    @Value("${max}")
    private int m_max;

    private int m_n;

    public RandomGeneratorToFileScheduleConfig(BufferedWriter bufferedWriter, DataOutputStream dataOutputStream, Random random, Scheduler scheduler)
    {
        m_bufferedWriter = bufferedWriter;
        m_dataOutputStream = dataOutputStream;
        m_random = random;
        m_scheduler = scheduler;
    }

    @Bean
    public ApplicationRunner run()
    {
        return args -> m_scheduler.schedule(this::generateNumbers);
    }

    public void generateNumbers()
    {
        try {
            if (m_n == m_count)
                System.exit(1);
            ++m_n;

            int val = m_random.nextInt(m_max - m_min) + m_min;

            Console.write("%d ", val);
            m_dataOutputStream.writeInt(val);
            m_bufferedWriter.write(val + "\r\n");
            m_bufferedWriter.flush();
        }
        catch (IOException ignore) {

        }
    }
}
