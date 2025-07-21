package com.jcpenney.tests;

import org.testng.annotations.Test;

import com.jcpenney.pages.AddToCartPage;
import com.jcpenney.utlis.BaseTest;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddToCartFlow() throws InterruptedException {
        AddToCartPage cartPage = new AddToCartPage(driver);

        cartPage.searchForProduct("men");
        Thread.sleep(3000); // wait for results

        cartPage.clickFirstProduct();
        Thread.sleep(3000); // wait for product page

        cartPage.chooseColorAndSize();
        cartPage.selectQuantity("2");
       
    }
}

