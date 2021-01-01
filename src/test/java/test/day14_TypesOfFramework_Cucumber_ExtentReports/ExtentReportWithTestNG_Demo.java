package test.day14_TypesOfFramework_Cucumber_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class ExtentReportWithTestNG_Demo {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test1;
    WebDriver driver;

    @BeforeTest
    public void setUp(){

        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter("extent.html");

        // initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();

        // attach only HtmlReporter
        extent.attachReporter(htmlReporter);

    }

    @Test
    public void test(){

        test1 = extent.createTest("Google Search Functionality Validation");

        driver = WebDriverFactory.getDriver("chrome");

        test1.log(Status.INFO,"Starting test case");

        driver.get("https://www.google.com");

        test1.pass("Navigated to google search page");

        driver.findElement(By.name("q")).sendKeys("Automation Step by Step" + Keys.ENTER);

        test1.pass("Entered text into search box and pressed Enter key");


    }

    @AfterTest
    public void tearDown() throws InterruptedException{

        Thread.sleep(1000);

        driver.close();

        test1.pass("Closed driver");

        test1.log(Status.INFO,"Test completed");

        extent.flush();
    }

}
