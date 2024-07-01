package OpenCart.main;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileReader;



import OpenCart.spillitedCodes.SpilitedLoginCodesOrRegisterCodes;

import resoucesCodes.upCode;


public class loginFlow2_DataDriver_Excel extends upCode {
    
	@Test(dataProvider="loginDetails")
    public void loginTest(String email,String password) throws InterruptedException {
    
        SpilitedLoginCodesOrRegisterCodes loginPage = new SpilitedLoginCodesOrRegisterCodes(driver);

       
                    loginPage.loginOrRegisteDropDown();
                    loginPage.LoginButton();
                    loginPage.loginCredential(email, password); 
                    loginPage.loginSubmitButton();
                    Thread.sleep(1000); 
                    
              
}
	
	
	
//	@DataProvider(name = "loginDetails")
//    public Object[][] getData() throws IOException {
//        DataFormatter formatter = new DataFormatter();
//        FileInputStream fis = null;
//        XSSFWorkbook wb = null;
//
//        try {
//            fis = new FileInputStream("D:\\EXCEL FOLDERS\\Login_Credentials.xlsx");
//            wb = new XSSFWorkbook(fis);
//            XSSFSheet sheet = wb.getSheetAt(0);
//            int rowsCount = sheet.getPhysicalNumberOfRows();
//            // Initialize the data array. Skip the header row.
//            Object[][] data = new Object[rowsCount - 1][2]; 
//
//            for (int i = 0; i < rowsCount - 1; i++) {
//                XSSFRow row = sheet.getRow(i + 1); // Skip the header row
//                XSSFCell emailCell = row.getCell(1); // Get the email from the second column
//                XSSFCell passwordCell = row.getCell(2); // Get the password from the third column
//                
//                data[i][0] = formatter.formatCellValue(emailCell);
//                data[i][1] = formatter.formatCellValue(passwordCell);
//            }
//
//            return data;
//
//        } finally {
//            if (wb != null) {
//                wb.close();
//            }
//            if (fis != null) {
//                fis.close();
//            }
//        }
//    }
	
	
	
	
	
	
//	public ArrayList<String> getData(String testcaseName) throws IOException {
//		
//		//Identify TestCases coloumn by scanning the entire 1st Row
//				//Once Coloumn is identified then scan entire testcase coloum to identify purchase testcase
//				// after you grab purchase testcase row = pull all the data of that row and feed into test
//		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\OneDrive\\Documents\\Credentials.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		ArrayList<String> a = new ArrayList<String>();
//		int sheets=workbook.getNumberOfSheets();
//		for(int i=0;i<sheets;i++) {
//			if(workbook.getSheetName(i).equalsIgnoreCase("Credentials")) {
//				XSSFSheet sheet=workbook.getSheetAt(i);//sheet is collection of rows
//				//Identify TestCases coloumn by scanning the entire 1st Row
//				
//				Iterator<Row> rows=sheet.iterator();//row is collection of cells
//				Row firstRow=rows.next();
//				Iterator<Cell>cell=firstRow.cellIterator();
//				
//				int k=0;
//				int coloumn = 0;
//				while(cell.hasNext()) {
//					Cell value=cell.next();
//					
//					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
//						
//						coloumn=k;
//						
//					}
//					
//					k++;
//				}
//				
//				System.out.println(coloumn);
//				
//				while(rows.hasNext()) {
//					
//					Row r=rows.next();
//					
//					if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
//						Iterator<Cell>cel=r.cellIterator();
//						while(cel.hasNext()) {
//							
//							 Cell c = cel.next();
//							 if(c.getCellType()==CellType.STRING) {
//							a.add(c.getStringCellValue());
//							 }else {
//								 a.add(NumberToTextConverter.toText( c.getNumericCellValue()));
//							 }
//						}
//					}
//				}
//				
//			}
//		}
//		return a;
//		
//	}
	
	
	
//	public static void main(String[] args) throws IOException{
//		loginFlow2_DataDriver_Excel ex= new loginFlow2_DataDriver_Excel();
//		ArrayList d=ex.getData("Delete Profile");
//		System.out.println(d.get(0));
//		System.out.println(d.get(1));
//		System.out.println(d.get(2));
//	}
    
    
	
	
	
}




