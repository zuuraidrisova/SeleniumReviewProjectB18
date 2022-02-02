package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TC41_WindowHandleAmazonPractice {
    /*
    TC-WarmUp # : Window Handle practice
1. Create a new class called: WindowHandleWarmup
2. Create new test and make set ups
3. Go to : https://www.amazon.com
4. Copy paste the lines from below into your class
5. Create a logic to switch to the tab where Etsy.com is open
6. Assert: Title contains “Etsy”

Lines to be pasted:
((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
These lines will simple open new tabs using something called JavaScriptExecutor
and get those pages. We will learn JavaScriptExecutor later as well.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void multiple_windowHandleAmazon_test(){

        driver.get("https://www.amazon.com");

        //we are downcasting our driver to JavaScriptExecutor to be able to use its methods
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //Create a logic to switch to the tab where Etsy.com is open

        Set<String> windowHandles =  driver.getWindowHandles();//to store all window handles

       for (String  each: windowHandles){//loop thru all window handles

           driver.switchTo().window(each);

           System.out.println("Current title: "+driver.getTitle());

           // Assert: Title contains “Etsy”
           if(driver.getCurrentUrl().contains("etsy")){

               Assert.assertTrue(driver.getTitle().contains("Etsy"));

               break;
           }
       }

    }

    @AfterMethod
    public void teardown(){

       driver.close();

    }

}
