package test.day11_PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC44_DragAndDrop_Test {

    /*
    TC #44: Hover Test
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
     */

    @Test
    public void dragAndDrop_test() throws InterruptedException{

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

       // Driver.getDriver().manage().window().maximize();

        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));

        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(1000);

        //Drag and drop the small circle to bigger circle.
        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        //below line also works as such
        actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();

        String expectedWhileHover = "Now drop...";

        String actualWhileHover = bigCircle.getText();

        Assert.assertEquals(actualWhileHover, expectedWhileHover);

        System.out.println("Verification Passed!");

        actions.release().perform();

        // Assert: -Text in big circle changed to: “You did great!”
        String expectedTextInBigCircle = "You did great!";

        String actualTextInBigCircle = bigCircle.getText();

        Thread.sleep(1000);

        Assert.assertTrue(actualTextInBigCircle.equals(expectedTextInBigCircle));

        Driver.closeDriver();

    }


}
