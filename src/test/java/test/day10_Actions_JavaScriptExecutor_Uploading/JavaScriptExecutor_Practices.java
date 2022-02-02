package test.day10_Actions_JavaScriptExecutor_Uploading;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class JavaScriptExecutor_Practices {

    @Test
    public void js_executor_test() throws InterruptedException{

        //we set up driver, open browser and get the given link
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        //locate the element we want to scroll until
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        //we cast our driver to JavascriptExecutor, so we are able to use JS methods
        JavascriptExecutor jsExecutor = (JavascriptExecutor)Driver.getDriver();

        //we would like to see
        Thread.sleep(3000);

        //we use executeScript() method and pass two arguments
                // 1. arguments[0].scrollIntoView(true); ==> is js code
                // 2. web element we located to scroll
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", cybertekSchoolLink);

        Thread.sleep(1000);

        Driver.closeDriver();

    }

}
