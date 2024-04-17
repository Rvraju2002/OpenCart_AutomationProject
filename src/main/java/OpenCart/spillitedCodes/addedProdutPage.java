package OpenCart.spillitedCodes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import excessOtherCodes.reusableCodes;

public class addedProdutPage extends reusableCodes{
	
	WebDriver driver;
	public addedProdutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="td[class='text-start'] a")
	List<WebElement> listedItems;
	
	@FindBy(xpath="//p[@class='text-end']/a[1]")
	WebElement wayTocart;
	
	public List<WebElement> addedProductListallItems() {
		List<WebElement>addedProductList=listedItems;
		return addedProductList;
	}
	
	public String getListProductName(int i) {
		String itemList=listedItems.get(i).getText();
		return itemList;
	}
	
	public CartPage waytoCartPage() {
		wayTocart.click();
		return new CartPage(driver);
	}

}
