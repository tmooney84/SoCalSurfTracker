package com.surf.surftracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurfSpotsDeprecated {
    private String spotName;
    private String sl_Rating_URL;
    private String sl_Sunlight_URL;
    private String sl_Surf_URL;
    private String sl_Swells_URL;
    private String sl_Tides_URL;
    private String sl_Weather_URL;
    private String sl_Wind_URL;
    private String deepSwell_URL;
    private String surfCaptain_URL;
    private String surfForecast_URL;
}
