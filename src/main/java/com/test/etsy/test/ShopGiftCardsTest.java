package com.test.etsy.test;

import com.test.etsy.pages.HomePage;
import com.test.etsy.pages.ShopGiftCards;
import com.test.etsy.utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class ShopGiftCardsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        HomePage homePage = new HomePage(driver);
     //  homePage.SignIn("elifozdemir89+etsy@gmail.com", "TenaciousTigers");
       Thread.sleep(2000);
        homePage.ClickShopGiftCards(driver);
    }

    @Test
    public void validateCurrencyIsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        ShopGiftCards shopGiftCards=new ShopGiftCards(driver);
        Assert.assertTrue(shopGiftCards.getChangeCurrency().isDisplayed());
    }

    @Test
    public void validateAllCurrenciesDisplayedAfterClickingChangeCurrency(){
        ShopGiftCards shopGiftCards=new ShopGiftCards(driver);
        shopGiftCards.clickChangeCurrency();
        for(WebElement currency:shopGiftCards.getCurrencies()){
            Assert.assertTrue(currency.isDisplayed());
        }
    }

    @Test
    public void validateOptionSendCardByEmailTest(){
        ShopGiftCards shopGiftCards=new ShopGiftCards(driver);
        Assert.assertTrue(BrowserUtils.getText(shopGiftCards.getEmailToRecipient()).equals("Email to recipient"));
    }

    @Test
    public void validateDesignTemplatesTest(){
        ShopGiftCards shopGiftCards=new ShopGiftCards(driver);
      for(  WebElement designTemp : shopGiftCards.getDesignTemplateList()) {
            Assert.assertTrue(designTemp.isDisplayed());
    }
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
    public void TearDown(){
        driver.close();
    }
}
