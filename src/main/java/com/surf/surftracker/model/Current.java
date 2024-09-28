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

    public Current(String surfSpotName, String averageWaveHeight, String waveQuality, String surfLineWaveHeight, String surfCaptainWaveHeight,
                   String deepSwellWaveHeight, String surfForecastWaveHeight, String wind, String tide, String futureTide, String waterTemperature,
                   String airTemperature, String sunrise, String sunset, String weatherConditions, String swellOne, String swellTwo, String swellThree){
        this.surfSpotName = surfSpotName;
        this.averageWaveHeight = averageWaveHeight;
        this.waveQuality = waveQuality;
        this.surfLineWaveHeight = surfLineWaveHeight;
        this.surfCaptainWaveHeight = surfCaptainWaveHeight;
        this.deepSwellWaveHeight = deepSwellWaveHeight;
        this.surfForecastWaveHeight = surfForecastWaveHeight;
        this.wind = wind;
        this.tide = tide;
        this.futureTide = futureTide;
        this.waterTemperature = waterTemperature;
        this.airTemperature = airTemperature;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.weatherConditions = weatherConditions;
        this.swellOne = swellOne;
        this.swellTwo = swellTwo;
        this.swellThree = swellThree;
    }
}
