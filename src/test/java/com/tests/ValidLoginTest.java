package com.tests;

import com.pages.LoginPage;
import com.resources.OpenApplication;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ValidLoginTest extends OpenApplication {
    @Test
    public void loginTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        boolean testStatus = loginPage.verifyLoginValid();
        Assert.assertTrue(testStatus);
    }
}
