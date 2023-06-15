package model;

import java.util.Objects;
@SuppressWarnings("CheckStyle")
public class LandParcel {
    public double longitude;
    public double moistureLevel;
    public double lightLevel;
    private double latitude;
    private String id;
    private Location location;
    private SoilMoisture soilMoisture;
    private Illumination illumination;

    public LandParcel(String latitude, double id, final Location location, SoilMoisture soilMoisture, Illumination illumination) {
        this.id = String.valueOf(id);
        this.location = location;
        this.soilMoisture = soilMoisture;
        this.illumination = illumination;
    }

    public LandParcel(String id, Location location, SoilMoisture soilMoisture) {

    }

    public LandParcel(double latitude, String id, Location location, SoilMoisture soilMoisture, Illumination illumination) {

    }

    public LandParcel(String number, double v, double v1, double v2, double v3) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;

    }

    public SoilMoisture getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(SoilMoisture soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public Illumination getIllumination() {
        return illumination;
    }

    public void setIllumination(Illumination illumination) {
        this.illumination = illumination;
    }

    public String toCSV() {
        return id + "," +
                Objects.toString(location != null ? location.getLatitude() : null, "") + "," +
                Objects.toString(location != null ? location.getLongitude() : null, "") + "," +
                Objects.toString(soilMoisture != null ? soilMoisture.getMoistureLevel() : null, "") + "," +
                Objects.toString(illumination != null ? illumination.getLightLevel() : null, "");
    }


    public short getLatitude() {
        return 0;
    }

    public double getLongitude() {
        return 0;
    }
}