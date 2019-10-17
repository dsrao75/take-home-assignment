# Take Home Assignment

FoodFacility Finder API provides a list of facilities near by the given coordinates (longitude, latitude). Users can provide the maximm number of near by facilities they want to see.

# SetUp

1.1 Prerequisites
This API is implemnted as RESTful Web Service using SpringBoot. In order to run locally the following software/tools are needed 

* Java 7
* Maven for compiling and packaging
* IE, Chrome, FireFox, SAPUI, or Postman (Chrome plugin) to test API

1.2 Source Code
	- Clone the repository https://github.com/dsrao75/take-home-assignment.git
	
1.3 Build and deployment
	a. After cloning the repo in the desired directory, go to the director where the code is cloned
	   e.g; cd <Desired directory>\take-home-assignment\foodfacility-finder-rest-service
	 
	b. Run the following command from the prompt: mvn clean install
	   In this step the build procee generates foodfacility-finder-rest-service-0.1.0.jar in the target folder  
	   e.g; <Desired directory>\take-home-assignment\foodfacility-finder-rest-service\target
	  
	c. To run the pplication, go the target directory (<Desired directory>\take-home-assignment\foodfacility-finder-rest-service\target) and perform   the following steps
		* Copy <Desired directory>\take-home-assignment\foodfacility-finder-rest-service\Mobile_Food_Facility_Permit.xlsx to this target directory.
		* Run the following command: java -jar foodfacility-finder-rest-service-0.1.0.jar

# Testing the service

	* Open a broser and enter the following URL
	 
	  http://localhost:8080/foodfinder/find?latitude=37.79757899&longitude=-122.4114399&maxlocations=2
	
	  This will display the JSON response as below. We can change the latitude, longitude, and maximm number of locations in the URL and get the results accordingly.

	[{
        "locationId": "934513",
        "applicant": "Mike's Catering",
        "facilityType": "Truck",
        "cnn": "3157000",
        "locationDescription": "BROADWAY: POWELL ST \\ ROBERT C LEVY TUNL to MASON ST (800 - 898) -- NORTH --",
        "address": "860 BROADWAY",
        "blocklot": "148009",
        "block": "148",
        "lot": "9",
        "permit": "17MFF-0092",
        "status": "APPROVED",
        "foodItems": "Cold Truck: packaged sandwiches: snacks: candy: hot and cold drinks",
        "x": "6009425.916",
        "y": "2118518.297",
        "latitude": "37.79757899",
        "longitude": "-122.4114399",
        "schedule": "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=17MFF-0092&ExportPDF=1&Filename=17MFF-0092_schedule.pdf",
        "dayshours": "Mo/Tu/We/Th/Fr:7AM-8AM;Mo/Mo/Tu/Tu/We:9AM-11AM;Su:9AM-2PM;Sa:9AM-3PM;Mo/Mo/Tu/Tu/We:11AM-1PM;Mo-Fr:",
        "noiSent": "",
        "approved": "3/10/17 0:00",
        "received": "2/13/17",
        "priorPermit": "1",
        "expirationDate": "7/15/18 0:00",
        "distance": 0
    },
    {
        "locationId": "1185382",
        "applicant": "Philz Coffee Truck",
        "facilityType": "Truck",
        "cnn": "9306000",
        "locationDescription": "MONTGOMERY ST: COLUMBUS AVE \\ WASHINGTON ST to JACKSON ST (700 - 799)",
        "address": "735 MONTGOMERY ST",
        "blocklot": "195001",
        "block": "195",
        "lot": "1",
        "permit": "18MFF-0061",
        "status": "APPROVED",
        "foodItems": "Hot coffee: iced coffee: hot chocolate: tea: pastries",
        "x": "6011635.905",
        "y": "2117976.662",
        "latitude": "37.7962155",
        "longitude": "-122.4037546",
        "schedule": "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=18MFF-0061&ExportPDF=1&Filename=18MFF-0061_schedule.pdf",
        "dayshours": "Mo-We:6AM-6PM",
        "noiSent": "",
        "approved": "7/12/18 0:00",
        "received": "7/12/18",
        "priorPermit": "0",
        "expirationDate": "7/15/19 0:00",
        "distance": 0.43003751295214576177983190063969232141971588134765625
    }].