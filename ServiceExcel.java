package week5day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceExcel {

	public static String[][] sendData(String fileName) throws IOException {
	XSSFWorkbook wb=new XSSFWorkbook("./Excel/"+fileName+".xlsx");
	XSSFSheet ws = wb.getSheet("Sheet1");
	
	int lastRowNum = ws.getLastRowNum();
	System.out.println("No of rows" +lastRowNum);
	
	int lastCellNum = ws.getRow(0).getLastCellNum();
	System.out.println("No of columns" +lastCellNum);
	String[][]data=new String[lastRowNum][lastCellNum];
	for(int i=1;i<=lastRowNum;i++) {
		for(int j=0;j<lastCellNum;j++) {
			String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
			System.out.println(stringCellValue);
			data[i-1][j]=stringCellValue;
		}
	}
	
	wb.close();
	return data;
	}
	

}
