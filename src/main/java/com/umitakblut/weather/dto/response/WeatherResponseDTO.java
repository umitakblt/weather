package com.umitakblut.weather.dto.response;

import java.io.Serializable;

public class WeatherResponseDTO implements Serializable {
    private Double tempCelcius;
    private Double tempFahrenheit;

    public WeatherResponseDTO() {
    }

    public WeatherResponseDTO(Double tempCelcius, Double tempFahrenheit) {
        this.tempCelcius = tempCelcius;
        this.tempFahrenheit = tempFahrenheit;
    }

    public Double getTempCelcius() {
        return tempCelcius;
    }

    public void setTempCelcius(Double tempCelcius) {
        this.tempCelcius = tempCelcius;
    }

    public Double getTempFahrenheit() {
        return tempFahrenheit;
    }

    public void setTempFahrenheit(Double tempFahrenheit) {
        this.tempFahrenheit = tempFahrenheit;
    }

    @Override
    public String toString() {
        return "WeatherResponseDTO{" +
                "tempCelcius=" + tempCelcius +
                ", tempFahrenheit=" + tempFahrenheit +
                '}';
    }
}
