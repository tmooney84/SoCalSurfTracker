
/*
CURRENT CONDITIONS:                      MAPPER CLASS INFORMATION!!!
 */
package com.surf.surftracker.mapper;

import com.surf.surftracker.dto.*;
import com.surf.surftracker.model.Current;
import com.surf.surftracker.util.TimeStampUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

//@Scheduled

public class CurrentMapperNEW {
   // private final Current currentSpot;
    private final SurfLine_rating_DTO currentRatingDTO;
    private final SurfLine_sunlight_DTO currentSunlightDTO;
    private final SurfLine_surf_DTO currentSurfDTO;
    private final SurfLine_wind_DTO currentWindDTO;
    private final SurfLine_weather_DTO currentWeatherDTO;
    private final SurfLine_tides_DTO currentTidesDTO;
    private final SurfLine_swells_DTO currentSwellsDTO;

    Long nearestHour = TimeStampUtils.NearestHour();
    Long midnight = TimeStampUtils.Midnight();

    public CurrentMapperNEW(SurfLine_rating_DTO currentRatingDTO, SurfLine_sunlight_DTO currentSunlightDTO, SurfLine_surf_DTO currentSurfDTO, SurfLine_wind_DTO currentWindDTO, SurfLine_weather_DTO currentWeatherDTO, SurfLine_tides_DTO currentTidesDTO, SurfLine_swells_DTO currentSwellsDTO) {
      //  this.currentSpot = currentSpot;
        this.currentRatingDTO = currentRatingDTO;
        this.currentSunlightDTO = currentSunlightDTO;
        this.currentSurfDTO = currentSurfDTO;
        this.currentWindDTO = currentWindDTO;
        this.currentWeatherDTO = currentWeatherDTO;
        this.currentTidesDTO = currentTidesDTO;
        this.currentSwellsDTO = currentSwellsDTO;
    }

    //Current average wave height    String average of the 4 forecasts
    public String averageWaveHeight(String surfLineWaveHeight, String deepSwellWaveHeight, String surfCaptainWaveHeight, String surfForecastWaveHeight)
    { String[] waveHeights = {
            surfLineWaveHeight, deepSwellWaveHeight, surfCaptainWaveHeight, surfForecastWaveHeight
//                currentSpot.getSurfLineWaveHeight(),
//                currentSpot.getDeepSwellWaveHeight(),
//                currentSpot.getSurfCaptainWaveHeight(),
//                currentSpot.getSurfForecastWaveHeight()
        };
        // Calculate the average height
        double averageHeight = calculateAverageWaveHeight(waveHeights);

        // Format the average height
        String formattedHeight = formatHeight(averageHeight);

        // Print the formatted average height
        System.out.println("Average Wave Height: " + formattedHeight);
        //currentSpot.setAverageWaveHeight(formattedHeight);
        return formattedHeight;
    }

    // Method to calculate the average wave height
    public static double calculateAverageWaveHeight(String[] waveHeights) {
        double totalHeight = 0;
        int count = 0;

        for (String waveHeight : waveHeights) {
            if (waveHeight == null || waveHeight.isEmpty()) {
                continue; // Skip if the wave height is null or empty
            }

            // Remove any non-numeric characters
            waveHeight = waveHeight.replaceAll("[^0-9-+]", "").trim();

            // Check if the string contains a range or a single value
            if (waveHeight.contains("-")) {
                String[] parts = waveHeight.split("-");
                double low = parseHeight(parts[0]);
                double high = parseHeight(parts[1]);
                totalHeight += (low + high) / 2;
            } else if (waveHeight.contains("+")) {
                // Handle cases with a "+" (e.g., "1+ ft")
                double base = parseHeight(waveHeight.split("\\+")[0]);
                totalHeight += base + 0.5; // Assuming "+ ft" means an additional 0.5 feet
            } else {
                totalHeight += parseHeight(waveHeight);
            }
            count++;
        }

        if (count == 0) return 0; // Avoid division by zero
        // Calculate the average and round to the nearest half foot
        double averageHeight = totalHeight / count;
        return roundToNearestHalfFoot(averageHeight);
    }

