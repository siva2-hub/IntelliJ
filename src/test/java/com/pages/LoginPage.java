package com.pages;


import com.resources.OpenApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    PageObjects po;
    public void login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        po= new PageObjects();
        po.email.sendKeys("defaultuser@enterpi.com");
        po.password.sendKeys("Enter@4321");
        po.signIn.click();
    }
}
