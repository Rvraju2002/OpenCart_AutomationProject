package OpenCart.spillitedCodes;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import excessOtherCodes.reusableCodes;

public class SpilitedLoginCodesOrRegisterCodes extends reusableCodes {

	WebDriver driver;
	public SpilitedLoginCodesOrRegisterCodes(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='nav float-end'] a[class='dropdown-toggle']")
	WebElement SigninOrSignupDropDown;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right show']/li[2]")
	WebElement loginButton;
	
	@FindBy(id="input-email")
	WebElement emailTextbox;
	
	@FindBy(id="input-password")
	WebElement passwordTextbox;
	
	@FindBy(css="button[class$='btn btn-primary']")
	WebElement submitLoginButton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right show']/li[1]")
	WebElement RegisterFlow;
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(css="input[name='agree']")
	WebElement privacyPolicy;
	
	@FindBy(css="button[type='submit']")
	WebElement submit;
	
	@FindBy(css="div[class='row'] h1")
	WebElement successMessage;
	
	//LoginFlow start
	public void loginOrRegisteDropDown() throws InterruptedException {
		SigninOrSignupDropDown.click();
	}
	
	public void LoginButton() {
		loginButton.click();
	}
	
	public void loginCredential(String email, String Password) {
		emailTextbox.sendKeys(email);
		passwordTextbox.sendKeys(Password);
	}
	
	public void loginSubmitButton() throws InterruptedException {
		submitLoginButton.click();
		Thread.sleep(1000);
	}
	
	public productPage LoginwithCredential(String email, String Password) throws InterruptedException {
		SigninOrSignupDropDown.click();
		loginButton.click();
		emailTextbox.sendKeys(email);
		passwordTextbox.sendKeys(Password);
		submitLoginButton.click();
		Thread.sleep(1000);
		return new productPage(driver);
	}
	
	//LoginFlow end
	
	//Register flow
	
	public void RegisterAnAccountlink() {
		
		RegisterFlow.click();
		
	}
	
	public void customerFirstNameandLastName(String firstNameField, String lastNameField) {
		firstName.sendKeys(firstNameField);
		lastName.sendKeys(lastNameField);
	}
	
	public void customerEmailandPassword(String randomEmail, String customerPassword ) throws InterruptedException {
		email.sendKeys(randomEmail);
	    password.sendKeys(customerPassword);
	    scrollBy500();
	    threadSleep1000Seconds();
	}
	
	public void privacyPolicyCheckbox() {
		privacyPolicy.click();
	}
	
	public void registerDetailsSumbitButton() throws InterruptedException {
		submit.click();
		threadSleep1000Seconds();	
	}
	
	public String successfullRegisterMessageCheck() throws InterruptedException {
		
		String successMessageText=successMessage.getText();
		return successMessageText;
	}
	
	public productPage Registrationflow() throws InterruptedException {
		SigninOrSignupDropDown.click();
		RegisterAnAccountlink();
		customerFirstNameandLastName("Vignesh","testing");
		String randomEmailGen=generateRandomEmail();
		customerEmailandPassword(randomEmailGen,"1234567");
		saveEmailAndPasswordToJson(randomEmailGen,"1234567");
		privacyPolicyCheckbox();
		registerDetailsSumbitButton();
		successfullRegisterMessageCheck();
		return new productPage(driver);
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
	
	public static void saveEmailAndPasswordToJson(String email1, String password1) {
		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\excessOtherCodes\\credential.json";
		 JSONArray jsonArray = readJsonFile(filePath);
		 JSONObject newEntry = new JSONObject();
		 newEntry.put("email", email1);
		 newEntry.put("password", password1);
		 jsonArray.add(newEntry);
        
        
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
	public static JSONArray readJsonFile(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONParser parser = new JSONParser();
            return (JSONArray) parser.parse(fileReader);
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            return new JSONArray(); // Return empty JSONArray if file does not exist or parsing fails
        }
    }
	
//register flow end
    
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
