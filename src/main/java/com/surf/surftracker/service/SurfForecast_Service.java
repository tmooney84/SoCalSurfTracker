package com.surf.surftracker.service;

import com.surf.surftracker.model.Current;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SurfForecast_Service {
    private Current LowersCurrent;

    public SurfForecast_Service(Current LowersCurrent) {
        this.LowersCurrent = LowersCurrent;
    }

    String[] SFurl = {
            "https://www.surf-forecast.com/breaks/Trestles_Lowers/forecasts/latest/"
    };

    public void getSurfForecastCurrent() {
        try {
            for (String url : SFurl) {
                Document sfConnect = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36")
                        .get();

                LocalTime[] times = {
                        LocalTime.of(8, 0),
                        LocalTime.of(11, 0),
                        LocalTime.of(14, 0),
                        LocalTime.of(17, 0),
                        LocalTime.of(20, 0),
                        LocalTime.of(23, 0)
                };

                // Get the current time in Los Angeles
                ZonedDateTime nowInLA = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
                LocalTime currentTime = nowInLA.toLocalTime();

                // Initialize the closest previous time
                LocalTime closestTime = times[0];

                // Find the closest previous time
                for (LocalTime time : times) {
                    if (currentTime.isAfter(time) || currentTime.equals(time)) {
                        closestTime = time;
                    } else {
                        break;
                    }
                }

                // Format the closest previous time in 12-hour format with AM/PM
                String formattedTimeOfDay = closestTime.format(DateTimeFormatter.ofPattern("ha")).toUpperCase();

                // Format to get the day of the week and day of the month in Los Angeles time
                String dayOfWeek = nowInLA.format(DateTimeFormatter.ofPattern("EEEE"));
                String dayOfMonth = nowInLA.format(DateTimeFormatter.ofPattern("dd"));

                // Print the results
                System.out.println("Los Angeles Day of the Week: " + dayOfWeek);
                System.out.println("Los Angeles Day of the Month: " + dayOfMonth);
                System.out.println("Closest Previous Time of Day in Los Angeles: " + formattedTimeOfDay);

                // Construct the query string with variables
                String query = String.format(
                        "td.forecast-table__cell.forecast-table-wave-height__cell[data-date='%s %s %s']",
                        dayOfWeek, dayOfMonth, formattedTimeOfDay
                );

                System.out.println("Generated Query: " + query); // Debugging print

                // Use the query string in the selectFirst method
                Element tdElement = sfConnect.selectFirst(query);

                if (tdElement != null) {
                    // Navigate to the <text> element inside the SVG and get the content
                    Element textElement = tdElement.selectFirst("text.swell-icon__val");
                    if (textElement != null) {
                        String waveHeight = textElement.text();
                        int intWave = (int) Math.round(Double.parseDouble(waveHeight) * 3.048);
                        String formattedWave = String.format("%d ft", intWave);

                        System.out.println("Surf Captain Wave is " + formattedWave);
                        LowersCurrent.setSurfForecastWaveHeight(formattedWave);

                        System.out.println("Wave height: " + formattedWave);
                    } else {
                        System.out.println("Wave height value not found");
                    }
                } else {
                    System.out.println("Element with specified class and data-date not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
                // Select the <td> element with the specific class and data-date attribute

                // Define your variables
                // String dayOfWeek = "Saturday";
                // String dayOfMonth = "24";
                String timeOfDay = "5PM";

                // Get the current date and time
                LocalDateTime now = LocalDateTime.now();



                String dayOfWeek = now.format(DateTimeFormatter.ofPattern("EEEE"));
                String dayOfMonth = now.format(DateTimeFormatter.ofPattern("d"));

                // Format to get the time of day in 12-hour format with AM/PM
                String timeOfDay = now.format(DateTimeFormatter.ofPattern("h:mm a"));
                // Print the results
                System.out.println("Day of the Week: " + dayOfWeek);
                System.out.println("Day of the Month: " + dayOfMonth);
                System.out.println("Time of Day: " + timeOfDay);
*/
// Construct the query string with variables
