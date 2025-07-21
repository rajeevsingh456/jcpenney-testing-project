package com.jcpenney.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;

    private By productTitle = By.xpath("//h1[@id='productTitle-false']");
    private By productImage = By.cssSelector("img[data-automation-id='ProductImageZoom']");

    private By productPrice =  By.xpath("//span[@class='l-Kw- CBHlT _34SKb PI6hD Ef5l6']");
    private By addToCartBtn = By.xpath("//button[@class='kAmxf YMPh6 qrYeE _22RuR _7t8db cR8kV DbgMf _6KNOg NJgg3']");
    

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTitleVisible() {
        return driver.findElement(productTitle).isDisplayed();
    }

    public boolean isImageVisible() {
        return driver.findElement(productImage).isDisplayed();
    }

    public boolean isPriceVisible() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean isAddToCartVisible() {
        return driver.findElement(addToCartBtn).isDisplayed();
    }

   
}

