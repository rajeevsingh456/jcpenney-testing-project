package com.jcpenney.tests;




import com.jcpenney.pages.HomePage;
import com.jcpenney.pages.ProductPage;
import com.jcpenney.utlis.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test
    public void searchProductAndVerifyProductDetails() throws InterruptedException {
        // Step 1: Search for "Men"
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct("Men");

        Thread.sleep(3000);

       
        driver.findElement(By.cssSelector("a[data-automation-id='product-title']")).click();

        Thread.sleep(2000);

        
        ProductPage productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.isTitleVisible(), "Product title not visible.");
        Assert.assertTrue(productPage.isPriceVisible(), "Product price not visible.");
        Assert.assertTrue(productPage.isImageVisible(), " Product image not visible.");
        Assert.assertTrue(productPage.isAddToCartVisible(), " Add to Cart button not visible.");
       

        System.out.println("All product details verified successfully.");
    }
}



