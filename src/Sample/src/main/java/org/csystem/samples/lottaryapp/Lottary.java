package org.csystem.samples.lottaryapp;

import java.util.Random;
import java.util.TreeSet;

public class Lottary {
    private final Random m_rand;

    private int[] getNumbers()
    {
        int [] numbers = new int[6];
        int i = 0;

        var treeSet = new TreeSet<Integer>();

        while (treeSet.size() != 6)
            treeSet.add(m_rand.nextInt(49) + 1);

        while (!treeSet.isEmpty())
            numbers[i++] = treeSet.pollFirst();

        return numbers;
    }

    public Lottary()
    {
        m_rand = new Random();
    }

    public int [][] getNumbers(int n)
    {
        int [][] numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}