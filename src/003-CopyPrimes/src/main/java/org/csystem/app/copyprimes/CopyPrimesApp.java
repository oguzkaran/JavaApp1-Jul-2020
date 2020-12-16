package org.csystem.app.copyprimes;

import org.csystem.util.CommandLineUtil;
import org.csystem.util.Console;

import java.io.IOException;
import java.nio.file.Path;

public class CopyPrimesApp {
    private static final boolean DEBUG = true;

    public static void run(String [] args)
    {
        try {
            args = CommandLineUtil.getCommandLineArgs(args, "Kaynak dosyayı, hedef dosyayı ve t/f bilgisini giriniz:");
            CommandLineUtil.checkForLengthEqual(args, 3, "Geçersiz argüman sayısı");
            var copyPrimes = new CopyPrimes(Path.of(args[0]), Path.of(args[1]), args[2].charAt(0) == 't');

            copyPrimes.copy();
        }
        catch (IOException ex) {
            if (DEBUG)
                Console.Error.writeLine(ex.getMessage());

            Console.writeLine("Kopyalama sorunu");
        }
        catch (Throwable ex) {
            if (DEBUG)
                Console.Error.writeLine(ex.getMessage());

            Console.writeLine("Beklenmedik bir durum oluştu");
        }

    }
}
