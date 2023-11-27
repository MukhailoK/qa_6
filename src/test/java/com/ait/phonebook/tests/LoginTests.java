package com.ait.phonebook.tests;

import com.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("test1023@test.test")
                .setPassword("test123"));

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test
    public void loginRegisteredUserNegativeTestWithoutEmail() {
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User()
                .setPassword("test123"));

        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isMessagePresent(By.cssSelector("div.validation-summary-errors > span"),
                "Login was unsuccessful. Please correct the errors and try again."));
//        Assert.assertTrue(app.getUser().isMessagePresent());
    }


}
