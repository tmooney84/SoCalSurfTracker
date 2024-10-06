//package com.surf.surftracker;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import com.surf.surftracker.dto.*;
//import com.surf.surftracker.mapper.CurrentMapper;
//import com.surf.surftracker.model.Current;
//import com.surf.surftracker.service.*;
//
//@SpringBootApplication(scanBasePackages = "com.surf.surftracker")
//public class SurftrackerApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SurftrackerApplication.class, args);
//	}
//
//@Bean
//	public Current getLowerTrestlesCurrent() {
//		Current lowerTrestlesCurrent = new Current();
//
//		DeepSwell_Service lt_ds_service = new DeepSwell_Service(lowerTrestlesCurrent);
//		Surf_Captain_Service lt_sc_service = new Surf_Captain_Service(lowerTrestlesCurrent);
//		SurfForecast_Service lt_sf_service = new SurfForecast_Service(lowerTrestlesCurrent);
//
//		SurfLineService lt_surfLineService = new SurfLineService();
//
//		try {
//			// Fetch data from services
//			SurfLine_rating_DTO ratingDTO = lt_surfLineService.getSurfLineRating();
//			SurfLine_sunlight_DTO sunlightDTO = lt_surfLineService.getSurfLineSunlight();
//			SurfLine_surf_DTO surfDTO = lt_surfLineService.getSurfLineSurf();
//			SurfLine_swells_DTO swellsDTO = lt_surfLineService.getSurfLineSwells();
//			SurfLine_tides_DTO tidesDTO = lt_surfLineService.getSurfLineTides();
//			SurfLine_weather_DTO weatherDTO = lt_surfLineService.getSurfLineWeather();
//			SurfLine_wind_DTO windDTO = lt_surfLineService.getSurfLineWind();
//
//			// Map data to Current object
//			CurrentMapper ltCurrentMapper = new CurrentMapper(lowerTrestlesCurrent, ratingDTO, sunlightDTO, surfDTO, windDTO, weatherDTO, tidesDTO, swellsDTO);
//			ltCurrentMapper.SL_FutureTides();
//			ltCurrentMapper.SL_Swells();
//			ltCurrentMapper.SL_Sunrise();
//			ltCurrentMapper.SL_Sunset();
//			ltCurrentMapper.SL_Surf();
//			ltCurrentMapper.SL_Tides();
//			ltCurrentMapper.SL_AirTemp();
//			ltCurrentMapper.SL_WaveQuality();
//			ltCurrentMapper.SL_WeatherConditons();
//			ltCurrentMapper.SL_Wind();
//			lowerTrestlesCurrent.setSurfSpotName("Lower Trestles");
//
//			lt_ds_service.getDeepSwellCurrent();
//			lt_sc_service.getSurfCaptainCurrent();
//			lt_sf_service.getSurfForecastCurrent();
//
//			// Average Wave Height Needs to be found last
//
//			ltCurrentMapper.AverageWaveHeight();
//
//			// Print out the Current Lower Trestles POJO for debugging
//			System.out.println("Lower Trestles: " + lowerTrestlesCurrent);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return lowerTrestlesCurrent;
//	}
//}