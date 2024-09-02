//Associated doesn't print so better to rely on the first timestamp in the swell data

/*
currently using SurfLine's API for swell data but will migrate to the National Weather Service
Data at: https://weather-gov.github.io/api/gridpoints for primarySwellHeight:    primarySwellDirection:
secondarySwellHeight:    secondarySwellDirection: & will get an additional datapoint for
waveHeight:  wavePeriod:   waveDirection:
 */
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
public class SurfLine_swells_DTO {

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

        @JsonProperty("location")
        private Location location;

        @JsonProperty("forecastLocation")
        private ForecastLocation forecastLocation;

        @JsonProperty("runInitializationTimestamp")
        private Long runInitializationTimestamp;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Units {
            @JsonProperty("swellHeight")
            private String swellHeight;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Location {
            @JsonProperty("lon")
            private Double lon;

            @JsonProperty("lat")
            private Double lat;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ForecastLocation {
            @JsonProperty("lat")
            private Double lat;

            @JsonProperty("lon")
            private Double lon;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataData {
        @JsonProperty("swells")
        private List<SwellEntry> swells;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SwellEntry {
            @JsonProperty("timestamp")
            private Long timestamp;

            @JsonProperty("probability")
            private Integer probability;

            @JsonProperty("utcOffset")
            private Integer utcOffset;

            @JsonProperty("power")
            private Double power;

            @JsonProperty("swells")
            private List<SwellData> swells;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SwellData {
                @JsonProperty("height")
                private Double height;

                @JsonProperty("period")
                private Integer period;

                @JsonProperty("impact")
                private Double impact;

                @JsonProperty("power")
                private Double power;

                @JsonProperty("direction")
                private Double direction;

                @JsonProperty("directionMin")
                private Double directionMin;

                @Override
                public String toString() {
                    return "SwellData{" +
                            "height=" + height +
                            ", period=" + period +
                            ", impact=" + impact +
                            ", power=" + power +
                            ", direction=" + direction +
                            ", directionMin=" + directionMin +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "SwellEntry{" +
                        "timestamp=" + timestamp +
                        ", probability=" + probability +
                        ", utcOffset=" + utcOffset +
                        ", power=" + power +
                        ", swells=" + swells +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "SurfLineSwellsDTO{" +
                "associated=" + associated +
                ", data=" + data +
                '}';
    }
}





/*Example swells JSON Data: https://services.surfline.com/kbyg/spots/forecasts/swells?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a770888a&units%5BswellHeight%5D=FT
{
    "associated": {
        "units": {
            "swellHeight": "FT"
        },
        "location": {
            "lon": -117.58843,
            "lat": 33.38143999849023
        },
        "forecastLocation": {
            "lat": 33.35,
            "lon": -117.65
        },
        "runInitializationTimestamp": 1722664800
    },
    "data": {
        "swells": [
            {
                "timestamp": 1722668400,
                "probability": 100,
                "utcOffset": -7,
                "power": 38.59851,
                "swells": [
                    {
                        "height": 1.47638,
                        "period": 11,
                        "impact": 0.2727,
                        "power": 14.20735,
                        "direction": 185.62,
                        "directionMin": 180.69
                    },
                    {
                        "height": 1.24672,
                        "period": 15,
                        "impact": 0.2583,
                        "power": 15.49564,
                        "direction": 180.27,
                        "directionMin": 177.875
                    },
                    {
                        "height": 0.85302,
                        "period": 16,
                        "impact": 0.2382,
                        "power": 8.15026,
                        "direction": 215.46,
                        "directionMin": 211.13500000000002
                    },
                    {
                        "height": 1.04987,
                        "period": 5,
                        "impact": 0.1322,
                        "power": 0.59435,
                        "direction": 264.82,
                        "directionMin": 253.345
                    },
                    {
                        "height": 0,
                        "period": 0,
                        "impact": 0,
                        "power": 0,
                        "direction": 0,
                        "directionMin": 0
                    },
                    {
                        "height": 0.19685,
                        "period": 16,
                        "impact": 0.0818,
                        "power": 0.15091,
                        "direction": 249.37,
                        "directionMin": 246.595
                    }
                ]
            },
            {
                "timestamp": 1722672000,
                "probability": 100,
                "utcOffset": -7,
                "power": 36.99531,
                "swells": [
                    {
                        "height": 1.47638,
                        "period": 11,
                        "impact": 0.2596,
                        "power": 12.96382,
                        "direction": 185.54,
                        "directionMin": 180.6
                    },
                    {
                        "height": 1.24672,
                        "period": 15,
                        "impact": 0.2482,
                        "power": 14.8284,
                        "direction": 180.33,
                        "directionMin": 177.91000000000003
                    },
                    {
                        "height": 0.88583,
                        "period": 16,
                        "impact": 0.2358,
                        "power": 8.63581,
                        "direction": 215.74,
                        "directionMin": 211.215
                    },
                    {
                        "height": 0.62336,
                        "period": 5,
                        "impact": 0.0716,
                        "power": 0.14901,
                        "direction": 284.58,
                        "directionMin": 280.205
                    },
                    {
                        "height": 0.85302,
                        "period": 5,
                        "impact": 0.1134,
                        "power": 0.32668,
                        "direction": 253.53,
                        "directionMin": 243.745
                    },
                    {
                        "height": 0.16404,
                        "period": 16,
                        "impact": 0.0714,
                        "power": 0.09159,
                        "direction": 251.32,
                        "directionMin": 249.385
                    }
                ]
            },
            {
                "timestamp": 1722675600,
                "probability": 100,
                "utcOffset": -7,
                "power": 36.3252,
                "swells": [
                    {
                        "height": 1.47638,
                        "period": 11,
                        "impact": 0.2576,
                        "power": 12.59001,
                        "direction": 185.52,
                        "directionMin": 180.54500000000002
                    },
                    {
                        "height": 1.21391,
                        "period": 14,
                        "impact": 0.242,
                        "power": 13.63164,
                        "direction": 180.38,
                        "directionMin": 177.93
                    },
                    {
                        "height": 0.91864,
                        "period": 16,
                        "impact": 0.2416,
                        "power": 9.43271,
                        "direction": 215.71,
                        "directionMin": 211.17000000000002
                    },
                    {
                        "height": 0.55774,
                        "period": 5,
                        "impact": 0.0649,
                        "power": 0.10535,
                        "direction": 284.74,
                        "directionMin": 281.145
                    },
                    {
                        "height": 0.95144,
                        "period": 5,
                        "impact": 0.1227,
                        "power": 0.47438,
                        "direction": 257.14,
                        "directionMin": 247.195
                    },
                    {
                        "height": 0.16404,
                        "period": 16,
                        "impact": 0.0712,
                        "power": 0.09111,
                        "direction": 251.32,
                        "directionMin": 249.385
                    }
                ]
            },
            {
                "timestamp": 1722679200,
                "probability": 100,
                "utcOffset": -7,
                "power": 38.71046,
                "swells": [
                    {
                        "height": 1.47638,
                        "period": 11,
                        "impact": 0.2685,
                        "power": 12.98113,
                        "direction": 185.28,
                        "directionMin": 180.24
                    },
                    {
                        "height": 1.24672,
                        "period": 14,
                        "impact": 0.2586,
                        "power": 15.38596,
                        "direction": 181.23,
                        "directionMin": 178.32
                    },
                    {
                        "height": 0.91864,
                        "period": 16,
                        "impact": 0.2522,
                        "power": 9.63753,
                        "direction": 216.59,
                        "directionMin": 212.355
                    },
                    {
                        "height": 0.59055,
                        "period": 5,
                        "impact": 0.0702,
                        "power": 0.12256,
                        "direction": 284.68,
                        "directionMin": 281.055
                    },
                    {
                        "height": 0.98425,
                        "period": 5,
                        "impact": 0.1337,
                        "power": 0.58328,
                        "direction": 257.81,
                        "directionMin": 248.35
                    },
                    {
                        "height": 0,
                        "period": 0,
                        "impact": 0,
                        "power": 0,
                        "direction": 0,
                        "directionMin": 0
                    }
                ]
            },
 */