package test.day02_FindElement_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_EtsyTitleVerification_IdLocator {
    /*
    TC #5: EtsyTitle Verification
    1.Open Chrome browser
    2.Go to https://www.etsy.com
    3.Search for “wooden spoon”
    4.Verify title: Expected: “Wooden spoon | Etsy"
     */

    public static void main(String[] args) {

        /*
        4- id:
    --> id is one of the 8 locators in Selenium
    --> id will locate by matching id attribute's value
    --> id is unique for that specific web element
    --> if you have id and it is not dynamic (meaning the attribute value is not
    changing when you refresh the page) you should always use id
    syntax: driver.findElement(By.id("id attribute's value"))
         */

        //connects selenium and browser
        WebDriverManager.chromedriver().setup();

        //opens chrome browser
        WebDriver driver = new ChromeDriver();

        //makes window fullscreen
        driver.manage().window().maximize();

        //opens given url
        driver.get("https://www.etsy.com");

        //locating web element to be able to do action on it
        WebElement searchInput = driver.findElement(By.id("global-enhancements-search-query"));

        //searching wooden spoon by writing it actually
        searchInput.sendKeys("wooden spoon"+ Keys.ENTER);

        //Keys.ENTER ==> presses the enter keyboard

        //title verification using if else

        String expectedInTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedInTitle)){

            System.out.println("Etsy Title Verification Passed!");
        }else{

            System.out.println("Etsy Title Verification Failed!");
        }
    }
}
