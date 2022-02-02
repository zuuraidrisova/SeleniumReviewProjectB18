package test.day03_Xpath_CssSelector_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class TC12_AddRemoveElementsVerification {

    /*
    TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
     1. Open Chrome browser
     2. Go to http://practice.cybertekschool.com/add_remove_elements/
     3. Click to “Add Element” button
     4. Verify “Delete” button is displayed after clicking.
     5. Click to “Delete” button.
     6. Verify “Delete” button is NOT displayed after clicking.
      USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

     */

    public static void main(String[] args){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        //it is opening the web page
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //Click to “Add Element” button
        driver.findElement(By.xpath("//button[.='Add Element']")).click();

        //Verify “Delete” button is displayed after clicking.
       WebElement deleteButton =  driver.findElement(By.xpath("//button[@class='added-manually']"));

       if(deleteButton.isDisplayed()){

           System.out.println("Delete Button is displayed.Passed!");

       }else{

           System.out.println("Delete Button is not displayed.Failed!");
       }

       //Click to “Delete” button.
        deleteButton.click();

       // Verify “Delete” button is NOT displayed after clicking.
        try{

            if(! deleteButton.isDisplayed()){

                System.out.println("Delete Button is not displayed.Passed!");

            }else{

                System.out.println("Delete Button is displayed.Failed!");
            }

        }catch (StaleElementReferenceException e){

            System.out.println("Stale Element Reference Exception has been thrown");
            System.out.println("It means the element has been completely deleted from html");
            System.out.println("Delete Button is not Displayed.Verification Passed!");
        }


        driver.close();


    }

}
