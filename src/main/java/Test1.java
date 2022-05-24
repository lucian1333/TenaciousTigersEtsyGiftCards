import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Test1 {

    @BeforeClass


    @Test

    public void optionSendCardByEmail () {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/giftcards/");

        WebElement emailToRecipient = driver.findElement(By.xpath("//div[@class='wt-radio']//label[@for='medium-email']"));

        Assert.assertTrue(emailToRecipient.getText().trim().equals("Email to recipient"));






    }

    @Test
    public void changeTheCurrency() throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");

        WebElement signIn= driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));
        signIn.click();

        Thread.sleep(3000);

        WebElement email= driver.findElement(By.xpath("//input[@id='join_neu_email_field']"));
        WebElement password= driver.findElement(By.xpath("//input[@id='join_neu_password_field']"));
        WebElement sign= driver.findElement(By.name("submit_attempt"));
        email.sendKeys("elifozdemir89+etsy@gmail.com");
        password.sendKeys("TenaciousTigers");
        sign.click();

        Thread.sleep(3000);

        WebElement giftsAndGiftsCard=driver.findElement(By.linkText("Gifts & Gift Cards"));
        Actions actions= new Actions(driver);
        actions.moveToElement(giftsAndGiftsCard).perform();
        Thread.sleep(1000);
       WebElement shopGiftCards=driver.findElement(By.linkText("Shop gift cards"));
       shopGiftCards.click();
       String giftCardUrl= driver.getCurrentUrl();
       Assert.assertEquals(giftCardUrl, "https://www.etsy.com/giftcards?ref=catnav-shop-gift-card");

       Thread.sleep(1000);
       WebElement changeCurrency=driver.findElement(By.id("currency-picker"));
       Assert.assertTrue(changeCurrency.isDisplayed());

       changeCurrency.click();

       List<WebElement> currencies= driver.findElements(By.xpath("//button[@data-currency]"));

       for(WebElement currency:currencies){
           Assert.assertTrue(currency.isDisplayed());
       }

       takeSnapShot(driver, "/Users/elifokaynak/desktop/shot.png" );


    }

    @AfterMethod
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

}

