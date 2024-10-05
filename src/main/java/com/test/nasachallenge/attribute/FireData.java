package com.test.nasachallenge.attribute;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class FireData {
    private double latitude;
    private double longitude;
    private double brightness;

    private String Date;
    private String satellite;
    private String instrument;

    public FireData(double latitude, double longitude, double brightness, String date, String satellite, String instrument) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.brightness = brightness;
        Date = date;
        this.satellite = satellite;
        this.instrument = instrument;
    }

    public FireData() {
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

    public double getBrightness() {
        return brightness;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSatellite() {
        return satellite;
    }

    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }


}
