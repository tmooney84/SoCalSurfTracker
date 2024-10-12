
package com.surf.surftracker.service.oldServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surf.surftracker.dto.SurfLine_wind_DTO;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SurfLine_wind_Service implements Serializable {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private static final Logger LOGGER = Logger.getLogger(SurfLine_wind_Service.class.getName());

    public SurfLine_wind_Service() {
        this.webClient = WebClient.builder().build();
        this.objectMapper = new ObjectMapper();
    }

    public SurfLine_wind_DTO getSurfLineWind() throws Exception {
        String surfLineWind_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/wind?spotId=5842041f4e65fad6a770888a&days=5&intervalHours=1&corrected=false&cacheEnabled=true&units[windSpeed]=KTS";

        try {
            String response = webClient.get()
                    .uri(surfLineWind_LowerTrestles)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            //To test the valid response case
            // LOGGER.info("Response: " + response);

            // Deserialize the JSON response to the SurfLine_wind_DTO class
            return objectMapper.readValue(response, SurfLine_wind_DTO.class);
        } catch (WebClientResponseException e) {
            LOGGER.log(Level.SEVERE, "Error response code: " + e.getRawStatusCode());
            LOGGER.log(Level.SEVERE, "Error response body: " + e.getResponseBodyAsString());
            throw e;
        }
    }
}
