package org.csystem.application.springboot.periodicrandomgenerator.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    private final BufferedWriter m_firstFileBufferedWriter;
    private final BufferedWriter m_secondFileBufferedWriter;
    private final DataOutputStream m_thirdFileDataOutputStream;

    @Value("${count}")
    private int m_count;
    @Value("${min}")
    private int m_min;

    @Value("${max}")
    private int m_max;

    private int m_schedulerCount = 3;

    private int m_nFirst;
    private int m_nSecond;
    private int m_nThird;


    private void writeFile(BufferedWriter bw, int val) throws IOException
    {
        bw.write(val + "\r\n");
        bw.flush();
    }

    public SchedulingConfig(@Qualifier("firstfilebufferedwriterbean") BufferedWriter firstFileBufferedWriter,
                            @Qualifier("secondfilebufferedwriter") BufferedWriter secondFileBufferedWriter,
                            DataOutputStream thirdFileDataOutputStream)
    {
        m_firstFileBufferedWriter = firstFileBufferedWriter;
        m_secondFileBufferedWriter = secondFileBufferedWriter;
        m_thirdFileDataOutputStream = thirdFileDataOutputStream;
    }

    @Scheduled(fixedRate = 1)
    public void scheduleForFirstFile()
    {
        try {
            if (m_schedulerCount == 0) //Senkronize edilmesi gerekir
                System.exit(0);

            if (m_nFirst++ == m_count) {
                --m_schedulerCount; //Senkronize edilmesi gerekir
                return;
            }

            var val = ThreadLocalRandom.current().nextInt(m_min, m_max);

            writeFile(m_firstFileBufferedWriter, val);
        }
        catch (IOException ex) {
            System.exit(-1);
        }
    }

    @Scheduled(fixedRate = 1)
    public void scheduleForSecondFile()
    {
        try {
            if (m_schedulerCount == 0)  //Senkronize edilmesi gerekir
                System.exit(0);

            if (m_nSecond++ == m_count) {
                --m_schedulerCount;  //Senkronize edilmesi gerekir
                return;
            }

            var val = ThreadLocalRandom.current().nextInt(m_min, m_max);

            writeFile(m_secondFileBufferedWriter, val);
        }
        catch (IOException ex) {
            System.exit(-1);
        }
    }

    @Scheduled(fixedRate = 1)
    public void scheduleForThirdFile()
    {
        try {
            if (m_schedulerCount == 0)  //Senkronize edilmesi gerekir
                System.exit(0);

            if (m_nThird++ == m_count) {
                --m_schedulerCount;  //Senkronize edilmesi gerekir
                return;
            }

            var val = ThreadLocalRandom.current().nextInt(m_min, m_max);

            m_thirdFileDataOutputStream.writeInt(val);
        }
        catch (IOException ex) {
            System.exit(-1);
        }
    }
}
