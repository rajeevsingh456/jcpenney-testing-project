package com.jcpenney.tests;



import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddressBookPage;
import pages.LoginPage;
import base.BaseTest;

public class AddressBookTest extends BaseTest {

    private LoginPage loginPage;
    private AddressBookPage addressBookPage;

    @Test(priority = 1)
    public void verifyAddressBookNavigation() {
        loginPage = new LoginPage(driver);
        addressBookPage = new AddressBookPage(driver);

        loginPage.login("user@example.com", "password123");
        addressBookPage.goToAddressBook();

        Assert.assertTrue(driver.getCurrentUrl().contains("info"),
                "User is not on the Address Book Info page");
    }

    @Test(priority = 2)
    public void addNewAddressTest() {
        addressBookPage = new AddressBookPage(driver);
        addressBookPage.clickAddNewAddress();
        addressBookPage.fillAddressForm("Rajeev Singh", "Sector 10", "Delhi", "110011", "9876543210");
        addressBookPage.submitAddressForm();
        Assert.assertTrue(addressBookPage.isSuccessMessageDisplayed(), "Address was not added successfully");
        Assert.assertTrue(addressBookPage.isAddressPresent("Rajeev Singh"), "New address not found in list");
    }

    @Test(priority = 3)
    public void verifyAddressListIsDisplayed() {
        addressBookPage = new AddressBookPage(driver);
        int count = addressBookPage.getAddressCount();
        Assert.assertTrue(count > 0, "No addresses displayed");
    }

    @Test(priority = 4)
    public void editAddressTest() {
        addressBookPage = new AddressBookPage(driver);
        addressBookPage.clickEditAddress(0);
        addressBookPage.fillAddressForm("Rajeev Updated", "Updated St", "Noida", "110022", "9999999999");
        addressBookPage.submitAddressForm();
        Assert.assertTrue(addressBookPage.isAddressPresent("Rajeev Updated"), "Address was not updated");
    }

    @Test(priority = 5)
    public void deleteAddressTest() {
        addressBookPage = new AddressBookPage(driver);
        int beforeCount = addressBookPage.getAddressCount();
        addressBookPage.clickDeleteAddress(0);
        int afterCount = addressBookPage.getAddressCount();
        Assert.assertTrue(afterCount < beforeCount, "Address was not deleted");
    }
}
