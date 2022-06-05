package com.test.etsy.test;

import com.test.etsy.TestBase;
import com.test.etsy.pages.HomePage;
import com.test.etsy.pages.ShopGiftCardsPage;
import com.test.etsy.utils.BrowserUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class ShopGiftCardsTest extends TestBase {

    @Test
    public void validateCurrencyIsDisplayed() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        Thread.sleep(2000);
        ShopGiftCardsPage shopGiftCards=new ShopGiftCardsPage(driver);
        Assert.assertTrue(shopGiftCards.getChangeCurrency().isDisplayed());
    }
    @Test
    public void validateAllCurrenciesDisplayedAfterClickingChangeCurrency() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        Thread.sleep(2000);
        ShopGiftCardsPage shopGiftCards=new ShopGiftCardsPage(driver);
        shopGiftCards.clickChangeCurrency();
        for(WebElement currency:shopGiftCards.getCurrencies()){
            Assert.assertTrue(currency.isDisplayed());
        }
    }
    @Test
    public void validateOptionSendCardByEmailTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        Thread.sleep(2000);
        ShopGiftCardsPage shopGiftCards=new ShopGiftCardsPage(driver);
        Assert.assertTrue(BrowserUtils.getText(shopGiftCards.getEmailToRecipient()).equals("Email to recipient"));
    }
    @Test
    public void validateDesignTemplatesTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        Thread.sleep(2000);
        ShopGiftCardsPage shopGiftCards=new ShopGiftCardsPage(driver);
      for(  WebElement designTemp : shopGiftCards.getDesignTemplateList()) {
            Assert.assertTrue(designTemp.isDisplayed());
    }
    }

//    @AfterClass
//    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//        //Convert web driver object to TakeScreenshot
//        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//        //Call getScreenshotAs method to create image file
//        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//        //Move image file to new destination
//        File DestFile=new File(fileWithPath);
//        //Copy file at destination
//        FileUtils.copyFile(SrcFile, DestFile);
//    }


}