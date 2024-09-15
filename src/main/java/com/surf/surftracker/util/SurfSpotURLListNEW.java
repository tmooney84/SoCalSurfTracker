package com.surf.surftracker.util;

public class SurfSpotURLListNEW {
    public static final SurfSpotURLs[] SURF_SPOT_ARRAY;
    //1) Ponto

    //2) Tamarack

    //3) Oceanside

    //4) San Onofre

    //5) Lower Trestles
    static {
        SURF_SPOT_ARRAY = new SurfSpotURLs[]{
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
    };
    }
    //Utility method to get the surf spots array
    public static SurfSpotURLs[] getSurfSpots() {
        return SURF_SPOT_ARRAY;
    }

}
        //9) Salt Creek

        //10) Newport Beach

        //11) Huntington Beach

        //12) Seal Beach

        // Feed the list into a factory method
        //  processSurfSpots(surfSpots);
//just for testing
   /* public static void processSurfSpots(List<SurfSpotURL> surfSpots) {
        for (SurfSpotURL spot : surfSpots) {
            System.out.println("Surf Spot: " + spot.surfCaptainURL());
            System.out.println();
        } */
// }
