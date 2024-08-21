package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects {

    @FindBy(id = "username")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//*[text()=' Sign In']")
    WebElement signIn;
}
