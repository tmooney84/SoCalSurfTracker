package com.surf.surftracker;

import com.surf.surftracker.model.Current;
import com.surf.surftracker.util.SurfSpotURLs;
import com.surf.surftracker.util.SurfSpotURLListNEW;
import com.surf.surftracker.factory.CurrentFactory;

import java.util.HashMap;
import java.util.Map;

//@SpringBootApplication(scanBasePackages = "com.surf.surftracker")
public class SurftrackerApplicationNEW {

	public static void main(String[] args) throws Exception {
   // SpringApplication.run(SurftrackerApplicationNEW.class, args);

	Map<String,Current> currentMap = SurftrackerApplicationNEW.getCurrent();

		currentMap.forEach((key, value) -> {
			System.out.println("Key: " + key + ", Value: " + value);
		    System.out.println();
		});
	}
	//@Bean
	public static Map<String, Current> getCurrent() throws Exception {


		//in runner class:
		//access the surf spot records from the utility class
		SurfSpotURLs[] surfSpots = SurfSpotURLListNEW.getSurfSpots();

		//create a hashmap to store Current objects
		Map<String, Current> currentMap = new HashMap<>();

		//create Current objects from records and add to map
		int spotId = 0;
		for (SurfSpotURLs spot : surfSpots) {
			Current current = CurrentFactory.createCurrent(spot);
			spotId++;
			//set SurfSpotId here because it requires the for loop iteration; i+1 so the IDs start at 1
			current.setSurfSpotId(spotId);
			currentMap.put(current.getSurfSpotName(), current);
			System.out.println(current.getSurfSpotName() + ": " + current);
		}
		return currentMap;
	}
}