package test.day07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC31_TC32_MonthDropdownVerification {
    /*
    TC#31: Cybertek “month”dropdown default value
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/dropdown
    3.Verify default value is always showing the current month
    Expected: If currently in June, should show June selected
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void verifyMonthDefaultValue(){

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String expectedMonth = LocalDateTime.now().getMonth().name();

        System.out.println("actualMonth = " + actualMonth);
        System.out.println("expectedMonth = " + expectedMonth);

        Assert.assertEquals(actualMonth.toUpperCase(),expectedMonth);


    }

    /*
    TC#32: Cybertek “month”dropdown list of default values verification
    1.Do both verifications in the same test
    2.Verify list of months are correct as expected.
    Expected: Options should contain all 12 months of the year.
     */
    @Test(priority = 2)
    public void verifyListOfMonth(){

        //Create a list of Strings and write all the months in the year.
        // This will be our expected values.
        List<String> expectedListOfMonth = new ArrayList<>();

        expectedListOfMonth.addAll(Arrays.asList("January", "February", "March", "April", "May", "June", "July"
                , "August", "September", "October", "November", "December"));

        // 2.Get all the actual options from the select dropdown
        // and store it in a list of web elements
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        List<WebElement> listOfMonthWebelements = selectMonth.getOptions();

        // 3.You cannot compare a list of webelements with a list of strings.
        // 4.Create a list of strings, ArrayList.This list will act as our container.
       List<String> actualListOfMonth = new ArrayList<>();

        // 5.You need to store the values in the list of web elements, get their
        // string values and add those values into the previously created container list.

        for (WebElement each : listOfMonthWebelements){

           String eachMonth = each.getText();

           actualListOfMonth.add(eachMonth);

       }


        System.out.println("expectedListOfMonth = " + expectedListOfMonth);
        System.out.println("actualListOfMonth = " + actualListOfMonth);

        // 6.You can direcly assert.equalsbothlists.
        // 7.If both lists contains same item, your assertion will pass.
        Assert.assertEquals(actualListOfMonth, expectedListOfMonth);


    }


    @AfterMethod
    public void teardown(){

        driver.close();
    }
}

