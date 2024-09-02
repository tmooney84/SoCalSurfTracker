package com.surf.surftracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surf.surftracker.dto.SurfLine_weather_DTO;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;

public class SurfLine_weather_Service implements Serializable {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public SurfLine_weather_Service() {
        this.webClient = WebClient.builder().build();
        this.objectMapper = new ObjectMapper();
    }

    //Webclient to a GET method and pull the JSON for mapping
    public SurfLine_weather_DTO getSurfLineWeather() throws Exception {
        String surfLineWeather_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/weather?spotId=5842041f4e65fad6a770888a&days=16&intervalHours=1&cacheEnabled=true&units[temperature]=F";

        String response = webClient.get()
                .uri(surfLineWeather_LowerTrestles)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Deserialize the JSON response to the SurfLine_rating_DTO class
        SurfLine_weather_DTO surfLineWeather = objectMapper.readValue(response, SurfLine_weather_DTO.class);
        return surfLineWeather;
    }
}
