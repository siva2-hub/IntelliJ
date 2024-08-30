package com.pages;

import com.resources.OpenApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObjects {
    public WebDriver driver;
    public PageObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class='user_image']")
    public WebElement userProfile;
    @FindBy(id = "username")
    public WebElement email;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    public WebElement signIn;
    @FindBy(xpath = "(//*[contains(@src,'vendor_logo')])[1]")
    public WebElement companyLogo;
    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logout;
    @FindBy(xpath = "(//*[contains(@class, 'form-error')])[2]")
    public WebElement fromErrors;
    @FindBy(xpath = "(//*[text()='Create Quote'])[1]")
    public  WebElement createQuote1;
    @FindBy(xpath = "(//*[text()='Create Quote'])[2]")
    public WebElement createQuote2;
    //Create Quote button at Create Quote Page
    @FindBy(xpath = "(//*[text()='Create Quote'])[3]")
    public WebElement createQuote3;
    @FindBy(xpath = "(//*[text()='Quotes'])[1]")
    public WebElement quotes;
    @FindBy(className = "id-num")
    public WebElement repQuoteId;
    @FindBy(xpath = "//*[contains(text(), 'Quote Items')]")
    public WebElement quoteItems;
    @FindBy(xpath = "//*[text()='Add Items']")
    public WebElement addItems;
    @FindBy(xpath = "//*[@placeholder='Search By Part Number']")
    public WebElement partsSearch;
    @FindBy(xpath = "//*[contains(text(),'Add Selected')]")
    public WebElement addSelectedItems;
    @FindBy(xpath = "//*[@id='repair-items']/div[2]/div/div/div/div/div")
    public WebElement itemSelCheckBox;
    @FindBy(xpath = "//*[contains(@class,'data grid')]/div")
    public WebElement itemCheckBox;
    @FindBy(xpath = "(//*[@class='quote-option-del-icon edit-icon'])[1]")
    public WebElement bulkEdit;
    @FindBy(xpath = "(//*[contains(@class,'react-select__indicators')])[1]")
    public WebElement firstReactInput;
    @FindBy(xpath = "(//*[contains(@class,'react-select__value')])[2]")
    public WebElement secondReactInput;
    @FindBy(xpath = "(//*[contains(@class,'react-select__value')])[3]")
    public WebElement thirdReactInput;
    @FindBy(xpath = "(//*[contains(@class,'react-select__value')])[4]")
    public WebElement fourthReactInput;
    @FindBy(xpath = "(//*[contains(@class,'react-select__value')])[5]")
    public WebElement fifthReactInput;
    @FindBy(xpath = "//*[text()='Loading...']")
    public WebElement loading;
    @FindBys({@FindBy(xpath = "//*[contains(@class,'css-4mp3pp-menu')]/div/div")})
    public List<WebElement> reactDropDownLists;
}
