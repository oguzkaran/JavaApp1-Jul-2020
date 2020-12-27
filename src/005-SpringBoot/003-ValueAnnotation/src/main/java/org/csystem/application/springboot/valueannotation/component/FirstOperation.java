package org.csystem.application.springboot.valueannotation.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FirstOperation {
    @Value("${operation1.a:1}")
    private int m_a;

    @Value("${operation1.b:2}")
    private int m_b;

    @Value("${operation1.prefix:first result}")
    private String m_prefix;

    @PostConstruct
    public void doOperation()
    {
        System.out.printf("%s:%d + %d = %d%n", m_prefix, m_a, m_b, m_a + m_b);
    }
}
