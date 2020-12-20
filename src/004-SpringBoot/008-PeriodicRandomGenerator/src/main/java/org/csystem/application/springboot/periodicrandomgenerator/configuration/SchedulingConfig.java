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

@Configuration
@EnableScheduling
public class SchedulingConfig {
    private final BufferedWriter m_firstFileBufferedWriter;
    private final BufferedWriter m_secondFileBufferedWriter;
    private final DataOutputStream m_thirdFileDataOutputStream;
    private final Random m_random;

    @Value("${count}")
    private int m_count;
    @Value("${min}")
    private int m_min;

    @Value("${max}")
    private int m_max;

    private int m_n;

    private void writeFile(BufferedWriter bw, int val) throws IOException
    {
        bw.write(val + "\r\n");
        bw.flush();
    }

    public SchedulingConfig(@Qualifier("firstfilebufferedwriterbean") BufferedWriter firstFileBufferedWriter,
                            @Qualifier("secondfilebufferedwriter") BufferedWriter secondFileBufferedWriter,
                            DataOutputStream thirdFileDataOutputStream, Random random)
    {
        m_firstFileBufferedWriter = firstFileBufferedWriter;
        m_secondFileBufferedWriter = secondFileBufferedWriter;
        m_thirdFileDataOutputStream = thirdFileDataOutputStream;
        m_random = random;
    }

    @Scheduled(fixedRate = 1000)
    public void schedule()
    {
        try {
            if (m_n == m_count)
                System.exit(0);

            var val = m_random.nextInt(m_max - m_min) + m_min;

            System.out.printf("%d ", val);
            writeFile(m_firstFileBufferedWriter, val);
            writeFile(m_secondFileBufferedWriter, val);
            m_thirdFileDataOutputStream.writeInt(val);

            ++m_n;
        }
        catch (IOException ex) {
            System.exit(-1);
        }
    }
}
