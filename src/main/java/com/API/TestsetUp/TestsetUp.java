package com.API.TestsetUp;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.API.Utilities.ExcelRead;
import com.API.Utilities.ExtentReport;
import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;



public class TestsetUp {
	
	public static ConfigJSON configJSON;
	public static String path ="E:\\Softwares\\Reetu\\workspace\\RestAssuredFrameworkTest\\src\\main\\java\\com\\API\\TestData\\TestData.xlsx";
	@BeforeMethod
	public void setup() throws InvalidFormatException, IOException{
		configJSON  = ConfigFactory.create(ConfigJSON.class);
		//configJSON =(ConfigJSON) ConfigFactory.create(org.aeonbits.owner.Config.class);
		RestAssured.baseURI = configJSON.getBaseURL();
		RestAssured.basePath = configJSON.getBasePath();
		ExcelRead excelRead = new ExcelRead(path, "Sheet1");
		excelRead.getRowCount();
		excelRead.getColCount();
		ExtentReport extentReport = new ExtentReport();
		ExtentReport.extentTest.log(Status.INFO, "Test started");
	}
	
	@AfterMethod
	public void tearDown() throws IOException{
		ExcelRead.excel.close();
		ExtentReport.extentReports.flush();
	}

}
