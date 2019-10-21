package com.Test.API;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.API.TestData.TestDataRead;
import com.API.TestsetUp.TestsetUp;
import com.API.Utilities.ExtentReport;
import com.aventstack.extentreports.Status;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomerAPI extends TestsetUp{
	
	@Test(dataProvider="dataCust",dataProviderClass=TestDataRead.class)
	public void CreateCustomerWithValidKey(Hashtable<String, String> data){
		Response response =given().auth().basic(configJSON.getValidSecretKey(), "")
		//.formParam("email", "t@t.com")
		.formParam("email" , data.get("Email"))
		.formParam("description" , data.get("Description"))
		.post(configJSON.getCustomerEndPoint());
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		try{
			Assert.assertEquals(Integer.toString(statusCode), data.get("StatusCode"));
			ExtentReport.extentTest.log(Status.PASS, "Customer created Succesfully");
		}catch(AssertionError e){
			ExtentReport.extentTest.log(Status.FAIL, "Customer Not created");
		}
		
	}
	
	@Test
	public void CreateCustomerWithInValidKey(){
		
	}
	
	@Test
	public void CreateCustomerValidateIDKey(){
		
	}
	
	@Test
	public void CreateCustomerValidateIDValue(){
		
	}

}
