package org.csystem.samples.recurison;

public class RecursionUtil {
    private static int getFibonacciNumberRecur(int n)
    {
        if (n <= 2)
            return n - 1;

        return getFibonacciNumberRecur(n - 1) + getFibonacciNumberRecur(n - 2);
    }

    private static void getReverse(char [] c, int left, int right)
    {
        if (left >= right)
            return;

        char temp;

        temp = c[left];
        c[left] = c[right];
        c[right] = temp;

        getReverse(c, left + 1, right - 1);
    }

    private static void writeNumberRecur(int val)
    {
        if (val / 10 != 0)
            writeNumber(val / 10);

        System.out.write((char)(val % 10 + '0'));
    }

    private static void writeNumberRecur(int val, int radix)
    {
        if (val / radix != 0)
            writeNumberRecur(val / radix, radix);

        //System.out.write((char)(val % radix >= 10 ? val % radix - 10 + 'A' : val % radix + '0'));
        System.out.write((char)((val % radix >= 10 ? - 10 + 'A' : '0') + val % radix));
    }

    private static void writeReverse(String s, int i)
    {
        if (i == s.length())
            return;

        writeReverse(s, i + 1);
        System.out.write(s.charAt(i));
    }

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static int getFibonacciNumber(int n)
    {
        if (n <= 0)
            return -1;

        return getFibonacciNumberRecur(n);
    }

    public static String getReverse(String s)
    {
        char [] c = s.toCharArray();

        getReverse(c, 0, c.length - 1);

        return String.valueOf(c);
    }

    public static void writeNumber(int val)
    {
        if (val < 0) {
            System.out.write('-');
            val = -val;
        }
        writeNumberRecur(val);
        System.out.flush();
    }

    public static void writeNumber(int val, int radix)
    {
        if (val < 0) {
            System.out.write('-');
            val = -val;
        }

        writeNumberRecur(val, radix);
        System.out.flush();
    }

    public static void writeReverse(String s)
    {
        writeReverse(s, 0);
        System.out.flush();
    }

}
