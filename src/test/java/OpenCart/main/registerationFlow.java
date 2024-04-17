package OpenCart.main;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import OpenCart.spillitedCodes.SpilitedLoginCodesOrRegisterCodes;
import resoucesCodes.upCode;

public class registerationFlow extends upCode{
	
	
	@Test
	public void registerAnAcccount() throws InterruptedException {
		
		
		SpilitedLoginCodesOrRegisterCodes register = new SpilitedLoginCodesOrRegisterCodes(driver);
		register.loginOrRegisteDropDown();
		register.RegisterAnAccountlink();
		register.customerFirstNameandLastName("Vignesh", "raju");
		String randomEmail=generateRandomEmail();
		register.customerEmailandPassword(randomEmail, "12345678");
		register.privacyPolicyCheckbox();
		register.registerDetailsSumbitButton();
		String successMessage=register.successfullRegisterMessageCheck();
		assertEquals(successMessage, "Your Account Has Been Created!");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		
	}

	
		public static String generateRandomEmail() {
	        String[] names = {"john", "emma", "david", "sophia", "michael", "olivia", "william", "ava"};
	        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "aol.com"};
	        Random random = new Random();
	        String name = names[random.nextInt(names.length)];
	        String domain = domains[random.nextInt(domains.length)];
	        int randomNumber = random.nextInt(1000);
	        return name + randomNumber + "@" + domain;
	    }
	

}
