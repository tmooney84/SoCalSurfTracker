package com.surf.surftracker;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;
import java.time.Instant;

@SpringBootApplication
public class GetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetApiApplication.class, args);

		// Define the URL
		String surfLineUrl = "https://services.surfline.com/kbyg/spots/forecasts/surf?cacheEnabled=true&days=5&intervalHours=1&spotId=5842041f4e65fad6a770888a&units[waveHeight]=FT";
		String surfLineUrl_human = "https://services.surfline.com/kbyg/regions/forecasts/conditions?subregionId=58581a836630e24c4487900a&days=5";
		// Initialize the WebClient builder and build the WebClient
		WebClient.Builder builder = WebClient.builder();
		WebClient webClient = builder.build();

		try {
			// Fetch the data and block to get the result
			String response = webClient.get()
					.uri(surfLineUrl)
					.retrieve()
					.bodyToMono(String.class)
					.block();

			// Initialize ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(response);

			// Get the "data" node and the "surf" array
			JsonNode surfArray = rootNode.path("data").path("surf");

			// Target timestamp to filter
		//	long targetTimestamp = 1722452400L;

			long currentEpochSeconds = Instant.now().getEpochSecond();
			long lastHour = currentEpochSeconds/3600*3600;
			System.out.println("Current Epoch Time in Seconds: " + currentEpochSeconds);
			System.out.println("The Last Hour was: " + lastHour);

			// Iterate through the surf array to find the matching timestamp
			for (JsonNode node : surfArray) {
				long timestamp = node.path("timestamp").asLong();
				if (timestamp == lastHour) {
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
}
