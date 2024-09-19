package com.surf.surftracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Current {
    private int surfSpotId;
    private String surfSpotName;
    private String averageWaveHeight;
    private String waveQuality;
    private String surfLineWaveHeight;
    private String surfCaptainWaveHeight;
    private String deepSwellWaveHeight;
    private String surfForecastWaveHeight;
    private String wind;
    private String tide;
    private String futureTide;
    private String waterTemperature;
    private String airTemperature;
    private String sunrise;
    private String sunset;
    private String weatherConditions;
    private String swellOne;
    private String swellTwo;
    private String swellThree;
}
