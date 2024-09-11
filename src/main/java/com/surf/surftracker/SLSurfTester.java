package com.surf.surftracker;

import com.surf.surftracker.dto.SurfLine_surf_DTO;
import com.surf.surftracker.service.oldServices.SurfLine_surf_Service;

public class SLSurfTester {
    public static void main(String[] args) {
        SurfLine_surf_Service service = new SurfLine_surf_Service();
        try {
            SurfLine_surf_DTO surfDTO = service.getSurfLineSurf();
            System.out.println(surfDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
