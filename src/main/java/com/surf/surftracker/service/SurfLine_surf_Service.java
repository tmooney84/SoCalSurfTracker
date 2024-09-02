package com.surf.surftracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surf.surftracker.dto.SurfLine_surf_DTO;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SurfLine_surf_Service implements Serializable {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private static final Logger LOGGER = Logger.getLogger(SurfLine_surf_Service.class.getName());
//@Scheduled 11pm
    public SurfLine_surf_Service() {
        this.webClient = WebClient.builder().build();
        this.objectMapper = new ObjectMapper();
    }

    public SurfLine_surf_DTO getSurfLineSurf() throws Exception {
        String surfLineSurf_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/surf?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a770888a&units[waveHeight]=FT";

        try {
            String response = webClient.get()
                    .uri(surfLineSurf_LowerTrestles)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            //To test the valid response case
           // LOGGER.info("Response: " + response);

            // Deserialize the JSON response to the SurfLine_surf_DTO class
            return objectMapper.readValue(response, SurfLine_surf_DTO.class);
        } catch (WebClientResponseException e) {
            LOGGER.log(Level.SEVERE, "Error response code: " + e.getRawStatusCode());
            LOGGER.log(Level.SEVERE, "Error response body: " + e.getResponseBodyAsString());
            throw e;
        }
    }
}
