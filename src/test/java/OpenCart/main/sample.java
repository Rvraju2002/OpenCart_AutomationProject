package OpenCart.main;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sample {

	DataFormatter formatter = new DataFormatter();
	@Test(dataProvider="driverTest")
	public void dataAssemble(String text,String greetings,String id) {
		
		System.out.println(text+greetings+id);
	}
	
	
	@DataProvider(name="driverTest")
	public  Object[][] getData() throws IOException {
		
//		Object[][] data = {{"Bye","Enjoy","1"},{"Hello","gOOD","2"},{"wHY","Not","3"}};
		
		FileInputStream fis = new FileInputStream("D:\\EXCEL FOLDERS\\Example_TestCases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowscount=sheet.getPhysicalNumberOfRows();
	    XSSFRow row=sheet.getRow(0);
	    int colcount=row.getLastCellNum();
	    
	    Object data[][] = new Object[rowscount-1][colcount];
	    for(int i=0;i<rowscount-1;i++) {
	    	row=sheet.getRow(i+1);
	    	for(int j=0;j<colcount;j++) {
	    		XSSFCell ce=row.getCell(j);
	    		
	    		data[i][j]=formatter.formatCellValue(ce);
	    	}
	    }
		
		
	return data;
	}
}
