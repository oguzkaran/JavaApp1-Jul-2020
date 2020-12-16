package org.csystem.util.converter;

import java.util.function.DoubleFunction;

@FunctionalInterface
public interface IDoubleConverter<R> extends DoubleFunction<R> {

    default double convertBack(R r)
    {
        throw new UnsupportedOperationException("convertBack not supported");
    }
}
