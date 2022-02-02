package test.day03_Xpath_CssSelector_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class TC11_ForgotPasswordWebElementVerification {
    /*
    TC #11: PracticeCybertek.com_ForgotPassword WebElement verification
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/forgot_password
    3. Locate all the WebElements on the page using XPATH locator only (total of 6)
             a. “Home” link
             b. “Forgot password” header
             c. “E-mail” text
             d. E-mail input box
             e. “Retrieve password” button
             f. “Powered byCybertek School” text
    4. Verify all WebElements are displayed.
     */

    public static void main(String[] args) {

        //gets chrome driver and sets it up
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");


        /*
    1- //tagName[@attribute='value'] --> looks for tagname attribute and value
	1- //*[@attribute='value'] --> * means look for all of the webElements
	2- //tagName[contains(@attribute, 'value')] --> locates all web elements with the given value
	3- //tagName[.='text'] --> looks for exact text match in webElement

         */
        //Locate all the WebElements
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        WebElement emailText = driver.findElement(By.xpath("//label[.='E-mail']"));

        WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));

        WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[.='Retrieve password']"));

        WebElement poweredByCybertekSchool = driver.findElement(By.xpath("//a[contains(@target,'_blank')]/.."));

        //Verify all WebElements are displayed.

        if(homeLink.isDisplayed()){

            System.out.println("Home link is displayed.Passed!");

        }else{

            System.out.println("Home link is not displayed.Failed!");
        }

        if (forgotPasswordHeader.isDisplayed()){

            System.out.println("Forgot Password Header is displayed.Passed!");

        }else{

            System.out.println("Forgot Password Header is not displayed.Failed!");

        }

        if(emailText.isDisplayed()){

            System.out.println("Email Text is displayed.Passed!");

        }else{

            System.out.println("Email Text is not displayed.Failed!");
        }

        if(emailInput.isDisplayed()){

            System.out.println("Email Input is displayed.Passed!");
        }else{

            System.out.println("Email Text is not displayed.Failed!");
        }

        if(retrievePasswordButton.isDisplayed()){

            System.out.println("Retrieve Password Button is displayed.Passed!");
        }else{

            System.out.println("Retrieve Password Button is not displayed.Failed!");

        }

        if(poweredByCybertekSchool.isDisplayed()){

            System.out.println("Cybertek School Link is displayed.Passed!");

        }else{

            System.out.println("Cybertek School Link is not displayed.Failed!");
        }

        driver.close();


    }

}
