package test.day12_Synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC51_ForgotPasswordVerification {
    /*
    TC#51 : Vytrack forgot password page verifications à TITLE and URL
1. Go to https://qa2.vytrack.com
2. Click to “Forgot your password?” link
3. Verify title changed to expected
Expected: “Forgot Password”
4. Verify url is as expected:
Expected: “https://qa2.vytrack.com/user/reset-request”
Note: Follow Page Object Model design pattern
     */

    LoginPage loginPage;

    @Test
    public void vyTrack_forgotPassword_test() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage();

        loginPage.forgotPasswordLink.click();

        Thread.sleep(1000);

        //3. Verify title changed to expected
        //Expected: “Forgot Password”
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";

        Assert.assertEquals(actualTitle,expectedTitle);

        //4. Verify url is as expected:
        //Expected: “https://qa2.vytrack.com/user/reset-request”
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/user/reset-request";

        Assert.assertTrue(actualURL.equals(expectedURL));

        Thread.sleep(1000);

        Driver.closeDriver();
    }

}
