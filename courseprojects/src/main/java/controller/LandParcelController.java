package controller;

import model.LandParcel;
import org.springframework.web.bind.annotation.*;
import service.LandParcelService;
import java.util.*;
@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/landParcels")
public class LandParcelController {
	private LandParcelService landParcelService;

	public LandParcelController(LandParcelService landParcelService) {
		this.landParcelService = landParcelService;
	}

	@GetMapping
	public List<LandParcel> getAllLandParcels() {
		return landParcelService.getAllLandParcels();
	}

	@GetMapping("/{id}")
	public LandParcel getLandParcelById(@PathVariable String id) {
		return landParcelService.getLandParcelById(id);
	}

	@PostMapping
	public void createLandParcel(@RequestBody LandParcel landParcel) {
		landParcelService.createLandParcel(landParcel);
	}

	@PutMapping("/{id}")
	public void updateLandParcel(@PathVariable String id, @RequestBody LandParcel updatedLandParcel) {
		landParcelService.updateLandParcel(id, updatedLandParcel);
	}

	@DeleteMapping("/{id}")
	public void deleteLandParcel(@PathVariable String id) {
		landParcelService.deleteLandParcel(id);
	}

	@GetMapping("/2")
	public LandParcel getLandParcelWithIdTwo() {
		return landParcelService.getLandParcelById("2");
	}
}
