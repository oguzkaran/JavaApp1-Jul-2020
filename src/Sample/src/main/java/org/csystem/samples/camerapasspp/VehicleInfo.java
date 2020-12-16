package org.csystem.samples.camerapasspp;

import java.time.LocalDateTime;

public class VehicleInfo {
    private String m_plate;
    private VehicleType m_vehicleType;
    private final int m_speed;
    private final LocalDateTime m_passTime;

    public VehicleInfo()
    {
        this("", VehicleType.UNKNOWN, 0);
    }

    public VehicleInfo(String plate, VehicleType vehicleType, int speed)
    {
        m_plate = plate;
        m_vehicleType = vehicleType;
        m_speed = speed;
        m_passTime = LocalDateTime.now();
    }

    public String getPlate()
    {
        return m_plate;
    }

    public void setPlate(String plate)
    {
        m_plate = plate;
    }

    public VehicleType getVehicleType()
    {
        return m_vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType)
    {
        m_vehicleType = vehicleType;
    }

    public int getSpeed()
    {
        return m_speed;
    }

    public LocalDateTime getPassTime()
    {
        return m_passTime;
    }

    @Override
    public String toString()
    {
        return String.format("{plate : %s, type : %s, speed : %d, passTime : %s}", m_plate, m_vehicleType, m_speed, m_passTime);
    }
}
