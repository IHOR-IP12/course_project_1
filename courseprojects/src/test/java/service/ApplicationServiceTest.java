package service;

import model.LandParcel;
import org.junit.jupiter.api.Test;
import util.CsvUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApplicationServiceTest {

    @Test
    public void testRunApplication() {
        // Mock the LandParcelService
        LandParcelService landParcelService = mock(LandParcelService.class);
        ApplicationService applicationService = new ApplicationService(landParcelService);

        // Prepare test data
        List<LandParcel> landParcels = new ArrayList<>();
        LandParcel landParcel1 = new LandParcel("1", null, null);
        LandParcel landParcel2 = new LandParcel("2", null, null);
        landParcels.add(landParcel1);
        landParcels.add(landParcel2);
        Map<String, LandParcel> landParcelMap = Map.of("1", landParcel1, "2", landParcel2);
        List<File> filesForCurrentMonth = new ArrayList<>();
        filesForCurrentMonth.add(new File("file1.csv"));
        filesForCurrentMonth.add(new File("file2.csv"));

        // Mock the behavior of LandParcelService methods
        when(landParcelService.readLandParcelsFromFiles()).thenReturn(landParcelMap);
        when(landParcelService.getFilesForCurrentMonth()).thenReturn(filesForCurrentMonth);

        // Run the application
        applicationService.runApplication();

        // Verify the behavior
        verify(landParcelService, times(1)).readLandParcelsFromFiles();
        verify(landParcelService, times(1)).getFilesForCurrentMonth();

        // Assertions
        assertEquals(landParcelMap.size(), 2);
        assertEquals(filesForCurrentMonth.size(), 2);
    }
}