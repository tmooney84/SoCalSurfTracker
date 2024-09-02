package com.surf.surftracker;

import com.surf.surftracker.dto.SurfLine_swells_DTO;
import com.surf.surftracker.service.SurfLine_swells_Service;

public class SLSwellsTester {
    public static void main(String[] args) {
        SurfLine_swells_Service service = new SurfLine_swells_Service();
        try {
            SurfLine_swells_DTO swellsDTO = service.getSurfLineSwells();
            // Print out the ratingDTO
            System.out.println(swellsDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
