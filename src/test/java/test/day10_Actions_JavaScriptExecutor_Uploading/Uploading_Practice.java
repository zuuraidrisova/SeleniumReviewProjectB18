package test.day10_Actions_JavaScriptExecutor_Uploading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Uploading_Practice {

    @Test
    public void uploading_test() throws InterruptedException{

        //opens chrome and goes to given url
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        //locates button where we send our file to be uploaded
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));

        Thread.sleep(1000);

        //send our file
        chooseFile.sendKeys("/Users/zuura/Desktop/SomethingTest");

        Thread.sleep(1000);

        //locate upload button
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));

        //click to upload button
        uploadButton.click();

        //verify if uploaded message is displayed
       WebElement fileUploadedMessage = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedMessage.isDisplayed());

        Driver.closeDriver();


    }


}
