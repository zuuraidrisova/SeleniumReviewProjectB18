package test.day06_TestNG_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC23_SelectingDateVerification {
     /*
TC #23: Selecting date on dropdown and verifying
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
    public void selectDate_test() throws InterruptedException{



       WebElement yearDropdown =  driver.findElement(By.xpath("//select[@id='year']"));
       WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='month']"));
       WebElement dayDropdown = driver.findElement(By.xpath("//select[@id='day']"));

        Select yearSelect = new Select(yearDropdown);
        Select monthSelect = new Select(monthDropdown);
        Select daySelect = new Select(dayDropdown);

        //Select year using : visible text
        yearSelect.selectByVisibleText("1921");

       String actualYear = yearSelect.getFirstSelectedOption().getText();
       String expectedYear = "1921";

        //Select month using : value attribute
        monthSelect.selectByValue("11");

        String actualMonth = monthSelect.getFirstSelectedOption().getText();
        String expectedMonth = "December";

        //Select day using : index number
        daySelect.selectByIndex(0);

        String actualDay = daySelect.getFirstSelectedOption().getText();
        String expectedDay = "1";

        Thread.sleep(2000);

        //3. Select “December 1st, 1921” and verify it is selected.

        Assert.assertEquals(actualYear, expectedYear);

        Assert.assertEquals(actualMonth, expectedMonth);

        Assert.assertEquals(actualDay, expectedDay);

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }
}
