package com.resources;

import com.pages.PageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Map;

public class OpenApplication {

    public WebDriver driver;
    public PageObjects po;
    public WebDriverWait wait;
    public Actions actions;
    @BeforeSuite
    public void openBrowser() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("pageURL");
        driver.get(url);
        po = new PageObjects(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(po.email));
        po.email.sendKeys("defaultuser@enterpi.com");
        po.password.sendKeys("Enter@4321");
        po.signIn.click();
        wait.until(ExpectedConditions.visibilityOf(po.companyLogo));
    }

    public void closeBrowser() {
        driver.close();
    }
}
