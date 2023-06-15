package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoilMoistureTest {

    @Test
    public void testConstructorAndGetters() {
        double moistureLevel = 0.75;
        double latitude = 40.7128;
        double longitude = -74.0060;

        Location sensorLocation = new Location(latitude, longitude);

        SoilMoisture soilMoisture = new SoilMoisture(moistureLevel, sensorLocation);

        Assertions.assertEquals(moistureLevel, soilMoisture.getMoistureLevel());
        Assertions.assertEquals(sensorLocation, soilMoisture.getSensorLocation());
    }

    @Test
    public void testSetters() {
        double moistureLevel = 0.75;
        double latitude = 40.7128;
        double longitude = -74.0060;

        Location sensorLocation = new Location(latitude, longitude);

        SoilMoisture soilMoisture = new SoilMoisture();
        soilMoisture.setMoistureLevel(moistureLevel);
        soilMoisture.setSensorLocation(sensorLocation);

        Assertions.assertEquals(moistureLevel, soilMoisture.getMoistureLevel());
        Assertions.assertEquals(sensorLocation, soilMoisture.getSensorLocation());
    }

    @Test
    public void testConstructorWithMoistureLevelOnly() {
        double moistureLevel = 0.75;

        SoilMoisture soilMoisture = new SoilMoisture(moistureLevel);

        Assertions.assertEquals(moistureLevel, soilMoisture.getMoistureLevel());
        Assertions.assertNull(soilMoisture.getSensorLocation());
    }

    @Test
    public void testEqualsAndHashCode() {
        double moistureLevel = 0.75;
        double latitude = 40.7128;
        double longitude = -74.0060;

        Location sensorLocation1 = new Location(latitude, longitude);
        Location sensorLocation2 = new Location(latitude, longitude);
        Location sensorLocation3 = new Location(41.8781, -87.6298);

        SoilMoisture soilMoisture1 = new SoilMoisture(moistureLevel, sensorLocation1);
        SoilMoisture soilMoisture2 = new SoilMoisture(moistureLevel, sensorLocation2);
        SoilMoisture soilMoisture3 = new SoilMoisture(moistureLevel, sensorLocation3);

        Assertions.assertEquals(soilMoisture1, soilMoisture2);
        Assertions.assertEquals(soilMoisture1.hashCode(), soilMoisture2.hashCode());

        Assertions.assertNotEquals(soilMoisture1, soilMoisture3);
        Assertions.assertNotEquals(soilMoisture1.hashCode(), soilMoisture3.hashCode());
    }

    @Test
    public void testToString() {
        double moistureLevel = 0.75;
        double latitude = 40.7128;
        double longitude = -74.0060;

        Location sensorLocation = new Location(latitude, longitude);

        SoilMoisture soilMoisture = new SoilMoisture(moistureLevel, sensorLocation);

        String expectedString = "SoilMoisture(moistureLevel=0.75, sensorLocation=Location(latitude=40.7128, longitude=-74.006))";
        String actualString = soilMoisture.toString();

        Assertions.assertEquals(expectedString, actualString);
    }
}
