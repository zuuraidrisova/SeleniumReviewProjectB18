package test.day07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC29_SmartBearOrderVerification {
    /*
    TC#29: Smartbear software order verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 and login to Smartbear software
3. Verify Susan McLaren has order on date “01/05/2010”
     */
    static WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);

    }


    @Test
    public void smartBearOrder_verification(){

        //3. Verify Susan McLaren has order on date “01/05/2010”

        WebElement susanOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[6]/td[5]"));

        String expectedOrderDate = "01/05/2010";
        String actualOrderDate = susanOrderDate.getText();

        Assert.assertEquals(actualOrderDate, expectedOrderDate);

    }


    @AfterMethod
    public void teardown(){

        driver.close();
    }
}
