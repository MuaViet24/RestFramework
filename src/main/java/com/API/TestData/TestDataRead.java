package com.API.TestData;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.API.Utilities.ExcelRead;

public class TestDataRead {
		
	@DataProvider(name="dataCust")
	public static Object[][] readData() throws InvalidFormatException, IOException{
		
		Object[][] obj = new Object[ExcelRead.rowCount-1][1];
		Hashtable<String, String> tab ;
		
		for (int i=1;i<ExcelRead.rowCount;i++){
			tab = new Hashtable<String, String>();
			for(int j=0;j<ExcelRead.colCount;j++){
				tab.put(ExcelRead.sheet.getRow(0).getCell(j).toString(), ExcelRead.sheet.getRow(i).getCell(j).toString());
				obj[i-1][0] = tab;
			}
		}
		return obj;
	}
}
