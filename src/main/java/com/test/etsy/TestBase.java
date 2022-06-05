package com.test.etsy;

import com.test.etsy.pages.HomePage;
import com.test.etsy.utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod // it will run before all of the other test annotations
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenshot(driver, "etsy");
        driver.close();
    }



}
