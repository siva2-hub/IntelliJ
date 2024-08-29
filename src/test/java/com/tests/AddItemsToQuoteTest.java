package com.tests;

import com.pages.QuotesPage;
import com.resources.OpenApplication;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddItemsToQuoteTest extends OpenApplication {
    @Test
    public void addItemsTest() throws Exception {
        QuotesPage quotesPage=new QuotesPage();
        Object[] res=quotesPage.verifyAddItemsToQuote("331EARH");
        Assert.assertTrue((Boolean) res[2]);
    }
}
