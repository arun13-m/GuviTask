package excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//open the workBook
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\arunp\\eclipse-workspace\\guvi\\src\\main\\java\\excel\\Sheet1.xlsx");

		//open the sheet
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		//get row & column
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		//printing the data
		for(int i=1;i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0;j<columnCount;j++) {
				XSSFCell column = row.getCell(j);
				System.out.println(column.getStringCellValue());
			}
			System.out.println("");
		}
		book.close();
	}
}