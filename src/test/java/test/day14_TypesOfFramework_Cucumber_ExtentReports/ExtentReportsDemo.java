package test.day14_TypesOfFramework_Cucumber_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class ExtentReportsDemo {


    public static void main(String[] args) throws InterruptedException {

        // initialize the HtmlReporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

        // initialize ExtentReports and attach the HtmlReporter
        ExtentReports extent = new ExtentReports();

        // attach only HtmlReporter
        extent.attachReporter(htmlReporter);

        ExtentTest test1 = extent.createTest("Google Search Functionality Validation");

        test1.log(Status.INFO,"Starting test case");

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.google.com");

        test1.pass("Navigated to google search page");

        driver.findElement(By.name("q")).sendKeys("Automation Step by Step" + Keys.ENTER);

        test1.pass("Entered text into search box and pressed Enter key");

        Thread.sleep(1000);

        driver.close();

        test1.pass("Closed driver");

        test1.log(Status.INFO,"Test completed");


        //Simply call the flush() method to write or update test information to your reporter.
        extent.flush();

    }
}
