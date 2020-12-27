package org.csystem.application.springboot.simplecalculator.operation;

import org.springframework.stereotype.Component;

@Component
public class MultiplyOperation implements IIntBinaryOperation {
    @Override
    public boolean isVaLid(char op)
    {
        return op == '*';
    }

    @Override
    public int applyAsInt(int a, int b)
    {
        return a * b;
    }
}
