package com.umitakblut.weather.external.weather;


import com.umitakblut.weather.external.weather.model.WeatherExternalResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-service", url = "http://api.weatherapi.com/v1")
public interface WeatherExternalService {
    @GetMapping (value = "/current.json")
    WeatherExternalResponseDTO getWeather(@RequestParam(value = "q") String q,
                                          @RequestParam(value = "key") String key);

}
