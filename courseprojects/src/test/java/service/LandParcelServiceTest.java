package service;

import model.LandParcel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.LandParcelRepository;
import util.CsvUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LandParcelServiceTest {
    @Mock
    private LandParcelRepository landParcelRepository;

    @Mock
    private CsvUtil csvUtil;

    @InjectMocks
    private LandParcelService landParcelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllLandParcels() {
        // Set up the test data
        List<LandParcel> expectedLandParcels = new ArrayList<>();
        when(landParcelRepository.getAllLandParcels()).thenReturn(expectedLandParcels);

        // Call the service method
        List<LandParcel> actualLandParcels = landParcelService.getAllLandParcels();

        // Verify the result
        assertEquals(expectedLandParcels, actualLandParcels);
        verify(landParcelRepository, times(1)).getAllLandParcels();
        verifyNoMoreInteractions(landParcelRepository);
    }

    @Test
    public void testGetLandParcelById() {
        // Set up the test data
        String id = "1";
        LandParcel expectedLandParcel = new LandParcel(Double.parseDouble(id), null, null, null, null);
        when(landParcelRepository.getLandParcelById(id)).thenReturn(expectedLandParcel);

        // Call the service method
        LandParcel actualLandParcel = landParcelService.getLandParcelById(id);

        // Verify the result
        assertEquals(expectedLandParcel, actualLandParcel);
        verify(landParcelRepository, times(1)).getLandParcelById(id);
        verifyNoMoreInteractions(landParcelRepository);
    }

    @Test
    public void testCreateLandParcel() {
        // Set up the test data
        LandParcel landParcel = new LandParcel(Double.parseDouble("1"), null, null, null, null);

        // Call the service method
        landParcelService.createLandParcel(landParcel);

        // Verify that the repository method was called with the correct argument
        verify(landParcelRepository, times(1)).createLandParcel(landParcel);
        verifyNoMoreInteractions(landParcelRepository);
    }

    @Test
    public void testUpdateLandParcel() {
        // Set up the test data
        String id = "1";
        LandParcel updatedLandParcel = new LandParcel(Double.parseDouble(id), null, null, null, null);

        // Call the service method
        landParcelService.updateLandParcel(id, updatedLandParcel);

        // Verify that the repository method was called with the correct arguments
        verify(landParcelRepository, times(1)).updateLandParcel(id, updatedLandParcel);
        verifyNoMoreInteractions(landParcelRepository);
    }

    @Test
    public void testDeleteLandParcel() {
        // Set up the test data
        String id = "1";

        // Call the service method
        landParcelService.deleteLandParcel(id);

        // Verify that the repository method was called with the correct argument
        verify(landParcelRepository, times(1)).deleteLandParcel(id);
        verifyNoMoreInteractions(landParcelRepository);
    }

    @Test
    public void testGetFilesForCurrentMonth() {
        // Set up the test data
        List<File> expectedFiles = new ArrayList<>();
        when(csvUtil.loadLandParcelsFromFile(any(File.class))).thenReturn(new ArrayList<>());

        // Call the service method
        List<File> actualFiles = landParcelService.getFilesForCurrentMonth();

        // Verify the result
        assertEquals(expectedFiles, actualFiles);
    }

    @Test
    public void testReadLandParcelsFromFiles() {
        // Set up the test data
        Map<String, LandParcel> expectedLandParcelMap = new HashMap<>();
        List<File> files = new ArrayList<>();
        files.add(new File("file1.csv"));
        files.add(new File("file2.csv"));
        when(landParcelService.getFilesForCurrentMonth()).thenReturn(files);
        when(csvUtil.loadLandParcelsFromFile(any(File.class))).thenReturn(new ArrayList<>());

        // Call the service method
        Map<String, LandParcel> actualLandParcelMap = landParcelService.readLandParcelsFromFiles();

        // Verify the result
        assertEquals(expectedLandParcelMap, actualLandParcelMap);
    }

    @Test
    public void testExtractYearFromFileName() {
        LandParcelService landParcelService = new LandParcelService();
        String fileName = "parcel_2023.csv";
        int year = landParcelService.extractYearFromFileName(fileName);
        Assertions.assertEquals(2023, year);
    }
}