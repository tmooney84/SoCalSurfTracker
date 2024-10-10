package com.surf.surftracker.tester;

import com.surf.surftracker.dto.SurfLine_weather_DTO;
import com.surf.surftracker.service.oldServices.SurfLine_weather_Service;

public class SLWeatherTester {
    public static void main(String[] args) {
        SurfLine_weather_Service service = new SurfLine_weather_Service();
        try {
            SurfLine_weather_DTO weatherDTO = service.getSurfLineWeather();
            // Print out the ratingDTO
            System.out.println(weatherDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

