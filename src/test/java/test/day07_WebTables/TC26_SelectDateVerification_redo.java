package test.day07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC26_SelectDateVerification_redo {
     /*
TC #26: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select “December 1st, 1921” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void selectDateTest(){


        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        //Select year using : visible text
        yearDropdown.selectByVisibleText("1921");

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String expectedYear = "1921";

        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        //Select month using : value attribute
        monthDropdown.selectByValue("11");

        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String expectedMonth = "December";

        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        //Select day using : index number
        dayDropdown.selectByIndex(0);

        String actualDay = dayDropdown.getFirstSelectedOption().getText();
        String expectedDay = "1";

        //3. Select “December 1st, 1921” and verify it is selected.

        Assert.assertTrue(actualYear.equals(expectedYear));

        Assert.assertTrue(actualMonth.equals(expectedMonth));

        Assert.assertTrue(actualDay.equals(expectedDay));



    }

    @AfterMethod
    public void tearDown(){

       driver.close();
    }
}
