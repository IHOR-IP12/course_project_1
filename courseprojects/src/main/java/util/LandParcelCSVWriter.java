package util;

import model.LandParcel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@SuppressWarnings("CheckStyle")
public class LandParcelCSVWriter {
    private static final String CSV_FILE_PATH = "land_parcel.csv";

    public static void writeLandParcels(List<LandParcel> landParcels) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            // Записуємо заголовки
            writer.write(getHeadersAsString());
            writer.newLine();

            // Записуємо кожен об'єкт LandParcel у рядок CSV
            for (LandParcel landParcel : landParcels) {
                writer.write(landParcel.toCSV());
                writer.newLine();
            }

            System.out.println("Land parcels have been written to the CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getHeadersAsString() {
        return "id,latitude,longitude,moistureLevel,lightLevel";
    }
}