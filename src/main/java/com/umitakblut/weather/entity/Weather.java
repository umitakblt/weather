package com.umitakblut.weather.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "weather")
public class Weather implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "temp_celcius", nullable = false)
    private Double tempCelcius;

    @Column(name = "temp_fahrenheit", nullable = false)
    private Double tempFahrenheit;

    public Weather() {
    }

    public Weather(Long id, String cityName, Double tempCelcius, Double tempFahrenheit) {
        this.id = id;
        this.cityName = cityName;
        this.tempCelcius = tempCelcius;
        this.tempFahrenheit = tempFahrenheit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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
        return "Weather{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", tempCelcius=" + tempCelcius +
                ", tempFahrenheit=" + tempFahrenheit +
                '}';
    }
}
