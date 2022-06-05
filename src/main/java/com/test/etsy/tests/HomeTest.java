package com.test.etsy.tests;

import com.test.etsy.TestBase;
import com.test.etsy.pages.HomePage;

import static org.testng.Assert.*;

import org.testng.annotations.*;


public class HomeTest extends TestBase {


    @Test
    public void validatePositiveLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SignIn("elifozdemir89+etsy@gmail.com", "TenaciousTigers");
        Thread.sleep(2000);
        assertTrue(homePage.WelcomeMessageAfterLogin().contains("Welcome to Etsy,"));
    }

    @Test
    public void validateNegativeLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SignIn("elifozdemir89+etsy@gmail.com", "abcabc");
        Thread.sleep(500);
        assertTrue(homePage.ErrorMessageForPassword().contains("Password was incorrect"));
    }

    @Test
    public void validateNegativeLoginTest2() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SignIn("elifozdemir89+etsy@gmail.c", "TenaciousTigers");
        Thread.sleep(500);
        assertTrue(homePage.ErrorMessageForEmail().contains("Email address is invalid"));
    }

    @Test
    public void validateClickingShopGiftCards() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        assertEquals(driver.getCurrentUrl(), "https://www.etsy.com/giftcards?ref=catnav-shop-gift-card");
    }

    @Test
    public void validateClickingRedeemGiftCards() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickRedeemGiftCards(driver);
        assertEquals(driver.getCurrentUrl(), "https://www.etsy.com/redeem?ref=catnav-redeem-gift-card");
    }



}