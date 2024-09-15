package com.surf.surftracker;

import com.surf.surftracker.service.oldServices.SurfLine_sunlight_Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.surf.surftracker.dto.*;
import com.surf.surftracker.mapper.CurrentMapper;
import com.surf.surftracker.model.Current;
import com.surf.surftracker.service.*;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.surf.surftracker")
public class SurftrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurftrackerApplication.class, args);
	}

	@Bean
	public Current getLowerTrestlesCurrent() {
		Current lowerTrestlesCurrent = new Current();

		DeepSwell_Service lt_ds_service = new DeepSwell_Service(lowerTrestlesCurrent);
		Surf_Captain_Service lt_sc_service = new Surf_Captain_Service(lowerTrestlesCurrent);
		SurfForecast_Service lt_sf_service = new SurfForecast_Service(lowerTrestlesCurrent);

		SurfLineService lt_surfLineService = new SurfLineService();

		try {
			// Fetch data from services
			SurfLine_rating_DTO ratingDTO = lt_surfLineService.getSurfLineRating();
			SurfLine_sunlight_DTO sunlightDTO = lt_surfLineService.getSurfLineSunlight();
			SurfLine_surf_DTO surfDTO = lt_surfLineService.getSurfLineSurf();
			SurfLine_swells_DTO swellsDTO = lt_surfLineService.getSurfLineSwells();
			SurfLine_tides_DTO tidesDTO = lt_surfLineService.getSurfLineTides();
			SurfLine_weather_DTO weatherDTO = lt_surfLineService.getSurfLineWeather();
			SurfLine_wind_DTO windDTO = lt_surfLineService.getSurfLineWind();

			// Map data to Current object
			CurrentMapper ltCurrentMapper = new CurrentMapper(lowerTrestlesCurrent, ratingDTO, sunlightDTO, surfDTO, windDTO, weatherDTO, tidesDTO, swellsDTO);
			ltCurrentMapper.SL_FutureTides();
			ltCurrentMapper.SL_Swells();
			ltCurrentMapper.SL_Sunrise();
			ltCurrentMapper.SL_Sunset();
			ltCurrentMapper.SL_Surf();
			ltCurrentMapper.SL_Tides();
			ltCurrentMapper.SL_AirTemp();
			ltCurrentMapper.SL_WaveQuality();
			ltCurrentMapper.SL_WeatherConditons();
			ltCurrentMapper.SL_Wind();
			lowerTrestlesCurrent.setSurfSpotName("Lower Trestles");

			lt_ds_service.getDeepSwellCurrent();
			lt_sc_service.getSurfCaptainCurrent();
			lt_sf_service.getSurfForecastCurrent();

			// Average Wave Height Needs to be found last

			ltCurrentMapper.AverageWaveHeight();

			// Print out the Current Lower Trestles POJO for debugging
			System.out.println("Lower Trestles: " + lowerTrestlesCurrent);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lowerTrestlesCurrent;
	}
}
/*
	@Bean
	public Current getTStreetCurrent() {
		Current tStreetCurrent = new Current();

		// Instantiate your services
		SurfLine_rating_Service ts_rating_service = new SurfLine_rating_Service();
		SurfLine_sunlight_Service ts_sunlight_service = new SurfLine_sunlight_Service();
		SurfLine_surf_Service ts_surf_service = new SurfLine_surf_Service();
		SurfLine_swells_Service ts_swells_service = new SurfLine_swells_Service();
		SurfLine_tides_Service ts_tides_service = new SurfLine_tides_Service();
		SurfLine_weather_Service ts_weather_service = new SurfLine_weather_Service();
		SurfLine_wind_Service ts_wind_service = new SurfLine_wind_Service();
		DeepSwell_Service ts_ds_service = new DeepSwell_Service(tStreetCurrent);
		Surf_Captain_Service ts_sc_service = new Surf_Captain_Service(tStreetCurrent);
		SurfForecast_Service ts_sf_service = new SurfForecast_Service(tStreetCurrent);

		try {
			// Fetch data from services
			SurfLine_rating_DTO ratingDTO = ts_rating_service.getSurfLineRating();
			SurfLine_swells_DTO swellsDTO = ts_swells_service.getSurfLineSwells();
			SurfLine_sunlight_DTO sunlightDTO = ts_sunlight_service.getSurfLineSunlight();
			SurfLine_surf_DTO surfDTO = ts_surf_service.getSurfLineSurf();
			SurfLine_weather_DTO weatherDTO = ts_weather_service.getSurfLineWeather();
			SurfLine_wind_DTO windDTO = ts_wind_service.getSurfLineWind();
			SurfLine_tides_DTO tidesDTO = ts_tides_service.getSurfLineTides();

			// Map data to Current object
			CurrentMapper tSCurrentMapper = new CurrentMapper(tStreetCurrent, ratingDTO, sunlightDTO, surfDTO, windDTO, weatherDTO, tidesDTO, swellsDTO);
			tSCurrentMapper.SL_FutureTides();
			tSCurrentMapper.SL_Swells();
			tSCurrentMapper.SL_Sunrise();
			tSCurrentMapper.SL_Sunset();
			tSCurrentMapper.SL_Surf();
			tSCurrentMapper.SL_Tides();
			tSCurrentMapper.SL_AirTemp();
			tSCurrentMapper.SL_WaveQuality();
			tSCurrentMapper.SL_WeatherConditons();
			tSCurrentMapper.SL_Wind();
			tStreetCurrent.setSurfSpotName("Lower Trestles");

			ts_ds_service.getDeepSwellCurrent();
			ts_sc_service.getSurfCaptainCurrent();
			ts_sf_service.getSurfForecastCurrent();

			// Average Wave Height Needs to be found last

			tSCurrentMapper.AverageWaveHeight();

			// Print out the Current Lower Trestles POJO for debugging
			System.out.println("T-Street: " + tStreetCurrent);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tStreetCurrent;
	}

}
*/