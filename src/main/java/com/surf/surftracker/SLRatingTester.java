package com.surf.surftracker;

import com.surf.surftracker.dto.SurfLine_rating_DTO;
import com.surf.surftracker.service.SurfLine_rating_Service;

public class SLRatingTester {
    public static void main(String[] args) {
        SurfLine_rating_Service service = new SurfLine_rating_Service();
        try {
            SurfLine_rating_DTO ratingDTO = service.getSurfLineRating();
            // Print out the ratingDTO
            System.out.println(ratingDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

