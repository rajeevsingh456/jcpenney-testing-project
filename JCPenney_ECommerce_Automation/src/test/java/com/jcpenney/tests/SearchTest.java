package com.jcpenney.tests;



import com.jcpenney.pages.SearchPage;
import com.jcpenney.utlis.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public void testSearchBarIsVisible() {
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.isSearchBarVisible(), "Search bar is not visible or not enabled");
    }

    @Test(priority = 2)
    public void testSearchWithValidKeyword() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchKeyword("men");  
        searchPage.clickSearchButton();

        int resultCount = searchPage.getSearchResultCount();
        Assert.assertTrue(resultCount > 0, "Expected search results but found none");
    }

    @Test(priority = 3)
    public void testSearchWithInvalidKeyword() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchKeyword("invaliditem1234"); // use invalid keyword
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isNoResultMessageDisplayed(), "No result message should be displayed");
    }

}
