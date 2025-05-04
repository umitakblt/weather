package com.umitakblut.weather.controller;

import com.umitakblut.weather.dto.request.WeatherRequestDTO;
import com.umitakblut.weather.dto.response.WeatherResponseDTO;
import com.umitakblut.weather.service.WeatherService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/weather")
public class WeatherController {
    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/weather-check")
    public ResponseEntity<WeatherResponseDTO> weatherCheck(@Valid @RequestBody WeatherRequestDTO weatherRequestDTO) {
        log.info("WeatherController.weatherCheck(): weatherRequestDTO: {}", weatherRequestDTO);
        return ResponseEntity.ok(this.weatherService.weatherCheck(weatherRequestDTO));
    }

}
