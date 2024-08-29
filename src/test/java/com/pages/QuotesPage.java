package com.pages;

import com.resources.OpenApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class QuotesPage extends OpenApplication {

    private static final Logger log = LoggerFactory.getLogger(QuotesPage.class);
    LoginPage loginPage = new LoginPage(driver);

    public void createQuote(String compName, String quoteType) throws Exception {
        loginPage.login("", "");
        boolean getResults;
        loginPage.po.quotes.click();
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.po.companyLogo));
        loginPage.po.createQuote1.click();
        loginPage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Quote Type'])[1]")));
        loginPage.po.firstReactInput.click();
        loginPage.actions.sendKeys(compName).perform();
        Thread.sleep(1300);
        loginPage.wait.until(ExpectedConditions.invisibilityOf(loginPage.po.loading));
        getResults = this.selectDropDown(compName);
        if (getResults) {
            loginPage.driver.findElement(By.name("project_name")).sendKeys("For Testing");
            loginPage.po.secondReactInput.click();
            loginPage.actions.sendKeys(quoteType).perform();
            Thread.sleep(1300);
            loginPage.wait.until(ExpectedConditions.invisibilityOf(loginPage.po.loading));
            getResults = this.selectDropDown(quoteType);
            if (getResults) {
                //Create Quote button at Create Quote Page
                loginPage.po.createQuote3.click();
            } else {
            }
        }
    }
    public Object[] verifyCreateQuote(String compName, String quoteType) throws Exception {
        //this.createQuote(compName, quoteType);
        loginPage.login("","");
        loginPage.driver.get("https://buzzworld-web-iidm.enterpi.com/all_quotes/3692b3bb-ecf5-443a-bb1b-f3dbf5f956d4");
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.po.quoteItems));
        boolean res; String quoteNumber=""; String quoteUrl="";
        try {
            res = loginPage.po.quoteItems.isDisplayed();
            quoteNumber = loginPage.po.repQuoteId.getText().replace("#", "");
            System.out.println("Quote is Created with: " + quoteNumber);
            quoteUrl = loginPage.driver.getCurrentUrl();
            System.out.println("Quote page URL: "+quoteUrl);
        } catch (Exception e) {
            res = false;
        }
        Thread.sleep(1400);
        //loginPage.openApplication.closeBrowser();
        Object[] values = {res, quoteNumber, quoteUrl};
        return values;
    }
    public int[] addItemsToQuote(String item) throws Exception {
//        loginPage.login();
//        loginPage.driver.get("https://buzzworld-web-iidm.enterpi.com/all_quotes/b56c5732-24a7-4ca2-9f9e-8ed5050b18ac");
        Thread.sleep(1200);
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.elements("Add Items")));
        Thread.sleep(2000);
        String originalText = loginPage.po.quoteItems.getText();
        String n = originalText.substring(13, (originalText.length()-1));
        int itemsCountBeforeAdd = Integer.parseInt(n);
        loginPage.po.addItems.click();
        loginPage.po.partsSearch.sendKeys(item);
        Thread.sleep(2000);
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.elements(item)));
        loginPage.po.itemCheckBox.click();
        loginPage.po.addSelectedItems.click();
        Thread.sleep(2000);
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.elements("Add Options")));
        originalText = loginPage.po.quoteItems.getText();
        n = originalText.substring(13, (originalText.length()-1));
        int itemsCountAfterAdd = Integer.parseInt(n); boolean res;
        int[] vals = {itemsCountBeforeAdd, itemsCountAfterAdd};
        return vals;
    }
    public Object[] verifyAddItemsToQuote(String item) throws Exception {
        boolean res;
        int[] itemsCount=this.addItemsToQuote(item);
        if (itemsCount[0]<itemsCount[1]){
            res=true;
        }else{res=false;}
        Object[] vals = {itemsCount[0], itemsCount[1], res};
        return vals;
    }
    public void approveQuote(String item) throws Exception {
        this.verifyAddItemsToQuote(item);
        loginPage.po.itemSelCheckBox.click();
        loginPage.po.bulkEdit.click();
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.elements(item)));
    }

    public boolean selectDropDown(String compName) {
        List<WebElement> values = loginPage.po.reactDropDownLists;
        boolean res = false;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).getText().contains(compName)) {
                values.get(i).click();
                res = true;
                break;
            } else {
                System.err.println(compName + " is not found in dropdown search");
                res = false;
            }
        }
        return res;
    }
}
