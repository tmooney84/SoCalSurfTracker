package com.surf.surftracker.util;

public class SurfSpotURLList {
    //public static void main(String[] args) {
    //  List<SurfSpotURL> surfSpots = List.of(
    //1) Ponto

    //2) Tamarack

    //3) Oceanside

    //4) San Onofre

    //5) Lower Trestles

    public static SurfSpotURLs LowerTrestles = new SurfSpotURLs("Lower Trestles","https://services.surfline.com/kbyg/spots/forecasts/rating?spotId=5842041f4e65fad6a770888a&days=5&intervalHours=1&cacheEnabled=trued" ,
            "https://services.surfline.com/kbyg/spots/forecasts/sunlight?spotId=5842041f4e65fad6a770888a&days=16&intervalHours=1",
            "https://services.surfline.com/kbyg/spots/forecasts/surf?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a770888a&units[waveHeight]=FT",
            "https://services.surfline.com/kbyg/spots/forecasts/swells?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a770888a&units[swellHeight]=FT",
            "https://services.surfline.com/kbyg/spots/forecasts/tides?spotId=5842041f4e65fad6a770888a&days=6&cacheEnabled=true&units[tideHeight]=FT",
            "https://services.surfline.com/kbyg/spots/forecasts/weather?spotId=5842041f4e65fad6a770888a&days=16&intervalHours=1&cacheEnabled=true&units[temperature]=F",
            "https://services.surfline.com/kbyg/spots/forecasts/wind?spotId=5842041f4e65fad6a770888a&days=5&intervalHours=1&corrected=false&cacheEnabled=true&units[windSpeed]=KTS",
            "https://deepswell.com/surf-report/US/South-Orange-County/Lower-Trestles/1030",
            "https://surfcaptain.com/forecast/trestles-california/",
            "https://www.surf-forecast.com/breaks/Trestles_Lowers/forecasts/latest/");

    //6 Upper Trestles

    //7) T-Street
    public static SurfSpotURLs tStreet = new SurfSpotURLs("T-Street", "https://services.surfline.com/kbyg/spots/forecasts/rating?spotId=5842041f4e65fad6a7708830&days=5&intervalHours=1&cacheEnabled=true",
            "https://services.surfline.com/kbyg/spots/forecasts/sunlight?spotId=5842041f4e65fad6a7708830&days=16&intervalHours=1",
            "https://services.surfline.com/kbyg/spots/forecasts/surf?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a7708830&units[waveHeight]=FT",
            "https://services.surfline.com/kbyg/spots/forecasts/swells?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a7708830&units[swellHeight]=FT",
            "https://services.surfline.com/kbyg/spots/forecasts/tides?spotId=5842041f4e65fad6a7708830&days=6&cacheEnabled=true&units[tideHeight]=FT",
            "https://services.surfline.com/kbyg/spots/forecasts/weather?spotId=5842041f4e65fad6a7708830&days=16&intervalHours=1&cacheEnabled=true&units[temperature]=F",
            "https://services.surfline.com/kbyg/spots/forecasts/wind?spotId=5842041f4e65fad6a7708830&days=5&intervalHours=1&corrected=false&cacheEnabled=true&units[windSpeed]=KTS",
            "https://deepswell.com/surf-report/US/South-Orange-County/T-Street-Trafalgar-Street/1057",
            "https://surfcaptain.com/forecast/san-clemente-california",
            "https://www.surf-forecast.com/breaks/T-Street/forecasts/latest/");

    //8) Doheny

    //9) Salt Creek

    //10) Newport Beach

    //11) Huntington Beach

    //12) Seal Beach

    // Feed the list into a factory method
    //  processSurfSpots(surfSpots);
}

//just for testing
   /* public static void processSurfSpots(List<SurfSpotURL> surfSpots) {
        for (SurfSpotURL spot : surfSpots) {
            System.out.println("Surf Spot: " + spot.surfCaptainURL());
            System.out.println();
        } */
// }
