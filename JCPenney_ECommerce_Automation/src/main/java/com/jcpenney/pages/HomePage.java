package com.jcpenney.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private By signInButton = By.xpath("//p[@class='RfkhM _06mTn _2U7zC eDK-M nH8ys']");
    private By canclebtn = By.cssSelector("a[class='undefined ghgAN FwgYL t8qqy V1OpX d-j2G M21vE MdYIp']\r\n"
    		+ "");
    private By searchBox = By.xpath("//input[@id='searchInputId']");
    private By searchIcon = By.xpath("//button[@title='search']");
    private By firstProduct = By.cssSelector("a[data-automation-id='product-title']");
    

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSignIn() {
        driver.findElement(signInButton).click();
        driver.findElement(canclebtn).click();
    }

    

    public String getHomePageTitle() {
        return driver.getTitle();
    }
    
    
    public void searchForProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchIcon).click();
    }

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
    }
}

