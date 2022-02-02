package test.day09_TestBase_Properties_DriverUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;

public class WindowHandlePractice_withTestBase extends TestBase {

    //Because we are extending out TestBase class , we dont have to do setUp and
    // tearDown since we are inheriting these methods

    /*
    TC-WarmUp -41 # : Window Handle practice
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

    @Test
    public void multiple_windowHandleAmazon_test(){

        driver.get("https://www.amazon.com");

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //Create a logic to switch to the tab where Etsy.com is open

        for (String  each: driver.getWindowHandles()){

            driver.switchTo().window(each);
            System.out.println("Current title: "+driver.getTitle());

            // Assert: Title contains “Etsy”
            if(driver.getCurrentUrl().contains("etsy")){

                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }

    }

}
