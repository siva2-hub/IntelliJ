package com.pages;


import com.resources.OpenApplication;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends OpenApplication {
    public WebDriverWait wait;
    public WebDriver driver;
    public PageObjects po;
    public OpenApplication openApplication;
    public Actions actions;


    public void clickSignIn(String mail, String password) throws Exception {
        if (driver != null) {
        } else {
            openApplication = new OpenApplication();
            driver = openApplication.openBrowser();
        }
        po = PageFactory.initElements(driver, PageObjects.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(po.email));
        po.email.sendKeys(mail);
        po.password.sendKeys(password);
        po.signIn.click();
    }

    public void login() throws Exception {
        this.clickSignIn("defaultuser@enterpi.com", "Enter@4321");
        wait.until(ExpectedConditions.visibilityOf(po.companyLogo));
    }

    public boolean verifyLoginValid() throws Exception {
        this.login();
        driver.findElement(By.xpath("//*[@class='user_image']")).click();
        boolean res;
        if (po.logout.isDisplayed()) {
            res = true;
            po.logout.click();
        } else {
            res = false;
        }
        Thread.sleep(2000);
        openApplication.closeBrowser();
        return res;
    }

    public boolean verifyInValidLogin() throws Exception {
        this.clickSignIn("defaultu3243ser@enterpi.co", "Ent343er@4321");
        Thread.sleep(1400);
        boolean res;
        res = po.fromErrors.getText().equals("Invalid Email or Password");
        Thread.sleep(2000);
        openApplication.closeBrowser();
        return res;
    }
}
