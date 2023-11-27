package com.ait.phonebook.fw;

import com.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }
    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[@class='ico-login']"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//a[@class='ico-register']"));
    }

    public void fillLoginRegisterForm(User user) {
        click(By.id("gender-" + user.getGender()));
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//a[contains(text(),'Log out')]"));
    }
    public void clickLogOutButton(){
        click(By.xpath("//a[contains(text(),'Log out')]"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input[value='Log in']"));
    }

    public void clickOnRegistrationSubmitInput() {
        click(By.id("register-button"));
    }
}
