package controller;

import model.LandParcel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.LandParcelService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LandParcelControllerTest {
    @Mock
    private LandParcelService landParcelService;

    @InjectMocks
    private LandParcelController landParcelController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllLandParcels() {
        // Mock the service to return a list of land parcels
        List<LandParcel> expectedLandParcels = Arrays.asList(
                new LandParcel(Double.parseDouble("1"), null, null, null, null),
                new LandParcel(Double.parseDouble("2"), null, null, null, null)
        );
        when(landParcelService.getAllLandParcels()).thenReturn(expectedLandParcels);

        // Call the controller method
        List<LandParcel> actualLandParcels = landParcelController.getAllLandParcels();

        // Verify the result
        assertEquals(expectedLandParcels, actualLandParcels);
        verify(landParcelService, times(1)).getAllLandParcels();
        verifyNoMoreInteractions(landParcelService);
    }

    @Test
    public void testGetLandParcelById() {
        // Mock the service to return a land parcel
        String id = "1";
        LandParcel expectedLandParcel = new LandParcel(Double.parseDouble(id), null, null, null, null);
        when(landParcelService.getLandParcelById(id)).thenReturn(expectedLandParcel);

        // Call the controller method
        LandParcel actualLandParcel = landParcelController.getLandParcelById(id);

        // Verify the result
        assertEquals(expectedLandParcel, actualLandParcel);
        verify(landParcelService, times(1)).getLandParcelById(id);
        verifyNoMoreInteractions(landParcelService);
    }

    @Test
    public void testCreateLandParcel() {
        // Create a new land parcel
        LandParcel landParcel = new LandParcel(Double.parseDouble("1"), null, null, null, null);

        // Call the controller method
        landParcelController.createLandParcel(landParcel);

        // Verify that the service method was called with the correct arguments
        verify(landParcelService, times(1)).createLandParcel(landParcel);
        verifyNoMoreInteractions(landParcelService);
    }

    @Test
    public void testUpdateLandParcel() {
        // Set up the test data
        String id = "1";
        LandParcel updatedLandParcel = new LandParcel(Double.parseDouble(id), null, null, null, null);

        // Call the controller method
        landParcelController.updateLandParcel(id, updatedLandParcel);

        // Verify that the service method was called with the correct arguments
        verify(landParcelService, times(1)).updateLandParcel(id, updatedLandParcel);
        verifyNoMoreInteractions(landParcelService);
    }

    @Test
    public void testDeleteLandParcel() {
        // Set up the test data
        String id = "1";

        // Call the controller method
        landParcelController.deleteLandParcel(id);

        // Verify that the service method was called with the correct argument
        verify(landParcelService, times(1)).deleteLandParcel(id);
        verifyNoMoreInteractions(landParcelService);
    }

    @Test
    public void testGetLandParcelWithIdTwo() {
        // Set up the test data
        String id = "2";
        LandParcel expectedLandParcel = new LandParcel(Double.parseDouble(id), null, null, null, null);
        when(landParcelService.getLandParcelById(id)).thenReturn(expectedLandParcel);

        // Call the controller method
        LandParcel actualLandParcel = landParcelController.getLandParcelWithIdTwo();

        // Verify the result
        assertEquals(expectedLandParcel, actualLandParcel);
        verify(landParcelService, times(1)).getLandParcelById(id);
        verifyNoMoreInteractions(landParcelService);
    }

}
