package com.surf.surftracker.service.oldServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surf.surftracker.dto.SurfLine_swells_DTO;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.Serializable;

public class SurfLine_swells_Service implements Serializable {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public SurfLine_swells_Service() {
        this.webClient = WebClient.builder().build();
        this.objectMapper = new ObjectMapper();
    }

    //Webclient to a GET method and pull the JSON for mapping
    public SurfLine_swells_DTO getSurfLineSwells() throws Exception {
        String surfLineSwells_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/swells?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a770888a&units[swellHeight]=FT";

        String response = webClient.get()
                .uri(surfLineSwells_LowerTrestles)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Deserialize the JSON response to the SurfLine_rating_DTO class
        SurfLine_swells_DTO surfLineSwells = objectMapper.readValue(response, SurfLine_swells_DTO.class);
        return surfLineSwells;
    }
}