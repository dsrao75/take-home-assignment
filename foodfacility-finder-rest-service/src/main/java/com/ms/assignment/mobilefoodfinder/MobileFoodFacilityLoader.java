package com.ms.assignment.mobilefoodfinder;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ms.assignment.mobilefoodfinder.dto.FoodFacilityDTO;
import com.ms.assignment.mobilefoodfinder.dto.Location;

//@Component
public class MobileFoodFacilityLoader {
	private static List<FoodFacilityDTO> facilityCache = 
			new ArrayList<FoodFacilityDTO>();
	private static MobileFoodFacilityLoader instance = new MobileFoodFacilityLoader();
	
	public static final String RESOURCE_PATH = 
			"Mobile_Food_Facility_Permit.xlsx";
	
	private MobileFoodFacilityLoader() {
	}
	
	public static MobileFoodFacilityLoader getInstance() {
		load();
		return instance;
	}
	
	private static void load() {
		Workbook workbook = null;
		try {
	        workbook = WorkbookFactory.create(new File(RESOURCE_PATH));
	        
	        // get the first sheet
	        Sheet sheet = workbook.getSheetAt(0);	
	        DataFormatter dataFormatter = new DataFormatter();

	        // Load the excel data into cache
	        Iterator<Row> rowIterator = sheet.rowIterator();
	        int facilityNum = 0;
	        //Ignore first row as it's a heading
	        if(rowIterator.hasNext()) rowIterator.next();
	        
	        while (rowIterator.hasNext()) {
	        	FoodFacilityDTO dto = new FoodFacilityDTO();
	        	
	            Row row = rowIterator.next();
	            dto.setLocationId(dataFormatter.formatCellValue(row.getCell(0)));
	            dto.setApplicant(dataFormatter.formatCellValue(row.getCell(01)));
	            dto.setFacilityType(dataFormatter.formatCellValue(row.getCell(2)));
	            dto.setCnn(dataFormatter.formatCellValue(row.getCell(3)));
	            dto.setLocationDescription(dataFormatter.formatCellValue(row.getCell(4)));
	            dto.setAddress(dataFormatter.formatCellValue(row.getCell(5)));
	            dto.setBlocklot(dataFormatter.formatCellValue(row.getCell(6)));
	            dto.setBlock(dataFormatter.formatCellValue(row.getCell(7)));
	            dto.setLot(dataFormatter.formatCellValue(row.getCell(8)));
	            dto.setPermit(dataFormatter.formatCellValue(row.getCell(9)));
	            dto.setStatus(dataFormatter.formatCellValue(row.getCell(10)));
	            dto.setFoodItems(dataFormatter.formatCellValue(row.getCell(11)));
	            
	            dto.setX(dataFormatter.formatCellValue(row.getCell(12)));
	            dto.setY(dataFormatter.formatCellValue(row.getCell(13)));
	            dto.setLatitude(dataFormatter.formatCellValue(row.getCell(14)));
	            dto.setLongitude(dataFormatter.formatCellValue(row.getCell(15)));
	            dto.setSchedule(dataFormatter.formatCellValue(row.getCell(16)));
	            dto.setDayshours(dataFormatter.formatCellValue(row.getCell(17)));
	            dto.setNoiSent(dataFormatter.formatCellValue(row.getCell(18)));
	            dto.setApproved(dataFormatter.formatCellValue(row.getCell(19)));
	            dto.setReceived(dataFormatter.formatCellValue(row.getCell(20)));
	            dto.setPriorPermit(dataFormatter.formatCellValue(row.getCell(21)));
	            dto.setExpirationDate(dataFormatter.formatCellValue(row.getCell(22)));
	            
	            Location location = new Location(dto.getLocationId(), 
	            		new Double(dto.getLatitude()), new Double(dto.getLongitude()));
	            
	            dto.setLocation(location);
	            facilityCache.add(dto);
	            facilityNum++;
	            //System.out.println(facilityNum+":"+dto.toString());
	        }
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// Closing the workbook
			try {
				if(workbook != null) workbook.close();
			} catch(Exception ex) {
				
			}
		}
	}
	
	public synchronized List<FoodFacilityDTO> get(boolean refresh) {
		if(refresh) { load(); };
		
		return facilityCache;
	}
			
	public static void main(String[] args) {
		List<FoodFacilityDTO> facilities = MobileFoodFacilityLoader.getInstance().get(true);
		
	}
}

