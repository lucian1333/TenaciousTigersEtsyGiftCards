package com.test.etsy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopGiftCardsPage {
    public ShopGiftCardsPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "currency-picker")
      WebElement changeCurrency;

    @FindBy(xpath = "//button[@data-currency]")
    List<WebElement> currencies;

    @FindBy(xpath = "//div[@class='wt-radio']//label[@for='medium-email']")
    WebElement emailToRecipient;
    @FindBy(xpath = "//span[@class='wt-grid__item-xs-4 wt-grid__item-md-4 wt-grid__item-lg-3 wt-grid__item-xl-3 wt-p-xs-0']")
    List<WebElement> designTemplateList;

    public void clickChangeCurrency(){
        changeCurrency.click();
    }


    public WebElement getChangeCurrency() {
        return changeCurrency;
    }

    public List<WebElement> getCurrencies() {
        return currencies;
    }

    public WebElement getEmailToRecipient() {
        return emailToRecipient;
    }

    public List<WebElement> getDesignTemplateList() {
        return designTemplateList;
    }
}
