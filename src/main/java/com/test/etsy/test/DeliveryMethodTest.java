package com.test.etsy.test;

import com.test.etsy.TestBase;
import com.test.etsy.pages.DeliveryMethodPage;
import com.test.etsy.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeliveryMethodTest extends TestBase {

    /*
    TC-01 When I first access the gift card page,
    the radio button for Email to Recipient is selected

    TC-02 I can instead choose Email to you (printable)
    and go back to Email to recipient

    TC-03 The option that is selected shows a bolded padding
     inside the radio button circle

    TC-04 If I choose email to recipient, the following
    fields are shown: To: Recipient's Name (required);
    Recipient's Email (required); Gift message (optional);
    From: Sender's Name (required). If I try to submit the
    form without filling in the required fields,
    I receive an error

    TC-05 If I choose email to you (printable), the
    following fields are shown: To: Recipient's Name
    (required); Gift message (optional); From:
     Sender's Name (required)

    TC-06 If I add the item to my cart, the delivery method
     I selected is preserved

    TC-07 If I choose Email to recipient and purchase the
    gift card, an email is sent to the address in the
    Recipient's email field.

    TC-08 If I choose Email to you (printable) and purchase
    the gift card, an email is sent to the address in the
    profile of the shopper.
     */

    public WebDriver driver;

    @BeforeMethod // it will run before all of the other test annotations
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        Thread.sleep(2000);
    }

    @Test
    public void validateDeliveryMethodSelection() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.ClickShopGiftCards(driver);
        DeliveryMethodPage deliveryMethodPage = new DeliveryMethodPage(driver);
        deliveryMethodPage.emailToRecipientSelection();

    }


}
