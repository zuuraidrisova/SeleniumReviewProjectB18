package test.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_CybertekTitleVerification {

    /*
   TC #2: Cybertek verifications
   1. Open Chrome browser
   2. Go to http://practice.cybertekschool.com
   3. Verify URL contains
        Expected: cybertekschool
   4. Verify title:
       Expected: Practice
    */

    public static void main(String[] args) throws InterruptedException {

        //  1. Open Chrome browser and sets up my web driver
        WebDriverManager.chromedriver().setup();

        //creates an instance of chrome browser
        WebDriver driver = new ChromeDriver();

        //maximizes the current window
        driver.manage().window().maximize();

        //gets the current url
        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(2000);//pauses the session for 2 seconds

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        //verifications happen
        if(expectedTitle.equals(actualTitle)){

            System.out.println("Title Verification passed!");
        }else{

            System.out.println("Title Verification failed!");
        }

        String expectedInUrl = "cybertekschool";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedInUrl)){

            System.out.println("Url contains cybertekschool.Passed!");
        }else{

            System.out.println("Url does not contain cybertekschool.Failed!");
        }


        driver.close();//closes the instance of chrome browser
    }
}
