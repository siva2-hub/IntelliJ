package com.tests;

import com.pages.LoginPage;
import com.resources.OpenApplication;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ValidLoginTest extends OpenApplication {
    @Test
    public void loginTest(){
        LoginPage loginPage=new LoginPage();
        boolean testStatus = loginPage.verifyLoginValid(driver);
        Assert.assertTrue(testStatus);
    }
}
