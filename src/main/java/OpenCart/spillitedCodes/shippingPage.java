package OpenCart.spillitedCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import excessOtherCodes.reusableCodes;

public class shippingPage extends reusableCodes {

	WebDriver driver;
	public shippingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-shipping-address")
	WebElement registeredAddress;
	
	@FindBy(id="input-shipping-firstname")
	WebElement shippingFirstName;
	
	@FindBy(id="input-shipping-lastname")
	WebElement shippingLastName;
	
	@FindBy(id="input-shipping-address-1")
	WebElement streetAddress;
	
	@FindBy(id="input-shipping-city")
	WebElement cityName;
	
	@FindBy(id="input-shipping-postcode")
	WebElement postalCodes;
	
	@FindBy(id="input-shipping-country")
	WebElement countryChoosen;
	
	@FindBy(id="input-shipping-zone")
	WebElement stateChoosen;
	
	@FindBy(id="button-shipping-address")
	WebElement ConfirmAddress;
	
	@FindBy(id="button-shipping-methods")
	WebElement shippingMethodFlat;
	
	
	@FindBy(id="input-shipping-method-flat-flat")
	WebElement choosingFlatDiscount;
	
	@FindBy(id="button-shipping-method")
	WebElement confirmFlat;
	
	
	@FindBy(id="button-payment-methods")
	WebElement PaymentMethodButton;
	
	@FindBy(id="input-payment-method-cod-cod")
	WebElement ChoosePaymenthod;
	
	@FindBy(id="button-payment-method")
	WebElement confirmPayment;
	
	@FindBy(id="button-confirm")
	WebElement confirmOrderButton;
	
	
	public WebElement defaultAddressChoosen() {
		
		
			WebElement Address=registeredAddress;
			return 	Address;		
		
	}
	
	public void shippingAddressCustomerName(String FirstName, String LastName) {
		shippingFirstName.sendKeys(FirstName);
		shippingLastName.sendKeys(LastName);
	}
	
	
	public void ShippingAddressDetails(String streetName,String cityNames,String postalCode,String CountryName,String stateName) throws InterruptedException {
		streetAddress.sendKeys(streetName);
		cityName.sendKeys(cityNames);
		scrollBy500();
		threadSleep1000Seconds();
		
		
		postalCodes.sendKeys(postalCode);
		
		WebElement country=countryChoosen;
		Select countryChoosen = new Select(country);
		countryChoosen.selectByVisibleText(CountryName);
		
		WebElement state=stateChoosen;
		threadSleep1000Seconds();
		Select stateChoosen = new Select(state);
		stateChoosen.selectByVisibleText(stateName);
	}
	
	public void ConfirmShippingAddress() {
		ConfirmAddress.click();
	}
	
	
	public void ChoosingFlatDiscount() throws InterruptedException {
		bottomToUpScroll();
		threadSleep1000Seconds();
		shippingMethodFlat.click();
		choosingFlatDiscount.click();
		threadSleep1000Seconds();
		confirmFlat.click();
	}
	
	public void choosingPaymentMethod() {
		PaymentMethodButton.click();
		ChoosePaymenthod.click();
		confirmPayment.click();
	}
	
	public ConfirmOrderSuccessPage confirmOrder() throws InterruptedException {
		
		scrollBy500();
		threadSleep1000Seconds();
		confirmOrderButton.click();
		threadSleep1000Seconds();
		return new ConfirmOrderSuccessPage(driver);
	}
	
	
	

}
