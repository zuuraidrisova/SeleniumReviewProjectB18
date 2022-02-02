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

public class TC22_StateDropdownVerification {

    /*
  TC #22: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
these lines above have already been handled in beforeMethod
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
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
    public void selectStateVerification() throws InterruptedException{

      WebElement stateDropdown = driver.findElement(By.xpath("//select[@id='state']"));

      Select select = new Select(stateDropdown);

      Thread.sleep(1000);
       //3. Select Illinois by value
      select.selectByValue("IL");

      Thread.sleep(2000);
       //4. Select Virginia by visible text
      select.selectByVisibleText("Virginia");

      Thread.sleep(2000);
       //5. Select California by index
      select.selectByIndex(5);

      //Verify final selected option is California.
        String expectedOption = "California";
        String actualOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption);

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }

}
