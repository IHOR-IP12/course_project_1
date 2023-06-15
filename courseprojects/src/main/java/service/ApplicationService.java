package service;

import model.LandParcel;
import java.io.File;
import java.util.List;
import java.util.Map;
@SuppressWarnings("CheckStyle")
public class ApplicationService {
    private LandParcelService landParcelService;

    public ApplicationService() {
        landParcelService = new LandParcelService();
    }

    public ApplicationService(LandParcelService landParcelService) {

    }

    public  void  runApplication() {
        // Вичитка усіх сутностей з файлу та збереження у хеш-мапі
        Map<String, LandParcel> landParcelMap = landParcelService.readLandParcelsFromFiles();
        System.out.println("Land parcels loaded: " + landParcelMap.size());

        // Пошук файлів для сутностей, створених у поточному місяці
        List<File> filesForCurrentMonth = landParcelService.getFilesForCurrentMonth();
        System.out.println("Files for current month: " + filesForCurrentMonth.size());
    }
}