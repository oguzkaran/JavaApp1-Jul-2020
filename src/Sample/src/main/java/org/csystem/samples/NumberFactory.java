package org.csystem.samples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.IntStream;

public final class NumberFactory {
    private int[] m_numbers;

    private NumberFactory()
    {
    }

    public static NumberFactory loadFromFile(String path) throws IOException
    {
        var numberFactory = new NumberFactory();

        try (var scanner = new Scanner(Path.of(path), StandardCharsets.UTF_8)) {
            int count = scanner.nextInt();

            numberFactory.m_numbers = IntStream.range(0, count).map(i -> scanner.nextInt()).toArray();
        }

        return numberFactory;
    }

    public int[] getNumbers()
    {
        return m_numbers;
    }
}
