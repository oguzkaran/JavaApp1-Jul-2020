package org.csystem.samples.camerapasspp;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public final class VehicleFactory {
    private static final ArrayList<VehicleInfo> VEHICLES = new ArrayList<>();
    private static final Random RANDOM = new Random();

    static {
        VEHICLES.add(new VehicleInfo("34ABC34", VehicleType.CAR, 100));
        VEHICLES.add(new VehicleInfo("34XYZ34", VehicleType.BUS, 93));
        VEHICLES.add(new VehicleInfo("34AXY67", VehicleType.TRUCK, 70));
        VEHICLES.add(new VehicleInfo("34ABC89", VehicleType.UNKNOWN, 120));
        VEHICLES.add(null);
        VEHICLES.add(null);
        VEHICLES.add(new VehicleInfo("34tuy89", VehicleType.CAR, 130));
    }

    public VehicleFactory()
    {
    }

    public static Optional<VehicleInfo> getRandomVehicle()
    {
        return Optional.ofNullable(VEHICLES.get(RANDOM.nextInt(VEHICLES.size())));
    }
}
