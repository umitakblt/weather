package com.umitakblut.weather.external.weather.model;

import java.io.Serializable;

public class WeatherExternalResponseDTO implements Serializable {
    private Current current;
    private Location location;

    public WeatherExternalResponseDTO() {
    }

    public WeatherExternalResponseDTO(Current current, Location location) {
        this.current = current;
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "WeatherExternalResponseDTO{" +
                "current=" + current +
                ", location=" + location +
                '}';
    }
}
