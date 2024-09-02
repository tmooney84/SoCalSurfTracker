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
public class SurfLine_rating_DTO implements Serializable {

    @JsonProperty("associated")
    private Associated associated;

    //changed to public for testing
    @JsonProperty("data")
    public Data data;

    @Override
    public String toString() {
        return "SurfLine_rating_DTO{" +
                "associated=" + associated +
                ", data=" + data +
                '}';
    }

    @Setter
    @Getter
    public static class Associated implements Serializable {

        @JsonProperty("location")
        private Location location;

        @JsonProperty("runInitializationTimestamp")
        private long runInitializationTimestamp;

        @Override
        public String toString() {
            return "Associated{" +
                    "location=" + location +
                    ", runInitializationTimestamp=" + runInitializationTimestamp +
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

    public static class Data implements Serializable {

        @JsonProperty("rating")
        public List<Rating> rating;

        @Override
        public String toString() {
            return "Data{" +
                    "rating=" + rating +
                    '}';
        }

        public List<Rating> getRating() {
            return this.rating;
        }

        @JsonProperty("rating")
        public void setRating(List<Rating> rating) {
            this.rating = rating;
        }
    }

    @Setter
    @Getter
    public static class Rating implements Serializable {

        @JsonProperty("timestamp")
        private long timestamp;

        @JsonProperty("utcOffset")
        private int utcOffset;

        @JsonProperty("rating")
        private RatingDetails ratingDetails;

        @Override
        public String toString() {
            return "Rating{" +
                    "timestamp=" + timestamp +
                    ", utcOffset=" + utcOffset +
                    ", ratingDetails=" + ratingDetails +
                    '}';
        }
    }

    @Setter
    @Getter
    public static class RatingDetails implements Serializable {

        @JsonProperty("key")
        private String key;

        @JsonProperty("value")
        private double value;

        @Override
        public String toString() {
            return "RatingDetails{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}

/*Example rating JSON Data: https://services.surfline.com/kbyg/spots/forecasts/rating?spotId=5842041f4e65fad6a770888a&days=5&intervalHours=1&cacheEnabled=true

        {"associated": {
        "location": {
        "lon": -117.58843,
        "lat": 33.38143999849023
        },
        "runInitializationTimestamp": 1722686400
        },
        "data": {
        "rating": [
        {
        "timestamp": 1722668400,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR_TO_GOOD",
        "value": 3.8333333333333335
        }
        },
        {
        "timestamp": 1722672000,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR_TO_GOOD",
        "value": 3.6666666666666665
        }
        },
        {
        "timestamp": 1722675600,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR_TO_GOOD",
        "value": 3.5
        }
        },
        {
        "timestamp": 1722679200,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3.3333333333333335
        }
        },
        {
        "timestamp": 1722682800,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3.166666666666667
        }
        },
        {
        "timestamp": 1722686400,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722690000,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722693600,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722697200,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722700800,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 2.571428571428571
        }
        },
        {
        "timestamp": 1722704400,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 2.7142857142857144
        }
        },
        {
        "timestamp": 1722708000,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 2.857142857142857
        }
        },
        {
        "timestamp": 1722711600,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722715200,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722718800,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722722400,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722726000,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722729600,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722733200,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722736800,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722740400,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722744000,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722747600,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722751200,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722754800,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722758400,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722762000,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722765600,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722769200,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722772800,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722776400,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722780000,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722783600,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722787200,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722790800,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722794400,
        "utcOffset": -7,
        "rating": {
        "key": "FAIR",
        "value": 3
        }
        },
        {
        "timestamp": 1722798000,
        "utcOffset": -7,
        "rating": {
        "key": "POOR_TO_FAIR",
        "value": 2
        }
        },
        {
        "timestamp": 1722801600,
        "utcOffset": -7,
        "rating": {
        "key": "POOR_TO_FAIR",
        "value": 2
        }
        },
        {
        "timestamp": 1722805200,
        "utcOffset": -7,
        "rating": {
        "key": "POOR_TO_FAIR",
        "value": 2
        }
        },
        {
        "timestamp": 1722808800,
        "utcOffset": -7,
        "rating": {
        "key": "POOR_TO_FAIR",
        "value": 2
        }
        },
        {
        "timestamp": 1722812400,
        "utcOffset": -7,
        "rating": {
        "key": "POOR_TO_FAIR",
        "value": 2
        }
        },
 */