package test.day11_PageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC49_PositiveLoginTest_PageObjectModel {
    /*
    TC#49 : Vytrack positive login test às Store Manager
1. Go to https://qa2.vytrack.com
2. Enter correct username
3. Enter correct password
4. Verify title changed
Expected: “Dashboard”
Note: Follow Page Object Model design pattern
     */

    LoginPage loginPage;

    @Test
    public void positiveLogin_test_usingPageObject() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage();

        String username = ConfigurationReader.getProperty("storeManager_username");
        String password = ConfigurationReader.getProperty("storeManager_password");

       // loginPage.login(username, password); this will also work using our method

        loginPage.usernameInput.sendKeys(username);

        loginPage.passwordInput.sendKeys(password);

        loginPage.loginButton.click();

        //Verify title changed
        //Expected: “Dashboard”

        Thread.sleep(1000);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        Thread.sleep(1000);

        Driver.closeDriver();

    }


}
