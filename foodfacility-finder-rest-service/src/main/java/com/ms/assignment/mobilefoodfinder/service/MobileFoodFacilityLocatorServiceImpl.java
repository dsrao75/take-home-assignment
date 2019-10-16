package com.ms.assignment.mobilefoodfinder.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.stereotype.Service;

import com.ms.assignment.mobilefoodfinder.MobileFoodFacilityLoader;
import com.ms.assignment.mobilefoodfinder.dto.FoodFacilityDTO;
import com.ms.assignment.mobilefoodfinder.dto.Location;
import com.ms.assignment.mobilefoodfinder.dto.LocationUtils;

@Service
public class MobileFoodFacilityLocatorServiceImpl implements MobileFoodFacilityLocatorService {
	
	private MobileFoodFacilityLoader facilityLoader = MobileFoodFacilityLoader.getInstance();
	
	@Override
	public List<FoodFacilityDTO> locateNearByFacilities(Location inputLocation, int nearByCount) {
		List<FoodFacilityDTO> allFacilities = facilityLoader.get(false);
		
		// create map to store
        Map<BigDecimal, List<FoodFacilityDTO>> distancesMap = 
        		new TreeMap<BigDecimal, List<FoodFacilityDTO>>();
        
        for (FoodFacilityDTO facility : allFacilities) {
        	BigDecimal distance = LocationUtils.distance(inputLocation, facility.getLocation());
        	List<FoodFacilityDTO> facilityList = distancesMap.get(distance);
        	if(facilityList == null) {
        		facilityList = new ArrayList<FoodFacilityDTO>();
        		distancesMap.put(distance, facilityList);
        	}
        	facilityList.add((FoodFacilityDTO)SerializationUtils.clone(facility));
        }
        
        //get nearset facilities
        List<FoodFacilityDTO> outputList = new ArrayList<FoodFacilityDTO>();
        int outputCount = 0;
        for(Map.Entry<BigDecimal,List<FoodFacilityDTO>> entry : distancesMap.entrySet()) {
        	BigDecimal key = entry.getKey();
        	List<FoodFacilityDTO> values = entry.getValue();
        	
        	int subListSize = 0;
        	if(values.size()+outputCount > nearByCount) {
        		subListSize = nearByCount - outputCount;
        	} else {
        		subListSize = values.size();
        	} 
        	
        	for(FoodFacilityDTO facility : allFacilities) {
        		
        	}
        	outputList.addAll(values.subList(0, subListSize));
        	outputCount = outputCount+subListSize;
        	
        	System.out.println(outputCount+"."+key + " ===============> " + values+"\n\n");
        	if(outputCount == nearByCount) {
        		break;
        	}
        }
        
        System.out.println("outputList.size===>"+outputList.size());
        
        return outputList;
	}
}