package com.ms.assignment.mobilefoodfinder.dto;

import java.math.BigDecimal;

public class LocationUtils {
	/** 
	 * Distance in Miles between two locations
	*/
	public static BigDecimal distance(Location loc1, Location loc2) {
		double latInDouble = Math.toRadians(loc2.getLatitude() - loc1.getLatitude());
		double lonInDouble = Math.toRadians(loc2.getLongitude() - loc1.getLongitude());

		double sinLatitude = Math.sin(latInDouble / 2);
		double sinLongitude = Math.sin(lonInDouble / 2);

		double a = Math.pow(sinLatitude, 2) + Math.pow(sinLongitude, 2) * Math.cos(Math.toRadians(loc1.getLatitude()))
				* Math.cos(Math.toRadians(loc2.getLatitude()));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double radiusofEarth = 3958.75; // Miles. Change to 6371 for output in Kilometer
		double distance = radiusofEarth * c;
		return new BigDecimal(distance);  //Distance in miles
	}	
}