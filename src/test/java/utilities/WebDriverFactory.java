package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

     // we create and add repeated actions/methods inside this package
    // good for repeated actions, write once and use as needed, easy to maintain

    /*
    Task :
	- Write a static method in WebDriverFactory class
	- Return type is WebDriver
	- method name getDriver
	- it accepts one String argument, and returns the browser according to what string is passed
	- if "chrome" --> returns chrome browser
	- if "firefox" --> returns firefox browser
     */

    public static WebDriver getDriver(String browserType){

        browserType = browserType.toLowerCase();

        if(browserType.equals("chrome")){

            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();

        }else if(browserType.equals("firefox")){

            WebDriverManager.firefoxdriver().setup();

            return  new FirefoxDriver();

        }else if(browserType.equals("opera")){

            WebDriverManager.operadriver().setup();

            return new OperaDriver();

        }else if(browserType.equals("safari")){

            return new SafariDriver();

        }else{

            System.out.println("Given browser Type does not exists.Driver == null!");
            return null;
        }


    }
}
