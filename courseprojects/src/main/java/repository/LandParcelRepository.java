package repository;

import model.LandParcel;
import org.springframework.stereotype.Repository;
import util.CsvUtil;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
@SuppressWarnings("CheckStyle")
@Repository
public class LandParcelRepository {
    private File testCsvFile;

    public List<LandParcel> getAllLandParcels() {
        return CsvUtil.loadAllLandParcels();
    }

    public LandParcel getLandParcelById(String id) {
        List<LandParcel> landParcels = getAllLandParcels();
        for (LandParcel landParcel : landParcels) {
            if (landParcel.getId().equals(id)) {
                return landParcel;
            }
        }
        return null;
    }

    public void createLandParcel(LandParcel landParcel) {
        CsvUtil.saveLandParcel(landParcel);
    }

    public void updateLandParcel(String id, LandParcel updatedLandParcel) {
        List<LandParcel> landParcels = getAllLandParcels();
        for (int i = 0; i < landParcels.size(); i++) {
            LandParcel landParcel = landParcels.get(i);
            if (landParcel.getId().equals(id)) {
                landParcels.set(i, updatedLandParcel);
                break;
            }
        }
        overwriteLandParcels(landParcels);
    }

    public void deleteLandParcel(String id) {
        List<LandParcel> landParcels = getAllLandParcels();
        for (int i = 0; i < landParcels.size(); i++) {
            LandParcel landParcel = landParcels.get(i);
            if (landParcel.getId().equals(id)) {
                landParcels.remove(i);
                break;
            }
        }
        overwriteLandParcels(landParcels);
    }

    public void overwriteLandParcels(List<LandParcel> landParcels) {
        try {
            FileWriter writer = new FileWriter("csv/land_parcel.csv");
            writer.write("id,latitude,longitude,moistureLevel,lightLevel\n");
            for (LandParcel landParcel : landParcels) {
                writer.write(landParcel.toCSV());
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getFilesForMonth() {
        return CsvUtil.getFilesForMonth();
    }

    public void removeLandParcelById(String id) {
    }
}

