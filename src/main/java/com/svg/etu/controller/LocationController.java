package com.svg.etu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.svg.etu.location.LocationService;
import com.svg.etu.location.LocationVO;

@RestController
@RequestMapping("/location")
public class LocationController {
	@Autowired
	LocationService locationService;
	
	@RequestMapping(method=RequestMethod.GET)
	public LocationVO getLocation(LocationVO vo) {
		return locationService.getLocation(vo);
	}
}
