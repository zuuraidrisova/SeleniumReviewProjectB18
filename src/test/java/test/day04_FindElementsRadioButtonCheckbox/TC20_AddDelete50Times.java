package test.day04_FindElementsRadioButtonCheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC20_AddDelete50Times {
     /*
    TC #20: PracticeCybertek.com_AddRemoveElements WebElement verification
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/add_remove_elements/
    3. Click to “Add Element” button 50 times
    4. Verify 50 “Delete” button is displayed after clicking.
    5. Click to ALL “Delete” buttons to delete them.
    6. Verify “Delete” button is NOT displayed after clicking.

     USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
      Hint: Need to use findElements method.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addElement =  driver.findElement(By.xpath("//button[.='Add Element']"));

        //Click to “Add Element” button 50 times

        for (int i = 0; i < 50; i++){

            addElement.click();
        }

        //Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> deleteButtonsList = driver.findElements(By.xpath("//button[.='Delete']"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

        if (deleteButtonsList.size() == 50){

            System.out.println("There are 50 Delete Buttons.Verification passed!");
        }else{

            System.out.println("There are not 50 Delete Buttons.Verification failed!");

        }

        System.out.println("====================================");

        //Click to ALL “Delete” buttons to delete them.

        for (int i = 0; i < 50; i++){

            deleteButtonsList.get(i).click();
        }


        try{
            // Verify “Delete” button is NOT displayed after clicking.
            if(! deleteButton.isDisplayed()){

                System.out.println(" “Delete” button is NOT displayed. Verification passed!");
            }else{

                System.out.println(" “Delete” button is displayed. Verification failed!");

            }
        }catch (StaleElementReferenceException exception){

            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("“Delete” button is NOT displayed. Verification passed!");
        }

        driver.close();

    }
}
