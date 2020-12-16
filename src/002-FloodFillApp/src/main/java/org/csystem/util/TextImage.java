package org.csystem.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public final class TextImage {
    private char [][] m_bitmap;

    private static void floodFill(char [][] bitmap, int row, int col, char ch, char bound)
    {
        if (bitmap[row][col] == ch || bitmap[row][col] == bound)
            return;

        bitmap[row][col] = ch;
        floodFill(bitmap, row + 1, col, ch, bound);
        floodFill(bitmap, row, col + 1, ch, bound);
        floodFill(bitmap, row - 1, col, ch, bound);
        floodFill(bitmap, row, col - 1, ch, bound);
    }

    private void fillBitmap(String path)
    {
        int row = 0;

        try (var bufferedReader = Files.newBufferedReader(Path.of(path))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); ++i)
                    m_bitmap[row][i] = line.charAt(i);

                ++row;
            }
        }
        catch (Throwable ex) {
            System.err.println(ex.getMessage());
        }
    }

    public TextImage(int rowSize, int colSize)
    {
        m_bitmap = new char[rowSize][colSize];
    }

    public int getRowSize()
    {
        return m_bitmap.length;
    }

    public int getColSize()
    {
        return m_bitmap[0].length;
    }

    public char getChar(int i, int k)
    {
        return m_bitmap[i][k];
    }

    public void setBitmap(int i, int k, char c)
    {
        m_bitmap[i][k] = c;
    }

    public void displayBitmap()
    {
        System.out.println(this.toString());
    }

    public void floodFill(int row, int col, char ch, char bound)
    {
        floodFill(m_bitmap, row, col, ch, bound);
    }

    public void loadBitmap(String path)
    {
        for (var array : m_bitmap)
            Arrays.fill(array, ' ');

        fillBitmap(path);
    }

    public void saveBitmap(String path)
    {
        try (var bufferedWriter = Files.newBufferedWriter(Path.of(path), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bufferedWriter.write(this.toString());
            bufferedWriter.flush();
        }
        catch (Throwable ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void flip()
    {
        //...
    }


    public void transpose()
    {
        int rowSize = m_bitmap.length;
        int colSize = m_bitmap[0].length;

        char [][] bitmap = new char[colSize][rowSize];

        for (int i = 0; i < rowSize; ++i)
            for (int k = 0; k < colSize; ++k)
                bitmap[k][i] = m_bitmap[i][k];

        m_bitmap = bitmap;
    }

    @Override
    public String toString()
    {
        var stringBuilder = new StringBuilder();

        for (char[] chars : m_bitmap) {
            for (char c : chars)
                stringBuilder.append(c);

            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}
