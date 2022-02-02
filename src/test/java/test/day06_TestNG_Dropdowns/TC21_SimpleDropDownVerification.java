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

public class TC21_SimpleDropDownVerification {

    /*
TC#21: Verifying “Simple dropdown” and “State selection” dropdown default values
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    //3. Verify “Simple dropdown” default selected value is correct
    //Expected: “Please select an option”

    @Test
    public void verifySimpleDropdown(){

       WebElement simpleDropdown =  driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(simpleDropdown);

       String actualDropdownDefaultValue = select.getFirstSelectedOption().getText();
       String expectedDropdownDefaultValue = "Please select an option";

        Assert.assertEquals(actualDropdownDefaultValue,expectedDropdownDefaultValue);
    }

    //4. Verify “State selection” default selected value is correct
    //Expected: “Select a State”
    @Test
    public void verifyStateSelectionDropdown(){

      WebElement stateDropdown = driver.findElement(By.xpath("//select[@id='state']"));

      Select select = new Select(stateDropdown);

      String actualStateSelectionDefaultValue = select.getFirstSelectedOption().getText();
      String expectedStateSelectionDefaultValue = "Select a State";

      Assert.assertTrue(actualStateSelectionDefaultValue.equals(expectedStateSelectionDefaultValue));

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }

}
