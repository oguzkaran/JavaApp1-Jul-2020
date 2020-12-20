package org.csystem.application.springboot.simplecalculator.configuration;

import org.csystem.application.springboot.simplecalculator.SimpleCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class CalculatorRunnerConfig {
    private final SimpleCalculator m_simpleCalculator;

    @Value("${secondoperation.a}")
    private int m_a;
    @Value("${secondoperation.b}")
    private int m_b;

    @Value("${secondoperation.op}")
    private char m_op;

    @Value("${secondoperation.message:Second Operation}")
    private String m_message;

    public CalculatorRunnerConfig(SimpleCalculator simpleCalculator)
    {
        m_simpleCalculator = simpleCalculator;
    }

    @Bean("calculatorrunner")
    public ApplicationRunner runCalculator()
    {
        return args -> {
            System.out.println(m_message);
            m_simpleCalculator.calculate(m_a, m_b, m_op);
        };
    }
}
