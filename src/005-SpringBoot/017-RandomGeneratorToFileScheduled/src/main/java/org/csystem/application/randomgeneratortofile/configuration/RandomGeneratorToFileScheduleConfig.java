package org.csystem.application.randomgeneratortofile.configuration;

import org.csystem.util.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class RandomGeneratorToFileScheduleConfig {
    private final BufferedWriter m_bufferedWriter;
    private final DataOutputStream m_dataOutputStream;
    private final ThreadLocalRandom m_threadLocalRandom;

    @Value("${count}")
    private int m_count;

    @Value("${min}")
    private int m_min;

    @Value("${max}")
    private int m_max;

    private int m_n;

    public RandomGeneratorToFileScheduleConfig(BufferedWriter bufferedWriter, DataOutputStream dataOutputStream, ThreadLocalRandom threadLocalRandom)
    {
        m_bufferedWriter = bufferedWriter;
        m_dataOutputStream = dataOutputStream;
        m_threadLocalRandom = threadLocalRandom;
    }

    @Scheduled(fixedRate = 1000)
    public void generateNumbers() throws IOException
    {
        if (m_n == m_count)
            System.exit(1);
        ++m_n;

        int val = m_threadLocalRandom.nextInt(m_min, m_max);

        Console.write("%d ", val);
        m_dataOutputStream.writeInt(val);
        m_bufferedWriter.write(val + "\r\n");
        m_bufferedWriter.flush();
    }
}
