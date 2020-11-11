package test.day11_PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC47_TC48_NegativeLoginTest_PageObjectModelPractice {
    /*
   TC#47 : Vytrack negative login test à Wrong Password Test
1. Go to https://qa2.vytrack.com
2. Enter correct username
3. Enter incorrect password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Do this practice once before Page Object Model design pattern
    */

     //this is before introducing Page Object Model
    @Test
    public void negativeLogin_test() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        WebElement usernameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        //we are getting our username from Configuration properties file
        usernameInput.sendKeys(ConfigurationReader.getProperty("storeManager_username"));

        //we are doing incorrect login test, so getting wrong password
        passwordInput.sendKeys("983271");

        loginButton.click();

        //Verify error message text is as expected
        //Expected: “Invalid user name or password.”
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        Assert.assertTrue(errorMessage.isDisplayed());

        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Invalid user name or password.";

        Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));

        Thread.sleep(1000);

        Driver.closeDriver();

    }

     /*
   TC#47 : Vytrack negative login test à Wrong Password Test
1. Go to https://qa2.vytrack.com
2. Enter correct username
3. Enter incorrect password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Do this practice USING Page Object Model design pattern
    */

    LoginPage loginPage;

    @Test
    public void negativeLogin_test_usingPageObjectModel() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage(); //we have to create an object of class to use web elements

        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("storeManager_username"));

        loginPage.passwordInput.sendKeys("2874s");

        loginPage.loginButton.click();

        //asserting error message is displayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //4. Verify error message text is as expected
        //Expected: “Invalid user name or password.”

        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "Invalid user name or password.";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        Thread.sleep(1000);

        Driver.closeDriver();

    }
    /*
    TC#48 : Vytrack negative login test à Wrong Username Test
1. Go to https://qa2.vytrack.com
2. Enter incorrect username
3. Enter correct password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Follow Page Object Model design pattern
     */

    @Test
    public void wrongUsername_test() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage();

        //loginPage.usernameInput.sendKeys("bdjahsguyeqw");

        //loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("storeManager_password"));

        //loginPage.loginButton.click();

        //instead of doing as above, below line also works since we created method for login
        loginPage.login("sjhgfuiqw", ConfigurationReader.getProperty("storeManager_password"));

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //4. Verify error message text is as expected
        //Expected: “Invalid user name or password.”

        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "Invalid user name or password.";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        Thread.sleep(1000);

        Driver.closeDriver();
    }




}
