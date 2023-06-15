package util;

import model.LandParcel;
import model.Location;
import model.SoilMoisture;
import model.Illumination;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("CheckStyle")
public class CsvUtil {
    private static final String CSV_PATH = "csv/";

    public static void saveLandParcel(LandParcel landParcel) {
        String csvFilePath = CSV_PATH + "land_parcel.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
            writer.write(landParcel.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<LandParcel> loadAllLandParcels() {
        String csvFilePath = CSV_PATH + "land_parcel.csv";
        List<LandParcel> landParcels = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                double latitude = Double.parseDouble(data[1]);
                double longitude = Double.parseDouble(data[2]);
                double moistureLevel = Double.parseDouble(data[3]);
                double lightLevel = Double.parseDouble(data[4]);

                Location location = new Location(latitude, longitude);
                SoilMoisture soilMoisture = new SoilMoisture(moistureLevel);
                Illumination illumination = new Illumination(lightLevel);

                LandParcel landParcel = new LandParcel(id, location, soilMoisture);
                landParcels.add(landParcel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return landParcels;
    }

    public static List<String> getFilesForMonth() {
        List<String> filesForMonth = new ArrayList<>();
        // Implement the logic to get files for the current month
        return filesForMonth;
    }

    public static List<LandParcel> loadLandParcelsFromFile(File file) {
        List<LandParcel> landParcels = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                double latitude = Double.parseDouble(data[1]);
                double longitude = Double.parseDouble(data[2]);
                double moistureLevel = Double.parseDouble(data[3]);
                double soilMoistureLatitude = Double.parseDouble(data[4]);
                double soilMoistureLongitude = Double.parseDouble(data[5]);
                double lightLevel = Double.parseDouble(data[6]);
                double illuminationLatitude = Double.parseDouble(data[7]);
                double illuminationLongitude = Double.parseDouble(data[8]);

                Location location = new Location(latitude, longitude);
                SoilMoisture soilMoisture = new SoilMoisture();
                Illumination illumination = new Illumination(lightLevel, illuminationLatitude, illuminationLongitude);

                LandParcel landParcel = new LandParcel(id, location, soilMoisture);
                landParcels.add(landParcel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return landParcels;
    }

    public static void setLandParcels(List<LandParcel> landParcels) {
    }

    public static void setFilesForMonth(List<String> expectedFiles) {
    }
}