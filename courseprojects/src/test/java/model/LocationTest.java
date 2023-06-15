package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocationTest {

    @Test
    public void testConstructorAndGetters() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        Location location = new Location(latitude, longitude);

        Assertions.assertEquals(latitude, location.getLatitude());
        Assertions.assertEquals(longitude, location.getLongitude());
    }

    @Test
    public void testSetters() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        Location location = new Location();
        location.setLatitude(latitude);
        location.setLongitude(longitude);

        Assertions.assertEquals(latitude, location.getLatitude());
        Assertions.assertEquals(longitude, location.getLongitude());
    }

    @Test
    public void testEqualsAndHashCode() {
        Location location1 = new Location(40.7128, -74.0060);
        Location location2 = new Location(40.7128, -74.0060);
        Location location3 = new Location(41.8781, -87.6298);

        Assertions.assertEquals(location1, location2);
        Assertions.assertEquals(location1.hashCode(), location2.hashCode());

        Assertions.assertNotEquals(location1, location3);
        Assertions.assertNotEquals(location1.hashCode(), location3.hashCode());
    }

    @Test
    public void testToString() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        Location location = new Location(latitude, longitude);

        String expectedString = "Location(latitude=40.7128, longitude=-74.006)";
        String actualString = location.toString();

        Assertions.assertEquals(expectedString, actualString);
    }
}
