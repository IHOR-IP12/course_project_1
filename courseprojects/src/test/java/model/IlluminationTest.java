package model;

import static org.junit.jupiter.api.Assertions.*;

import model.Illumination;
import model.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IlluminationTest {

    @Test
    public void testConstructorWithLightLevel() {
        double lightLevel = 10.5;
        Illumination illumination = new Illumination(lightLevel);

        Assertions.assertEquals(lightLevel, illumination.getLightLevel());
        Assertions.assertNull(illumination.getSensorLocation());
    }

    @Test
    public void testConstructorWithLightLevelAndLocation() {
        double lightLevel = 10.5;
        double latitude = 40.7128;
        double longitude = -74.0060;
        Location location = new Location(latitude, longitude);

        Illumination illumination = new Illumination(lightLevel, location);

        Assertions.assertEquals(lightLevel, illumination.getLightLevel());
        Assertions.assertEquals(location, illumination.getSensorLocation());
    }
}
