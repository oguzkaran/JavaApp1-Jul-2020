package org.csystem.application.commandprompt;

import org.csystem.commandpromptapp.common.TextInfo;
import org.csystem.util.Console;
import org.csystem.util.ThreadUtil;
import org.csystem.util.scheduler.CountDownScheduler;

import static org.csystem.util.StringUtil.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GenerateCommandController {
    private String m_prompt;
    private ArrayList m_textInfoList;
    private final String [] m_arguments;
    private final Random m_random;

    //generate 10 15
    private void doWorkForTwo()
    {
        var count = Integer.parseInt(m_arguments[0]);
        var length = Integer.parseInt(m_arguments[1]);

        for (int i = 0; i < count; ++i)
            m_textInfoList.add(m_random.nextBoolean() ?
                    new TextInfo(getRandomTextTR(m_random, length)) : new TextInfo(getRandomTextEN(m_random, length)));
    }

    //generate p 1 10 15
    private void doWorkForFour()
    {
        if (m_arguments[0].charAt(0) != 'p')
            throw new RuntimeException(); //Şimdilik fırlatıldı ileride düzeltilecek

        var period = Integer.parseInt(m_arguments[1]);
        var count = Integer.parseInt(m_arguments[2]);
        var length = Integer.parseInt(m_arguments[3]);

        //GenerateController arka planda çalışıyor. Dolayısıyla CommandPrompt bunu beklemiyor
        new CountDownScheduler(count, period, TimeUnit.SECONDS) {
            public void onTick(long millisUntilFinished)
            {
                Console.writeLine(m_random.nextBoolean() ? getRandomTextTR(m_random, length) : getRandomTextEN(m_random, length));
            }

            public void onFinish()
            {
                Console.write(m_prompt);
            }
        }.start();
    }

    public void doWorkForFive()
    {
        if (m_arguments.length != 5)
            throw new IllegalArgumentException();

        if (m_arguments[0].charAt(0) != 'w')
            throw new RuntimeException(); //Şimdilik fırlatıldı ileride düzeltilecek

        if (m_arguments[1].charAt(0) != 'p')
            throw new RuntimeException(); //Şimdilik fırlatıldı ileride düzeltilecek

        var period = Integer.parseInt(m_arguments[2]);
        var count = Integer.parseInt(m_arguments[3]);
        var length = Integer.parseInt(m_arguments[4]);

        for (int i = 0; i < count; ++i) {
            Console.writeLine(m_random.nextBoolean() ? getRandomTextTR(m_random, length) : getRandomTextEN(m_random, length));
            ThreadUtil.sleep(period * 1000);
        }
    }
    public GenerateCommandController(Random random, String prompt, String...arguments)
    {
        m_arguments = Arrays.copyOf(arguments, arguments.length);
        m_random = random;
        m_prompt = prompt;
    }

    public GenerateCommandController(Random random, ArrayList textInfoList, String prompt, String...arguments)
    {
        this(random, prompt, arguments);
        m_textInfoList = textInfoList;
    }

    public void doWork()
    {
        if (m_arguments.length != 2 && m_arguments.length != 4 && m_arguments.length != 5)
            throw new IllegalArgumentException();

        if (m_arguments.length == 2)
            this.doWorkForTwo();
        else if (m_arguments.length == 4)
            this.doWorkForFour();
        else
            this.doWorkForFive();
    }
}
