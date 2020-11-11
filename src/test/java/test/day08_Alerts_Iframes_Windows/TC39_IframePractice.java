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

public class TC39_IframePractice {
    /*
    TC #39 : Iframe practice
1. Create a new class called: IframePractice
2. Create new test and make set ups
3. Go to: http://practice.cybertekschool.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get(" http://practice.cybertekschool.com/iframe");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iframe_test(){

       // locating iframe as webelement and switching to it
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        //switching to iframe using web element
        driver.switchTo().frame(iframe);

        //Assert: “Your content goes here.” Text is displayed.
        WebElement yourContextGoesHereText = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourContextGoesHereText.isDisplayed());

        //assert the actual and expected value
        String actualText = yourContextGoesHereText.getText();
        String expectedText = "Your content goes here.";

        Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));

        //WE HAVE TO SWITCH BACK TO DEFAULT HTML TO BE ABLE TO LOCATE ANYTHING IN THERE

        //to switch back to original iframe
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent(); ==> both switch to the original iframe

        //Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        WebElement h3HeaderText = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(h3HeaderText.isDisplayed());

        //assert the actual and expected value
        String actualIframeText = h3HeaderText.getText();
        String expectedIframeText = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertTrue(actualIframeText.equals(expectedIframeText));

        System.out.println("Both verifications passed!");

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }
}
