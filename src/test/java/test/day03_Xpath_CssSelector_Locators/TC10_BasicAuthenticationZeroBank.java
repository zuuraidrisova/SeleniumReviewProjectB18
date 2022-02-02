package test.day03_Xpath_CssSelector_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TC10_BasicAuthenticationZeroBank {
     /*
    TC #10: Basic authentication Zero Bank
1. Open Safari browser
2. Go to http://zero.webappsecurity.com/login.html
3. Enter username: username
4. Enter password: password
5. Click sign in button
6. Verify username is displayed on the page
7. Verify the title Zero – Account Summary
8. Verify the link Account Summary’s href value contains: “account-summary”
Print out results in validation formats
     */
     public static void main(String[] args) {

         //sets up the driver
        // WebDriverManager.chromedriver().setup();

         //opens chrome browser
         WebDriver driver = new SafariDriver();

         //makes fullscreen
         driver.manage().window().maximize();

         //goes to given url
         driver.get("http://zero.webappsecurity.com/login.html");

         //entering username
         driver.findElement(By.id("user_login")).sendKeys("username");

         //entering password
         driver.findElement(By.id("user_password")).sendKeys("password");

         //clicking sign in button
         driver.findElement(By.name("submit")).click();

         //Verify the title Zero – Account Summary
         String expectedTitle = "Zero - Account Summary";
         String actualTitle = driver.getTitle();

         System.out.println("actualTitle = " + actualTitle);

         if(actualTitle.equals(expectedTitle)){

             System.out.println("Landing Page Title Verification Passed!");

         }else{

             System.out.println("Landing Page Title Verification Failed!");
         }

         //Verify the link Account Summary’s href value contains: “account-summary”
         String hrefAttributeValue = driver.findElement(By.linkText("Account Summary")).getAttribute("href");
         String hrefAttributeValueContains = "account-summary";

         System.out.println("hrefAttributeValue = " + hrefAttributeValue);

         if(hrefAttributeValue.contains(hrefAttributeValueContains)){

             System.out.println("Href Attribute Value contains expected value.Passed!");

         }else{

             System.out.println("Href Attribute Value does not contain expected value.Failed!");
         }


         //Verify username is displayed on the page
         boolean displayed =  driver.findElement(By.linkText("username")).isDisplayed();

         if(displayed){

             System.out.println("Username is displayed.Passed!");

         }else{

             System.out.println("Username is not displayed.Failed");
         }

         driver.close();


     }
}
