package com.surf.surftracker.factory;

import com.surf.surftracker.dto.SurfLine_surf_DTO;
import com.surf.surftracker.model.Current;
import com.surf.surftracker.service.DeepSwell_Service;
import com.surf.surftracker.service.SurfForecast_Service;
import com.surf.surftracker.service.Surf_Captain_Service;
import com.surf.surftracker.util.SurfSpotURLs;

public class CurrentFactory {
    private SurfSpotURLs spotURLs;

    CurrentFactory(SurfSpotURLs spotURLs) {
        this.spotURLs = spotURLs;
    }
    /*
    public static Current createCurrent(SurfSpotURLs spotURLs) {
    try{
    SurfLineService currentSurfLineService = new SurfLineService(String spotsURLs.surfLineId);
     ^^^ spotURLs.surfLineId needs to be passed in???


    DeepSwell_Service dS_Service = new DeepSwell_Service(spotURLs.deepSwellURL);
                                                               ^^^ does this need to be passed in here or can be below
                                                               if here then make sure to update the DeepSwell_Service/NEW to have this
                                                               passed in at the class level... or like below at the method level
    Surf_Captain_Service sC_Service = new Surf_Captain_Service(spotURLs.surfCaptainURL);
    SurfForecast_Service sF_service = new SurfForecast_Service(spotURLs.surfForecastURL);




    *** Need to spin up DTO objects for parsing

    			// Fetch data from services
			SurfLine_rating_DTO ratingDTO = currentSurfLineService.getSurfLineRating();
			SurfLine_sunlight_DTO sunlightDTO = currentSurfLineService.getSurfLineSunlight();
			SurfLine_surf_DTO surfDTO = currentSurfLineService.getSurfLineSurf();
			SurfLine_swells_DTO swellsDTO = currentSurfLineService.getSurfLineSwells();
			SurfLine_tides_DTO tidesDTO = currentSurfLineService.getSurfLineTides();
			SurfLine_weather_DTO weatherDTO = currentSurfLineService.getSurfLineWeather();
			SurfLine_wind_DTO windDTO = currentSurfLineService.getSurfLineWind();


		*** Map data to Current object >>> rename .SL_FutureTides(); to futureTides ...etc.

			// Map data to Current object
			CurrentMapper currentMapper = new CurrentMapper(lowerTrestlesCurrent, ratingDTO, sunlightDTO, surfDTO, windDTO, weatherDTO, tidesDTO, swellsDTO);
			currentMapper.futureTides();
			currentMapper.swells();
			currentMapper.sunrise();
			currentMapper.sunset();
			currentMapper.surf();
			currentMapper.tides();
			currentMapper.airTemp();
			currentMapper.waveQuality();
			currentMapper.weatherConditons();
			currentMapper.wind();

	        String surfSpotName = spotURLs.surfSpotName;

	        String deepSwellWaveHeight = dS_Service.getDeepSwellCurrent(spotURLs.deepSwellURL);
            String surfCaptainWaveHeight = sC_Service.getSurfCaptainCurrent(spotURLs.surfCaptainUrl);
            String surfForecastWaveHeight = sF_Service.getSurfForecastCurrent(spotURLs.surfForecastURL);

            // Average Wave Height Needs to be found last

			currentMapper.averageWaveHeight();

            String waterTemperature = "N/A";
            //need to add external api

            int surfSpotId = null; .... set in runner
            or int? ^^^  *** change surfSpotID to surfSpotId in model class and make an int!!!


			//replaced above ...lowerTrestlesCurrent.setSurfSpotName("Lower Trestles");









    return new Current(surfSpotID, surfSpotName, averageWaveHeight, waveQuality, surfLineWaveHeight, surfCaptainWaveHeight,
      deepSwellWaveHeight, surfForecastWaveHeight, wind, tide, futureTide, waterTemperature,
      airTemperature, sunrise, sunset, weatherConditions, swellOne, swellTwo, swellThree)

       }
        catch (IOException e) {
                e.printStackTrace();
            }
}
*/
}








/*in runner class:
    # access the surf spot records from the utility class
    SurfSpotURLs[] surfSpots = SurfSpotURLList.getSurfSpots();

    # create a hashmap to store Current objects
    Map<String, Current> currentMap = new HashMap<>();

    # create Current objects from records and add to map
    for (SurfSpotURLs spot : surfSpots) {

    Current current = CurrentFactory.createCurrent(spot);
    #set SurfSpotId here because it requires the for loop iteration; i+1 so the IDs start at 1
    current.setSurfSpotId(i+1);
    System.out.println(current.surfSpotName + ": " + current);
    currentMap.put(current.getSurfSpotName, current);


    }


 */

//from chatgpt example
//   Access Employee by email
//        Employee johnDoe = employeeMap.get("john.doe@example.com");
//        System.out.println("Employee with email john.doe@example.com: " + johnDoe);
//
//        Employee janeSmith = employeeMap.get("jane.smith@example.com");
//        System.out.println("Employee with email jane.smith@example.com: " + janeSmith);