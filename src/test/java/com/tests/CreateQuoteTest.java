package com.tests;

import com.pages.QuotesPage;
import com.resources.OpenApplication;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateQuoteTest extends OpenApplication {

    @Test
    public void createQuoteTest() throws Exception {
        QuotesPage quotesPage = new QuotesPage();
        boolean testResults = quotesPage.verifyCreateQuote("MULTI00", "Parts Quote");
        Assert.assertTrue(testResults);
    }

}
