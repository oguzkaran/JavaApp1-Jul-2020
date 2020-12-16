package org.csystem.samples.recurison;

public class Util {

    public static long factorial(int n)
    {
        long result = 1;

        for (; n > 1; --n)
            result *= n;

        return result;
    }

    public static int getFibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        if (n <= 2)
            return  n - 1;

        int prev1 = 0, prev2 = 1, val = 0;

        for (int i = 2; i < n; ++i) {
            val = prev1 + prev2;
            prev1 = prev2;
            prev2 = val;
        }

        return val;
    }

    public static String getReverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static void writeNumber(int val)
    {
        if (val == 0) {
            System.out.write('0');
            return;
        }

        char [] s = new char[11];
        int i;
        boolean isNegative;
        isNegative = false;

        if (val < 0) {
            isNegative = true;
            val = -val;
        }

        for (i = 0; val != 0; ++i) {
            s[i] = (char)(val % 10 + '0');
            val /= 10;
        }
        if (isNegative)
            s[i++] = '-';

        for (--i; i >= 0; --i)
            System.out.write(s[i]);

        System.out.flush();
    }

    public static void writeReverse(String s)
    {
        for (int i = s.length() - 1; i >= 0; --i)
            System.out.write(s.charAt(i));

        System.out.flush();
    }
}
