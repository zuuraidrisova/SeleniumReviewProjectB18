package test.day03_Xpath_CssSelector_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC8_CybertekUrlVerification {

    /*
    TC #8: PracticeCybertek/ForgotPassword URL verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”
Hint: You need to use getText method for this practice.
     */

    public static void main(String[] args) {

        //sets up the driver in order to create a connection between selenium and browser
        WebDriverManager.chromedriver().setup();

        //opens chrome browser, by creating instance of chrome driver
        WebDriver driver = new ChromeDriver();

        //maximizes the screen
        driver.manage().window().maximize();

        //gets the given url in an open browser
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email into input box
        driver.findElement(By.name("email")).sendKeys("zuuraidrisova@gmail.com");

        //click on Retrieve password
        driver.findElement(By.id("form_submit")).click();

        //verifying URL contains: Expected: “email_sent”
        String expectedInUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();//http://practice.cybertekschool.com/email_sent

        if(actualUrl.contains(expectedInUrl)){

            System.out.println("Cybertek URL Verification Passed!");

        }else{

            System.out.println("Cybertek URL Verification Failed!");
        }

        //Verify textBox displayed the content as expected:“Your e-mail’s been sent!”
        String expectedTextBox = "Your e-mail's been sent!";
        String actualTextBox = driver.findElement(By.name("confirmation_message")).getText();

        if(actualTextBox.equals(expectedTextBox)){

            System.out.println("Text Box Message Verification Passed!");

        }else{

            System.out.println("Text Box Message Verification Failed!");
        }

        //verify if text message is displayed, //if webElement is  displayed or not
        if (driver.findElement(By.name("confirmation_message")).isDisplayed()){

            System.out.println("Confirmation Message is Displayed!Passed!");
        }else{

            System.out.println("Confirmation Message is NOT Displayed!Failed!");
        }


        driver.close();

    }

}
