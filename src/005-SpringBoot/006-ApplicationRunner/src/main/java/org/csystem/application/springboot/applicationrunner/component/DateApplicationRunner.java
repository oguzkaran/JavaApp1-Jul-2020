package org.csystem.application.springboot.applicationrunner.component;

import org.csystem.springboot.util.datetime.configuration.DateTimeBeanName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateApplicationRunner implements ApplicationRunner {
    private final LocalDate m_localDate;

    public DateApplicationRunner(@Qualifier(DateTimeBeanName.DATE_SINGLETON) LocalDate localDate)
    {
        System.out.println("DateApplicationRunner");
        m_localDate = localDate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.println(DateTimeFormatter.ofPattern("dd.MM.yyyy").format(m_localDate));

    }
}
