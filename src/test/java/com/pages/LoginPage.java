package com.pages;


import com.resources.OpenApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends OpenApplication {
    WebDriverWait wait;
    WebDriver driver;
    PageObjects po;

    public void login(WebDriver driver1) {
        driver = driver1;
        po = PageFactory.initElements(driver, PageObjects.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        po.email.sendKeys("defaultuser@enterpi.com");
        po.password.sendKeys("Enter@4321");
        po.signIn.click();
        wait.until(ExpectedConditions.visibilityOf(po.companyLogo));
    }

    public boolean verifyLoginValid(WebDriver driver) {
        this.login(driver);
        driver.findElement(By.xpath("//*[@class='user_image']")).click();
        boolean res;
        if (po.logout.isDisplayed()) {
            res = true;
            po.logout.click();
        }else {
            res=false;
        }
        return res;
    }
}
