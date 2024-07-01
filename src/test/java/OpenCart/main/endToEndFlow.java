package OpenCart.main;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import OpenCart.spillitedCodes.CartPage;
import OpenCart.spillitedCodes.ConfirmOrderSuccessPage;
import OpenCart.spillitedCodes.SpilitedLoginCodesOrRegisterCodes;
import OpenCart.spillitedCodes.addedProdutPage;
import OpenCart.spillitedCodes.productPage;
import OpenCart.spillitedCodes.shippingPage;
import reportGenerator.testReports;
import resoucesCodes.upCode;

public class endToEndFlow extends upCode {

	@Test(dataProvider="loginDetails")
	public void fullTest(String email,String password,String products,String firstName,String lastName,String street,String district,String mobileNumber,String country,String state) throws InterruptedException {

		
		SpilitedLoginCodesOrRegisterCodes registerOrLogin = new SpilitedLoginCodesOrRegisterCodes(driver);

	    productPage productShowCase = registerOrLogin.LoginwithCredential(email, password);
	    productShowCase.wayToProductListedPage();

	    // Split the products into an array and populate the productList
	    String[] productArray = products.split(",");
	    List<String> productList = new ArrayList<>();
	    for (String product : productArray) {
	        productList.add(product.trim());
	    }

	    List<WebElement> productsElements = productShowCase.gettingAllProductsElements();

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    for (int i = 0; i < productsElements.size(); i++) {
	        String extractedProductName = productShowCase.GetProductAllText(i);
	        if (productList.contains(extractedProductName)) {
	            js.executeScript("arguments[0].scrollIntoView(true);", productsElements.get(i));
	            productShowCase.addProductIntoCard(i);
	        }
	    }

	    addedProdutPage addedProduct = productShowCase.goToaddedProductPage();
	    List<WebElement> addedProductList = addedProduct.addedProductListallItems();

	    for (int i = 0; i < addedProductList.size(); i++) {
	        String ListedItems = addedProduct.getListProductName(i);
	        if (productList.contains(ListedItems)) {
	            System.out.println("Product found in added list: " + ListedItems);
	        } else {
	            System.out.println("Not same");
	        }
	    }

	    CartPage cart = addedProduct.waytoCartPage();

	    List<WebElement> listofAddedProductElements = cart.listedCartedItems();

	    for (int i = 0; i < listofAddedProductElements.size(); i++) {
	        String viewCardPageProductList = cart.getCartListedItemsName(i);
	        String[] cartProducts = viewCardPageProductList.split(", ");
	        
	        for (String product : cartProducts) {
	            if (productList.contains(product)) {
	                System.out.println("Product found in cart: " + product);
	            } else {
	                System.out.println("Not Same");
	            }
	        }
	    }

	    shippingPage shipping = cart.wayToShippingPage();

	    if (shipping.defaultAddressChoosen().isDisplayed()) {
	        WebElement Address = shipping.defaultAddressChoosen();
	        Select s = new Select(Address);
	        s.selectByIndex(1);
	    } else {
	        shipping.shippingAddressCustomerName(firstName, lastName);
	        shipping.ShippingAddressDetails(street, district, mobileNumber, country, state);
	        shipping.ConfirmShippingAddress();
	    }

	    shipping.ChoosingFlatDiscount();
	    shipping.choosingPaymentMethod();
	    ConfirmOrderSuccessPage confirmPage = shipping.confirmOrder();
	    String SuccessOrderMessage = confirmPage.OrderConfirmSuccessMessage();
	    Assert.assertEquals(SuccessOrderMessage, "Your order has been placed!");
	}
}
