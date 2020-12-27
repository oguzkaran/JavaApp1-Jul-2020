package org.csystem.application.springboot.simplecalculator.operation;

import java.util.function.IntBinaryOperator;

public interface IIntBinaryOperation extends IntBinaryOperator {
    boolean isVaLid(char op);
}
