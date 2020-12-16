package org.csystem.samples.lottaryapp;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;

public final class LottaryApp {
    private LottaryApp()
    {
    }

    public static void run()
    {
        int n = Console.readInt("Kaç kupon oynamak istiyorsunuz?");

        Lottary lottary = new Lottary();

        ArrayUtil.display(2, lottary.getNumbers(n));
    }
}