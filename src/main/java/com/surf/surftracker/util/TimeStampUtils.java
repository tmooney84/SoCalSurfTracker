package com.surf.surftracker.util;

import java.time.Instant;

public class TimeStampUtils {
    public static final int pstConversionFactor = 7;
    public static final long DayToSecondsConversion = 86400;

    public static Long CurrentTime(){
        return Instant.now().getEpochSecond();
    }

    public static Long NearestHour(){
        return  Instant.now().getEpochSecond()/3600 * 3600;
    }

    public static Long Midnight(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 0);
    }

    public static Long ThreeAM(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor +3);
    }

    public static Long SixAM(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 6);
    }

    public static Long NineAM(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 9);
    }

    public static Long TwelvePM(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 12);
    }

    public static Long ThreePM(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 15);
    }

    public static Long SixPM(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 18);
    }

    public static Long NinePM(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 21);
    }

    //All of the five day forecast info is set to 9AM local(PST-for now) time
    public static Long DayOne(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 9);
    }

    public static Long DayTwo(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 9) + 1 * DayToSecondsConversion;
    }

    public static Long DayThree(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 9) + 2 * DayToSecondsConversion;
    }

    public static Long DayFour(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 9) + 3 * DayToSecondsConversion;
    }

    public static Long DayFive(){
        return  Instant.now().getEpochSecond()/(3600*24) * 3600*24 + 3600 * (pstConversionFactor + 9) + 4 * DayToSecondsConversion;
    }


}