    // Helper method to parse height from a string
    private static double parseHeight(String heightString) {
        try {
            return Double.parseDouble(heightString.trim());
        } catch (NumberFormatException e) {
            // Handle any parsing errors gracefully
            return 0;
        }
    }

    // Helper method to round to the nearest half foot
    private static double roundToNearestHalfFoot(double height) {
        return Math.round(height * 2) / 2.0;
    }

    // Method to format height as a string
    private static String formatHeight(double height) {
        int roundedHeight = (int) Math.round(height);
        int lowerBound = (int) Math.floor(height);
        int upperBound = (int) Math.ceil(height);

        if (height == roundedHeight) {
            return roundedHeight + " ft";
        } else if (roundedHeight - lowerBound < 0.5) {
            return lowerBound + " ft";
        } else {
            return lowerBound + "-" + upperBound + " ft";
        }
    }























    //Current WaveQuality
    public String SL_waveQuality() {
        List<SurfLine_rating_DTO.Rating> ratings = currentRatingDTO.getData().getRating();
        for (SurfLine_rating_DTO.Rating rating : ratings) {
            if (Long.valueOf(rating.getTimestamp()).equals(nearestHour)) {
                String currentRating = rating.getRatingDetails().getKey();
                currentRating = currentRating.replaceAll("_", " ");

                //currentSpot.setWaveQuality(currentRating);
                return currentRating;
            }
        }
        throw new NoSuchElementException("No rating found for the timestamp: " + nearestHour);
    }

    //SurfLine Wave Height
    public String SL_surf() {
        List<SurfLine_surf_DTO.Surf> surfList = currentSurfDTO.getData().getSurf();

        for (SurfLine_surf_DTO.Surf surf : surfList) {
            if (surf.getTimestamp() == TimeStampUtils.NearestHour()) {
                SurfLine_surf_DTO.SurfDetails surfDetails = surf.getSurfDetails();

                int min = (int)surfDetails.getMin();
                int max = (int)surfDetails.getMax();
                boolean plus = surfDetails.isPlus();
                String plusSign = "";
                if(plus){
                    plusSign = "+";
                }

                String waveHeight = String.format("%d-%d%s ft",min,max,plusSign);
                return waveHeight;
                //currentSpot.setSurfLineWaveHeight(waveHeight);
                //System.out.println("SL Wave Height is: " + waveHeight);
               // return; // Exit after finding and processing the relevant surf details
            }
        }

        throw new NoSuchElementException("No surf details found for the timestamp: " + TimeStampUtils.NearestHour());
    }

    //Sunrise
    public String SL_sunrise() {
        List<SurfLine_sunlight_DTO.Sunlight> sunlightList = currentSunlightDTO.getData().getSunlight();
        for (SurfLine_sunlight_DTO.Sunlight sun : sunlightList) {
            if (sun.getMidnight() == midnight) {
                long sunriseTimestamp = sun.getSunrise();
                ZonedDateTime sunriseTime = Instant.ofEpochSecond(sunriseTimestamp)
                        .atZone(ZoneId.of("America/Los_Angeles"));
                String formattedSunriseTime = sunriseTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                //currentSpot.setSunrise(formattedSunriseTime);
                return formattedSunriseTime;
            }
        }
        throw new NoSuchElementException("No sunrise found for the midnight timestamp: " + midnight);
    }

    //Sunset
    public String SL_sunset() {
        List<SurfLine_sunlight_DTO.Sunlight> sunlightList = currentSunlightDTO.getData().getSunlight();
        for (SurfLine_sunlight_DTO.Sunlight sun : sunlightList) {
            if (sun.getMidnight() == midnight) {
                long sunriseTimestamp = sun.getSunset();

            //    System.out.println("Midnight: " + midnight);
                //    System.out.println("sunrise: " + sunriseTimestamp);

                ZonedDateTime sunriseTime = Instant.ofEpochSecond(sunriseTimestamp)
                        .atZone(ZoneId.of("America/Los_Angeles"));
                String formattedSunriseTime = sunriseTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                //currentSpot.setSunset(formattedSunriseTime);
                return formattedSunriseTime;
            }
        }
        throw new NoSuchElementException("No sunrise found for the midnight timestamp: " + midnight);
    }

