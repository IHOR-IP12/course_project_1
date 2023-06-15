package repository;

import model.LandParcel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.CsvUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LandParcelRepositoryTest {
    private LandParcelRepository repository;
    private File testCsvFile;

    @BeforeEach
    public void setUp() {
        // Перед кожним тестом, створюємо новий репозиторій і мокуємо завантаження даних з CSV
        repository = new LandParcelRepository();

        // Мокуємо метод loadAllLandParcels() з CsvUtil, щоб повернути тестові дані
        CsvUtil.setLandParcels(mockLandParcels());
    }

    @Test
    public void testRemoveLandParcelById() throws IOException {
        // Arrange
        List<LandParcel> landParcels = new ArrayList<>();
        landParcels.add(new LandParcel(Double.parseDouble("1"), null, null, null, null));
        landParcels.add(new LandParcel(Double.parseDouble("2"), null, null, null, null));
        repository.overwriteLandParcels(landParcels);

        String id = "1";

        // Act
        repository.removeLandParcelById(id);

        // Assert
        List<LandParcel> updatedLandParcels = repository.getAllLandParcels();
        for (LandParcel landParcel : updatedLandParcels) {
            assertNull(landParcel.getId().equals(id));
        }
    }




    @Test
    public void testGetAllLandParcels() {
        List<LandParcel> expectedLandParcels = mockLandParcels();
        List<LandParcel> actualLandParcels = repository.getAllLandParcels();

        assertEquals(expectedLandParcels.size(), actualLandParcels.size());
        assertIterableEquals(expectedLandParcels, actualLandParcels);
    }

    @Test
    public void testGetLandParcelById() {
        String id = "1";
        LandParcel expectedLandParcel = mockLandParcels().get(0);
        LandParcel actualLandParcel = repository.getLandParcelById(id);

        assertNotNull(actualLandParcel);
        assertEquals(expectedLandParcel, actualLandParcel);
        List<LandParcel> landParcels = new ArrayList<>();
        landParcels.add(new LandParcel(Double.parseDouble("1"), null, null, null, null));
        landParcels.add(new LandParcel(Double.parseDouble("2"), null, null, null, null));
        repository.overwriteLandParcels(landParcels);

        id = "1";

        // Act
        LandParcel foundLandParcel = repository.getLandParcelById(id);

        // Assert
        assertEquals(id, foundLandParcel.getId());
    }

    @Test
    public void testGetLandParcelById_WithInvalidId() {
        String id = "99"; // Невірний ідентифікатор, який не існує
        LandParcel actualLandParcel = repository.getLandParcelById(id);

        assertNull(actualLandParcel);
    }

    @Test
    public void testCreateLandParcel() {
        LandParcel landParcel = new LandParcel(Double.parseDouble("3"), null, null, null, null);

        repository.createLandParcel(landParcel);

        List<LandParcel> landParcels = repository.getAllLandParcels();
        assertTrue(landParcels.contains(landParcel));
    }

    @Test
    public void testUpdateLandParcel() {
        String id = "1";
        LandParcel updatedLandParcel = new LandParcel(Double.parseDouble(id), null, null, null, null);

        repository.updateLandParcel(id, updatedLandParcel);

        LandParcel actualLandParcel = repository.getLandParcelById(id);
        assertEquals(updatedLandParcel, actualLandParcel);
    }

    @Test
    public void testDeleteLandParcel() {
        String id = "1";

        repository.deleteLandParcel(id);

        LandParcel deletedLandParcel = repository.getLandParcelById(id);
        assertNull(deletedLandParcel);
    }

    @Test
    public void testOverwriteLandParcels() throws IOException {
        List<LandParcel> landParcels = new ArrayList<>();
        LandParcel landParcel1 = new LandParcel(Double.parseDouble("1"), null, null, null, null);
        LandParcel landParcel2 = new LandParcel(Double.parseDouble("2"), null, null, null, null);
        landParcels.add(landParcel1);
        landParcels.add(landParcel2);

        repository.overwriteLandParcels(landParcels);

        List<LandParcel> actualLandParcels = CsvUtil.loadAllLandParcels();
        assertEquals(landParcels.size(), actualLandParcels.size());
        assertIterableEquals(landParcels, actualLandParcels);
    }

    @Test
    public void testGetFilesForMonth() {
        List<String> expectedFiles = new ArrayList<>();
        expectedFiles.add("file1.csv");
        expectedFiles.add("file2.csv");
        CsvUtil.setFilesForMonth(expectedFiles);

        List<String> actualFiles = repository.getFilesForMonth();

        assertEquals(expectedFiles.size(), actualFiles.size());
        assertIterableEquals(expectedFiles, actualFiles);
    }

    // Метод для мокування тестових даних
    private List<LandParcel> mockLandParcels() {
        List<LandParcel> landParcels = new ArrayList<>();
        landParcels.add(new LandParcel(Double.parseDouble("1"), null, null, null, null));
        landParcels.add(new LandParcel(Double.parseDouble("2"), null, null, null, null));
        return landParcels;
    }
}
