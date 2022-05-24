import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 {

    @Test

    public void optionSendCardByEmail () {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/giftcards/");

        WebElement emailToRecipient = driver.findElement(By.xpath("//div[@class='wt-radio']//label[@for='medium-email']"));

        Assert.assertTrue(emailToRecipient.getText().trim().equals("Email to recipient"));






    }

    @Test
    public void designTemplateValidation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/giftcards/");

        List<WebElement> designTemplateList = driver.findElements(By.xpath("//span[@class='wt-grid__item-xs-4 wt-grid__item-md-4 wt-grid__item-lg-3 wt-grid__item-xl-3 wt-p-xs-0']"));
        Thread.sleep(3000);
        for(WebElement designTemp : designTemplateList){
            Thread.sleep(3000);
            designTemp.click();
            Assert.assertTrue(designTemp.isDisplayed());
        }


    }


}
