package com.surf.surftracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurfLine_weather_DTO {

    @JsonProperty("associated")
    private AssociatedData associated;

    @JsonProperty("data")
    private DataData data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AssociatedData {

        @JsonProperty("units")
        private Units units;

        @JsonProperty("utcOffset")
        private Integer utcOffset;

        @JsonProperty("weatherIconPath")
        private String weatherIconPath;

        @JsonProperty("runInitializationTimestamp")
        private Long runInitializationTimestamp;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Units {
            @JsonProperty("temperature")
            private String temperature;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataData {

        @JsonProperty("sunlightTimes")
        private List<SunlightTimes> sunlightTimes;

        @JsonProperty("weather")
        private List<WeatherEntry> weather;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SunlightTimes {
            @JsonProperty("midnight")
            private Long midnight;

            @JsonProperty("midnightUTCOffset")
            private Integer midnightUTCOffset;

            @JsonProperty("dawn")
            private Long dawn;

            @JsonProperty("dawnUTCOffset")
            private Integer dawnUTCOffset;

            @JsonProperty("sunrise")
            private Long sunrise;

            @JsonProperty("sunriseUTCOffset")
            private Integer sunriseUTCOffset;

            @JsonProperty("sunset")
            private Long sunset;

            @JsonProperty("sunsetUTCOffset")
            private Integer sunsetUTCOffset;

            @JsonProperty("dusk")
            private Long dusk;

            @JsonProperty("duskUTCOffset")
            private Integer duskUTCOffset;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class WeatherEntry {
            @JsonProperty("timestamp")
            private Long timestamp;

            @JsonProperty("utcOffset")
            private Integer utcOffset;

            @JsonProperty("temperature")
            private Double temperature;

            @JsonProperty("condition")
            private String condition;

            @JsonProperty("pressure")
            private Integer pressure;
        }
    }

    @Override
    public String toString() {
        return "WeatherDataDTO{" +
                "associated=" + associated +
                ", data=" + data +
                '}';
    }
}



/*
Example sunlight JSON Data: https://services.surfline.com/kbyg/spots/forecasts/weather?spotId=5842041f4e65fad6a770888a&days=16&intervalHours=1&cacheEnabled=true&units%5Btemperature%5D=F
{
  "associated": {
    "units": {
      "temperature": "F"
    },
    "utcOffset": -7,
    "weatherIconPath": "https://wa.cdn-surfline.com/quiver/0.21.2/weathericons",
    "runInitializationTimestamp": 1724133600
  },
  "data": {
    "sunlightTimes": [
      {
        "midnight": 1724137200,
        "midnightUTCOffset": -7,
        "dawn": 1724158334,
        "dawnUTCOffset": -7,
        "sunrise": 1724159888,
        "sunriseUTCOffset": -7,
        "sunset": 1724207521,
        "sunsetUTCOffset": -7,
        "dusk": 1724209075,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724223600,
        "midnightUTCOffset": -7,
        "dawn": 1724244779,
        "dawnUTCOffset": -7,
        "sunrise": 1724246330,
        "sunriseUTCOffset": -7,
        "sunset": 1724293851,
        "sunsetUTCOffset": -7,
        "dusk": 1724295401,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724310000,
        "midnightUTCOffset": -7,
        "dawn": 1724331224,
        "dawnUTCOffset": -7,
        "sunrise": 1724332771,
        "sunriseUTCOffset": -7,
        "sunset": 1724380179,
        "sunsetUTCOffset": -7,
        "dusk": 1724381726,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724396400,
        "midnightUTCOffset": -7,
        "dawn": 1724417669,
        "dawnUTCOffset": -7,
        "sunrise": 1724419213,
        "sunriseUTCOffset": -7,
        "sunset": 1724466507,
        "sunsetUTCOffset": -7,
        "dusk": 1724468051,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724482800,
        "midnightUTCOffset": -7,
        "dawn": 1724504113,
        "dawnUTCOffset": -7,
        "sunrise": 1724505654,
        "sunriseUTCOffset": -7,
        "sunset": 1724552834,
        "sunsetUTCOffset": -7,
        "dusk": 1724554375,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724569200,
        "midnightUTCOffset": -7,
        "dawn": 1724590558,
        "dawnUTCOffset": -7,
        "sunrise": 1724592095,
        "sunriseUTCOffset": -7,
        "sunset": 1724639160,
        "sunsetUTCOffset": -7,
        "dusk": 1724640698,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724655600,
        "midnightUTCOffset": -7,
        "dawn": 1724677002,
        "dawnUTCOffset": -7,
        "sunrise": 1724678536,
        "sunriseUTCOffset": -7,
        "sunset": 1724725486,
        "sunsetUTCOffset": -7,
        "dusk": 1724727021,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724742000,
        "midnightUTCOffset": -7,
        "dawn": 1724763445,
        "dawnUTCOffset": -7,
        "sunrise": 1724764977,
        "sunriseUTCOffset": -7,
        "sunset": 1724811811,
        "sunsetUTCOffset": -7,
        "dusk": 1724813342,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724828400,
        "midnightUTCOffset": -7,
        "dawn": 1724849889,
        "dawnUTCOffset": -7,
        "sunrise": 1724851418,
        "sunriseUTCOffset": -7,
        "sunset": 1724898135,
        "sunsetUTCOffset": -7,
        "dusk": 1724899664,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1724914800,
        "midnightUTCOffset": -7,
        "dawn": 1724936332,
        "dawnUTCOffset": -7,
        "sunrise": 1724937858,
        "sunriseUTCOffset": -7,
        "sunset": 1724984458,
        "sunsetUTCOffset": -7,
        "dusk": 1724985984,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1725001200,
        "midnightUTCOffset": -7,
        "dawn": 1725022775,
        "dawnUTCOffset": -7,
        "sunrise": 1725024298,
        "sunriseUTCOffset": -7,
        "sunset": 1725070781,
        "sunsetUTCOffset": -7,
        "dusk": 1725072304,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1725087600,
        "midnightUTCOffset": -7,
        "dawn": 1725109218,
        "dawnUTCOffset": -7,
        "sunrise": 1725110739,
        "sunriseUTCOffset": -7,
        "sunset": 1725157103,
        "sunsetUTCOffset": -7,
        "dusk": 1725158624,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1725174000,
        "midnightUTCOffset": -7,
        "dawn": 1725195660,
        "dawnUTCOffset": -7,
        "sunrise": 1725197179,
        "sunriseUTCOffset": -7,
        "sunset": 1725243425,
        "sunsetUTCOffset": -7,
        "dusk": 1725244943,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1725260400,
        "midnightUTCOffset": -7,
        "dawn": 1725282103,
        "dawnUTCOffset": -7,
        "sunrise": 1725283618,
        "sunriseUTCOffset": -7,
        "sunset": 1725329746,
        "sunsetUTCOffset": -7,
        "dusk": 1725331262,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1725346800,
        "midnightUTCOffset": -7,
        "dawn": 1725368545,
        "dawnUTCOffset": -7,
        "sunrise": 1725370058,
        "sunriseUTCOffset": -7,
        "sunset": 1725416067,
        "sunsetUTCOffset": -7,
        "dusk": 1725417580,
        "duskUTCOffset": -7
      },
      {
        "midnight": 1725433200,
        "midnightUTCOffset": -7,
        "dawn": 1725454987,
        "dawnUTCOffset": -7,
        "sunrise": 1725456498,
        "sunriseUTCOffset": -7,
        "sunset": 1725502387,
        "sunsetUTCOffset": -7,
        "dusk": 1725503898,
        "duskUTCOffset": -7
      }
    ],
    "weather": [
      {
        "timestamp": 1724137200,
        "utcOffset": -7,
        "temperature": 67.226,
        "condition": "NIGHT_CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724140800,
        "utcOffset": -7,
        "temperature": 66.506,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724144400,
        "utcOffset": -7,
        "temperature": 65.82204,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724148000,
        "utcOffset": -7,
        "temperature": 63.464,
        "condition": "NIGHT_CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724151600,
        "utcOffset": -7,
        "temperature": 61.95204,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724155200,
        "utcOffset": -7,
        "temperature": 60.944,
        "condition": "NIGHT_MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724158800,
        "utcOffset": -7,
        "temperature": 60.998,
        "condition": "MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724162400,
        "utcOffset": -7,
        "temperature": 62.564,
        "condition": "MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724166000,
        "utcOffset": -7,
        "temperature": 65.084,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724169600,
        "utcOffset": -7,
        "temperature": 74.69604,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724173200,
        "utcOffset": -7,
        "temperature": 76.658,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724176800,
        "utcOffset": -7,
        "temperature": 76.658,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724180400,
        "utcOffset": -7,
        "temperature": 76.82,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724184000,
        "utcOffset": -7,
        "temperature": 77.234,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724187600,
        "utcOffset": -7,
        "temperature": 76.55004,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724191200,
        "utcOffset": -7,
        "temperature": 76.604,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724194800,
        "utcOffset": -7,
        "temperature": 76.19,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724198400,
        "utcOffset": -7,
        "temperature": 74.804,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724202000,
        "utcOffset": -7,
        "temperature": 73.022,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724205600,
        "utcOffset": -7,
        "temperature": 70.33996,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724209200,
        "utcOffset": -7,
        "temperature": 68.666,
        "condition": "NIGHT_MIST",
        "pressure": 1012
      },
      {
        "timestamp": 1724212800,
        "utcOffset": -7,
        "temperature": 67.964,
        "condition": "NIGHT_MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724216400,
        "utcOffset": -7,
        "temperature": 67.478,
        "condition": "NIGHT_MOSTLY_CLOUDY",
        "pressure": 1014
      },
      {
        "timestamp": 1724220000,
        "utcOffset": -7,
        "temperature": 67.28,
        "condition": "NIGHT_MIST",
        "pressure": 1014
      },
      {
        "timestamp": 1724223600,
        "utcOffset": -7,
        "temperature": 67.028,
        "condition": "NIGHT_MIST",
        "pressure": 1014
      },
      {
        "timestamp": 1724227200,
        "utcOffset": -7,
        "temperature": 66.46996,
        "condition": "NIGHT_MIST",
        "pressure": 1014
      },
      {
        "timestamp": 1724230800,
        "utcOffset": -7,
        "temperature": 65.912,
        "condition": "NIGHT_MIST",
        "pressure": 1014
      },
      {
        "timestamp": 1724234400,
        "utcOffset": -7,
        "temperature": 66.632,
        "condition": "NIGHT_MOSTLY_CLOUDY",
        "pressure": 1013
      },
      {
        "timestamp": 1724238000,
        "utcOffset": -7,
        "temperature": 65.264,
        "condition": "NIGHT_MOSTLY_CLOUDY",
        "pressure": 1013
      },
      {
        "timestamp": 1724241600,
        "utcOffset": -7,
        "temperature": 64.68804,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724245200,
        "utcOffset": -7,
        "temperature": 63.986,
        "condition": "MOSTLY_CLOUDY",
        "pressure": 1013
      },
      {
        "timestamp": 1724248800,
        "utcOffset": -7,
        "temperature": 64.30996,
        "condition": "MOSTLY_CLOUDY",
        "pressure": 1014
      },
      {
        "timestamp": 1724252400,
        "utcOffset": -7,
        "temperature": 65.92996,
        "condition": "MOSTLY_CLOUDY",
        "pressure": 1014
      },
      {
        "timestamp": 1724256000,
        "utcOffset": -7,
        "temperature": 66.686,
        "condition": "MOSTLY_CLOUDY",
        "pressure": 1014
      },
      {
        "timestamp": 1724259600,
        "utcOffset": -7,
        "temperature": 70.86196,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724263200,
        "utcOffset": -7,
        "temperature": 73.20204,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724266800,
        "utcOffset": -7,
        "temperature": 74.336,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724270400,
        "utcOffset": -7,
        "temperature": 75.43396,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724274000,
        "utcOffset": -7,
        "temperature": 74.82196,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724277600,
        "utcOffset": -7,
        "temperature": 74.606,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724281200,
        "utcOffset": -7,
        "temperature": 73.724,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724284800,
        "utcOffset": -7,
        "temperature": 72.338,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724288400,
        "utcOffset": -7,
        "temperature": 70.43,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724292000,
        "utcOffset": -7,
        "temperature": 67.83804,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724295600,
        "utcOffset": -7,
        "temperature": 66.686,
        "condition": "NIGHT_CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724299200,
        "utcOffset": -7,
        "temperature": 66.09196,
        "condition": "NIGHT_MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724302800,
        "utcOffset": -7,
        "temperature": 65.966,
        "condition": "NIGHT_MIST",
        "pressure": 1014
      },
      {
        "timestamp": 1724306400,
        "utcOffset": -7,
        "temperature": 66.848,
        "condition": "NIGHT_BRIEF_SHOWERS",
        "pressure": 1014
      },
      {
        "timestamp": 1724310000,
        "utcOffset": -7,
        "temperature": 66.812,
        "condition": "NIGHT_MIST",
        "pressure": 1014
      },
      {
        "timestamp": 1724313600,
        "utcOffset": -7,
        "temperature": 66.416,
        "condition": "NIGHT_MIST",
        "pressure": 1014
      },
      {
        "timestamp": 1724317200,
        "utcOffset": -7,
        "temperature": 66.074,
        "condition": "NIGHT_MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724320800,
        "utcOffset": -7,
        "temperature": 66.29,
        "condition": "NIGHT_MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724324400,
        "utcOffset": -7,
        "temperature": 66.56,
        "condition": "NIGHT_MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724328000,
        "utcOffset": -7,
        "temperature": 65.768,
        "condition": "NIGHT_MIST",
        "pressure": 1013
      },
      {
        "timestamp": 1724331600,
        "utcOffset": -7,
        "temperature": 64.598,
        "condition": "MOSTLY_CLOUDY",
        "pressure": 1013
      },
      {
        "timestamp": 1724335200,
        "utcOffset": -7,
        "temperature": 64.742,
        "condition": "MOSTLY_CLOUDY",
        "pressure": 1013
      },
      {
        "timestamp": 1724338800,
        "utcOffset": -7,
        "temperature": 66.704,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724342400,
        "utcOffset": -7,
        "temperature": 68.702,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724346000,
        "utcOffset": -7,
        "temperature": 70.82604,
        "condition": "MOSTLY_CLOUDY",
        "pressure": 1014
      },
      {
        "timestamp": 1724349600,
        "utcOffset": -7,
        "temperature": 67.622,
        "condition": "BRIEF_SHOWERS",
        "pressure": 1014
      },
      {
        "timestamp": 1724353200,
        "utcOffset": -7,
        "temperature": 71.67255,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724356800,
        "utcOffset": -7,
        "temperature": 71.45942,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724360400,
        "utcOffset": -7,
        "temperature": 71.40937,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724364000,
        "utcOffset": -7,
        "temperature": 71.68578,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724367600,
        "utcOffset": -7,
        "temperature": 71.53566,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724371200,
        "utcOffset": -7,
        "temperature": 70.83948,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724374800,
        "utcOffset": -7,
        "temperature": 69.98233,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724378400,
        "utcOffset": -7,
        "temperature": 69.21953,
        "condition": "CLEAR",
        "pressure": 1012
      },
      {
        "timestamp": 1724382000,
        "utcOffset": -7,
        "temperature": 68.04772,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724385600,
        "utcOffset": -7,
        "temperature": 67.50408,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724389200,
        "utcOffset": -7,
        "temperature": 67.26937,
        "condition": "NIGHT_CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724392800,
        "utcOffset": -7,
        "temperature": 66.93582,
        "condition": "NIGHT_CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724396400,
        "utcOffset": -7,
        "temperature": 66.84661,
        "condition": "NIGHT_CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724400000,
        "utcOffset": -7,
        "temperature": 66.82301,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724403600,
        "utcOffset": -7,
        "temperature": 66.78228,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724407200,
        "utcOffset": -7,
        "temperature": 66.97181,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724410800,
        "utcOffset": -7,
        "temperature": 66.90822,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724414400,
        "utcOffset": -7,
        "temperature": 67.13274,
        "condition": "NIGHT_CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724418000,
        "utcOffset": -7,
        "temperature": 67.13718,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724421600,
        "utcOffset": -7,
        "temperature": 67.4125,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724425200,
        "utcOffset": -7,
        "temperature": 68.21718,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724428800,
        "utcOffset": -7,
        "temperature": 69.49265,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724432400,
        "utcOffset": -7,
        "temperature": 70.03181,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724436000,
        "utcOffset": -7,
        "temperature": 70.07325,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724439600,
        "utcOffset": -7,
        "temperature": 69.73742,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724443200,
        "utcOffset": -7,
        "temperature": 69.96818,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724446800,
        "utcOffset": -7,
        "temperature": 70.08784,
        "condition": "CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724450400,
        "utcOffset": -7,
        "temperature": 70.29236,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724454000,
        "utcOffset": -7,
        "temperature": 70.19999,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724457600,
        "utcOffset": -7,
        "temperature": 69.8559,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724461200,
        "utcOffset": -7,
        "temperature": 69.30443,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724464800,
        "utcOffset": -7,
        "temperature": 68.56382,
        "condition": "CLEAR",
        "pressure": 1013
      },
      {
        "timestamp": 1724468400,
        "utcOffset": -7,
        "temperature": 67.78994,
        "condition": "NIGHT_CLEAR",
        "pressure": 1014
      },
      {
        "timestamp": 1724472000,
        "utcOffset": -7,
        "temperature": 67.28229,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724475600,
        "utcOffset": -7,
        "temperature": 67.2869,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724479200,
        "utcOffset": -7,
        "temperature": 66.92686,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724482800,
        "utcOffset": -7,
        "temperature": 66.71297,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724486400,
        "utcOffset": -7,
        "temperature": 66.38382,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724490000,
        "utcOffset": -7,
        "temperature": 66.11611,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724493600,
        "utcOffset": -7,
        "temperature": 65.81451,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724497200,
        "utcOffset": -7,
        "temperature": 65.9053,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724500800,
        "utcOffset": -7,
        "temperature": 65.75004,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724504400,
        "utcOffset": -7,
        "temperature": 65.6154,
        "condition": "CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724508000,
        "utcOffset": -7,
        "temperature": 66.14538,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724511600,
        "utcOffset": -7,
        "temperature": 67.03272,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724515200,
        "utcOffset": -7,
        "temperature": 67.94199,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724518800,
        "utcOffset": -7,
        "temperature": 68.83131,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724522400,
        "utcOffset": -7,
        "temperature": 69.21263,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724526000,
        "utcOffset": -7,
        "temperature": 69.1152,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724529600,
        "utcOffset": -7,
        "temperature": 69.03263,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724533200,
        "utcOffset": -7,
        "temperature": 69.22045,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724536800,
        "utcOffset": -7,
        "temperature": 69.09336,
        "condition": "CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724540400,
        "utcOffset": -7,
        "temperature": 69.10021,
        "condition": "CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724544000,
        "utcOffset": -7,
        "temperature": 68.82169,
        "condition": "CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724547600,
        "utcOffset": -7,
        "temperature": 68.37854,
        "condition": "CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724551200,
        "utcOffset": -7,
        "temperature": 67.74397,
        "condition": "CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724554800,
        "utcOffset": -7,
        "temperature": 66.83409,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724558400,
        "utcOffset": -7,
        "temperature": 66.65475,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724562000,
        "utcOffset": -7,
        "temperature": 66.46767,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724565600,
        "utcOffset": -7,
        "temperature": 66.46314,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724569200,
        "utcOffset": -7,
        "temperature": 66.46314,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724572800,
        "utcOffset": -7,
        "temperature": 66.46314,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724576400,
        "utcOffset": -7,
        "temperature": 66.10996,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724580000,
        "utcOffset": -7,
        "temperature": 66.10996,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724583600,
        "utcOffset": -7,
        "temperature": 66.10996,
        "condition": "NIGHT_CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724587200,
        "utcOffset": -7,
        "temperature": 66.18581,
        "condition": "NIGHT_CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724590800,
        "utcOffset": -7,
        "temperature": 66.18581,
        "condition": "CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724594400,
        "utcOffset": -7,
        "temperature": 66.18581,
        "condition": "CLEAR",
        "pressure": 1015
      },
      {
        "timestamp": 1724598000,
        "utcOffset": -7,
        "temperature": 67.91281,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724601600,
        "utcOffset": -7,
        "temperature": 67.91281,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724605200,
        "utcOffset": -7,
        "temperature": 67.91281,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724608800,
        "utcOffset": -7,
        "temperature": 70.79699,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724612400,
        "utcOffset": -7,
        "temperature": 70.79699,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724616000,
        "utcOffset": -7,
        "temperature": 70.79699,
        "condition": "CLEAR",
        "pressure": 1016
      },
      {
        "timestamp": 1724619600,
        "utcOffset": -7,
        "temperature": 71.27639,}*/