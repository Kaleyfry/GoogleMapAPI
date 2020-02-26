package com.tts.tts.MapsApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tts.tts.MapsApp.model.Location;
import com.tts.tts.MapsApp.service.MapService;

@Controller
public class MapController {
	
	@Autowired
	private MapService mapService;
	
	@GetMapping("/home")
    public String getDefaultMap() {
		Location location = new Location();
		location.setCity("Dallas");
		location.setState("Texas");
		mapService.addCoordinates(location);
		System.out.println(location);
		return "index.html";
        
	}
	

}
