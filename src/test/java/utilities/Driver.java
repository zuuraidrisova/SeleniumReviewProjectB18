package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    //1- Make constructor private
    private Driver(){//make constructor private so no one can create an object of the class

    }

    private static WebDriver driver;
    // private ==> we dont want any access to the driver from outside
    // static ==> because  we are gonna use driver in static method

    //static method because we want to call the method thru class name
    // without creating an object of the class
    public static WebDriver getDriver(){

        if(driver == null){//we will create an instance of driver if only it is null

            // we get the browser thru our getProperty method
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;

                case "chrome=headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firefox=headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

            }
        }

        return driver;
    }


    public static void closeDriver(){

        if(driver != null){//if there is any browser assigned

            driver.close();//then close it

            driver = null;//and assign it to its initial default value
        }
    }

}
