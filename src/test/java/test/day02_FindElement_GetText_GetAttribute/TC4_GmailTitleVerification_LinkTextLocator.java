package test.day02_FindElement_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_GmailTitleVerification_LinkTextLocator {
     /*
    TC #4: Back and forth navigation
    1-Open a chrome browser
    2-Go to: https://google.com
    3-Click to Gmail from top right.
    4-Verify title contains:Expected: Gmail
    5-Go back to Google by using the .back();
    6-Verify title equals:
            Expected: Google
     */

    public static void main(String[] args) throws InterruptedException {

        /*
        LinkText is one of the 8 locators in Selenium
           2.linkText ==> it allows user to locate links by their text
                Only works only links,
                i know it is link by <a> webelement
                <a href = "https://www.google.com"> TEXT HERE </a>
         */

        //creates connection between selenium code and browser
        WebDriverManager.chromedriver().setup();

        //opens chrome browser
        WebDriver driver = new ChromeDriver();

        //makes window fullscreen
        driver.manage().window().maximize();

        //opens given url in an open browser
        driver.get("https://google.com");

        //locating gmail web element
        WebElement gmailText = driver.findElement(By.linkText("Gmail"));

        Thread.sleep(2000);//pausing the session for 2 seconds in order to avoid exceptions

        //clicking to gmail web element
        gmailText.click();

        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedInTitle)){

            System.out.println("Gmail Title Verification Passed");
        }else{

            System.out.println("Gmail Title Verification Failed");

        }


        driver.navigate().back();//goes back to previous page

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if(actualGoogleTitle.equals(expectedGoogleTitle)){

            System.out.println("Google Title Verification Passed");

        }else{

            System.out.println("Google Title Verification Passed");
        }

        driver.close();

    }
}
