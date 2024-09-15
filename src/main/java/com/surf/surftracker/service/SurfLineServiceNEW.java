package com.surf.surftracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surf.surftracker.dto.*;
import com.surf.surftracker.service.oldServices.SurfLine_surf_Service;
import com.surf.surftracker.util.SurfSpotURLList;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SurfLineServiceNEW implements Serializable{
        private final WebClient webClient;
        private final ObjectMapper objectMapper;
        private final String surfLineId;
    private static final Logger LOGGER = Logger.getLogger(SurfLine_surf_Service.class.getName());

        public SurfLineServiceNEW(String surfLineId) {
            this.webClient = WebClient.builder().build();
            this.objectMapper = new ObjectMapper();
            this.surfLineId = surfLineId;
        }



        //Webclient to a GET method and pull the JSON for mapping
        public SurfLine_rating_DTO getSurfLineRating() throws Exception {
            String surfLineRating_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/rating?spotId=" + surfLineId + "&days=5&intervalHours=1&cacheEnabled=trued";
            // String SurfSpotURLFactory.LowerTrestles
            //LowerTrestles.getRatingURL();
            String response = webClient.get()
                    .uri(surfLineRating_LowerTrestles)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // Deserialize the JSON response to the SurfLine_rating_DTO class
            SurfLine_rating_DTO surfLineRating = objectMapper.readValue(response, SurfLine_rating_DTO.class);
            return surfLineRating;
        }



    //Webclient to a GET method and pull the JSON for mapping
    public SurfLine_sunlight_DTO getSurfLineSunlight() throws Exception {
        String surfLineSunlight_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/sunlight?spotId=" + surfLineId + "&days=16&intervalHours=1";

        String response = webClient.get()
                .uri(surfLineSunlight_LowerTrestles)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Deserialize the JSON response to the SurfLine_rating_DTO class
        SurfLine_sunlight_DTO surfLineSunlight = objectMapper.readValue(response, SurfLine_sunlight_DTO.class);
        return surfLineSunlight;
    }



    public SurfLine_surf_DTO getSurfLineSurf() throws Exception {
        String surfLineSurf_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/surf?cacheEnabled=true&days=5&intervalHours=1&spotId="+ surfLineId + "&units[waveHeight]=FT";

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



    //Webclient to a GET method and pull the JSON for mapping
    public SurfLine_swells_DTO getSurfLineSwells() throws Exception {
        String surfLineSwells_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/swells?cacheEnabled=true&days=5&intervalHours=1&spotId="+ surfLineId +"&units[swellHeight]=FT";

        String response = webClient.get()
                .uri(surfLineSwells_LowerTrestles)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Deserialize the JSON response to the SurfLine_rating_DTO class
        SurfLine_swells_DTO surfLineSwells = objectMapper.readValue(response, SurfLine_swells_DTO.class);
        return surfLineSwells;
    }



    //Webclient to a GET method and pull the JSON for mapping
    public SurfLine_tides_DTO getSurfLineTides() throws Exception {
        String surfLineTides_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/tides?spotId="+ surfLineId + "&days=6&cacheEnabled=true&units[tideHeight]=FT";

        String response = webClient.get()
                .uri(surfLineTides_LowerTrestles)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Deserialize the JSON response to the SurfLine_rating_DTO class
        SurfLine_tides_DTO surfLineTides = objectMapper.readValue(response, SurfLine_tides_DTO.class);
        return surfLineTides;
    }


    //Webclient to a GET method and pull the JSON for mapping
    public SurfLine_weather_DTO getSurfLineWeather() throws Exception {
        String surfLineWeather_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/weather?spotId=" + surfLineId + "&days=16&intervalHours=1&cacheEnabled=true&units[temperature]=F";

        String response = webClient.get()
                .uri(surfLineWeather_LowerTrestles)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Deserialize the JSON response to the SurfLine_rating_DTO class
        SurfLine_weather_DTO surfLineWeather = objectMapper.readValue(response, SurfLine_weather_DTO.class);
        return surfLineWeather;
    }


    public SurfLine_wind_DTO getSurfLineWind() throws Exception {
        String surfLineWind_LowerTrestles = "https://services.surfline.com/kbyg/spots/forecasts/wind?spotId=" + surfLineId + "&days=5&intervalHours=1&corrected=false&cacheEnabled=true&units[windSpeed]=KTS";

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



