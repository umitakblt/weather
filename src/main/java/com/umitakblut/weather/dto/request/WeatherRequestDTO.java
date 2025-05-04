package com.umitakblut.weather.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class WeatherRequestDTO implements Serializable {
    @NotNull
    @NotEmpty
    private String cityName;

    public WeatherRequestDTO() {
    }

    public WeatherRequestDTO(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "WeatherRequestDTO{" +
                "cityName='" + cityName + '\'' +
                '}';
    }
}
