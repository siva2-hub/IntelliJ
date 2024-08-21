package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects {

    @FindBy(id = "username")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    WebElement signIn;
    @FindBy(xpath = "(//*[contains(@src,'vendor_logo')])[1]")
    WebElement companyLogo;
    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logout;
}
