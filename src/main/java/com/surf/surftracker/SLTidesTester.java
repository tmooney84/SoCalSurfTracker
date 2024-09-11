package com.surf.surftracker;

import com.surf.surftracker.dto.SurfLine_tides_DTO;
import com.surf.surftracker.service.oldServices.SurfLine_tides_Service;

public class SLTidesTester {
    public static void main(String[] args) {
        SurfLine_tides_Service service = new SurfLine_tides_Service();
        try {
            SurfLine_tides_DTO tidesDTO = service.getSurfLineTides();
            // Print out the ratingDTO
            System.out.println(tidesDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

