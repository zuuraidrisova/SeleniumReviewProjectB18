package test.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {


    public static void main(String[] args) {

        //1- This line creates the connection between driver and selenium.
        // And sets up the driver.
        WebDriverManager.chromedriver().setup();

        //2- Creating the instance of ChromeDriver to be able to do action on ChromeBrowser
        WebDriver driver = new ChromeDriver();

        //3- This methods gets the given URL in an open browser.
        driver.get("https://www.google.com");


    }
}
