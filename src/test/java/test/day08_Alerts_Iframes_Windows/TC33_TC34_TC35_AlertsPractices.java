package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC33_TC34_TC35_AlertsPractices {
    /*
    TC #33: Information alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfuly clicked an alert” text is displayed.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void js_warning_alert_test() throws InterruptedException{

        //locating info alert button
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

        //Click to “Click for JS Alert” button
        infoAlertButton.click();

        //create an alert instance and switch to it
        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);

        //Click to OK button from the alert
        //use alert instance to accept it
        alert.accept();

        //locating result web element
        WebElement successMessage = driver.findElement(By.xpath("//p[@id='result']"));

        //Verify “You successfuly clicked an alert” text is displayed.
        Assert.assertTrue(successMessage.isDisplayed());

        String actualSuccessMessage = successMessage.getText();
        String expectedSuccessMessage = "You successfuly clicked an alert";

        //asserting the equality of actual vs expected success message
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

    }

    /*
  TC #34: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
   */
    @Test
    public void js_confirmation_alert_test() throws InterruptedException{

        //locating confirmation alert
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        //Click to “Click for JS Confirm” button
        confirmationAlertButton.click();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        //Click to OK button from the alert
        alert.accept();

        //Verify “You clicked: Ok” text is displayed.
        WebElement okText = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));

        Assert.assertTrue(okText.isDisplayed());

        //asserting the equality of actual vs expected success message
        String actualOkText = okText.getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(actualOkText,expectedText);
    }

    /*
    TC #35: JS Prompt alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed.
     */

    @Test
    public void js_prompt_alert_test() throws InterruptedException{

        //locating prompt alert
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

        //clicking tp prompt alert
        promptAlertButton.click();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        //Click to OK button from the alert
        alert.sendKeys("hello");

        Thread.sleep(1000);

        alert.accept();

        //Verify “You entered: hello” text is displayed.
        WebElement  helloTextMessage = driver.findElement(By.xpath("//p[.='You entered: hello']"));

        Assert.assertTrue(helloTextMessage.isDisplayed());

        String actualText = helloTextMessage.getText();
        String expectedText = "You entered: hello";

        Assert.assertEquals(actualText,expectedText);

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }




}
