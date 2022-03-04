package Testcases;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public Exceldata(String excelfile) 
	{
		try {
			File src = new File(excelfile);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} 
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
		public String getdata(int sheetnum, int row, int col)
		{
			sheet = wb.getSheetAt(sheetnum);
			String data = sheet.getRow(row).getCell(col).getStringCellValue();
			
			return data;
			
		}
		
		public int getrowcount(int indexnum)
		{
			int row = wb.getSheetAt(indexnum).getLastRowNum();
			row = row+1;
			
			return row;
		}
	
}
