package com.jcpenney.tests;

import org.testng.annotations.Test;
import com.jcpenney.pages.HomePage;
import com.jcpenney.pages.RegisterPage;
import com.jcpenney.utlis.BaseTest;

public class RegisterTest extends BaseTest {

    @Test
    public void verifyRegisterFunctionality() {
        HomePage home = new HomePage(driver);
        home.clickSignIn(); 
        home.searchForProduct("");
       System.out.println("The Home Page Title is: "+ home.getHomePageTitle());
       RegisterPage register = new   RegisterPage(driver);
       register.signbtnvisibleTC_001_01();
       register.registerwithvalidTC_001_03("Rajeev", "Singh", "9005742689", "rajeevsingh15206@gmail.com", "@Devil1234");
    }
}
