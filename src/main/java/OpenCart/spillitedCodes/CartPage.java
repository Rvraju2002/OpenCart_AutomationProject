package OpenCart.spillitedCodes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import excessOtherCodes.reusableCodes;

public class CartPage extends reusableCodes {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="td[class$='text-start text-wrap'] a")
	List<WebElement> listCardItems;
    
	@FindBy(css="a[class='btn btn-primary']")
	WebElement wayToShipping;
	
	public List<WebElement> listedCartedItems() {
		List<WebElement> listofAddedProductElements = listCardItems;
		return listofAddedProductElements;
	}
	
	public String getCartListedItemsName(int i) {
		String listedCartedItems=listCardItems.get(i).getText();
		return listedCartedItems;
	}
	
	
	public shippingPage wayToShippingPage() throws InterruptedException {

        smoothScrollByElement(wayToShipping);
		Thread.sleep(1000);
		wayToShipping.click();
		Thread.sleep(1000);
		return new shippingPage(driver);
	}
	

}
