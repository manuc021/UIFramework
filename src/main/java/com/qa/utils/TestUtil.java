package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICT_WAIT = 20;
	public static String TEST_DATA_SHEET = "C:\\Users\\Manu Chauhan\\eclipse-workspace\\UIAutomation\\src\\test\\resources\\EmployeeData.xlsx";

	static HSSFWorkbook book;
	static XSSFWorkbook workbook;
	static XSSFSheet sheets;

	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;

		try {
			file = new FileInputStream(TEST_DATA_SHEET);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sheets = workbook.getSheet("Employee");
		Object[][] data = new Object[sheets.getLastRowNum()][sheets.getRow(0).getLastCellNum()];

		for (int i = 0; i <sheets.getLastRowNum(); i++) {
			for (int j = 0; j < sheets.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheets.getRow(i).getCell(j).toString();
				System.out.println(data[i][j]);
			}

		}

		return data;

	}
}
