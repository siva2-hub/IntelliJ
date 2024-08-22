package com.pages;

import com.resources.OpenApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class QuotesPage extends OpenApplication {

    LoginPage loginPage = new LoginPage();

    public void createQuote(String compName, String quoteType) throws Exception {
        loginPage.login();
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

    public boolean verifyCreateQuote(String compName, String quoteType) throws Exception {
//        this.createQuote(compName, quoteType);
        loginPage.login();
        loginPage.driver.get("https://buzzworld-web-iidm.enterpi.com/all_quotes/3692b3bb-ecf5-443a-bb1b-f3dbf5f956d4");
        loginPage.wait.until(ExpectedConditions.visibilityOf(loginPage.po.quoteItems));
        boolean res;
        try {
            res = loginPage.po.quoteItems.isDisplayed();
            String quoteNumber = loginPage.driver.findElement(By.xpath("//*[@class='id-num']")).getText().replace("#", "");
            System.out.println("Quote is Created with: " + quoteNumber);
            System.out.println(loginPage.driver.getCurrentUrl());
        } catch (Exception e) {
            res = false;
        }
        Thread.sleep(1400);
        loginPage.openApplication.closeBrowser();
        return res;
    }

    public boolean selectDropDown(String compName) {
        List<WebElement> values = loginPage.driver.findElements(By.xpath("//*[contains(@class,'css-4mp3pp-menu')]/div/div"));
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
