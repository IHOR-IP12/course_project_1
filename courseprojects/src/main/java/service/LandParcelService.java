package service;

import model.LandParcel;
import repository.LandParcelRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.CsvUtil;
@SuppressWarnings("CheckStyle")
@Service

public class LandParcelService {
    private LandParcelRepository landParcelRepository;

    public LandParcelService() {
        this.landParcelRepository = new LandParcelRepository();
    }

    public  List<LandParcel> getAllLandParcels() {
        return landParcelRepository.getAllLandParcels();
    }

    public  LandParcel getLandParcelById(String id) {
        return landParcelRepository.getLandParcelById(id);
    }

    public void createLandParcel(LandParcel landParcel) {
        landParcelRepository.createLandParcel(landParcel);
    }

    public void updateLandParcel(String id, LandParcel updatedLandParcel) {
        landParcelRepository.updateLandParcel(id, updatedLandParcel);
    }

    public void deleteLandParcel( String id) {
        landParcelRepository.deleteLandParcel(id);
    }

    public List<File> getFilesForCurrentMonth() {
        List<File> filesForCurrentMonth = new ArrayList<>();
        File folder = new File("csv");
        // Замініть це на шлях до вашої папки з файлами
        File[] files = folder.listFiles();
        if (files != null) {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();
            for (File file : files) {
                String fileName = file.getName();
                if (fileName.endsWith(".csv")) {
                    int month = extractMonthFromFileName(fileName);
                    int year = extractYearFromFileName(fileName);
                    if (month == currentMonth && year == currentYear) {
                        filesForCurrentMonth.add(file);
                    }
                }
            }
        }
        return filesForCurrentMonth;
    }

    private int extractMonthFromFileName(String fileName) {
        String[] parts = fileName.split("_");
        String monthString = null;

        for (String part : parts) {
            if (part.matches("\\d+")) {
                monthString = part;
                break;
            }
        }

        if (monthString == null) {
            throw new IllegalArgumentException("Invalid month format in file name: " + fileName);}
        return Integer.parseInt(monthString) ;}
    int extractYearFromFileName(String fileName) {
        String yearStr = fileName.substring(3, 7);
        // Припустимо, що рік знаходиться після трьох символів роздільника
        return Integer.parseInt(yearStr);
    }

    public Map<String, LandParcel> readLandParcelsFromFiles() {
        Map<String, LandParcel> landParcelMap = new HashMap<>();
        List<File> files = getFilesForCurrentMonth();
        for (File file : files) {
            List<LandParcel> landParcels = CsvUtil.loadLandParcelsFromFile(file);
            for (LandParcel landParcel : landParcels) {
                landParcelMap.put(landParcel.getId(), landParcel);
            }
        }
        return landParcelMap;
    }
}