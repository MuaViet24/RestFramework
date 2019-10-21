package com.API.TestData;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataRead {
	
	@Test(dataProvider="data")
	public void dataRead(Hashtable<String, String> hashTable){
	//public void dataRead(String a, String b){
		System.out.println(hashTable.get("Email"));
		System.out.println(hashTable.get("Description"));
		System.out.println(hashTable.get("StatusCode"));
		
	}
	
	@DataProvider(name="data")
	public Object[][] readData() throws InvalidFormatException, IOException{
		
		XSSFWorkbook excel = new XSSFWorkbook(new File("E:\\Softwares\\Reetu\\workspace\\RestAssuredFrameworkTest\\src\\main\\java\\com\\API\\TestData\\TestData.xlsx"));
		XSSFSheet sheet = excel.getSheet("Sheet1");
		int rowCount =sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Total number of rows:"+rowCount);
		System.out.println("Total number of cols:"+colCount);
		Hashtable<String, String> hashTable ;
		
		Object[][] obj = new Object[rowCount-1][1];
		for(int i=1;i<rowCount;i++){
			
			hashTable = new Hashtable<String, String>();
			for(int j=0;j<colCount;j++){
				
				hashTable.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i).getCell(j).toString());
				obj[i-1][0] = hashTable;
				
			}
		}
		return obj ;
	}

}
