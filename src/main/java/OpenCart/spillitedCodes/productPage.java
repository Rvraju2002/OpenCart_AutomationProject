package OpenCart.spillitedCodes;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import excessOtherCodes.reusableCodes;

public class productPage extends reusableCodes {
	
	WebDriver driver;
	public productPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[1]")
	WebElement productsLinks;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[1]/div/a")
	WebElement productsPage;
	
	@FindBy(css="div[class='content'] h4")
	List<WebElement> ProductsAllListElement;
	
	@FindBy(xpath="//div[@class='button-group']/button[1]")
	List<WebElement> addCartButton;
	
	@FindBy(css=".dropdown.d-grid")
	WebElement gotoProductAddedPage;
	public  void wayToProductListedPage() {
		productsLinks.click();
		productsPage.click();
	}
	
	public List<WebElement> gettingAllProductsElements() {
		
		List<WebElement> productsElements = ProductsAllListElement;
		return productsElements;
		
	}
	
	public String GetProductAllText(int i) {
		String extractedProductName = ProductsAllListElement.get(i).getText();
		return extractedProductName;
	}
	
	public void addProductIntoCard(int i) throws InterruptedException {
		
		threadSleep1000Seconds();
		addCartButton.get(i).click();
	}
	
	public addedProdutPage goToaddedProductPage() throws InterruptedException {
		bottomToUpScroll();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 

	        // Wait for the alert to be visible (with opacity > 0)
	        WebElement alertElement = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
	        

	        // Wait for the alert to disappear (with opacity == 0 or element to be not present)
	        wait.until(ExpectedConditions.or(
	            ExpectedConditions.invisibilityOf(alertElement)
	          
	        ));
		gotoProductAddedPage.click();
		return new addedProdutPage(driver);
	}
	
	
	

}
