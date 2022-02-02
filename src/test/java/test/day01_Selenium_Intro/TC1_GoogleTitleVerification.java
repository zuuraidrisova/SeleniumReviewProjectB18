package test.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_GoogleTitleVerification {

/*
    TC #1: Google Title Verification
    1. Open Chrome browser
            set up my web driver
    2. Go to https://www.google.com
    3. Verify title: Expected: Google
     */

    public static void main(String[] args) {

        //  1. Open Chrome browser
        //            set up my web driver
        WebDriverManager.chromedriver().setup();

        // create an instance of my chrome driver
        WebDriver driver = new ChromeDriver();

        //maximizes the window
        driver.manage().window().maximize();

        //gets the given url
        driver.get("https://www.google.com");

        String expectedTitle= "Google";
        String actualTitle = driver.getTitle();//gets the current page title as string

        if(expectedTitle.equals(actualTitle)){

            System.out.println("Verification passed!");
        }else{

            System.out.println("Verification failed!");
        }

        driver.close();


    }
}
