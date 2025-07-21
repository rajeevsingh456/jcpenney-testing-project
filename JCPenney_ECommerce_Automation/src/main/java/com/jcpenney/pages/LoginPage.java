package com.jcpenney.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By myAccount = By.xpath("//p[@class='iOg0V VhxJp _06mTn']");
    private By signInButton = By.xpath("//button[@class='_2vrNp iOg0V S7DSF signInValidate O9B68 dZvy3 kR8H8 f-VEk _5k9-F _06mTn xHWUC _6FzcK rKnHl H7CkW']//span[@class='eDK-M nH8ys TWg-M'][normalize-space()='Sign In']");
    private By emailField = By.xpath("//input[@id='loginEmail']");
    private By passwordField = By.xpath("//input[@id='signin-password']");
    private By loginButton = By.xpath("//button[@data-automation-id='signin_button']");
    private By invalidEmailError = By.xpath("//span[@data-automation-id='email_id_inline_error']");
    private By emptyFieldError = By.xpath("//p[contains(text(),'Please correct the errors below.')]");
    private By wrongPasswordError = By.xpath("//p[contains(text(),'Oops! Something went wrong.')]");

    public void openLoginPage() {
        driver.findElement(myAccount).click();
        driver.findElement(signInButton).click();
    }

    public void loginWithCredentials(String email, String password) {
        openLoginPage();
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getInvalidEmailErrorMessage() {
        return driver.findElement(invalidEmailError).getText();
    }

    public String getEmptyFieldErrorMessage() {
        return driver.findElement(emptyFieldError).getText();
    }

    public String getWrongPasswordErrorMessage() {
        return driver.findElement(wrongPasswordError).getText();
    }
}


