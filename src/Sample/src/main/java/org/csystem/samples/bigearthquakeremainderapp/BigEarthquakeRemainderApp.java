package org.csystem.samples.bigearthquakeremainderapp;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public final class BigEarthquakeRemainderApp {
    private BigEarthquakeRemainderApp()
    {}

    public static void run()
    {
        var earthQuakeDateTime = LocalDateTime.of(1999, Month.AUGUST, 17, 3, 2);

        while (true) {
            var now = LocalDateTime.now();
            var seconds = ChronoUnit.SECONDS.between(earthQuakeDateTime, now);

            System.out.printf("Depremden bu zamana kadar geçen saniye:%d\r", seconds);
        }
    }
}
