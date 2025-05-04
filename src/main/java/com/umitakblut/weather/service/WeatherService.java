package com.umitakblut.weather.service;

import com.umitakblut.weather.dto.request.WeatherRequestDTO;
import com.umitakblut.weather.dto.response.WeatherResponseDTO;

public interface WeatherService {
    WeatherResponseDTO weatherCheck(WeatherRequestDTO weatherRequestDTO);
}
