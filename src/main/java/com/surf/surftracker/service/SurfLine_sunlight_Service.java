package com.surf.surftracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surf.surftracker.dto.SurfLine_sunlight_DTO;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;

public class SurfLine_sunlight_Service implements Serializable {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public SurfLine_sunlight_Service() {
        this.webClient = WebClient.builder().build();
        this.objectMapper = new ObjectMapper();
    }

    //Webclient to a GET method and pull the JSON for mapping
    public SurfLine_sunlight_DTO getSurfLineSunlight() throws Exception {
        String surfLineSunlight_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/sunlight?spotId=5842041f4e65fad6a770888a&days=16&intervalHours=1";

        String response = webClient.get()
                .uri(surfLineSunlight_LowerTrestles)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Deserialize the JSON response to the SurfLine_rating_DTO class
        SurfLine_sunlight_DTO surfLineSunlight = objectMapper.readValue(response, SurfLine_sunlight_DTO.class);
        return surfLineSunlight;
    }
}
