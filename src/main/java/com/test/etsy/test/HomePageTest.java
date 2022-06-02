package com.test.etsy.test;

import com.test.etsy.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.testng.annotations.*;

import java.io.File;


public class HomePageTest {
    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
    }

    @Test
    public void validatePositiveLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SignIn("elifozdemir89+etsy@gmail.com", "TenaciousTigers");
        Thread.sleep(2000);
        assertTrue(homePage.WelcomeMessageAfterLogin().contains("Welcome to Etsy,"));
    }

    @Test
    public void validateNegativeLoginTest() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.SignIn("elifozdemir89+etsy@gmail.com", "abcabc");
        Thread.sleep(500);
        assertTrue(homePage.ErrorMessageForPassword().contains("Password was incorrect"));
    }

    @Test
    public void validateNegativeLoginTest2()throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        homePage.SignIn("elifozdemir89+etsy@gmail.c", "TenaciousTigers");
        Thread.sleep(500);
        assertTrue(homePage.ErrorMessageForEmail().contains("Email address is invalid"));

    }

    @Test
    public void validateClickingShopGiftCards() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        assertEquals(driver.getCurrentUrl(),"https://www.etsy.com/giftcards?ref=catnav-shop-gift-card");
    }

    @Test
    public void validateClickingRedeemGiftCards() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        homePage.ClickRedeemGiftCards(driver);
        assertEquals(driver.getCurrentUrl(),"https://www.etsy.com/redeem?ref=catnav-redeem-gift-card");
    }

    @AfterClass
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }



}
