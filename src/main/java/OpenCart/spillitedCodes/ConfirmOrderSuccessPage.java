package OpenCart.spillitedCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import excessOtherCodes.reusableCodes;

public class ConfirmOrderSuccessPage extends reusableCodes {

	WebDriver driver;
	public ConfirmOrderSuccessPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="div[id='content'] h1")
	WebElement successText;
	public String OrderConfirmSuccessMessage() {
		String SuccessOrderMessage=successText.getText();
		return SuccessOrderMessage;
	}

	
	
}
