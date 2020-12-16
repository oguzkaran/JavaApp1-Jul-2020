/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden girilen saat ve dakika bilgisine göre o zaman geldiğinde ekrana "Artık uyan"
    şeklinde bir mesaj veren ve alarmı kapatan, zaman gelene kadar ise ekranda sürekli nokta basan programı yazınız.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.samples.alarmapp;

import org.csystem.util.Console;
import org.csystem.util.scheduler.alarm.Alarm;

public class AlarmWithoutSecondApp {
    private AlarmWithoutSecondApp() {}

    public static void run()
    {
        var hour = Console.readInt("Saati giriniz:");
        var minute = Console.readInt("Dakikayı giriniz:");

        Alarm alarm = new Alarm(hour, minute);

        alarm.run(() -> Console.write("."), () -> Console.writeLine("\nArtık uyan"));
    }
}
