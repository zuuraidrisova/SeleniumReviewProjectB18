package test.day07_WebTables;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class VerifyOrderMethod_test {

    static WebDriver driver;//we have to make our driver static, since our methods are static

    //STATIC ACCEPTS ONLY STATIC

    @Test
    public void verifyOrder_test(){

        //SET UP DRIVER AND OPEN CHROME BROWSER
        driver = WebDriverFactory.getDriver("chrome");

        //  make window full screen
        driver.manage().window().maximize();

        //go to given url and open it in an open browser
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //wait until page is loaded
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //login to web page using our utility method
        SmartBearUtilities.loginToSmartBear(driver);

        //checking of name exists in the list
        SmartBearUtilities.verifyOrder(driver, "Bob Feather");

        //closing the browser
        driver.close();
    }
}
