package com.umitakblut.weather.exception;

public enum WeatherExceptionEnum {
    WEATHER_EXTERNAL_SERVICE_ERROR("Weather External Service Error", "WEATHER_EXTERNAL_SERVICE_ERROR"),
    WEATHER_EXTERNAL_SERVICE_NULL_ERROR("Weather External Service Null Error", "WEATHER_EXTERNAL_SERVICE_NULL_ERROR");

    private final String message;
    private final String key;

    WeatherExceptionEnum(String message, String key) {
        this.message = message;
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public String getKey() {
        return key;
    }
}
