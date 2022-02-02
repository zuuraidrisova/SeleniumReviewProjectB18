package test.day06_TestNG_Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){//creating driver and setting it up and opening chrome browser
        //open browser, go to : https://www.google.com

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com");

    }


    @Test (priority = 1)
    public void googleTitleTest(){

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test (priority = 2)
    public void googleSearchTitleTest(){

        //search apple
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

        //verify title contains apple
        String actualTitle = driver.getTitle();
        String expectedInTitle = "apple";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }


    @AfterMethod
    public void tearDown(){//closing the browser instances

        driver.close();
    }



}
