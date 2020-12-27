package org.csystem.application.springboot.valueannotation.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SecondOperation {
    @Value("${operation2.a}")
    private int m_a;

    @Value("${operation2.b}")
    private int m_b;

    @Value("${operation2.prefix}")
    private String m_prefix;

    @PostConstruct
    public void doOperation()
    {
        System.out.printf("%s:%d + %d = %d%n", m_prefix, m_a, m_b, m_a + m_b);
    }
}
