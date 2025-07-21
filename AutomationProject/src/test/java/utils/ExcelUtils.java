package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] readExcelData(String filePath,String sheetName)throws IOException{
		FileInputStream file=new FileInputStream(filePath);
		Workbook workBook=new XSSFWorkbook(file);
		Sheet sheet=workBook.getSheet(sheetName);
		int rowCount= sheet.getPhysicalNumberOfRows();
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<colCount;j++) {
				Cell cell=row.getCell(j);
				if(cell==null) {
					data[i-1][j]="";
				}
				else {
					data[i-1][j]=cell.toString();
				}
			}
		}
		workBook.close();
		file.close();
		return data;
	}
	
}
