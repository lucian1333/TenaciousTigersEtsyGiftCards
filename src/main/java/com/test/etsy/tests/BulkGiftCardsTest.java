package com.test.etsy.tests;

import com.test.etsy.TestBase;
import com.test.etsy.pages.HomePage;
import com.test.etsy.pages.ShopGiftCardsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BulkGiftCardsTest extends TestBase {
    //This test only verified customer support link works because this is live site
    @Test(priority = 1)
    public void MakeBulkPurchase() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.SignIn("elifozdemir89+etsy@gmail.com", "TenaciousTigers");
        Thread.sleep(2000);
        assertTrue(homePage.WelcomeMessageAfterLogin().contains("Welcome to Etsy,"));
        homePage.ClickShopGiftCards(driver);
        Thread.sleep(2000);
        ShopGiftCardsPage shopGiftCards=new ShopGiftCardsPage(driver);
        WebElement bulkPurchase = driver.findElement(By.xpath("//p[contains(text(),'bulk gift')]"));
        String actualText=bulkPurchase.getText().trim();
        String expectedText="Want to make a bulk gift card purchase? Contact Etsy Support.";
        Assert.assertEquals(actualText,expectedText);
        WebElement linkBulk=driver.findElement(By.xpath("//a[@href='/help/contact']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",linkBulk);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()",linkBulk);
    }
}
