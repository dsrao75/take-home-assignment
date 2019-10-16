package com.ms.assignment.mobilefoodfinder.service;

import java.util.List;

import com.ms.assignment.mobilefoodfinder.dto.FoodFacilityDTO;
import com.ms.assignment.mobilefoodfinder.dto.Location;

public interface MobileFoodFacilityLocatorService {
	List<FoodFacilityDTO> locateNearByFacilities(Location location, int nearByCount);
}