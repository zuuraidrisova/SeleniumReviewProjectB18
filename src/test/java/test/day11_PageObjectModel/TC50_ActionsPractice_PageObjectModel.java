package test.day11_PageObjectModel;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;
import utilities.Driver;

public class TC50_ActionsPractice_PageObjectModel {

    /*
    TC #50: Hover Test using Page Object Model
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

    HoversPage hoversPage;


    @Test
    public void hoverTest_pageObjectModel() throws InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        hoversPage = new HoversPage();

        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
        //3. Assert:
        //a. “name: user1” is displayed
        Thread.sleep(1000);
        actions.moveToElement(hoversPage.image1).perform();
        Assert.assertTrue(hoversPage.user1.isDisplayed());

        //4. Hover over to second image
        //5. Assert:
        //a. “name: user2” is displayed
        Thread.sleep(1000);
        actions.moveToElement(hoversPage.image2).perform();
        Assert.assertTrue(hoversPage.user2.isDisplayed());

        //6. Hover over to third image
        //7. Confirm:
        //a. “name: user3” is displayed
        Thread.sleep(1000);
        actions.moveToElement(hoversPage.image3).perform();
        Assert.assertTrue(hoversPage.user3.isDisplayed());

        Thread.sleep(1000);

        Driver.closeDriver();

    }

}
