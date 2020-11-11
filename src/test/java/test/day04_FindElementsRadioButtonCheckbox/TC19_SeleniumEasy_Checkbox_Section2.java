package test.day04_FindElementsRadioButtonCheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC19_SeleniumEasy_Checkbox_Section2 {
     /*
TC #19: SeleniumEasy Checkbox Verification – Section 2
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Check All” button text is “Check All”
4. Click to “Check All” button
5. Verify all check boxes are checked
6. Verify button text changed to “Uncheck All”
         */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");


       WebElement checkAllButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));

        // Verify “Check All” button text is “Check All”
       String attributeValue =  checkAllButton.getAttribute("value");
       String expectedText = "Check All";

       if(expectedText.equals(attributeValue)){

           System.out.println("Check All” button text is “Check All”.Verification passed!");
       }else{

           System.out.println("Check All” button text is not “Check All”.Verification failed!");

       }

      checkAllButton.click();

       List <WebElement> listOfCheckBoxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));

       for (WebElement eachCheckbox: listOfCheckBoxes){
           //5. Verify all check boxes are checked
           if (eachCheckbox.isSelected()){

               System.out.println("All checkBoxes are selected. Verification passed!");
           }else{

               System.out.println("One or some of checkBoxes are NOT selected. Verification failed!");

           }
       }

        //6. Verify button text changed to “Uncheck All”
        if(checkAllButton.getAttribute("value").equals("Uncheck All")){

            System.out.println("Button text changed to “Uncheck All”.Verification passed!");
        }else{

            System.out.println("Button text did not change to “Uncheck All”.Verification failed!");

        }


        driver.close();




    }
}

