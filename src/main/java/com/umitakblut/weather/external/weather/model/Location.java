package com.umitakblut.weather.external.weather.model;

import java.io.Serializable;

public class Location implements Serializable {
    private String name;
    private String region;
    private String country;
    private Double lat;
    private Double lon;
    private String tz_id;
    private Long localtime_epoch;
    public String localtime;

    public Location() {
    }

    public Location(String name, String region, String country, Double lat, Double lon, String tz_id, Long localtime_epoch, String localtime) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.tz_id = tz_id;
        this.localtime_epoch = localtime_epoch;
        this.localtime = localtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTz_id() {
        return tz_id;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }

    public Long getLocaltime_epoch() {
        return localtime_epoch;
    }

    public void setLocaltime_epoch(Long localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", tz_id='" + tz_id + '\'' +
                ", localtime_epoch=" + localtime_epoch +
                ", localtime='" + localtime + '\'' +
                '}';
    }
}

