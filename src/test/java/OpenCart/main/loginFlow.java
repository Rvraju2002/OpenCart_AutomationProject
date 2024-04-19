package OpenCart.main;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;



import OpenCart.spillitedCodes.SpilitedLoginCodesOrRegisterCodes;

import resoucesCodes.upCode;


public class loginFlow extends upCode {
    
	@Test(dataProvider = "loginCredentials")
    public void loginTest(String email, String password) throws InterruptedException {
    
        SpilitedLoginCodesOrRegisterCodes loginPage = new SpilitedLoginCodesOrRegisterCodes(driver);

       
                    loginPage.loginOrRegisteDropDown();
                    loginPage.LoginButton();
                    loginPage.loginCredential(email, password); 
                    loginPage.loginSubmitButton();
                    Thread.sleep(1000); 
                    
              
}
    
    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() throws IOException, ParseException {
        // Read JSON file
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\excessOtherCodes\\credential.json"));

        // Create a 2D array to store email and password combinations
        Object[][] data = new Object[jsonArray.size()][2];

        // Extract email and password from each JSON object
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String email = (String) jsonObject.get("email");
            String password = (String) jsonObject.get("password");
            data[i][0] = email;
            data[i][1] = password;
        }

        return data;
    }

}




