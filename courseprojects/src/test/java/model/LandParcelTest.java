package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LandParcelTest {

    @Test
    public void testToCSV() {
        // Arrange
        double latitude = 123.456;
        String id = "null";
        Location location = new Location(12.345, 67.890);
        SoilMoisture soilMoisture = new SoilMoisture(0.8);
        Illumination illumination = new Illumination(0.6);
        LandParcel landParcel = new LandParcel(latitude, id, location, soilMoisture, illumination);
        String expectedCSV = "123,12.345,67.89,0.8,0.6";

        // Act
        String actualCSV = landParcel.toCSV();

        // Assert
        Assertions.assertEquals(expectedCSV, actualCSV);
    }

    @Test
    public void testGetId() {
        // Arrange
        String id = "null";
        LandParcel landParcel = new LandParcel(id, null, null);

        // Act
        String actualId = landParcel.getId();

        // Assert
        Assertions.assertEquals(id, actualId);
    }

    @Test
    public void testSetId() {
        // Arrange
        String id = "null";
        LandParcel landParcel = new LandParcel(null, null, null);

        // Act
        landParcel.setId(id);
        String actualId = landParcel.getId();

        // Assert
        Assertions.assertEquals(id, actualId);
    }

    @Test
    public void testGetLocation() {
        // Arrange
        Location location = null;
        LandParcel landParcel = new LandParcel(null, location, null);

        // Act
        Location actualLocation = landParcel.getLocation();

        // Assert
        Assertions.assertEquals(location, actualLocation);
    }

    @Test
    public void testSetLocation() {
        // Arrange
        Location location = null;
        LandParcel landParcel = new LandParcel(null, null, null);

        // Act
        landParcel.setLocation(location);
        Location actualLocation = landParcel.getLocation();

        // Assert
        Assertions.assertEquals(location, actualLocation);
    }

    @Test
    public void testGetSoilMoisture() {
        // Arrange
        SoilMoisture soilMoisture = null;
        LandParcel landParcel = new LandParcel(null, null, soilMoisture);

        // Act
        SoilMoisture actualSoilMoisture = landParcel.getSoilMoisture();

        // Assert
        Assertions.assertEquals(soilMoisture, actualSoilMoisture);
    }

    @Test
    public void testSetSoilMoisture() {
        // Arrange
        SoilMoisture soilMoisture = null;
        LandParcel landParcel = new LandParcel(null, null, null);

        // Act
        landParcel.setSoilMoisture(soilMoisture);
        SoilMoisture actualSoilMoisture = landParcel.getSoilMoisture();

        // Assert
        Assertions.assertEquals(soilMoisture, actualSoilMoisture);
    }

    @Test
    public void testGetIllumination() {
        // Arrange
        Illumination illumination = null;
        LandParcel landParcel = new LandParcel(null, null, null);

        // Act
        Illumination actualIllumination = landParcel.getIllumination();

        // Assert
        Assertions.assertEquals(illumination, actualIllumination);
    }

    @Test
    public void testSetIllumination() {
        // Arrange
        Illumination illumination = new Illumination(0.6);
        LandParcel landParcel = new LandParcel(null, null, null);

        // Act
        landParcel.setIllumination(illumination);
        Illumination actualIllumination = landParcel.getIllumination();

        // Assert
        Assertions.assertEquals(illumination, actualIllumination);
    }
}

