package com.surf.surftracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CatApi {

    public static void main(String[] args) {
        SpringApplication.run(GetApiApplication.class, args);

        // Define the URL
        String url = "https://catfact.ninja/fact?max_length=140";

        // Initialize the WebClient builder and build the WebClient
        WebClient.Builder builder = WebClient.builder();
        WebClient webClient = builder.build();

     //   try {
            // Fetch the data and block to get the result
            String response = webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();


           System.out.println("--------------------------------------------------");
           System.out.println(response);
           System.out.println("--------------------------------------------------");

/*
            // Initialize ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);

            // Get the "data" node and the "surf" array
            JsonNode surfArray = rootNode.path("data").path("surf");

            // Target timestamp to filter
            long targetTimestamp = 1722452400L;

            // Iterate through the surf array to find the matching timestamp
            for (JsonNode node : surfArray) {
                long timestamp = node.path("timestamp").asLong();
                if (timestamp == targetTimestamp) {
                    JsonNode surf = node.path("surf");
                    double min = surf.path("min").asDouble();
                    double max = surf.path("max").asDouble();
                    boolean plus = surf.path("plus").asBoolean();

                    System.out.println("Timestamp: " + timestamp);
                    System.out.println("Min: " + min);
                    System.out.println("Max: " + max);
                    System.out.println("Plus: " + plus);
                    break;
                }
            }

        } catch (WebClientResponseException e) {
            System.err.println("Error response: " + e.getStatusCode());
            System.err.println("Error body: " + e.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
*/
}
    }
