package test.day11_PageObjectModel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC45_ContextClick_Test {
    /*
    TC #45: Context Click – HOMEWORK
1. Go to https://the-internet.herokuapp.com/context_menu
2. Right click to the box.
3. Alert will open.
4. Accept alert
No assertion needed for this practice.
     */

    @Test
    public void contextClick_test() throws InterruptedException{

        //getting the page and url
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        //locating box web element
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        //creating an instance of Actions class to be able to use its methods
        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(1000);

        //Right click to the box using contextClick method from actions class
        actions.contextClick(box).perform();

        //we have to use alert class to switch to Java Script alert
        Alert alert = Driver.getDriver().switchTo().alert();

        Thread.sleep(1000);
        //Accept alert
        alert.accept();

        Thread.sleep(1000);


        Driver.closeDriver();

    }
}
