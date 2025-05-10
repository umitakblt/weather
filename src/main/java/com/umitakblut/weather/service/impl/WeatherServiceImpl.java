package com.umitakblut.weather.service.impl;

import com.umitakblut.weather.dto.request.WeatherRequestDTO;
import com.umitakblut.weather.dto.response.WeatherResponseDTO;
import com.umitakblut.weather.entity.Weather;
import com.umitakblut.weather.exception.WeatherException;
import com.umitakblut.weather.exception.WeatherExceptionEnum;
import com.umitakblut.weather.external.weather.WeatherExternalService;
import com.umitakblut.weather.external.weather.model.WeatherExternalResponseDTO;
import com.umitakblut.weather.repository.WeatherRepository;
import com.umitakblut.weather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);
    private final WeatherExternalService weatherExternalService;
    private final WeatherRepository weatherRepository;

    private static final String WEATHER_API_KEY = "8d59968cf77a4e87974182359250405";

    public WeatherServiceImpl(WeatherExternalService weatherExternalService,
                              WeatherRepository weatherRepository) {
        this.weatherExternalService = weatherExternalService;
        this.weatherRepository = weatherRepository;
    }

    @Cacheable(key = "#weatherRequestDTO.cityName", value = "weatherChecks")
    @Override
    public WeatherResponseDTO weatherCheck(WeatherRequestDTO weatherRequestDTO) {
        log.info("WeatherServiceImpl.weatherCheck(): weatherRequestDTO: {}", weatherRequestDTO);
        WeatherExternalResponseDTO weatherExternalResponseDTO;
        try {
            weatherExternalResponseDTO = weatherExternalService.getWeather(weatherRequestDTO.getCityName(), WEATHER_API_KEY);
            log.info("WeatherServiceImpl.weatherCheck(): weatherExternalResponseDTO: {}", weatherExternalResponseDTO);
        } catch (Exception e) {
            log.error("WeatherServiceImpl.weatherCheck(): Exception occurred while getting weather", e);
            throw new WeatherException(WeatherExceptionEnum.WEATHER_EXTERNAL_SERVICE_ERROR);
        }

        if (weatherExternalResponseDTO == null || weatherExternalResponseDTO.getCurrent() == null) {
            log.error("WeatherServiceImpl.weatherCheck(): weatherExternalResponseDTO: {}", weatherExternalResponseDTO);
            throw new WeatherException(WeatherExceptionEnum.WEATHER_EXTERNAL_SERVICE_NULL_ERROR);
        }

        Weather weather = new Weather();
        weather.setCityName(weatherRequestDTO.getCityName());
        weather.setTempCelcius(weatherExternalResponseDTO.getCurrent().getTemp_c());
        weather.setTempFahrenheit(weatherExternalResponseDTO.getCurrent().getTemp_f());
        this.weatherRepository.save(weather);

        return new WeatherResponseDTO(weatherExternalResponseDTO.getCurrent().getTemp_c(),
                weatherExternalResponseDTO.getCurrent().getTemp_f());
    }
}
