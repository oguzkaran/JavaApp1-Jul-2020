package org.csystem.util.converter;

import java.util.function.Function;

@FunctionalInterface
public interface IConverter<T, R> extends Function<T, R> {
    default T convertBack(R r)
    {
        throw new UnsupportedOperationException("convertBack not supported");
    }
}
