package OpenCart.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.testng.annotations.Test;
import org.mindrot.jbcrypt.BCrypt;
import OpenCart.spillitedCodes.SpilitedLoginCodesOrRegisterCodes;
import resoucesCodes.upCode;

public class loginFlow extends upCode {
    
    @Test
    public void loginTest() throws InterruptedException {
    	String url = "jdbc:mysql://localhost:3308/opencardprodb";
        String username = "root";
        String password = "";

        // Create an instance of SpilitedLoginCodesOrRegisterCodes with a WebDriver instance
        SpilitedLoginCodesOrRegisterCodes loginPage = new SpilitedLoginCodesOrRegisterCodes(driver);

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT password FROM oc_customer WHERE email = 'vignesh@ngfot.com';")) {

           
//                String email = resultSet.getString("email");
                String passwordFromDB = resultSet.getString("password");

                // Hash the user input password for comparison
                String hashedPasswordFromDB = BCrypt.hashpw(passwordFromDB, BCrypt.gensalt());

                // Simulated login test
                boolean loginSuccessful = BCrypt.checkpw("1234567", hashedPasswordFromDB);

                // Output login result
                if (loginSuccessful) {
//                    System.out.println("Login successful for email: " + email);

                    // Perform login actions using SpilitedLoginCodesOrRegisterCodes
                    loginPage.loginOrRegisteDropDown();
                    loginPage.LoginButton();
                    loginPage.loginCredential("Vignesh@ngfot.com", hashedPasswordFromDB); // Use the hashed password directly
                    loginPage.loginSubmitButton();
                    Thread.sleep(1000); // Adding a delay for demonstration purposes
                    
                } else {
//                    System.out.println("Login failed for email: " + email);
                    System.out.println(hashedPasswordFromDB);
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





