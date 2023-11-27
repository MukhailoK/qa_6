package com.ait.phonebook.tests;

import com.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddToCartTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("test1023@test.test")
                .setPassword("test123"));

        app.getUser().clickOnLoginButton();

    }

    @Test
    public void checkMessageProductAddedPositiveTest() {
        app.getCart().clickOnProductOnStartPage(3);
        app.getCart().clickOnAddToCartInProductPage();

        String message = "The product has been added to your ";
        By locator = By.cssSelector(".content");

        Assert.assertTrue(app.getCart().isMessagePresent(locator, message));
    }

    @Test
    public void checkAddProductInCartPositiveTest() {
        app.getCart().clickOnProductOnStartPage(3);
        app.getCart().clickOnAddToCartInProductPage();
        app.getCart().clickOnShoppingCartLink();

        Assert.assertTrue(app.getCart().isProductTableInCartPresent());
    }

    @AfterMethod
    public void exit() {
        app.getUser().clickLogOutButton();
    }
}
