package org.csystem.app.copyprimes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.IntStream;

public final class NumberFactory {
    private int[] m_numbers;

    private NumberFactory()
    {}

    public static NumberFactory loadFromFile(Path path) throws IOException
    {
        var numberFactory = new NumberFactory();

        try (var scanner = new Scanner(path, StandardCharsets.UTF_8)) {
            int count = scanner.nextInt();

            numberFactory.m_numbers = new int[count];
            IntStream.range(0, count).forEach(i -> numberFactory.m_numbers[i] = scanner.nextInt());

            return numberFactory;
        }
    }

    public int[] getNumbers()
    {
        return m_numbers;
    }
}
