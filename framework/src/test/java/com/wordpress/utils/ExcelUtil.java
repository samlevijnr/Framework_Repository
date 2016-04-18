package com.wordpress.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.dev.XSSFSave;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil
{
		String filename;
		int sheetNo;
		XSSFWorkbook workBook;
		XSSFSheet sheet;
		
		
		
		public ExcelUtil(String filename,int sheetNo)
		{
			this.filename = filename;
			this.sheetNo = sheetNo;
			load();
		}
		
		public void load()
		{
			File file = new File(filename);
			try {
				workBook = new XSSFWorkbook(file);
				sheet = workBook.getSheetAt(sheetNo);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		public String getValue(int rowNo,int colNo)
		{
			String value ="";
			try{
			XSSFRow row = sheet.getRow(rowNo);
			XSSFCell cell = row.getCell(colNo);
			 value = cell.toString();
			}
			catch(Exception e)
			{
				value ="";
			}
			return value;
			
		}
		
		
		public int getNumberOfRows()
		{
			return sheet.getLastRowNum();
		}
		
}
