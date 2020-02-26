package com.tts.tts.MapsApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tts.tts.MapsApp.model.GeocodingResponse;
import com.tts.tts.MapsApp.model.Location;

@Service
public class MapService {
	
	@Value("${api_key}")
	private String apiKey;
	
	public void addCoordinates (Location location) {
		//URL from root geocoding to get info about city, state
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + 
			    location.getCity() + "," + location.getState() + "&key=" + apiKey;
		//Make API call to google maps and store that information as a response in 
		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());
	}

}
