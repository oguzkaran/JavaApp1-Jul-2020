package org.csystem.app.floodfill;

import org.csystem.util.TextImage;

public final class FloodFillApp {
    private FloodFillApp()
    {}

    public static void run()
    {
        try {
            TextImage textImage = new TextImage(25, 80);

            textImage.loadBitmap("pattern.txt");
            textImage.displayBitmap();
            textImage.floodFill(4, 4, '-', '#');

            System.out.println();
            System.out.println();
            System.out.println();

            textImage.displayBitmap();
            textImage.saveBitmap("filled.txt");
        }
        catch (Throwable ex) {
            System.err.println(ex.getMessage());
        }
    }
}
