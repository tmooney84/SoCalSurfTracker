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
    public class SurfLine_wind_DTO {

        @JsonProperty("associated")
        private AssociatedData associated;

        @JsonProperty("data")
        private WindData data;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AssociatedData {
            @JsonProperty("units")
            private Units units;

            @JsonProperty("utcOffset")
            private Integer utcOffset;

            @JsonProperty("location")
            private Location location;

            @JsonProperty("runInitializationTimestamp")
            private Long runInitializationTimestamp;

            @JsonProperty("windStation")
            private WindStation windStation;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Units {
                @JsonProperty("windSpeed")
                private String windSpeed;
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
            public static class WindStation {
                @JsonProperty("name")
                private String name;

                @JsonProperty("location")
                private Location location;

                @JsonProperty("provider")
                private String provider;
            }
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class WindData {
            @JsonProperty("wind")
            private List<WindEntry> wind;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class WindEntry {
                @JsonProperty("timestamp")
                private Long timestamp;

                @JsonProperty("utcOffset")
                private Integer utcOffset;

                @JsonProperty("speed")
                private Double speed;

                @JsonProperty("direction")
                private Double direction;

                @JsonProperty("directionType")
                private String directionType;

                @JsonProperty("gust")
                private Double gust;

                @JsonProperty("optimalScore")
                private Integer optimalScore;

                @Override
                public String toString() {
                    return "WindEntry{" +
                            "timestamp=" + timestamp +
                            ", utcOffset=" + utcOffset +
                            ", speed=" + speed +
                            ", direction=" + direction +
                            ", directionType='" + directionType + '\'' +
                            ", gust=" + gust +
                            ", optimalScore=" + optimalScore +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "WindData{" +
                        "wind=" + wind +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "SurfLineWindDTO{" +
                    "associated=" + associated +
                    ", data=" + data +
                    '}';
        }
    }



/*
{
  "associated": {
    "units": {
      "windSpeed": "KTS"
    },
    "utcOffset": -7,
    "location": {
      "lon": -117.58843,
      "lat": 33.3814399984902
    },
    "runInitializationTimestamp": 1724220000,
    "windStation": {
      "name": "Lower Trestles",
      "location": {
        "lat": 33.38104,
        "lon": -117.57768
      },
      "provider": "DAVIS"
    }
  },
  "data": {
    "wind": [
      {
        "timestamp": 1724223600,
        "utcOffset": -7,
        "speed": 2.52412,
        "direction": 235.88665,
        "directionType": "Onshore",
        "gust": 2.52412,
        "optimalScore": 2
      },
      {
        "timestamp": 1724227200,
        "utcOffset": -7,
        "speed": 3.45126,
        "direction": 233.15265,
        "directionType": "Onshore",
        "gust": 3.45126,
        "optimalScore": 2
      },
      {
        "timestamp": 1724230800,
        "utcOffset": -7,
        "speed": 3.24039,
        "direction": 220.71223,
        "directionType": "Onshore",
        "gust": 3.24039,
        "optimalScore": 2
      },
      {
        "timestamp": 1724234400,
        "utcOffset": -7,
        "speed": 2.03561,
        "direction": 175.65287,
        "directionType": "Onshore",
        "gust": 2.15371,
        "optimalScore": 2
      },
      {
        "timestamp": 1724238000,
        "utcOffset": -7,
        "speed": 3.42871,
        "direction": 154.91861,
        "directionType": "Onshore",
        "gust": 3.70041,
        "optimalScore": 2
      },
      {
        "timestamp": 1724241600,
        "utcOffset": -7,
        "speed": 4.58859,
        "direction": 160.15703,
        "directionType": "Onshore",
        "gust": 4.8819,
        "optimalScore": 2
      },
      {
        "timestamp": 1724245200,
        "utcOffset": -7,
        "speed": 5.13833,
        "direction": 160.00706,
        "directionType": "Onshore",
        "gust": 5.4879,
        "optimalScore": 0
      },
      {
        "timestamp": 1724248800,
        "utcOffset": -7,
        "speed": 7.18361,
        "direction": 153.42388,
        "directionType": "Onshore",
        "gust": 8.02527,
        "optimalScore": 0
      },
      {
        "timestamp": 1724252400,
        "utcOffset": -7,
        "speed": 8.21975,
        "direction": 150.01458,
        "directionType": "Onshore",
        "gust": 9.18782,
        "optimalScore": 0
      },
      {
        "timestamp": 1724256000,
        "utcOffset": -7,
        "speed": 9.34622,
        "direction": 154.66036,
        "directionType": "Onshore",
        "gust": 10.19135,
        "optimalScore": 0
      },
      {
        "timestamp": 1724259600,
        "utcOffset": -7,
        "speed": 8.69507,
        "direction": 165.55725,
        "directionType": "Onshore",
        "gust": 8.94185,
        "optimalScore": 0
      },
      {
        "timestamp": 1724263200,
        "utcOffset": -7,
        "speed": 7.79911,
        "direction": 172.00226,
        "directionType": "Onshore",
        "gust": 7.79911,
        "optimalScore": 0
      },
      {
        "timestamp": 1724266800,
        "utcOffset": -7,
        "speed": 6.81485,
        "direction": 183.00086,
        "directionType": "Onshore",
        "gust": 6.81485,
        "optimalScore": 0
      },
      {
        "timestamp": 1724270400,
        "utcOffset": -7,
        "speed": 5.85375,
        "direction": 191.93422,
        "directionType": "Onshore",
        "gust": 5.85375,
        "optimalScore": 0
      },
      {
        "timestamp": 1724274000,
        "utcOffset": -7,
        "speed": 6.43087,
        "direction": 190.51326,
        "directionType": "Onshore",
        "gust": 6.43087,
        "optimalScore": 0
      },
      {
        "timestamp": 1724277600,
        "utcOffset": -7,
        "speed": 6.14932,
        "direction": 202.67984,
        "directionType": "Onshore",
        "gust": 6.14932,
        "optimalScore": 0
      },
      {
        "timestamp": 1724281200,
        "utcOffset": -7,
        "speed": 7.0557,
        "direction": 190.54469,
        "directionType": "Onshore",
        "gust": 7.0557,
        "optimalScore": 0
      },
      {
        "timestamp": 1724284800,
        "utcOffset": -7,
        "speed": 6.30211,
        "direction": 186.31426,
        "directionType": "Onshore",
        "gust": 6.30211,
        "optimalScore": 0
      },
      {
        "timestamp": 1724288400,
        "utcOffset": -7,
        "speed": 5.69505,
        "direction": 174.0053,
        "directionType": "Onshore",
        "gust": 5.69505,
        "optimalScore": 0
      },
      {
        "timestamp": 1724292000,
        "utcOffset": -7,
        "speed": 6.58818,
        "direction": 164.99361,
        "directionType": "Onshore",
        "gust": 6.62242,
        "optimalScore": 0
      },
      {
        "timestamp": 1724295600,
        "utcOffset": -7,
        "speed": 8.74308,
        "direction": 145.55382,
        "directionType": "Cross-shore",
        "gust": 9.72001,
        "optimalScore": 0
      },
      {
        "timestamp": 1724299200,
        "utcOffset": -7,
        "speed": 9.23574,
        "direction": 139.59206,
        "directionType": "Cross-shore",
        "gust": 10.70739,
        "optimalScore": 0
      },
      {
        "timestamp": 1724302800,
        "utcOffset": -7,
        "speed": 9.3136,
        "direction": 141.0211,
        "directionType": "Cross-shore",
        "gust": 10.52963,
        "optimalScore": 0
      },
      {
        "timestamp": 1724306400,
        "utcOffset": -7,
        "speed": 10.84044,
        "direction": 136.47002,
        "directionType": "Cross-shore",
        "gust": 12.46313,
        "optimalScore": 0
      },
      {
        "timestamp": 1724310000,
        "utcOffset": -7,
        "speed": 9.03617,
        "direction": 143.59245,
        "directionType": "Cross-shore",
        "gust": 10.54838,
        "optimalScore": 0
      },
      {
        "timestamp": 1724313600,
        "utcOffset": -7,
        "speed": 8.27251,
        "direction": 145.56505,
        "directionType": "Cross-shore",
        "gust": 9.37407,
        "optimalScore": 0
      },
      {
        "timestamp": 1724317200,
        "utcOffset": -7,
        "speed": 7.71505,
        "direction": 146.61417,
        "directionType": "Cross-shore",
        "gust": 8.7473,
        "optimalScore": 0
      },
      {
        "timestamp": 1724320800,
        "utcOffset": -7,
        "speed": 7.64668,
        "direction": 142.62273,
        "directionType": "Cross-shore",
        "gust": 8.55975,
        "optimalScore": 0
      },
      {
        "timestamp": 1724324400,
        "utcOffset": -7,
        "speed": 8.30547,
        "direction": 138.7431,
        "directionType": "Cross-shore",
        "gust": 9.55209,
        "optimalScore": 0
      },
      {
        "timestamp": 1724328000,
        "utcOffset": -7,
        "speed": 8.27087,
        "direction": 139.11804,
        "directionType": "Cross-shore",
        "gust": 9.55426,
        "optimalScore": 0
      },
      {
        "timestamp": 1724331600,
        "utcOffset": -7,
        "speed": 8.36107,
        "direction": 140.057,
        "directionType": "Cross-shore",
        "gust": 9.55937,
        "optimalScore": 0
      },
      {
        "timestamp": 1724335200,
        "utcOffset": -7,
        "speed": 8.26566,
        "direction": 143.3142,
        "directionType": "Cross-shore",
        "gust": 9.34426,
        "optimalScore": 0
      },
      {
        "timestamp": 1724338800,
        "utcOffset": -7,
        "speed": 8.24829,
        "direction": 148.84712,
        "directionType": "Onshore",
        "gust": 8.98438,
        "optimalScore": 0
      },
      {
        "timestamp": 1724342400,
        "utcOffset": -7,
        "speed": 8.32217,
        "direction": 156.869,
        "directionType": "Onshore",
        "gust": 8.7488,
        "optimalScore": 0
      },
      {
        "timestamp": 1724346000,
        "utcOffset": -7,
        "speed": 8.06234,
        "direction": 166.56324,
        "directionType": "Onshore",
        "gust": 8.20983,
        "optimalScore": 0
      },
      {
        "timestamp": 1724349600,
        "utcOffset": -7,
        "speed": 8.38728,
        "direction": 174.5579,
        "directionType": "Onshore",
        "gust": 8.38728,
        "optimalScore": 0
      },
      {
        "timestamp": 1724353200,
        "utcOffset": -7,
        "speed": 8.24931,
        "direction": 184.35296,
        "directionType": "Onshore",
        "gust": 8.24931,
        "optimalScore": 0
      },
      {
        "timestamp": 1724356800,
        "utcOffset": -7,
        "speed": 7.43268,
        "direction": 191.64297,
        "directionType": "Onshore",
        "gust": 7.43268,
        "optimalScore": 0
      },
      {
        "timestamp": 1724360400,
        "utcOffset": -7,
        "speed": 6.60913,
        "direction": 201.22794,
        "directionType": "Onshore",
        "gust": 6.60913,
        "optimalScore": 0
      },
      {
        "timestamp": 1724364000,
        "utcOffset": -7,
        "speed": 5.809,
        "direction": 221.12588,
        "directionType": "Onshore",
        "gust": 5.809,
        "optimalScore": 0
      },
      {
        "timestamp": 1724367600,
        "utcOffset": -7,
        "speed": 6.11891,
        "direction": 247.40069,
        "directionType": "Onshore",
        "gust": 6.11891,
        "optimalScore": 0
      },
      {
        "timestamp": 1724371200,
        "utcOffset": -7,
        "speed": 7.12851,
        "direction": 262.72292,
        "directionType": "Onshore",
        "gust": 7.12851,
        "optimalScore": 0
      },
      {
        "timestamp": 1724374800,
        "utcOffset": -7,
        "speed": 7.13245,
        "direction": 270.47014,
        "directionType": "Onshore",
        "gust": 7.13245,
        "optimalScore": 0
      },
      {
        "timestamp": 1724378400,
        "utcOffset": -7,
        "speed": 6.36503,
        "direction": 276.54867,
        "directionType": "Onshore",
        "gust": 6.36503,
        "optimalScore": 0
      },
      {
        "timestamp": 1724382000,
        "utcOffset": -7,
        "speed": 5.70057,
        "direction": 277.64087,
        "directionType": "Cross-shore",
        "gust": 5.70057,
        "optimalScore": 0
      },
      {
        "timestamp": 1724385600,
        "utcOffset": -7,
        "speed": 4.15572,
        "direction": 278.02201,
        "directionType": "Cross-shore",
        "gust": 4.15572,
        "optimalScore": 2
      },
      {
        "timestamp": 1724389200,
        "utcOffset": -7,
        "speed": 3.22485,
        "direction": 269.03807,
        "directionType": "Onshore",
        "gust": 3.22485,
        "optimalScore": 2
      },
      {
        "timestamp": 1724392800,
        "utcOffset": -7,
        "speed": 1.97411,
        "direction": 254.0942,
        "directionType": "Onshore",
        "gust": 1.97411,
        "optimalScore": 2
      },
      {
        "timestamp": 1724396400,
        "utcOffset": -7,
        "speed": 1.75676,
        "direction": 183.97962,
        "directionType": "Onshore",
        "gust": 1.995,
        "optimalScore": 2
      },
      {
        "timestamp": 1724400000,
        "utcOffset": -7,
        "speed": 2.75614,
        "direction": 175.42213,
        "directionType": "Onshore",
        "gust": 3.11262,
        "optimalScore": 2
      },
      {
        "timestamp": 1724403600,
        "utcOffset": -7,
        "speed": 3.83611,
        "direction": 164.85373,
        "directionType": "Onshore",
        "gust": 4.4738,
        "optimalScore": 2
      },
      {
        "timestamp": 1724407200,
        "utcOffset": -7,
        "speed": 4.43119,
        "direction": 154.42813,
        "directionType": "Onshore",
        "gust": 5.054,
        "optimalScore": 2
      },
      {
        "timestamp": 1724410800,
        "utcOffset": -7,
        "speed": 4.95144,
        "direction": 151.42071,
        "directionType": "Onshore",
        "gust": 5.49567,
        "optimalScore": 2
      },
      {
        "timestamp": 1724414400,
        "utcOffset": -7,
        "speed": 5.09474,
        "direction": 146.28484,
        "directionType": "Cross-shore",
        "gust": 5.67174,
        "optimalScore": 0
      },
      {
        "timestamp": 1724418000,
        "utcOffset": -7,
        "speed": 5.67617,
        "direction": 140.21382,
        "directionType": "Cross-shore",
        "gust": 6.44396,
        "optimalScore": 0
      },
      {
        "timestamp": 1724421600,
        "utcOffset": -7,
        "speed": 5.8234,
        "direction": 153.42242,
        "directionType": "Onshore",
        "gust": 6.80389,
        "optimalScore": 0
      },
      {
        "timestamp": 1724425200,
        "utcOffset": -7,
        "speed": 6.93644,
        "direction": 151.34354,
        "directionType": "Onshore",
        "gust": 7.62155,
        "optimalScore": 0
      },
      {
        "timestamp": 1724428800,
        "utcOffset": -7,
        "speed": 8.22353,
        "direction": 157.67183,
        "directionType": "Onshore",
        "gust": 8.76287,
        "optimalScore": 0
      },
      {
        "timestamp": 1724432400,
        "utcOffset": -7,
        "speed": 8.03601,
        "direction": 176.23373,
        "directionType": "Onshore",
        "gust": 8.03601,
        "optimalScore": 0
      },
      {
        "timestamp": 1724436000,
        "utcOffset": -7,
        "speed": 7.7367,
        "direction": 188.86502,
        "directionType": "Onshore",
        "gust": 7.7367,
        "optimalScore": 0
      },
      {
        "timestamp": 1724439600,
        "utcOffset": -7,
        "speed": 7.58895,
        "direction": 196.01811,
        "directionType": "Onshore",
        "gust": 7.58895,
        "optimalScore": 0
      },
      {
        "timestamp": 1724443200,
        "utcOffset": -7,
        "speed": 7.62928,
        "direction": 203.01397,
        "directionType": "Onshore",
        "gust": 7.62928,
        "optimalScore": 0
      },
      {
        "timestamp": 1724446800,
        "utcOffset": -7,
        "speed": 7.90329,
        "direction": 231.18299,
        "directionType": "Onshore",
        "gust": 7.90329,
        "optimalScore": 0
      },
      {
        "timestamp": 1724450400,
        "utcOffset": -7,
        "speed": 6.82082,
        "direction": 245.41684,
        "directionType": "Onshore",
        "gust": 6.82082,
        "optimalScore": 0
      },
      {
        "timestamp": 1724454000,
        "utcOffset": -7,
        "speed": 7.37059,
        "direction": 252.7685,
        "directionType": "Onshore",
        "gust": 7.37059,
        "optimalScore": 0
      },
      {
        "timestamp": 1724457600,
        "utcOffset": -7,
        "speed": 7.35421,
        "direction": 258.24214,
        "directionType": "Onshore",
        "gust": 7.35421,
        "optimalScore": 0
      },
 */