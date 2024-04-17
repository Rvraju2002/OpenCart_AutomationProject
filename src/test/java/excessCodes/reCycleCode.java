package excessCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import OpenCart.main.registerationFlow;
import resoucesCodes.upCode;

public class reCycleCode extends upCode {

	public void fullTest() throws InterruptedException {

		registerationFlow register = new registerationFlow();
	register.registerAnAcccount();
		
//		loginFlow login = new loginFlow();
//		login.loginTest(driver);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]")).click();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div/a")).click();

		String[] productName = { "iPhone", "HTC Touch HD", "iPod Classic", "MacBook Air" };
		List<String> productList = new ArrayList<>(Arrays.asList(productName));
		System.out.println(productList);
		List<WebElement> productsElements = driver.findElements(By.cssSelector("div[class=\"content\"] h4"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < productsElements.size(); i++) {
			String extractedProductName = productsElements.get(i).getText();
			if (productList.contains(extractedProductName)) {

				js.executeScript("arguments[0].scrollIntoView(true);", productsElements.get(i));
				Thread.sleep(1000);
				driver.findElements(By.xpath("//div[@class=\"button-group\"]/button[1]")).get(i).click();

			}
		}
		js.executeScript("window.scrollTo(0, 0);");
		//
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[id$='header-cart'] div")).click();
		driver.findElement(By.xpath("//p[@class='text-end']/a[1]")).click();

		List<WebElement> listofAddedProductElements = driver
				.findElements(By.cssSelector("td[class$='text-start text-wrap'] a"));
		for (int i = 0; i < listofAddedProductElements.size(); i++) {
			String viewCardPageProductList = listofAddedProductElements.get(i).getText();
			String[] products = viewCardPageProductList.split(", ");

			boolean found = false;

			// Check if any product name exists in the array using Arrays.asList() and
			// contains()
			for (String product : products) {
				if (productList.contains(product)) {
					found = true;
					break;
				} else {
					System.out.println("Not Same");
				}
			}

		}
		WebElement element = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));

		
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", element);
		Thread.sleep(1000);
		element.click();
		Thread.sleep(1000);
		if(driver.findElement(By.id("input-shipping-address")).isDisplayed()) {
			WebElement Address=driver.findElement(By.id("input-shipping-address"));
			Select s = new Select(Address);
			s.selectByIndex(1);
			
		}else {
		driver.findElement(By.id("input-shipping-firstname")).sendKeys("Vignesh");
		driver.findElement(By.id("input-shipping-lastname")).sendKeys("raju");
		driver.findElement(By.id("input-shipping-address-1")).sendKeys("raju");
		driver.findElement(By.id("input-shipping-city")).sendKeys("raju");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		driver.findElement(By.id("input-shipping-postcode")).sendKeys("raju");
		WebElement country=driver.findElement(By.id("input-shipping-country"));
		
		Select countryChoosen = new Select(country);
		countryChoosen.selectByVisibleText("India");
		WebElement state=driver.findElement(By.id("input-shipping-zone"));
		Thread.sleep(1000);
		Select stateChoosen = new Select(state);
		stateChoosen.selectByVisibleText("Tamil Nadu");
		driver.findElement(By.id("button-shipping-address")).click();
		}
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(1000);
		driver.findElement(By.id("button-shipping-methods")).click();
		driver.findElement(By.id("input-shipping-method-flat-flat")).click();
		driver.findElement(By.id("button-shipping-method")).click();
		driver.findElement(By.id("button-payment-methods")).click();
		driver.findElement(By.id("input-payment-method-cod-cod")).click();
		driver.findElement(By.id("button-payment-method")).click();
		js.executeScript("window.scrollTo(0, 500);");
		Thread.sleep(1000);
		driver.findElement(By.id("button-confirm")).click();
		Thread.sleep(1000);
		String SuccessOrderMessage=driver.findElement(By.cssSelector("div[id=\"content\"] h1")).getText();
		Assert.assertEquals(SuccessOrderMessage, "Your order has been placed!");		

	}
}
