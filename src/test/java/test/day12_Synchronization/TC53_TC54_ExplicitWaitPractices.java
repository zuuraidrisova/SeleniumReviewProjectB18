package test.day12_Synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class TC53_TC54_ExplicitWaitPractices {
    /*
    TC#53 : Dynamically Loaded Page Elements 7
1. Go to http://practice.cybertekschool.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert : Message “Done” is displayed.
4. Assert : Image is displayed.
Note: Follow POM
     */
    @Test
    public void dynamicTitle_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

        Loading7Page loading = new Loading7Page();

        //we create an instance of WebDriverWait class to be able to use its waits
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        //Wait until title is “Dynamic Title”
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

       //Assert : Message “Done” is displayed.
        Assert.assertTrue(loading.doneMessage.isDisplayed());

        //4. Assert : Image is displayed.
        Assert.assertTrue(loading.spongeBobImage.isDisplayed());

    }

     /*
    TC#54 : Dynamically Loaded Page Elements 1
1. Go to http://practice.cybertekschool.com/dynamic_loading/1
2. Click to start
3. Wait until loading bar disappears
4. Assert username inputbox is displayed
5. Enter username: tomsmith
6. Enter password: incorrectpassword
7. Click to Submit button
8. Assert “Your username is invalid!” text is displayed.
Note: Follow POM
     */
    @Test
    public void dynamicForm_test() throws InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        Loading1Page loading1Page = new Loading1Page();

        //Click to start
        loading1Page.startButton.click();

        //creating an instance of WebDriverWait class to use its methods
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        //Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loadingBar));

        //Assert username inputBox is displayed
        Assert.assertTrue(loading1Page.usernameInput.isDisplayed());

        //Enter username: tomsmith
        loading1Page.usernameInput.sendKeys("tomsmith");

        //Assert password inputBox is displayed
        Assert.assertTrue(loading1Page.passwordInput.isDisplayed());

        //Enter password: incorrectpassword
        loading1Page.passwordInput.sendKeys("hdasas");

        //Click to Submit button
        loading1Page.submitButton.click();

        //Assert “Your username is invalid!” text is displayed.
        Assert.assertTrue(loading1Page.errorMessage.isDisplayed());


        Thread.sleep(1000);

        Driver.closeDriver();

    }


}
