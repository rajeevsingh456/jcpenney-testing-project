package com.jcpenney.pages;

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AddressBookPage {

    private WebDriver driver;

    // Locators – These are assumed based on typical structure. Please update with actual if needed.
    private By addNewAddressBtn = By.xpath("//button[contains(text(),'Add New Address')]");
    private By nameField = By.id("fullName");
    private By streetField = By.id("addressLine1");
    private By cityField = By.id("city");
    private By zipField = By.id("postalCode");
    private By phoneField = By.id("phoneNumber");
    private By submitBtn = By.xpath("//button[contains(text(),'Save') or contains(text(),'Add')]");
    private By successMessage = By.cssSelector(".alert-success, .message-success");
    private By addressList = By.cssSelector(".address-entry, .address-card");
    private By editButtons = By.xpath("//button[contains(text(),'Edit')]");
    private By deleteButtons = By.xpath("//button[contains(text(),'Delete')]");

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAddressBook() {
        driver.get("https://www.jcpenney.com/account/dashboard/personal/info");
    }

    public void clickAddNewAddress() {
        driver.findElement(addNewAddressBtn).click();
    }

    public void fillAddressForm(String name, String street, String city, String zip, String phone) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);

        driver.findElement(streetField).clear();
        driver.findElement(streetField).sendKeys(street);

        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);

        driver.findElement(zipField).clear();
        driver.findElement(zipField).sendKeys(zip);

        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void submitAddressForm() {
        driver.findElement(submitBtn).click();
    }

    public boolean isSuccessMessageDisplayed() {
        List<WebElement> messages = driver.findElements(successMessage);
        return messages.stream().anyMatch(WebElement::isDisplayed);
    }

    public boolean isAddressPresent(String name) {
        List<WebElement> addresses = driver.findElements(addressList);
        return addresses.stream().anyMatch(address -> address.getText().contains(name));
    }

    public int getAddressCount() {
        return driver.findElements(addressList).size();
    }

    public void clickEditAddress(int index) {
        List<WebElement> editList = driver.findElements(editButtons);
        if (index < editList.size()) {
            editList.get(index).click();
        }
    }

    public void clickDeleteAddress(int index) {
        List<WebElement> deleteList = driver.findElements(deleteButtons);
        if (index < deleteList.size()) {
            deleteList.get(index).click();
            // Confirm delete popup (if any) – assumed
            driver.switchTo().alert().accept(); // or locate and click 'Yes' manually if not an alert
        }
    }
}


