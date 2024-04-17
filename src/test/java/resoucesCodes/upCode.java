package resoucesCodes;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class upCode {
	
	
	public WebDriver driver;
    public WebDriver  upBrowser() {
    	
    	String browserName="chrome";
    	
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
    public void upWebsite() {
    	WebDriver driver=upBrowser();
        driver.get("http://localhost/opencart/");
    }
      @AfterMethod
      public void closeWeb() {
     	driver.quit();
       }
}
