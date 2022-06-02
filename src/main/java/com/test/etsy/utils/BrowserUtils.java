package com.test.etsy.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement element, String value, String methodName){

        Select select =new Select(element);
        switch(methodName){
            case "text" :
                select.selectByVisibleText(value);
                break;
            case "value" :
                select.selectByValue(value);
                break;
            case "index" :
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available");
        }

    }

    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString(); //it gets the title
    }

    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }

    public static void scrollWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

    }

    public static void switchById(WebDriver driver, String mainID){
        Set<String> windowIDs= driver.getWindowHandles();
        for (String id:windowIDs){
            if (!id.equals(mainID)){
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver,String title){
        Set<String> allIds= driver.getWindowHandles(); //4
        for (String id:allIds){
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }

}
