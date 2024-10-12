package com.surf.surftracker.tester;

import com.surf.surftracker.dto.SurfLine_sunlight_DTO;
import com.surf.surftracker.service.oldServices.SurfLine_sunlight_Service;

public class SLSunlightTester {
    public static void main(String[] args) {
        SurfLine_sunlight_Service service = new SurfLine_sunlight_Service();
        try {
            SurfLine_sunlight_DTO sunlightDTO = service.getSurfLineSunlight();
            // Print out the ratingDTO
            System.out.println(sunlightDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

