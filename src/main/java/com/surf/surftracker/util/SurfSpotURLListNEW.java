package com.surf.surftracker.util;

public class SurfSpotURLListNEW {
    public static final SurfSpotURLs[] SURF_SPOT_ARRAY;
    static {
        SURF_SPOT_ARRAY = new SurfSpotURLs[]{
                //1) Ponto
                new SurfSpotURLs("Ponto (Carlsbad)",
                        "https://deepswell.com/surf-report/US/North-San-Diego/Ponto-at-South-Carlsbad-State-Beach/1004",
                        "https://surfcaptain.com/forecast/carlsbad-california",
                        "https://www.surf-forecast.com/breaks/Ponto/forecasts/latest/",
                        "5842041f4e65fad6a77088a5"),

                //2) Tamarack
                new SurfSpotURLs("Tamarack",
                        "https://deepswell.com/surf-report/US/North-San-Diego/Tamarack/1003",
                        "https://surfcaptain.com/forecast/carlsbad-california",
                        "https://www.surf-forecast.com/breaks/Tamarack-st/forecasts/latest/",
                        "5842041f4e65fad6a7708837"),

                //3) Oceanside
                new SurfSpotURLs("Oceanside",
                        "https://deepswell.com/surf-report/US/North-San-Diego/Oceanside-Pier-northside/1001",
                        "https://surfcaptain.com/forecast/oceanside-california",
                        "https://www.surf-forecast.com/breaks/Oceanside-Pier/forecasts/latest/",
                        "5842041f4e65fad6a7708835"),

                //4) San Onofre
                new SurfSpotURLs("San Onofre",
                        "https://deepswell.com/surf-report/US/South-Orange-County/San-Onofre-State-Beach/1059",
                        "https://surfcaptain.com/forecast/san-onofre-california",
                        "https://www.surf-forecast.com/breaks/San-Onofre/forecasts/latest/",
                        "584204204e65fad6a77099d4"),

                //5) Lower Trestles
                new SurfSpotURLs("Lower Trestles",
                        "https://deepswell.com/surf-report/US/South-Orange-County/Lower-Trestles/1030",
                        "https://surfcaptain.com/forecast/trestles-california/",
                        "https://www.surf-forecast.com/breaks/Trestles_Lowers/forecasts/latest/",
                        "5842041f4e65fad6a770888a"),

        //6 Upper Trestles

        //7) T-Street
        new SurfSpotURLs("T-Street",
                "https://deepswell.com/surf-report/US/South-Orange-County/T-Street-Trafalgar-Street/1057",
                "https://surfcaptain.com/forecast/san-clemente-california",
                "https://www.surf-forecast.com/breaks/T-Street/forecasts/latest/",
                "5842041f4e65fad6a7708830"),

        //8) Doheny
        new SurfSpotURLs("Doheny",
                "https://deepswell.com/surf-report/US/South-Orange-County/Doheny-State-Beach/1027",
                "https://surfcaptain.com/forecast/dana-point-california/",
                "https://www.surf-forecast.com/breaks/Doheney-Beach/forecasts/latest/",
                "5842041f4e65fad6a77088d7"),

                //9) Salt Creek
//                new SurfSpotURLs("Doheny",
//                        "https://deepswell.com/surf-report/US/South-Orange-County/Doheny-State-Beach/1027",
//                        "https://surfcaptain.com/forecast/dana-point-california/",
//                        "https://www.surf-forecast.com/breaks/Doheney-Beach/forecasts/latest/",
//                        "5842041f4e65fad6a77088d7"),
//                //10) Newport Beach
//                new SurfSpotURLs("Doheny",
//                        "https://deepswell.com/surf-report/US/South-Orange-County/Doheny-State-Beach/1027",
//                        "https://surfcaptain.com/forecast/dana-point-california/",
//                        "https://www.surf-forecast.com/breaks/Doheney-Beach/forecasts/latest/",
//                        "5842041f4e65fad6a77088d7"),
//                //11) Huntington Beach
//                new SurfSpotURLs("Doheny",
//                        "https://deepswell.com/surf-report/US/South-Orange-County/Doheny-State-Beach/1027",
//                        "https://surfcaptain.com/forecast/dana-point-california/",
//                        "https://www.surf-forecast.com/breaks/Doheney-Beach/forecasts/latest/",
//                        "5842041f4e65fad6a77088d7"),
//                //12) Seal Beach
//                new SurfSpotURLs("Doheny",
//                        "https://deepswell.com/surf-report/US/South-Orange-County/Doheny-State-Beach/1027",
//                        "https://surfcaptain.com/forecast/dana-point-california/",
//                        "https://www.surf-forecast.com/breaks/Doheney-Beach/forecasts/latest/",
//                        "5842041f4e65fad6a77088d7"),
    };
    }
    //Utility method to get the surf spots array
    public static SurfSpotURLs[] getSurfSpots() {
        return SURF_SPOT_ARRAY;
    }

}