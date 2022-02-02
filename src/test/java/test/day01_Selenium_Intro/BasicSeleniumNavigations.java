package test.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumNavigations {

    /*
   Selenium Navigations:

       back() : takes us to previous page

       forward() :  takes us to forwarded page

       refresh():  refreshes the page

       to() : takes us to another given url

    */
    public static void main(String[] args) throws InterruptedException {

        //1- This line creates the connection between driver and selenium.
        // And sets up the driver.
        WebDriverManager.chromedriver().setup();

        //2- Creating the instance of ChromeDriver to be able to do action on ChromeBrowser
        WebDriver driver = new ChromeDriver();

        //manage().window().maximize();
        driver.manage().window().maximize(); //this line makes whole window, maximizes it

        //3- This methods gets the given URL in an open browser.
        driver.get("https://www.google.com");

        String googleTitle =driver.getTitle();
        String googleUrl = driver.getCurrentUrl();

        System.out.println("googleTitle = " + googleTitle);
        System.out.println("googleUrl = " + googleUrl);

        //Basic Selenium Navigations:

        Thread.sleep(2000);//to add 2 seconds of wait
        driver.navigate().back();//this line will take you to previous page

        Thread.sleep(2000);//method is added to see selenium movements
        driver.navigate().refresh();//this line will refresh  the page

        /*
        these both do the same thing, but only difference is :
        driver.get() : will wait the page to be loaded before continuing

        navigate().to() : does not wait the whole page to be downloaded
         */

        driver.navigate().to("https://www.facebook.com");

        //getTitle(); ==> returns title of the web page as string, does not take any parameter
        String facebookTitle = driver.getTitle();

        System.out.println("facebookTitle = " + facebookTitle);

        //getCurrentUrl(); ==> returns the url of the current web page as string, does not take any parameter
        String facebookUrl = driver.getCurrentUrl();

        System.out.println("facebookUrl = " + facebookUrl);

        //getPageSource(); method which returns whole page source of the current browser as a string
        String pageSource =  driver.getPageSource();

        //System.out.println("pageSource = " + pageSource);
        //it works, pageSource is too long in console, so just comment out for now

        //close() ==> closes just the current open browser
        //quit() ==>closes all tabs and ends the session

        Thread.sleep(2000);
        driver.close();//closes the driver instance

    }
}
