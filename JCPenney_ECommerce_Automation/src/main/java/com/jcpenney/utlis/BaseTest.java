
package com.jcpenney.utlis;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
       
        ChromeOptions options = new ChromeOptions();

        // Disable the automation flag and extension
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Disable detection by JavaScript
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Set a real-looking user-agent
        options.addArguments("user-agent=Mozilla/5.0");

        // Optional browser setup
        options.addArguments("start-maximized");  // Open browser in full-screen

        // Initialize the ChromeDriver with these options
        driver = new ChromeDriver(options);

        // Set implicit wait and open the application
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jcpenney.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
