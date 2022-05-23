import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

    @Test

    public void optionSendCardByEmail () {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/giftcards/");

        WebElement emailToRecipient = driver.findElement(By.xpath("//div[@class='wt-radio']//label[@for='medium-email']"));

        Assert.assertTrue(emailToRecipient.getText().trim().equals("Email to recipient"));






    }


}
