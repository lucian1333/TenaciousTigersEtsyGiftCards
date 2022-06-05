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

    @Test
    public void MakeBulkPurchase() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        WebElement Gifts= driver.findElement(By.id("catnav-primary-link--10"));
        Gifts.click();
        Thread.sleep(2000);
        WebElement giftCardPage=driver.findElement(By.xpath("//a[@href='https://www.etsy.com/giftcards?ref=ftr']"));
        giftCardPage.click();
        Thread.sleep(1000);
        WebElement bulkPurchase = driver.findElement(By.xpath("//p[contains(text(),'bulk gift')]"));
        String actualText=bulkPurchase.getText().trim();
        String expectedText="Want to make a bulk gift card purchase? Contact Etsy Support.";
        Assert.assertEquals(actualText,expectedText);
        WebElement link=driver.findElement(By.xpath("//a[@href='/help/contact']"));
        link.click();
        WebElement SignIn=driver.findElement(By.name("submit_attempt"));
        SignIn.isDisplayed();
        WebElement google=driver.findElement(By.xpath("//button[@data-google-button='true']"));
        google.isDisplayed();
        WebElement facebook=driver.findElement(By.xpath("//button[@data-facebook-button='true']"));
        facebook.isDisplayed();
        WebElement apple=driver.findElement(By.xpath("//a[@aria-describedby='aria-privacy-policy']"));
        apple.isDisplayed();
    }



}
