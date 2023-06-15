package util;

import model.LandParcel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.LandParcelCSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LandParcelCSVWriterTest {

    @Test
    public void testWriteLandParcels() {
        // Create some sample land parcels
        List<LandParcel> landParcels = new ArrayList<>();
        landParcels.add(new LandParcel("1", 50.123, 30.456, 0.75, 0.85));
        landParcels.add(new LandParcel("2", 51.789, 31.234, 0.62, 0.71));
        landParcels.add(new LandParcel("3", 52.345, 32.678, 0.82, 0.91));

        // Write the land parcels to CSV
        LandParcelCSVWriter.writeLandParcels(landParcels);

        // Read the CSV file and verify its content
        List<LandParcel> readLandParcels = readLandParcelsFromCSV();

        // Assertions
        Assertions.assertEquals(landParcels.size(), readLandParcels.size());
        for (int i = 0; i < landParcels.size(); i++) {
            LandParcel expected = landParcels.get(i);
            LandParcel actual = readLandParcels.get(i);
            Assertions.assertEquals(expected.getId(), actual.getId());
            Assertions.assertEquals(expected.getLatitude(), actual.getLatitude(), 0.001);
            Assertions.assertEquals(expected.longitude, actual.longitude, 0.001);
            Assertions.assertEquals(expected.moistureLevel, actual.moistureLevel, 0.001);
            Assertions.assertEquals(expected.lightLevel, actual.lightLevel, 0.001);
        }
    }

    private List<LandParcel> readLandParcelsFromCSV() {
        List<LandParcel> landParcels = new ArrayList<>();
        String csvFilePath = "land_parcel.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            // Skip the headers line
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                double latitude = Double.parseDouble(values[1]);
                double longitude = Double.parseDouble(values[2]);
                double moistureLevel = Double.parseDouble(values[3]);
                double lightLevel = Double.parseDouble(values[4]);

                LandParcel landParcel = new LandParcel(id, latitude, longitude, moistureLevel, lightLevel);
                landParcels.add(landParcel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return landParcels;
    }
}
