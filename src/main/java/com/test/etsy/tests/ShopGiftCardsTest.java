package com.test.etsy.tests;

import com.test.etsy.TestBase;
import com.test.etsy.pages.HomePage;
import com.test.etsy.pages.ShopGiftCardsPage;
import com.test.etsy.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    @Test
    public void addMessageToGiftCard() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        Thread.sleep(2000);
        ShopGiftCardsPage shopGiftCards = new ShopGiftCardsPage(driver);
        shopGiftCards.addMessage("I hope you love your gift!"); Thread.sleep(2500);
    }

}