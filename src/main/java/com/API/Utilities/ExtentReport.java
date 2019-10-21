package com.API.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public static ExtentReports extentReports;
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentTest extentTest;
	
	public ExtentReport(){
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter(".\\Reports\\extent.html");
		extentReports.attachReporter(extentHtmlReporter);
		extentTest = extentReports.createTest("Extent Test");
		
	}

}
