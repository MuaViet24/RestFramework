package com.API.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static XSSFWorkbook excel;
	public static XSSFSheet sheet;
	public  static int rowCount;
	public  static int colCount;

	public ExcelRead(String path, String SheetName) throws InvalidFormatException, IOException{
		excel = new XSSFWorkbook(new File(path));
		sheet = excel.getSheet(SheetName);
	}
	
	public int getRowCount(){
		rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public int getColCount(){
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}


}
