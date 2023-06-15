package model;

import lombok.AllArgsConstructor;
import lombok.Data;
@SuppressWarnings("CheckStyle")
@Data
@AllArgsConstructor
public class Illumination {
    private double lightLevel;
    private Location sensorLocation;
    public Illumination(double lightLevel, double illuminationLatitude, double illuminationLongitude) {
    }

    public Illumination(double lightLevel) {
        this.lightLevel = lightLevel;
    }

    public int getLocation() {
        return 0;
    }
}
