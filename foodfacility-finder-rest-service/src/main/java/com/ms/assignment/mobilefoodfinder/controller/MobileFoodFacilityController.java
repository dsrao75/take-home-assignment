package com.ms.assignment.mobilefoodfinder.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.assignment.mobilefoodfinder.dto.FoodFacilityDTO;
import com.ms.assignment.mobilefoodfinder.dto.Location;
import com.ms.assignment.mobilefoodfinder.service.MobileFoodFacilityLocatorService;
import com.ms.assignment.mobilefoodfinder.service.MobileFoodFacilityLocatorServiceImpl;

@RestController
@RequestMapping("/foodfinder")
public class MobileFoodFacilityController {

    @Autowired
    MobileFoodFacilityLocatorService service;
    
    /*@GET
    @RequestMapping("/find")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response find(@RequestParam(value="latitude") String latitude,
    		@RequestParam(value="longitude") String longitude, @RequestParam(value="maxlocations") int maxlocations) {
    	
    	Location location = new Location("My Place", new Double(latitude), new Double(longitude));
    	List<FoodFacilityDTO> result = service.locateNearByFacilities(location, maxlocations);
    	
    	if(result != null && result.size() > 0) {
    		return Response.ok(result).build();
    	} else {
    		return Response.ok("No data found for given location").build();
    	}
    }*/
    
    @GET
    @RequestMapping("/find")
    //@Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<FoodFacilityDTO>> find(@RequestParam(value="latitude") String latitude,
    		@RequestParam(value="longitude") String longitude, @RequestParam(value="maxlocations") int maxlocations) {
    	
    	Location location = new Location("My Place", new Double(latitude), new Double(longitude));
    	List<FoodFacilityDTO> result = service.locateNearByFacilities(location, maxlocations);
    	
    	if(result != null && result.size() > 0) {
    		return new ResponseEntity<>(result, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    /*
    @GET
    @RequestMapping("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find() {
    	Location location = new Location("My Place", new Double("37.8077432884455"), new Double("-122.42414994487"));
    	return Response.ok(service.locateNearByFacilities(location, 5)).build();
    }
    */
    
    public static void main(String[] args) {
    	Location location = new Location("My Place", new Double("37.8077432884455"), new Double("-122.42414994487"));
    	MobileFoodFacilityLocatorService serviceImpl = new MobileFoodFacilityLocatorServiceImpl();
    	serviceImpl.locateNearByFacilities(location, 5);
    }
}


