package com.pages;


import com.resources.OpenApplication;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends OpenApplication {
    public WebDriverWait wait;
    public WebDriver driver;
    public PageObjects po;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.po = new PageObjects(driver);
    }

    public void clickSignIn(String mail, String password) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(po.email));
        po.email.sendKeys(mail);
        po.password.sendKeys(password);
        po.signIn.click();
    }

    public void login(String uname, String pwrod) throws Exception {
        Thread.sleep(1200);
        try {
            po.userProfile.isDisplayed();
            po.userProfile.click();
            po.logout.click();
        } catch (Exception e) {}
        this.clickSignIn(uname, pwrod);
    }

    public boolean verifyLoginValid() throws Exception {
        this.login("defaultuser@enterpi.com", "Enter@4321");
        po.userProfile.click();
        Thread.sleep(1200);
        boolean res;
        if (po.logout.isDisplayed()) {
            res = true;
            po.logout.click();
        } else {
            res = false;
        }
        Thread.sleep(2000);
        return res;
    }

    public boolean verifyInValidLogin() throws Exception {
        this.login("defaultu3243ser@enterpi.co", "Ent343er@4321");
        Thread.sleep(1400);
        boolean res;
        res = po.fromErrors.getText().equals("Invalid Email or Password");
        Thread.sleep(2000);
        return res;
    }

    public WebElement elements(String name) {
        WebElement element = driver.findElement(By.xpath("//*[text()='" + name + "']"));
        return element;
    }
}
