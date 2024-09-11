package com.surf.surftracker;

import com.surf.surftracker.dto.SurfLine_wind_DTO;
import com.surf.surftracker.service.oldServices.SurfLine_wind_Service;

public class SLWindTester {
    public static void main(String[] args) {
        SurfLine_wind_Service service = new SurfLine_wind_Service();
        try {
            SurfLine_wind_DTO windDTO = service.getSurfLineWind();
            // Print out the ratingDTO
            System.out.println(windDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

