package com.ms.assignment.mobilefoodfinder.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FoodFacilityDTO implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private String locationId;
	private String applicant;	
	private String facilityType;	
	private String cnn;	
	private String locationDescription;	
	private String address;	
	private String blocklot;	
	private String block;	
	private String lot;	
	private String permit;	
	private String status;	
	private String foodItems;	
	private String x;	
	private String y;	
	@JsonIgnore
	private Location location;
	private String latitude;	
	private String longitude;	
	private String schedule;	
	private String dayshours;	
	private String noiSent;	
	private String approved;	
	private String received;	
	private String priorPermit;	
	private String expirationDate;
	
	private BigDecimal distance;

	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationid) {
		this.locationId = locationid;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getCnn() {
		return cnn;
	}
	public void setCnn(String cnn) {
		this.cnn = cnn;
	}
	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlocklot() {
		return blocklot;
	}
	public void setBlocklot(String blocklot) {
		this.blocklot = blocklot;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getDayshours() {
		return dayshours;
	}
	public void setDayshours(String dayshours) {
		this.dayshours = dayshours;
	}
	public String getNoiSent() {
		return noiSent;
	}
	public void setNoiSent(String noiSent) {
		this.noiSent = noiSent;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public String getReceived() {
		return received;
	}
	public void setReceived(String received) {
		this.received = received;
	}
	public String getPriorPermit() {
		return priorPermit;
	}
	public void setPriorPermit(String priorPermit) {
		this.priorPermit = priorPermit;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "FoodFacilityDTO [locationId=" + locationId + ", applicant=" + applicant + ", facilityType="
				+ facilityType + ", cnn=" + cnn + ", locationDescription=" + locationDescription + ", address="
				+ address + ", blocklot=" + blocklot + ", block=" + block + ", lot=" + lot + ", permit=" + permit
				+ ", status=" + status + ", foodItems=" + foodItems + ", x=" + x + ", y=" + y + ", location=" + location
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", schedule=" + schedule + ", dayshours="
				+ dayshours + ", noiSent=" + noiSent + ", approved=" + approved + ", received=" + received
				+ ", priorPermit=" + priorPermit + ", expirationDate=" + expirationDate + "]";
	}
}
