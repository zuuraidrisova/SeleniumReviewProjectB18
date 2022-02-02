package test.day09_TestBase_Properties_DriverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DriverUtilPractice {

    @Test
    public void driver_practice(){

        //now below line will set up driver, open chrome and go to given url altogether
        Driver.getDriver().get("https://www.google.com");

        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));

        googleSearch.sendKeys(ConfigurationReader.getProperty("testdata") + Keys.ENTER);

        Driver.getDriver().close();


    }

}
