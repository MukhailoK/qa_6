package com.ait.phonebook.tests;

import com.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().clickOnRegistrationButton();
        app.getUser().fillLoginRegisterForm(
                new User()
                        .setFirstName("Code")
                        .setLastName("Turtle")
                        .setGender("male")
                        .setEmail("test1023@test.test")
                        .setPassword("test123")

        );
        app.getUser().clickOnRegistrationSubmitInput();

        Assert.assertTrue(app.getUser().isMessagePresent(By.xpath("//li[contains(text(),'The specified email already exists')]"),
                "The specified email already exists"));
    }

}
