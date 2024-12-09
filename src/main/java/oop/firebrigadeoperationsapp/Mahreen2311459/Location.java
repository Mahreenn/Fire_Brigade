package oop.firebrigadeoperationsapp.Mahreen2311459;

import java.io.Serializable;

public class Location implements Serializable {
    public double latitude;
    public double longitude;
    public int responseTimeEstimate;  //in minutes

    public Location(double latitude, double longitude, int responseTimeEstimate) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.responseTimeEstimate = responseTimeEstimate;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getResponseTimeEstimate() {
        return responseTimeEstimate;
    }

    public void setResponseTimeEstimate(int responseTimeEstimate) {
        this.responseTimeEstimate = responseTimeEstimate;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", responseTimeEstimate=" + responseTimeEstimate +
                '}';
    }

    // This method is a static factory method to create a Location based on a String name
    public static Location fromStringToLocation(String str) {
        switch (str) {
            case "Uttara":
                return new Location(23.8586, 90.4012, 50); // Example coordinates and response time
            case "Dhanmondi":
                return new Location(23.748, 90.3802, 7);
            case "Bashundhara":
                return new Location(23.8251, 90.4374, 8);
            case "Mirpur":
                return new Location(23.8156, 90.3471, 60);
            default:
                throw new IllegalArgumentException("Unknown location: " + str);
        }
    }

}
