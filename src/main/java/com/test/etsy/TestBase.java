package com.test.etsy;

import com.test.etsy.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod // it will run before all of the other test annotations
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        Thread.sleep(2000);
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
