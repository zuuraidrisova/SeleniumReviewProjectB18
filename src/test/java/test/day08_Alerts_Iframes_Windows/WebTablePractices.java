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

public class WebTablePractices {

    /*
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
     */
    static WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void verifyOrder(){

        SmartBearUtilities.loginToSmartBear(driver);

        verifyOrder_2(driver, "Paul Brown");

        printNamesAndCities_2(driver);

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }
    /*
    PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in SmartBearUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
     */

    public static void verifyOrder_2(WebDriver driver, String expectedName){

        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

        String actualName = "";

        for (WebElement eachName : listOfNames){

            if(eachName.getText().equals(expectedName)) {

                actualName += eachName.getText();
            }
        }

        Assert.assertEquals(actualName, expectedName);
    }

    /*
    Practice #5: Method: printNamesAndCities
• Create a method named printNamesAndCities in SmartBearUtils class.
• Method takes WebDriver object.
• This method should simply print all the names in the List of All Orders.
• Create a new TestNG test to test if the method is working as expected.
• Output should be like:
• Name1: name , City1: city
• Name2: name , City2: city
     */

    public static void  printNamesAndCities_2(WebDriver driver){

        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
        List<WebElement> listOfCities = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[7]"));

        for (int i = 0; i < listOfNames.size(); i++){

            System.out.println("Name "+(i+1) +" : "+listOfNames.get(i).getText()

              +", City "+(i+1)+" : "+listOfCities.get(i).getText()

            );

        }
    }





}
