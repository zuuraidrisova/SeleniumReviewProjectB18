package test.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //abstract class is meant to be inherited, cannot create an object

    /*
    TESTBASE:
   PROBLEM: We have many repeated lines just to setup the driver and be able to use it.
      -> Create instance variable of the driver
      -> setUp:
         driver -> manager -> open with chrome
      -> maximize
      -> implicitWait

   How to handle this problem:
   All of these lines can be simplified by creating a TestBase class where we store
    them and get them(all of the setup, and/or teardown) when we need it.
     */
    protected WebDriver driver;//we make our driver protected so it is secure

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @AfterMethod
    public void tearDown(){

        driver.close();//will close current open window only

        //driver.quit();//will close all open windows
    }

}