    //Wind and Wind Direction
    public String SL_wind() {
        List<SurfLine_wind_DTO.WindData.WindEntry> windEntries = currentWindDTO.getData().getWind();

        for (SurfLine_wind_DTO.WindData.WindEntry windEntry : windEntries) {
            if (windEntry.getTimestamp().equals(TimeStampUtils.NearestHour())) {
                int speed = windEntry.getSpeed().intValue();
                int direction = windEntry.getDirection().intValue();
                String formattedDirection = getCompassDirection(direction);
                String windSpeedDirection = String.format("%dkts %s", speed, formattedDirection);
               // currentSpot.setWind(windSpeedDirection);
                return windSpeedDirection;
            }
        }
        throw new NoSuchElementException("No wind found for the timestamp: " + TimeStampUtils.NearestHour());
    }
    private String getCompassDirection(int direction) {
        String[] compassDirections = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
        int index = (int) Math.round(((double) direction % 360) / 22.5);
        return compassDirections[index % 16];
    }

    //Air temperature current
    public String SL_airTemp(){
        List<SurfLine_weather_DTO.DataData.WeatherEntry> weatherEntries = currentWeatherDTO.getData().getWeather();
        long nearestHour = TimeStampUtils.NearestHour();

        for (SurfLine_weather_DTO.DataData.WeatherEntry weatherEntry : weatherEntries) {
            if (weatherEntry.getTimestamp().equals(nearestHour)) {
                String temperature = String.format("%d°F", Math.round(weatherEntry.getTemperature()));
                //currentSpot.setAirTemperature(temperature);
                return temperature;
            }
        }
        throw new NoSuchElementException("No temperature found for the timestamp: " + nearestHour);
    }

    //Weather					    String Search by time @hour and then get rid of "_" and all caps maybe regex?


    public String SL_weatherConditions(){
        List<SurfLine_weather_DTO.DataData.WeatherEntry> conditionEntries = currentWeatherDTO.getData().getWeather();

        for (SurfLine_weather_DTO.DataData.WeatherEntry conditionEntry : conditionEntries) {
            if (conditionEntry.getTimestamp().equals(nearestHour)) {
                String weatherCondition = conditionEntry.getCondition().replace("_"," ");
                //currentSpot.setWeatherConditions(weatherCondition);
                return weatherCondition;
            }
        }
        throw new NoSuchElementException("No weather found for the timestamp: " + nearestHour);
    }

    //Tide current				    String Low Tide @ 16:00 >>> will have to have some logic for finding the low or high tide and time

    public String SL_tides() {
        List<SurfLine_tides_DTO.DataData.TideEntry> tideEntries = currentTidesDTO.getData().getTides();
        boolean tideFound = false;

        for (SurfLine_tides_DTO.DataData.TideEntry tideEntry : tideEntries) {
            String tideInfo = "";
            String tideType = "";

            if (tideEntry.getTimestamp().equals(nearestHour)) {
                Double tideHeight = tideEntry.getHeight();

                if (tideEntry.getType().equals("LOW") || tideEntry.getType().equals("HIGH")) {
                    tideType = tideEntry.getType() + " TIDE";
                }

                tideInfo = String.format("%.1f ft %s", tideHeight, tideType);
                return tideInfo;
//                 currentSpot.setTide(tideInfo);
//                System.out.println("Here is the tide info: " + tideInfo);
//                tideFound = true;
//                break;
            }
        }
        throw new NoSuchElementException("No tide information found for the timestamp: " + nearestHour);
//        if (!tideFound) {
//            throw new NoSuchElementException("No tide information found for the timestamp: " + nearestHour);
//        }
    }

