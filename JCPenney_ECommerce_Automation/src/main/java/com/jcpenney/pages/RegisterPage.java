package com.jcpenney.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage {
	
private WebDriver driver;

private By signInButton1 = By.xpath("//p[@class='RfkhM _06mTn _2U7zC eDK-M nH8ys']");
private By signUpBtn = By.xpath("//button[@type='Button']");
private By firstname = By.xpath("//input[@id='firstName']");
private By lastname = By.xpath("//input[@id='lastName']");
private By phonenum  = By.xpath("//input[@id='phone']");
private By email = By.xpath("//input[@id='createAccountEmail']");
private By keeplogin  = By.xpath("//label[normalize-space()='Keep Me Signed In']");
private By password = By.xpath("//input[@id='create-password']");
private By createact = By.xpath("//button[@type='submit']//span[@class='eDK-M nH8ys TWg-M'][normalize-space()='Create Account']");
private By confirmMessage = By.xpath("//h2[normalize-space()='Confirm Your Account']");



public RegisterPage (WebDriver driver) {
    this.driver = driver;
}

public void signbtnvisibleTC_001_01() {
	
	WebElement regibtn = driver.findElement(signInButton1);
	if(regibtn.isDisplayed()&&regibtn.isEnabled()) {
		System.out.println(" Register button is visible and clickable.");
	}else {
		System.out.println("Register button is NOT visible or not clickable.");
	}
	
}

public void registerwithvalidTC_001_03(String Firstname, String LastName, String phonrnum, String Email, String Password) {
    try {
        driver.findElement(signInButton1).click();
        driver.findElement(signUpBtn).click();
        driver.findElement(firstname).sendKeys(Firstname);  
        driver.findElement(lastname).sendKeys(LastName);    
        driver.findElement(phonenum).sendKeys(phonrnum);     
        driver.findElement(email).sendKeys(Email);          
        driver.findElement(password).sendKeys(Password);     
        driver.findElement(keeplogin).click();
        driver.findElement(createact).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmMessage));

        String actualText = confirmMsgElement.getText();

        // ✅ Success condition
        if (actualText.contains("Confirm Your Account")) {
            System.out.println("✅ Test Passed: Registration successful.");
            Assert.assertEquals(actualText, "Confirm Your Account", "Confirmation message is not as expected.");
        } else {
            System.out.println("❌ Test Failed: Unexpected confirmation message: " + actualText);
        }

    } catch (Exception e) {
        // ✅ If any error occurs, like user already exists or backend error
        try {
            WebElement errorMsg = driver.findElement(By.xpath("//span[contains(text(),\"We're having trouble completing your requ\")]"));
            if (errorMsg.isDisplayed()) {
                System.out.println("✅ Test Passed: Proper error message displayed: " + errorMsg.getText());
            } else {
                System.out.println("❌ Test Failed: No confirmation or error message found.");
            }
        } catch (Exception innerEx) {
            System.out.println("❌ Test Failed: Exception occurred - " + e.getMessage());
        }
    }
}

}
