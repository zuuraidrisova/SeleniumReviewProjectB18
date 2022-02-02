package test.day11_PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC43_DoubleClick_Test {

    /*
    TC #43: Double Click Test
1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
     */

    @Test
    public void actions_doubleClick_test() throws InterruptedException{

        //open chrome browser and go to given url
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //switches to iframe using id
        Driver.getDriver().switchTo().frame("iframeResult");

        //locating web element to be clicked
        WebElement textToBeDoubleClicked = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));

        //creating an object of actions class, so to be able to use its methods
        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(1000);

        //using doubleClick() method we perform desired action
        actions.doubleClick(textToBeDoubleClicked).perform();

        Thread.sleep(1000);

        //verifying Text’s “style” attribute value contains “red”.
        String actualAttributeValue = Driver.getDriver().findElement(By.xpath("//p[@id='demo']")).getAttribute("style");
       // String actual = textToBeDoubleClicked.getAttribute("style"); ==> also works
        String expectedInAttributeValue = "red";

        Assert.assertTrue(actualAttributeValue.contains(expectedInAttributeValue));

        System.out.println("Verification Passed!");

        //after everything finished we can switch back to our parent frame

        Driver.getDriver().switchTo().parentFrame();

        Driver.closeDriver();

    }
}
