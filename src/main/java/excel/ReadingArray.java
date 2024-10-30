package excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//open the Workbook
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\arunp\\eclipse-workspace\\guvi\\src\\main\\java\\excel\\Sheet1.xlsx");
		
		//open the sheet
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		//rowCount & columnCount
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		//Array
		String[][] data = new String[rowCount][columnCount];		
		for(int i=1;i<=rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0;j<columnCount;j++) {
				XSSFCell col =  row.getCell(j);
				
				data[i-1][j] = col.getStringCellValue();
			}
			
		}

		for(String[] r : data) {
			
			for(String c : r) {
				System.out.println(c);
			}
		}
	}

}