    //Future Low or High Tide
    public String SL_futureTides() {
        List<SurfLine_tides_DTO.DataData.TideEntry> tideEntries = currentTidesDTO.getData().getTides();
        String futureTideInfo = null; // Initialize to null to check if a tide is found

        for (SurfLine_tides_DTO.DataData.TideEntry tideEntry : tideEntries) {
            if (tideEntry.getTimestamp() > nearestHour && (tideEntry.getType().equals("LOW") || tideEntry.getType().equals("HIGH"))) {
                String futureTide = tideEntry.getType() + " TIDE";
                double futureTideHeight = tideEntry.getHeight();
                long tideTime = tideEntry.getTimestamp();
                ZonedDateTime futureTideTime = Instant.ofEpochSecond(tideTime)
                        .atZone(ZoneId.of("America/Los_Angeles"));
                String formattedFutureTideTime = futureTideTime.format(DateTimeFormatter.ofPattern("HH:mm"));
                futureTideInfo = String.format("%.1f ft %s @ %s", futureTideHeight, futureTide, formattedFutureTideTime);
                break; // Exit the loop after finding the next tide
            }
        }
        if (futureTideInfo == null) {
            throw new NoSuchElementException("No future tide found after the timestamp: " + nearestHour);
        }
        return futureTideInfo;
        //currentSpot.setFutureTide(futureTideInfo);
        //System.out.println("Here is the future tide info: " + futureTideInfo);
    }


    //Current Swells				    String Top 1.6ft @ 14s SSW 193º three swells locate by hour and pull top 3; need logic for SSW, SSE etc. 251 degrees is WSW...so find 					 something for the logic
    public String[] SL_swells() {
        List<SurfLine_swells_DTO.DataData.SwellEntry> swellEntries = currentSwellsDTO.getData().getSwells();

        // Find the SwellEntry for the given timestamp
        for (SurfLine_swells_DTO.DataData.SwellEntry swellEntry : swellEntries) {
            if (swellEntry.getTimestamp().equals(nearestHour)) {
                List<SurfLine_swells_DTO.DataData.SwellEntry.SwellData> swells = swellEntry.getSwells();

                // Ensure there are at least three swells available
                if (swells.size() >= 3) {
                    String[] swellInfos = new String[3]; // Array to store swell information

                    for (int i = 0; i < 3; i++) {
                        SurfLine_swells_DTO.DataData.SwellEntry.SwellData swell = swells.get(i);
                        String compassDirection = convertDirectionToCompass(swell.getDirection());
                        swellInfos[i] = String.format("%.1fft @ %ds %s %.0fº",
                                swell.getHeight(), swell.getPeriod(), compassDirection, swell.getDirection());
                    }
                    return swellInfos;

                    // Set each swell string into the corresponding CurrentSpot method
//                    currentSpot.setSwellOne(swellInfos[0]);
//                    currentSpot.setSwellTwo(swellInfos[1]);
//                    currentSpot.setSwellThree(swellInfos[2]);

                    // Print the stored swell information
//                    for (int i = 0; i < swellInfos.length; i++) {
//                        System.out.println("Swell " + (i + 1) + ": " + swellInfos[i]);
//                    }
                } else {
                    throw new NoSuchElementException("Not enough swells data available for the timestamp: " + nearestHour);
                }
              //  return;
            }
        }
        throw new NoSuchElementException("No swell data found for the timestamp: " + nearestHour);
    }

    // Helper method to convert direction in degrees to compass direction
    private String convertDirectionToCompass(Double direction) {
        String[] compassDirections = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE",
                "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
        // Convert direction to int index
        int index = (int) Math.round((direction + 11.25) % 360 / 22.5);
        // Handle the case where index might be 16 due to rounding
        if (index >= compassDirections.length) {
            index = compassDirections.length - 1;
        }
        return compassDirections[index];
    }

}


/*
    //@Scheduled... every hour
    //SurfLine current --> if plus add plus...String
    public void SurfLineWaveHeight() {
        //  String mappedSLWave = "3-4+"; "3" "4" "plus"
        //  currentSurfBreak.setSurfLineWaveHeight(mappedSLWave);

currentSpot.setSurfLineWaveHeight();
    }

}
*/   /*




     //Air temperature current  	    String 83ºF
    public void airTemperature(){}


} */