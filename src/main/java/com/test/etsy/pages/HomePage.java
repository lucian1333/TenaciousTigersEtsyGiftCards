package com.test.etsy.pages;

import com.test.etsy.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath = "//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")
    WebElement signIn;
    @FindBy (xpath = "//input[@id='join_neu_email_field']")
    WebElement email;
    @FindBy(xpath = "//input[@id='join_neu_password_field']")
    WebElement password;
    @FindBy(name = "submit_attempt")
    WebElement signInSubmitButton;
    @FindBy (linkText = "Gifts & Gift Cards")
    WebElement giftsAndGiftCards;
    @FindBy(linkText = "Shop gift cards")
    WebElement shopGiftCards;
    @FindBy(linkText = "Redeem gift cards")
    WebElement redeemGiftCards;
    @FindBy (id = "aria-join_neu_email_field-error")
    WebElement errorMessageForEmail;
    @FindBy(id="aria-join_neu_password_field-error")
    WebElement errorMessageForPassword;
    @FindBy(xpath = "//h1[@class='welcome-message-text wt-hide-xs wt-show-lg wt-position-relative wt-text-center-xs wt-text-heading-01 wt-p-xs-3 wt-p-md-3']")
    WebElement welcomeMessage;
    public void SignIn(String username, String password) throws InterruptedException {
        signIn.click();
        Thread.sleep(1000);
        email.sendKeys(username);
        this.password.sendKeys(password);
        signInSubmitButton.click();
        Thread.sleep(1000);
    }

    public void HoverOverToGiftsAndGiftCards(WebDriver driver){
        Actions actions= new Actions(driver);
        actions.moveToElement(giftsAndGiftCards).perform();
    }

    public void ClickShopGiftCards(WebDriver driver) throws InterruptedException {
        HoverOverToGiftsAndGiftCards(driver);
        Thread.sleep(1000);
        shopGiftCards.click();
    }

    public void  ClickRedeemGiftCards(WebDriver driver) throws InterruptedException {
        HoverOverToGiftsAndGiftCards(driver);
        Thread.sleep(1000);
        redeemGiftCards.click();
    }

    public String ErrorMessageForEmail(){
        return BrowserUtils.getText(errorMessageForEmail);
    }

    public String ErrorMessageForPassword(){
        return BrowserUtils.getText(errorMessageForPassword);
    }

    public String WelcomeMessageAfterLogin(){
        return BrowserUtils.getText(welcomeMessage);

    }
}
