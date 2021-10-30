package com.vtiger.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String FilePath;
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelReader(String FilePath) {
		this.FilePath = FilePath;
		try {
			fis = new FileInputStream(FilePath);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getrowcount(String SheetName) {

		sheet = workbook.getSheet(SheetName);
		int rowcount = sheet.getLastRowNum();
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount;
	}

	public int getcellcount(String SheetName) {
		sheet = workbook.getSheet(SheetName);
		row = sheet.getRow(1);
		int cellcount = row.getLastCellNum();
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cellcount;
	}

	public String getcelldata(int rownum, int colnum, String SheetName) {
		sheet = workbook.getSheet(SheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static void main(String[] args){
		ExcelReader r = new ExcelReader("E:\\eclipse workspace\\krish workspace\\vtigerTesting\\Excel_File\\Book1.xlsx");
		System.out.println(r.getcellcount("Sheet1"));
		System.out.println(r.getrowcount("Sheet1"));
		System.out.println(r.getcelldata(1, 1, "Sheet1"));
	}

}
