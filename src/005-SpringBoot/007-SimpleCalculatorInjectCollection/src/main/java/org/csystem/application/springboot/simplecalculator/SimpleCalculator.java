package org.csystem.application.springboot.simplecalculator;

import org.csystem.application.springboot.simplecalculator.operation.IIntBinaryOperation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Scope("prototype")
public class SimpleCalculator {
    private final Collection<IIntBinaryOperation> m_operations;

    private void throwException()
    {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    public SimpleCalculator(Collection<IIntBinaryOperation> operations)
    {
        m_operations = operations;
    }

    public void calculate(int a, int b, char op)
    {
        m_operations.stream()
                .filter(iop -> iop.isVaLid(op))
                .findFirst()
                .ifPresentOrElse(iop -> System.out.printf("%d %c %d = %d%n", a, op, b, iop.applyAsInt(a, b)), this::throwException);
    }
}
