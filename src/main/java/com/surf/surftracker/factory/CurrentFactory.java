package com.surf.surftracker.factory;

import com.surf.surftracker.dto.*;
import com.surf.surftracker.mapper.CurrentMapperNEW;
import com.surf.surftracker.model.Current;
import com.surf.surftracker.service.*;
import com.surf.surftracker.util.SurfSpotURLs;

public class CurrentFactory {
	private SurfSpotURLs spotURLs;
	private Current current;
	CurrentFactory(SurfSpotURLs spotURLs) {
		this.spotURLs = spotURLs;
	}

	public static Current createCurrent (SurfSpotURLs spotURLs) throws Exception {
			SurfLineServiceNEW currentSurfLineService = new SurfLineServiceNEW(spotURLs.surfLineId());
			DeepSwell_ServiceNEW dS_Service = new DeepSwell_ServiceNEW();
			Surf_Captain_ServiceNEW sC_Service = new Surf_Captain_ServiceNEW();
			SurfForecast_ServiceNEW sF_Service = new SurfForecast_ServiceNEW();

			// Fetch data from services
			SurfLine_rating_DTO ratingDTO = currentSurfLineService.getSurfLineRating();
			SurfLine_sunlight_DTO sunlightDTO = currentSurfLineService.getSurfLineSunlight();
			SurfLine_surf_DTO surfDTO = currentSurfLineService.getSurfLineSurf();
			SurfLine_swells_DTO swellsDTO = currentSurfLineService.getSurfLineSwells();
			SurfLine_tides_DTO tidesDTO = currentSurfLineService.getSurfLineTides();
			SurfLine_weather_DTO weatherDTO = currentSurfLineService.getSurfLineWeather();
			SurfLine_wind_DTO windDTO = currentSurfLineService.getSurfLineWind();

			// Map data to Current object
			CurrentMapperNEW currentMapper = new CurrentMapperNEW(ratingDTO, sunlightDTO, surfDTO, windDTO, weatherDTO, tidesDTO, swellsDTO);
			String futureTide = currentMapper.SL_futureTides();
			String[] swells = currentMapper.SL_swells();
			String swellOne = swells[0];
			String swellTwo = swells[1];
			String swellThree = swells[2];

			String sunrise = currentMapper.SL_sunrise();
			String sunset = currentMapper.SL_sunset();
			String surfLineWaveHeight = currentMapper.SL_surf();
			String tide = currentMapper.SL_tides();
			String airTemperature = currentMapper.SL_airTemp();
			String waveQuality = currentMapper.SL_waveQuality();
			String weatherConditions = currentMapper.SL_weatherConditions();
			String wind = currentMapper.SL_wind();

			String surfSpotName = spotURLs.surfSpotName();

			String deepSwellWaveHeight = dS_Service.getDeepSwellCurrent(spotURLs.deepSwellURL());
			String surfCaptainWaveHeight = sC_Service.getSurfCaptainCurrent(spotURLs.surfCaptainURL());
			String surfForecastWaveHeight = sF_Service.getSurfForecastCurrent(spotURLs.surfForecastURL());

			// Average Wave Height Needs to be found last
			String averageWaveHeight = currentMapper.averageWaveHeight(surfLineWaveHeight, deepSwellWaveHeight, surfCaptainWaveHeight, surfForecastWaveHeight);


			//need to add external api
			String waterTemperature = "N/A";

			return new Current(surfSpotName, averageWaveHeight, waveQuality, surfLineWaveHeight, surfCaptainWaveHeight,
					deepSwellWaveHeight, surfForecastWaveHeight, wind, tide, futureTide, waterTemperature,
					airTemperature, sunrise, sunset, weatherConditions, swellOne, swellTwo, swellThree);
	}
}






