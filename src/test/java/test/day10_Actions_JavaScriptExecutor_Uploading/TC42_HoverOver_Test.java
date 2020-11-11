package test.day10_Actions_JavaScriptExecutor_Uploading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC42_HoverOver_Test {
    /*
    TC #15: Hover Test
1. Go to http://practice.cybertekschool.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
     */

    @Test
    public void hover_over_test() throws InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        //we need to locate images
        WebElement firstImage = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));

        WebElement secondImage = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));

        WebElement thirdImage = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));

        // we need to locate texts
        WebElement text1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));

        WebElement text2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));

        WebElement text3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));


        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(firstImage).perform();

        Assert.assertTrue(text1.isDisplayed());

        Thread.sleep(1000);

        actions.moveToElement(secondImage).perform();

        Assert.assertTrue(text2.isDisplayed());

        Thread.sleep(1000);

        actions.moveToElement(thirdImage).perform();

        Assert.assertTrue(text3.isDisplayed());

        Thread.sleep(1000);

        Driver.closeDriver();
    }




}
