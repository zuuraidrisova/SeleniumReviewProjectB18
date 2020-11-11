package test.day11_PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class TC46_ScrollingDown_UsingActions {

    @Test
    public void scrollDown_usingActions() throws InterruptedException{

        //get the page
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        //creating Actions instance to be able to use its methods
        Actions actions = new Actions(Driver.getDriver());

        //locate the element we want to scroll until
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        Thread.sleep(1000);

        //using actions  instance we use moveToElement method
        actions.moveToElement(cybertekSchoolLink).perform();

        Thread.sleep(1000);

        WebElement inputsLink = Driver.getDriver().findElement(By.linkText("Inputs"));

        actions.moveToElement(inputsLink).perform();

        Driver.closeDriver();
    }
}
