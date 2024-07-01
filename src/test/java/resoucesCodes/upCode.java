package resoucesCodes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class upCode {
	
	
	public WebDriver driver;
    public WebDriver  upBrowser() throws IOException {
    	
    	Properties prop = new Properties();
		FileInputStream fis = new FileInputStream( System.getProperty("user.dir")+"\\src\\main\\java\\excessOtherCodes\\GolbalData.properties");
		prop.load(fis);
		 String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
        prop.getProperty("browser");
    	
    	
    	if(browserName.contains("chrome")) {
    		driver = new ChromeDriver();
    	}else if(browserName.contains("firefox")){
    		driver = new FirefoxDriver();
    	}else if(browserName.contains("edge")){
    	    driver = new EdgeDriver();
    	}
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.manage().window().maximize();
    	return driver;
    	    
    }
    
    
    public String getScreenShot(String testCaseName,WebDriver Driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)Driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+ "//reports//"+testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//"+testCaseName + ".png";
	}
    @BeforeMethod
    public void upWebsite() throws IOException {
    	WebDriver driver=upBrowser();
        driver.get("http://localhost/opencart/");
    }
      @AfterMethod
      public void closeWeb() {
     	driver.close();
       }
      
      
//      @DataProvider(name = "loginDetails")
//      public Object[][] getData() throws IOException {
//          DataFormatter formatter = new DataFormatter();
//          FileInputStream fis = null;
//          XSSFWorkbook wb = null;
//
//          try {
//              fis = new FileInputStream("D:\\EXCEL FOLDERS\\Login_Credentials.xlsx");
//              wb = new XSSFWorkbook(fis);
//              XSSFSheet sheet = wb.getSheetAt(0);
//              int rowsCount = sheet.getPhysicalNumberOfRows();
//              // Initialize the data array. Skip the header row.
//              Object[][] data = new Object[rowsCount - 1][2]; 
//
//              for (int i = 0; i < rowsCount - 1; i++) {
//                  XSSFRow row = sheet.getRow(i + 1); // Skip the header row
//                  XSSFCell emailCell = row.getCell(1); // Get the email from the second column
//                  XSSFCell passwordCell = row.getCell(2); // Get the password from the third column
//                  
//                  data[i][0] = formatter.formatCellValue(emailCell);
//                  data[i][1] = formatter.formatCellValue(passwordCell);
//              }
//
//              return data;
//
//          } finally {
//              if (wb != null) {
//                  wb.close();
//              }
//              if (fis != null) {
//                  fis.close();
//              }
//          }
//      }
      
      
      
      @DataProvider(name = "loginDetails")
      public Object[][] getData() throws IOException {
          DataFormatter formatter = new DataFormatter();
          FileInputStream fis = null;
          XSSFWorkbook wb = null;

          try {
              fis = new FileInputStream("D:\\EXCEL FOLDERS\\Login_Credentials.xlsx");
              wb = new XSSFWorkbook(fis);
              XSSFSheet sheet = wb.getSheetAt(0);
              int rowsCount = sheet.getPhysicalNumberOfRows();

              Object[][] data = new Object[rowsCount - 1][10]; // 3 columns: email, password, products

              for (int i = 0; i < rowsCount - 1; i++) {
                  XSSFRow row = sheet.getRow(i + 1); // Skip the header row
                  XSSFCell emailCell = row.getCell(1); // Get the email from the second column
                  XSSFCell passwordCell = row.getCell(2); // Get the password from the third column
                  XSSFCell productCell = row.getCell(3); // Get the product names from the fourth column
                  XSSFCell customerFirstNameCell = row.getCell(4);
                  XSSFCell customerLastNameCell = row.getCell(5);
                  XSSFCell StreetCell = row.getCell(6);
                  XSSFCell DistrictCell = row.getCell(7);
                  XSSFCell MobileNumberCell = row.getCell(8);
                  XSSFCell CountryCell = row.getCell(9);
                  XSSFCell StateCell = row.getCell(10);

                  data[i][0] = formatter.formatCellValue(emailCell);
                  data[i][1] = formatter.formatCellValue(passwordCell);

                  // Combine product names into a single comma-separated string
                  String[] products = formatter.formatCellValue(productCell).split(",");
                  data[i][2] = String.join(",", products).trim();
                  data[i][3] = formatter.formatCellValue(customerFirstNameCell);
                  data[i][4] = formatter.formatCellValue(customerLastNameCell);
                  data[i][5] = formatter.formatCellValue(StreetCell);
                  data[i][6] = formatter.formatCellValue(DistrictCell);
                  data[i][7] = formatter.formatCellValue(MobileNumberCell);
                  data[i][8] = formatter.formatCellValue(CountryCell);
                  data[i][9] = formatter.formatCellValue(StateCell);
                  
                  
              }

              return data;

          } finally {
              if (wb != null) {
                  wb.close();
              }
              if (fis != null) {
                  fis.close();
              }
          }
      }
}
