package com.jcpenney.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
    WebDriver driver;

    

    private By searchBox = By.xpath("//input[@id='searchInputId']");
    private By searchIcon = By.xpath("//button[@title='search']");
    private By firstProduct = By.cssSelector("a[data-automation-id='product-title']");
    private By colorOption = By.xpath("//button[@data-for='Black']"); 
    private By sizeOption = By.xpath("//button[normalize-space()='small']"); 
    private By quantityDropdown = By.xpath("//select[@name='quantity']");
    private By addToCartButton = By.xpath("//button[@class='kAmxf YMPh6 qrYeE _22RuR _7t8db cR8kV DbgMf _6KNOg NJgg3']");
    private By cartIcon = By.xpath("//button[@class='kAmxf YMPh6 GW-hU RnVYy _7t8db cR8kV DbgMf _6KNOg NJgg3']");

    // Methods
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void searchForProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchIcon).click();
    }

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public void chooseColorAndSize() {
        try {
            WebElement color = driver.findElement(colorOption);
            color.click();
        } catch (Exception e) {
            System.out.println("Color not required or not found.");
        }

        try {
            WebElement size = driver.findElement(sizeOption);
            size.click();
        } catch (Exception e) {
            System.out.println("Size not required or not found.");
        }
    }

    public void selectQuantity(String qty) {
        try {
            WebElement quantity = driver.findElement(quantityDropdown);
            quantity.sendKeys(qty); // or use Select class if it's a <select>
        } catch (Exception e) {
            System.out.println("Quantity selector not found.");
        }
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }
}
