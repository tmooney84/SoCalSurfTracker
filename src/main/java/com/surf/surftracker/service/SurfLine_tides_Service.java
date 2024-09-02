package com.surf.surftracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surf.surftracker.dto.SurfLine_tides_DTO;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;

public class SurfLine_tides_Service implements Serializable {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public SurfLine_tides_Service() {
        this.webClient = WebClient.builder().build();
        this.objectMapper = new ObjectMapper();
    }

    //Webclient to a GET method and pull the JSON for mapping
    public SurfLine_tides_DTO getSurfLineTides() throws Exception {
        String surfLineTides_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/tides?spotId=5842041f4e65fad6a770888a&days=6&cacheEnabled=true&units[tideHeight]=FT";

        String response = webClient.get()
                .uri(surfLineTides_LowerTrestles)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Deserialize the JSON response to the SurfLine_rating_DTO class
        SurfLine_tides_DTO surfLineTides = objectMapper.readValue(response, SurfLine_tides_DTO.class);
        return surfLineTides;
    }
}
