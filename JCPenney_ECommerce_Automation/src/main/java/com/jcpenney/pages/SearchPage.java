package com.jcpenney.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    private By searchBar = By.xpath("//input[@id='searchInputId']");
    private By searchButton = By.xpath("//button[@title='search']");
    private By searchResults = By.cssSelector("a[data-automation-id='product-title']");
    private By noResultMessage = By.xpath("//h1[@data-automation-id='headerTag']");

  

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchBarVisible() {
        return driver.findElement(searchBar).isDisplayed() && driver.findElement(searchBar).isEnabled();
    }

    public void enterSearchKeyword(String keyword) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(keyword);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public int getSearchResultCount() {
        List<WebElement> results = driver.findElements(searchResults);
        return results.size();
    }

    public boolean isNoResultMessageDisplayed() {
        return driver.findElements(noResultMessage).size() > 0;
    }

    
}

