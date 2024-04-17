package excessOtherCodes;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class reusableCodes {

	WebDriver driver;
	
	public  reusableCodes(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void scrollBy500() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void threadSleep1000Seconds() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	public void threadSleep3000Seconds() throws InterruptedException {
		Thread.sleep(3000);
	}

	
	
	public void bottomToUpScroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 0);");
	}
	
	public void smoothScrollByElement(WebElement ScrollElement) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", ScrollElement);
	}
	
	
	
}
