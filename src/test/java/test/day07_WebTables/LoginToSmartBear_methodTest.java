package test.day07_WebTables;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

public class LoginToSmartBear_methodTest {
    /*
    Mini-Task:•Create a method called loginToSmartBear
    •This method simply logs in to SmartBear when you call it.
    •Accepts WebDriver type as parameter
     */

    static WebDriver driver;
    //we have to make our driver static since our method is static, static accepts only static

    @Test
    public void loginSmartBear_methodTest(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);

        driver.close();

    }

}

