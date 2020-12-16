package org.csystem.util.converter;

import java.util.function.LongFunction;

@FunctionalInterface
public interface ILongConverter<R> extends LongFunction<R> {
    default long convertBack(R r)
    {
        throw new UnsupportedOperationException("convertBack not supported");
    }
}
