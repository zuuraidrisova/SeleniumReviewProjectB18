package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC31_TC32_DropdownPractices {

    /*
    TC#31: Cybertek “month”dropdown default value
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/dropdown
    3.Verify default value is always showing the current month
    Expected: If currently in June, should show June selected

   TC#32: Cybertek “month”dropdown list of default values verification
   1.Do both verifications in the same test
   2.Verify list of months are correct as expected.
   Expected: Options should contain all 12 months of the year.
    */
    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void verifyDefaultMonth(){

        //3.Verify default value is always showing the current month
        //    Expected: If currently in June, should show June selected
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String expectedMonth = LocalDate.now().getMonth().name();

        System.out.println("actualMonth = " + actualMonth);
        System.out.println("expectedMonth = " + expectedMonth);

        Assert.assertEquals(actualMonth.toLowerCase(), expectedMonth.toLowerCase());

        //another way ot checking
       // Assert.assertTrue(actualMonth.equalsIgnoreCase(expectedMonth));

        //1.Do both verifications in the same test
        //   2.Verify list of months are correct as expected.
        //   Expected: Options should contain all 12 months of the year.
        List<WebElement> dropdownOptions = monthDropdown.getOptions();

        List<String> actualMonthList = new ArrayList<>();

        for (WebElement each : dropdownOptions) {

            actualMonthList.add(each.getText());
        }

        List<String> expectedMonthList = new ArrayList<>(Arrays.asList("January", "February", "March", "April", "May", "June", "July"
                , "August", "September", "October", "November", "December"));


        Assert.assertTrue(actualMonthList.size() == expectedMonthList.size());

        Assert.assertEquals(actualMonthList,expectedMonthList);


    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }


}
