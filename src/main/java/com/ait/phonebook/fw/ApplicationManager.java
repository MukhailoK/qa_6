package com.ait.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;

    UserHelper user;
    CartHelper cart;
    HomePageHelper homePage;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cart = new CartHelper(driver);
        user = new UserHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public CartHelper getCart() {
        return cart;
    }

    public UserHelper getUser() {
        return user;
    }


    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void stop() {
        driver.quit();
    }

}
