package org.csystem.samples.camerapasspp;

import org.csystem.util.Console;

public final class CameraPassApp {
    private static int ms_sum;

    private static void vehicleConsumerCallback(VehicleInfo vehicleInfo)
    {
        Console.writeLine("Araç Bilgisi:%s", vehicleInfo);
        ms_sum += vehicleInfo.getSpeed();
    }

    private CameraPassApp()
    {
    }

    public static void run()
    {
        var count = Console.readInt("Araç sayısını giriniz:");

        var randomVehiclesOperations = new RandomVehiclesOperations(count);

        randomVehiclesOperations.run(CameraPassApp::vehicleConsumerCallback);

        Console.writeLine("Hız ortalaması:%f", (double)ms_sum / count);
    }
}
