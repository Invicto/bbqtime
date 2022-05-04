package com.zsenyuk.bbqtime.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class WeatherData {
    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private Current current;
    private List<Minutely> minutely;
    private ArrayList<Alert> alerts;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(int timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public List<Minutely> getMinutely() {
        return minutely;
    }

    public void setMinutely(List<Minutely> minutely) {
        this.minutely = minutely;
    }

    public ArrayList<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(ArrayList<Alert> alerts) {
        this.alerts = alerts;
    }

    public double getSumPrecipitation() {
        BinaryOperator<Double> sum = (x1, x2) -> x1 + x2;
        return minutely.stream()
                .map(m -> m.getPrecipitation())
                .reduce(sum).get().doubleValue();
    }

    public double getTempInCelsius(){
        return current.getTemp()-273.15;
    }

}

