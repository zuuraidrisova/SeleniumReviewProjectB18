package test.day10_Actions_JavaScriptExecutor_Uploading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class Actions_Practice {

    @Test
    public void actions_hoverOver_test() throws InterruptedException{

        //hover over = move To element
        Driver.getDriver().get("https://www.amazon.com");

        //1- Create the instance of Actions class
        //2- Pass the current driver instance
        //3- Locate the web element to hover over
        //4- Using actions, hover over to the Language options
        Actions actions = new Actions(Driver.getDriver());

        WebElement languageOptions = Driver.getDriver().findElement(By.id("icp-nav-flyout"));

        Thread.sleep(2000);

        actions.moveToElement(languageOptions).perform();

        Driver.closeDriver();

    }

}
