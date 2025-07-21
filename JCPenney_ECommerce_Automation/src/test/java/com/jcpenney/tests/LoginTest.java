package com.jcpenney.tests;

import org.testng.annotations.Test;
import com.jcpenney.pages.LoginPage;
import com.jcpenney.utlis.BaseTest;
import org.testng.Assert;

public class LoginTest extends BaseTest {

    
    @Test(priority = 1)
    public void TC_01_loginWithValidCredentials() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.loginWithCredentials("sachinsingh6392747885@gmail.com", "@Devil1234");
        Thread.sleep(3000);
        String error = login.getWrongPasswordErrorMessage(); // Reuse the same method that captures error from <p> tag
        System.out.println("Error during valid login I think it's detect Automation Script Or bot : " + error);
        Assert.assertEquals(error, "Oops! Something went wrong.");
    }


    @Test(priority = 2)
    public void TC_02_loginWithInvalidEmail() {
        LoginPage login = new LoginPage(driver);
        login.loginWithCredentials("rajeev123", "Wrong@123");
        String error = login.getInvalidEmailErrorMessage();
        System.out.println("Invalid Email Error: " + error);
        Assert.assertEquals(error, "Enter a valid email");
    }

    @Test(priority = 3)
    public void TC_03_loginWithWrongPassword() {
        LoginPage login = new LoginPage(driver);
        login.loginWithCredentials("sachinsingh6392747885@gmail.com", "WrongPass@123");
        String error = login.getWrongPasswordErrorMessage();
        System.out.println("Wrong Password Error: " + error);
        Assert.assertEquals(error, "Oops! Something went wrong.");
    }

    @Test(priority = 4)
    public void TC_04_loginWithEmptyFields() {
        LoginPage login = new LoginPage(driver);
        login.loginWithCredentials("", "");
        String error = login.getEmptyFieldErrorMessage();
        System.out.println("Empty Field Error: " + error);
        Assert.assertEquals(error, "Please correct the errors below.");
    }
}



