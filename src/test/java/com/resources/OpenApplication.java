package com.resources;

import com.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OpenApplication {

    public WebDriver driver;

    @BeforeTest
    public void openBrowser() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("pageURL");
        System.out.println(url);
        driver.get(url);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
