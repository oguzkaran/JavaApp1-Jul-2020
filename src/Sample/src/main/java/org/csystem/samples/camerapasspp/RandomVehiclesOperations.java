package org.csystem.samples.camerapasspp;

import java.util.function.Consumer;

public class RandomVehiclesOperations {
    private final int m_count;

    public RandomVehiclesOperations(int count)
    {
        m_count = count;
    }

    public void run(Consumer<VehicleInfo> vehicleInfoConsumer)
    {
        for (int i = 0; i < m_count; ++i)
            VehicleFactory.getRandomVehicle().ifPresent(vehicleInfoConsumer);
    }
}
