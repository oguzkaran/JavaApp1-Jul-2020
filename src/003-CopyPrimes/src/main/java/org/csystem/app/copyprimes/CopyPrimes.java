package org.csystem.app.copyprimes;

import org.csystem.util.NumberUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class CopyPrimes {
    private static final int LENGTH_BOUND = 65535;
    private final Path m_src;
    private final Path m_dest;
    private final IntPredicate m_predicate;

    private void write(BufferedWriter bufferedWriter, String str)
    {
        try {
            bufferedWriter.write(str + "\r\n");
            bufferedWriter.flush();
        }
        catch (IOException ex) {
            throw new RuntimeException("write", ex);
        }
    }

    private void writeCount(long count) throws IOException
    {
        var tempPath = Path.of("temp.txt");

        try (var bufferedReader = Files.newBufferedReader(m_dest);
             var bufferedWriter = Files.newBufferedWriter(tempPath, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
            write(bufferedWriter, count + "");

            String line;

            while ((line = bufferedReader.readLine()) != null)
                write(bufferedWriter, line);
        }

        m_dest.toFile().delete();
        tempPath.toFile().renameTo(m_dest.toFile());
    }

    private void write(BufferedWriter bufferedWriter, int val)
    {
        write(bufferedWriter, val + "");
    }

    private void doWorkForGreater() throws IOException
    {
        long count = 0;

        try (var bufferedReader = Files.newBufferedReader(m_src);
             var bufferedWriter = Files.newBufferedWriter(m_dest, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {

            String line;

            while ((line = bufferedReader.readLine()) != null)
                if (m_predicate.test(Integer.parseInt(line))) {
                    ++count;
                    write(bufferedWriter, line);
                }
        }

        writeCount(count); //Önceden count hesaplanıp dosyaya yazılarak yapılması göreceli daha efektif. Örnek olması açısından bu şekilde yapıldı
    }

    private void doWorkForLessOrEqual() throws IOException
    {
        var numberFactory = NumberFactory.loadFromFile(m_src);
        var numbers = numberFactory.getNumbers();

        var count = Arrays.stream(numbers).filter(m_predicate).count();

        try (var bufferedWriter = Files.newBufferedWriter(m_dest, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
            write(bufferedWriter, (int)count);
            Arrays.stream(numbers).filter(m_predicate).forEach(val -> write(bufferedWriter, val));
        }
    }

    public CopyPrimes(Path src, Path dest, boolean isPrime)
    {
        m_src = src;
        m_dest = dest;
        m_predicate = isPrime ? NumberUtil::isPrime : NumberUtil::isNotPrime;
    }

    public void copy()  throws IOException
    {
        if (m_src.toFile().length() > LENGTH_BOUND)
            this.doWorkForGreater();
        else
            this.doWorkForLessOrEqual();
    }
}
