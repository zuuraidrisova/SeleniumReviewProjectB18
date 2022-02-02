package test.day06_TestNG_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC24_SelectingFromMultipleDropdown {

     /*
    TC #24: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
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
    public void selectFromMultipleDropdown_test() throws InterruptedException{
//3. Select all the options from multiple select dropdown.
//4. Print out all selected values.
//5. Deselect all values.

       Select allOptions = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

       allOptions.selectByValue("java");

       Thread.sleep(1000);

       allOptions.selectByIndex(1);

       Thread.sleep(1000);

       allOptions.selectByVisibleText("C#");

       Thread.sleep(1000);

        allOptions.selectByVisibleText("Python");

        Thread.sleep(1000);

        allOptions.selectByValue("ruby");

        Thread.sleep(1000);

        allOptions.selectByIndex(5);

        List<WebElement> allOptionsList = allOptions.getAllSelectedOptions();

        for (WebElement each : allOptionsList){

            String eachOption = each.getText();

            System.out.println("eachOption = " + eachOption);

        }


        allOptions.deselectAll();

        Thread.sleep(1000);

    }

    @AfterMethod
    public void teardown(){

      driver.close();
    }

}
