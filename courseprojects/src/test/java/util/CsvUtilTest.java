package util;

import model.LandParcel;
import model.Location;
import model.SoilMoisture;
import model.Illumination;
import org.junit.jupiter.api.Test;
import util.CsvUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvUtilTest {
    private static final String TEST_CSV_PATH = "test_csv/";

    @Test
    public void testLoadAllLandParcels() {
        // Prepare test data
        createTestCsvFile();

        // Load land parcels
        List<LandParcel> landParcels = CsvUtil.loadAllLandParcels();

        // Assertions
        assertEquals(2, landParcels.size());

        LandParcel landParcel1 = landParcels.get(0);
        assertEquals("1", landParcel1.getId());
        assertEquals(12.34, landParcel1.getLocation().getLatitude());
        assertEquals(56.78, landParcel1.getLocation().getLongitude());
        assertEquals(0.75, landParcel1.getSoilMoisture().getMoistureLevel());
        assertEquals(0.8, landParcel1.getIllumination().getLightLevel());

        LandParcel landParcel2 = landParcels.get(1);
        assertEquals("2", landParcel2.getId());
        assertEquals(98.76, landParcel2.getLocation().getLatitude());
        assertEquals(54.32, landParcel2.getLocation().getLongitude());
        assertEquals(0.65, landParcel2.getSoilMoisture().getMoistureLevel());
        assertEquals(0.5, landParcel2.getIllumination().getLightLevel());

        // Clean up
        deleteTestCsvFile();
    }

    @Test
    public void testLoadLandParcelsFromFile() {
        // Prepare test data
        File testCsvFile = createTestCsvFile();

        // Load land parcels from file
        List<LandParcel> landParcels = CsvUtil.loadLandParcelsFromFile(testCsvFile);

        // Assertions
        assertEquals(2, landParcels.size());

        LandParcel landParcel1 = landParcels.get(0);
        assertEquals("1", landParcel1.getId());
        assertEquals(12.34, landParcel1.getLocation().getLatitude());
        assertEquals(56.78, landParcel1.getLocation().getLongitude());
        assertEquals(0.75, landParcel1.getSoilMoisture().getMoistureLevel());
        assertEquals(0.8, landParcel1.getIllumination().getLightLevel());

        LandParcel landParcel2 = landParcels.get(1);
        assertEquals("2", landParcel2.getId());
        assertEquals(98.76, landParcel2.getLocation().getLatitude());
        assertEquals(54.32, landParcel2.getLocation().getLongitude());
        assertEquals(0.65, landParcel2.getSoilMoisture().getMoistureLevel());
        assertEquals(0.5, landParcel2.getIllumination().getLightLevel());

        // Clean up
        deleteTestCsvFile();
    }

    private File createTestCsvFile() {
        File testCsvFile = new File(TEST_CSV_PATH + "test_land_parcel.csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testCsvFile))) {
            writer.write("1,12.34,56.78,0.75,12.34,56.78,0.8,12.34,56.78\n");
            writer.write("2,98.76,54.32,0.65,98.76,54.32,0.5,98.76,54.32\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testCsvFile;
    }

    private void deleteTestCsvFile() {
        File testCsvFile = new File(TEST_CSV_PATH + "test_land_parcel.csv");
        testCsvFile.delete();
    }
}
