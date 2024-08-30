package com.tests;

import com.pages.LoginPage;
import com.resources.OpenApplication;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class InValidLoginTest extends OpenApplication {
    public void inValidLoginTest() throws Exception{
        LoginPage loginPage = new LoginPage(driver);
        boolean testStatus = loginPage.verifyInValidLogin();
        Assert.assertTrue(testStatus);
    }
}
