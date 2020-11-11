package test.day02_FindElement_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC7_ZeroBankHeaderVerification_TagNameLocator {
    /*
    TC #7: Zero Bank header verification
    1.Open Chrome browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Verify header textExpected: “Log in to ZeroBank"
     */

    public static void main(String[] args) {
/*
6- tagName :
    --> tagName is one of the 8 locators in the Selenium
    --> tagName locates using the tagName itself
    --> the use case for this locator is very small
    --> usually good for when you want to locate all of the same type of web Elements
    --> for example : if you want to return all of the links on the page you can use it with findElements
    syntax : driver.findElements(By.tagName("a"))
 */
        //creates connection between selenium code and browser
        WebDriverManager.chromedriver().setup();

        //opens chrome browser
        WebDriver driver = new ChromeDriver();

        //makes window fullscreen
        driver.manage().window().maximize();

        //opens given url in an open browser
        driver.get("http://zero.webappsecurity.com/login.html");

        //locating the header
        WebElement header = driver.findElement(By.tagName("h3"));

        //verifying the header text

       String expectedHeaderText = "Log in to ZeroBank";
       String actualHeaderText = header.getText(); //getting the text of a tag

       if(actualHeaderText.equals(expectedHeaderText)){

           System.out.println("Bank Header Text Verification Passed!");

       }else{

           System.out.println("Bank Header Text Verification Failed!");
       }

       driver.close();
    }
}
