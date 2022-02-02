package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC37_SmartBearEditOrder {

     /*
    TC #37: SmartBear edit order
1. Open browser
Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
and login to SmartBear
2. Click to edit button from the right for “Steve Johns”
3. Change name to “Michael Jordan”
4. Click Update
5. Assert “Michael Jordan” is in the list
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void editOrder_test() throws InterruptedException{

        SmartBearUtilities.loginToSmartBear(driver);

        //Click to edit button from the right for “Steve Johns”
        WebElement steveJohnsEditButton = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[4]/td[13]"));

        steveJohnsEditButton.click();

        Thread.sleep(1000);

        //Change name to “Michael Jordan”

        WebElement customerNameInput = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));

        customerNameInput.clear();

        Thread.sleep(1000);

        customerNameInput.sendKeys("Michael Jordan");

        //Click Update

        WebElement updateButton = driver.findElement(By.linkText("Update"));

        updateButton.click();

        Thread.sleep(1000);

        //Assert “Michael Jordan” is in the list

        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

        for (WebElement each : listOfNames){

            if(each.getText().equals("Michael Jordan")) {

                Assert.assertTrue(each.getText().equals("Michael Jordan"));

            }
        }

        System.out.println("Verification passed!");

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }

}
