package org.csystem.util.converter;

import java.util.function.IntFunction;

@FunctionalInterface
public interface IIntConverter<R> extends IntFunction<R> {
    default int convertBack(R r)
    {
        throw new UnsupportedOperationException("convertBack not supported");
    }
}
