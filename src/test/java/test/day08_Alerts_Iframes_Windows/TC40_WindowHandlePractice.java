package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC40_WindowHandlePractice {

    /*
    TC # 40: Window Handle practice
1. Create a new class called: WindowHandlePractice
2. Create new test and make set ups
3. Go to : http://practice.cybertekschool.com/windows
4. Assert: Title is “Practice”
5. Click to: “Click Here” text
6. Switch to new Window.
7. Assert: Title is “New Window”
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/windows");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void windowHandle_test() throws InterruptedException{

        String currentWindowHandle = driver.getWindowHandle();

        System.out.println("currentWindowHandle = " + currentWindowHandle);

        String actualCurrentPageTitle =  driver.getTitle();

        String expectedCurrentPageTitle = "Practice";

        //Assert: Title is “Practice”
        Assert.assertEquals(actualCurrentPageTitle, expectedCurrentPageTitle);

       //Click to: “Click Here” text
        WebElement clickHereText  = driver.findElement(By.linkText("Click Here"));

        clickHereText.click();

        Thread.sleep(1000);

       // driver.getWindowHandles() ==> will return Set of String because window handles are always unique

        for(String each : driver.getWindowHandles()){

            driver.switchTo().window(each);

            System.out.println(driver.getTitle());

            //Assert: Title is “New Window”
            String actualNewWindowTitle = driver.getTitle();

            String expectedNewWindowTitle ="New Window";

            if(actualNewWindowTitle.equals(expectedNewWindowTitle)) {

                Assert.assertEquals(expectedNewWindowTitle, actualNewWindowTitle);
                break;
            }

        }

        driver.switchTo().window(currentWindowHandle);

        System.out.println(driver.getTitle());

        System.out.println("Verifications passed!");

    }

    @AfterMethod
    public void teardown(){

        driver.close();

    }
}
