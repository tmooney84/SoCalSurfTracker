package com.surf.surftracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurfLine_surf_DTO {

    @JsonProperty("associated")
    private Associated associated;

    @JsonProperty("data")
    private Data data;

    @Override
    public String toString() {
        return "SurfLine_surf_DTO{" +
                "associated=" + associated +
                ", data=" + data +
                '}';
    }

    @Setter
    @Getter
    public static class Associated {

        @JsonProperty("units")
        private Units units;

        @JsonProperty("location")
        private Location location;

        @JsonProperty("forecastLocation")
        private ForecastLocation forecastLocation;

        @JsonProperty("runInitializationTimestamp")
        private long runInitializationTimestamp;

        @Override
        public String toString() {
            return "Associated{" +
                    "units=" + units +
                    ", location=" + location +
                    ", forecastLocation=" + forecastLocation +
                    ", runInitializationTimestamp=" + runInitializationTimestamp +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class Units {

        @JsonProperty("waveHeight")
        private String waveHeight;

        @Override
        public String toString() {
            return "Units{" +
                    "waveHeight='" + waveHeight + '\'' +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class Location {

        @JsonProperty("lon")
        private double lon;

        @JsonProperty("lat")
        private double lat;

        @Override
        public String toString() {
            return "Location{" +
                    "lon=" + lon +
                    ", lat=" + lat +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class ForecastLocation {

        @JsonProperty("lon")
        private double lon;

        @JsonProperty("lat")
        private double lat;

        @Override
        public String toString() {
            return "ForecastLocation{" +
                    "lon=" + lon +
                    ", lat=" + lat +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class Data {

        @JsonProperty("surf")
        private List<Surf> surf;

        @Override
        public String toString() {
            return "Data{" +
                    "surf=" + surf +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class Surf {

        @JsonProperty("timestamp")
        private long timestamp;

        @JsonProperty("utcOffset")
        private int utcOffset;

        @JsonProperty("surf")
        private SurfDetails surfDetails;

        @Override
        public String toString() {
            return "Surf{" +
                    "timestamp=" + timestamp +
                    ", utcOffset=" + utcOffset +
                    ", surfDetails=" + surfDetails +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class SurfDetails {

        @JsonProperty("min")
        private double min;

        @JsonProperty("max")
        private double max;

        @JsonProperty("plus")
        private boolean plus;

        @JsonProperty("humanRelation")
        private String humanRelation;

        @JsonProperty("raw")
        private Raw raw;

        @Override
        public String toString() {
            return "SurfDetails{" +
                    "min=" + min +
                    ", max=" + max +
                    ", plus=" + plus +
                    ", humanRelation='" + humanRelation + '\'' +
                    ", raw=" + raw +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class Raw {

        @JsonProperty("min")
        private double min;

        @JsonProperty("max")
        private double max;

        @Override
        public String toString() {
            return "Raw{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
}

/*
Example surf JSON output from https://services.surfline.com/kbyg/spots/forecasts/surf?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a770888a&units%5BwaveHeight%5D=FT
{
    "associated": {
        "units": {
            "waveHeight": "FT"
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
        "surf": [
            {
                "timestamp": 1722668400,
                "utcOffset": -7,
                "surf": {
                    "min": 3,
                    "max": 5,
                    "plus": false,
                    "humanRelation": "Waist to head",
                    "raw": {
                        "min": 3.40007,
                        "max": 5.25504
                    }
                }
            },
            {
                "timestamp": 1722672000,
                "utcOffset": -7,
                "surf": {
                    "min": 4,
                    "max": 5,
                    "plus": false,
                    "humanRelation": "Chest to head",
                    "raw": {
                        "min": 3.69301,
                        "max": 5.37228
                    }
                }
            },
            {
                "timestamp": 1722675600,
                "utcOffset": -7,
                "surf": {
                    "min": 4,
                    "max": 5,
                    "plus": false,
                    "humanRelation": "Chest to head",
                    "raw": {
                        "min": 3.8219,
                        "max": 5.35829
                    }
                }
            },
            {
                "timestamp": 1722679200,
                "utcOffset": -7,
                "surf": {
                    "min": 4,
                    "max": 5,
                    "plus": false,
                    "humanRelation": "Chest to head",
                    "raw": {
                        "min": 3.85236,
                        "max": 5.27867
                    }
                }
            },
 */