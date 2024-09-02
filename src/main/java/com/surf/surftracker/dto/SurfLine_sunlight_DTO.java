package com.surf.surftracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurfLine_sunlight_DTO implements Serializable {

    @JsonProperty("associated")
    private Associated associated;

    @JsonProperty("data")
    private Data data;

    @Override
    public String toString() {
        return "SurfLine_sunlight_DTO{" +
                "associated=" + associated +
                ", data=" + data +
                '}';
    }

    @Setter
    @Getter
    public static class Associated implements Serializable {

        @JsonProperty("location")
        private Location location;

        @Override
        public String toString() {
            return "Associated{" +
                    "location=" + location +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class Location implements Serializable {

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
    public static class Data implements Serializable {

        @JsonProperty("sunlight")
        private List<Sunlight> sunlight;

        @Override
        public String toString() {
            return "Data{" +
                    "sunlight=" + sunlight +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class Sunlight implements Serializable {

        @JsonProperty("midnight")
        private long midnight;

        @JsonProperty("midnightUTCOffset")
        private int midnightUTCOffset;

        @JsonProperty("dawn")
        private long dawn;

        @JsonProperty("dawnUTCOffset")
        private int dawnUTCOffset;

        @JsonProperty("sunrise")
        private long sunrise;

        @JsonProperty("sunriseUTCOffset")
        private int sunriseUTCOffset;

        @JsonProperty("sunset")
        private long sunset;

        @JsonProperty("sunsetUTCOffset")
        private int sunsetUTCOffset;

        @JsonProperty("dusk")
        private long dusk;

        @JsonProperty("duskUTCOffset")
        private int duskUTCOffset;

        @Override
        public String toString() {
            return "Sunlight{" +
                    "midnight=" + midnight +
                    ", midnightUTCOffset=" + midnightUTCOffset +
                    ", dawn=" + dawn +
                    ", dawnUTCOffset=" + dawnUTCOffset +
                    ", sunrise=" + sunrise +
                    ", sunriseUTCOffset=" + sunriseUTCOffset +
                    ", sunset=" + sunset +
                    ", sunsetUTCOffset=" + sunsetUTCOffset +
                    ", dusk=" + dusk +
                    ", duskUTCOffset=" + duskUTCOffset +
                    '}';
        }
    }
}


/*Example sunlight JSON Data: https://services.surfline.com/kbyg/spots/forecasts/sunlight?spotId=5842041f4e65fad6a770888a&days=16&intervalHours=1
***The data contained in the JSON is for 2 weeks

   { "associated": {
        "location": {
            "lon": -117.58843,
            "lat": 33.38143999849023
        }
    },
    "data": {
        "sunlight": [
            {
                "midnight": 1722668400,
                "midnightUTCOffset": -7,
                "dawn": 1722688743,
                "dawnUTCOffset": -7,
                "sunrise": 1722690362,
                "sunriseUTCOffset": -7,
                "sunset": 1722739768,
                "sunsetUTCOffset": -7,
                "dusk": 1722741386,
                "duskUTCOffset": -7
            },
            {
                "midnight": 1722754800,
                "midnightUTCOffset": -7,
                "dawn": 1722775190,
                "dawnUTCOffset": -7,
                "sunrise": 1722776805,
                "sunriseUTCOffset": -7,
                "sunset": 1722826115,
                "sunsetUTCOffset": -7,
                "dusk": 1722827729,
                "duskUTCOffset": -7
            },
            {
                "midnight": 1722841200,
                "midnightUTCOffset": -7,
                "dawn": 1722861637,
                "dawnUTCOffset": -7,
                "sunrise": 1722863248,
                "sunriseUTCOffset": -7,
                "sunset": 1722912461,
                "sunsetUTCOffset": -7,
                "dusk": 1722914072,
                "duskUTCOffset": -7
            },
            {
                "midnight": 1722927600,
                "midnightUTCOffset": -7,
                "dawn": 1722948085,
                "dawnUTCOffset": -7,
                "sunrise": 1722949691,
                "sunriseUTCOffset": -7,
                "sunset": 1722998806,
                "sunsetUTCOffset": -7,
                "dusk": 1723000413,
                "duskUTCOffset": -7
            },
            {
                "midnight": 1723014000,
                "midnightUTCOffset": -7,
                "dawn": 1723034532,
                "dawnUTCOffset": -7,
                "sunrise": 1723036134,
                "sunriseUTCOffset": -7,
                "sunset": 1723085150,
                "sunsetUTCOffset": -7,
                "dusk": 1723086752,
                "duskUTCOffset": -7
            },
            {
                "midnight": 1723100400,
                "midnightUTCOffset": -7,
                "dawn": 1723120979,
                "dawnUTCOffset": -7,
                "sunrise": 1723122577,
                "sunriseUTCOffset": -7,
                "sunset": 1723171493,
                "sunsetUTCOffset": -7,
                "dusk": 1723173091,
                "duskUTCOffset": -7
            },
            {
                "midnight": 1723186800,
                "midnightUTCOffset": -7,
                "dawn": 1723207426,
                "dawnUTCOffset": -7,
                "sunrise": 1723209020,
                "sunriseUTCOffset": -7,
                "sunset": 1723257834,
                "sunsetUTCOffset": -7,
                "dusk": 1723259429,
                "duskUTCOffset": -7
            },
 */