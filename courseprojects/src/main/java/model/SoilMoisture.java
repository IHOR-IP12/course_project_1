package model;

import lombok.AllArgsConstructor;
import lombok.Data;
@SuppressWarnings("CheckStyle")
@Data
@AllArgsConstructor
public class SoilMoisture {
    private double moistureLevel;
    private Location sensorLocation;

    public SoilMoisture() {
    }

    public SoilMoisture(double moistureLevel) {
        this.moistureLevel = moistureLevel;
    }
}
