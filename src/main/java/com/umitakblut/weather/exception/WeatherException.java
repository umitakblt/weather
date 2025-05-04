package com.umitakblut.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class WeatherException extends RuntimeException {
    private String key;

    public WeatherException(WeatherExceptionEnum weatherExceptionEnum) {
        super(weatherExceptionEnum.getMessage());
        this.key = weatherExceptionEnum.getKey();
    }

    public String getKey() {
        return key;
    }
}
