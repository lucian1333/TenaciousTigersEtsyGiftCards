package com.test.etsy.pages;

import com.test.etsy.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DeliveryMethodPage extends TestBase {

    public DeliveryMethodPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//fieldset[@data-selector='giftcards-editor-medium-picker']//div//input")
    List<WebElement> radioButtons;

    @FindBy(xpath = "//div[@class='wt-radio']//label[@for='medium-email']") //--> this is label
    WebElement emailToRecipientMessage;

    @FindBy(xpath = "//input[@id='medium-email']") // --> this is radio button
    WebElement emailToRecipientButton;

    @FindBy(xpath = "//div[@class='wt-radio']//label[@for='medium-print']") //--> this is label
    WebElement emailToSelfMessage;

    @FindBy(xpath = "//input[@id='medium-print']") // --> this is radio button
    WebElement emailToSelfButton;

    @FindBy(xpath = "//input[@id='recipient_name']")
    WebElement recipientName;

    @FindBy(xpath = "//textarea[@placeholder='Gift message (optional)']")
    WebElement optionalMessage;

    @FindBy(xpath = "//input[@name='sender_name']")
    WebElement sender;

    @FindBy(id = "recipient_email")
    WebElement recipientEmail;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full']")
    WebElement addToCartButton;

    public void emailToRecipientSelection() throws InterruptedException {


        for(WebElement button : radioButtons){
            button.click();
            if(emailToRecipientButton.isSelected()){
                Assert.assertTrue(recipientName.isDisplayed());
                Assert.assertTrue(recipientEmail.isDisplayed());
                Assert.assertTrue(optionalMessage.isDisplayed());
                Assert.assertTrue(sender.isDisplayed());
                break;
            }else if(emailToSelfButton.isSelected()){
                Assert.assertTrue(recipientName.isDisplayed());
                Assert.assertTrue(optionalMessage.isDisplayed());
                Assert.assertTrue(sender.isDisplayed());
            }
        }


    }





}
