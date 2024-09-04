package com.surf.surftracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.surf.surftracker.dto.*;
import com.surf.surftracker.mapper.CurrentMapper;
import com.surf.surftracker.model.Current;
import com.surf.surftracker.service.*;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.surf.surftracker")
public class SurftrackerApplication {

	public static void main(String[] args) {SpringApplication.run(SurftrackerApplication.class, args);}

//	@Bean
//	CommandLineRunner commandLineRunner(UserService userService, BCryptPasswordEncoder encoder){
//		return args -> {
//
//			userService.save(new User("user", encoder.encode("password")));
//		};
//	}





	@Bean
	public Current getLowerTrestlesCurrent() {
		Current lowerTrestlesCurrent = new Current();

		// Instantiate your services
		SurfLine_rating_Service lt_rating_service = new SurfLine_rating_Service();
		SurfLine_sunlight_Service lt_sunlight_service = new SurfLine_sunlight_Service();
		SurfLine_surf_Service lt_surf_service = new SurfLine_surf_Service();
		SurfLine_swells_Service lt_swells_service = new SurfLine_swells_Service();
		SurfLine_tides_Service lt_tides_service = new SurfLine_tides_Service();
		SurfLine_weather_Service lt_weather_service = new SurfLine_weather_Service();
		SurfLine_wind_Service lt_wind_service = new SurfLine_wind_Service();
		DeepSwell_Service lt_ds_service = new DeepSwell_Service(lowerTrestlesCurrent);
		Surf_Captain_Service lt_sc_service = new Surf_Captain_Service(lowerTrestlesCurrent);
		SurfForecast_Service lt_sf_service = new SurfForecast_Service(lowerTrestlesCurrent);

		try {
			// Fetch data from services
			SurfLine_rating_DTO ratingDTO = lt_rating_service.getSurfLineRating();
			SurfLine_swells_DTO swellsDTO = lt_swells_service.getSurfLineSwells();
			SurfLine_sunlight_DTO sunlightDTO = lt_sunlight_service.getSurfLineSunlight();
			SurfLine_surf_DTO surfDTO = lt_surf_service.getSurfLineSurf();
			SurfLine_weather_DTO weatherDTO = lt_weather_service.getSurfLineWeather();
			SurfLine_wind_DTO windDTO = lt_wind_service.getSurfLineWind();
			SurfLine_tides_DTO tidesDTO = lt_tides_service.getSurfLineTides();

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
