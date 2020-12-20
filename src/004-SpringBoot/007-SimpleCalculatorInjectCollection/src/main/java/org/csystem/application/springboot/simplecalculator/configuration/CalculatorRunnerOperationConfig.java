package org.csystem.application.springboot.simplecalculator.configuration;

import org.csystem.application.springboot.simplecalculator.SimpleCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class CalculatorRunnerOperationConfig {
    private final SimpleCalculator m_simpleCalculator;

    @Value("${firstoperation.message: First Operation}")
    private String m_message;

    public CalculatorRunnerOperationConfig(SimpleCalculator simpleCalculator)
    {
        m_simpleCalculator = simpleCalculator;
    }

    @Bean("calculatorrunneroperation")
    public ApplicationRunner runCalculator(@Value("${firstoperation.a}") int a,
                                           @Value("${firstoperation.b}")int b,
                                           @Value("${firstoperation.op}")char op)
    {
        return args -> {
            System.out.println(m_message);
            m_simpleCalculator.calculate(a, b, op);
        };
    }
}
