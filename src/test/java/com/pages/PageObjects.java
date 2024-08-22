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
    @FindBy(xpath = "(//*[contains(@class, 'form-error')])[2]")
    WebElement fromErrors;
    @FindBy(xpath = "(//*[text()='Create Quote'])[1]")
    WebElement createQuote1;
    @FindBy(xpath = "(//*[text()='Create Quote'])[2]")
    WebElement createQuote2;
    //Create Quote button at Create Quote Page
    @FindBy(xpath = "(//*[text()='Create Quote'])[3]")
    WebElement createQuote3;
    @FindBy(xpath = "(//*[text()='Quotes'])[1]")
    WebElement quotes;
    @FindBy(xpath = "//*[contains(text(), 'Quote Items')]")
    WebElement quoteItems;
    @FindBy(xpath = "(//*[contains(@class,'react-select__indicators')])[1]")
    WebElement firstReactInput;
    @FindBy(xpath = "(//*[contains(@class,'react-select__value')])[2]")
    WebElement secondReactInput;
    @FindBy(xpath = "(//*[contains(@class,'react-select__value')])[3]")
    WebElement thirdReactInput;
    @FindBy(xpath = "(//*[contains(@class,'react-select__value')])[4]")
    WebElement fourthReactInput;
    @FindBy(xpath = "(//*[contains(@class,'react-select__value')])[5]")
    WebElement fifthReactInput;
    @FindBy(xpath = "//*[text()='Loading...']")
    WebElement loading;
}
