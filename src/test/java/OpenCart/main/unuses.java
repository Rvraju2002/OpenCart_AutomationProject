package OpenCart.main;



import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resoucesCodes.upCode;
import java.util.ArrayList;
public class unuses  extends upCode{

	


	
		
		@Test
		public void fullTest() throws InterruptedException {
			
			    registerationFlow register = new registerationFlow();
		        register.registerAnAcccount();
		        
		        // Click on the appropriate links to navigate to the desired page
		        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]")).click();
		        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div/a")).click();
		        
		        String[] productName = { "MacBook Air", "iPhone","HTC Touch HD","iPod Classic" };
		        List<String> productList = new ArrayList<>(Arrays.asList(productName));
		        
//		        boolean allProductsAdded = false;

//		        while (!allProductsAdded) {
		            List<WebElement> productsElements = driver.findElements(By.cssSelector("div[class=\"content\"] h4"));

		            boolean anyProductAdded = false;
		            for (int i = 0; i < productsElements.size(); i++) {
		                String extractedProductName = productsElements.get(i).getText();
		                if (productList.contains(extractedProductName)) {
		                    // If product found, click on it
		                    JavascriptExecutor js = (JavascriptExecutor) driver;
		                    js.executeScript("arguments[0].scrollIntoView(true);", productsElements.get(i));
		                    Thread.sleep(1000); // Add a small delay to allow the page to adjust
		                    // Click on the button associated with the product
		                    driver.findElements(By.xpath("//div[@class=\"button-group\"]/button[1]"))
		                          .get(i).click();
		                    productList.remove(extractedProductName); // Remove the product from the list
		                    anyProductAdded = true;
		                }
		            }

//		            if (!anyProductAdded && !isPageEnd(driver)) {
//		                JavascriptExecutor js = (JavascriptExecutor) driver;
//		                js.executeScript("window.scrollBy(0, 800);");
//		                Thread.sleep(1000); // Add a small delay to allow the page to load
//		            } else if (!anyProductAdded && isPageEnd(driver)) {
//		                allProductsAdded = true;
//		            }
		        
		    }

		    // Function to check if the page has reached the end
//		    private boolean isPageEnd(WebDriver driver) {
//		        JavascriptExecutor js = (JavascriptExecutor) driver;
//		        boolean isEnd = (boolean) js.executeScript(
//		                "return (window.innerHeight + window.scrollY) >= document.body.scrollHeight;");
//		        return isEnd;
//		    }
		
}