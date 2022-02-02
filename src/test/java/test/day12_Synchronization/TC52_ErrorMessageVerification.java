package test.day12_Synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VyTrackForgotPasswordPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC52_ErrorMessageVerification {

    /*
    TC#52 : Vytrack forgot password page verification à ERROR MESSAGE
1. Go to https://qa2.vytrack.com/user/reset-request
2. Enter random username
3. Click to request button
4. Verify error message is displayed
5. Verify error message text is as expected.
Expected: There is no active user with username or email address “given text”.
Note: Follow Page Object Model design pattern
     */

    @Test
    public void errorMessage_test() throws InterruptedException{

        Driver.getDriver().get(ConfigurationReader.getProperty("forgotPassword_url"));

        VyTrackForgotPasswordPage forgotPasswordPage = new VyTrackForgotPasswordPage();

        String randomUsername = "hehhe";

        forgotPasswordPage.inputBox.sendKeys(randomUsername);

        forgotPasswordPage.requestButton.click();

        //Verify error message is displayed
        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());

        //5. Verify error message text is as expected.
        //Expected: There is no active user with username or email address “given text”.
        String expectedErrorMessage = "There is no active user with username or email address \"" + randomUsername + "\".";

        String actualErrorMessage = forgotPasswordPage.errorMessage.getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        Thread.sleep(1000);

        Driver.closeDriver();
    }

}
