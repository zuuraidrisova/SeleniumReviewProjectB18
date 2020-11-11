package test.day04_FindElementsRadioButtonCheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC18_SeleniumEasy_Checkbox_Section1 {
            /*
    TC #18: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Success – Check box is checked” message is NOT displayed.
4. Click to checkbox under “Single Checkbox Demo” section
5. Verify “Success – Check box is checked” message is displayed.
     */

    public static void main(String[] args) throws InterruptedException{


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //Verify “Success – Check box is checked” message is NOT displayed.
        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        WebElement successMessage= driver.findElement(By.xpath("//div[@id='txtAge']"));

        if(! successCheckbox.isSelected() && !successMessage.isDisplayed()){

            System.out.println("Default value verification passed!");

        }else{

            System.out.println("Default value verification failed!");
        }

        //4. Click to checkbox under “Single Checkbox Demo” section
        successCheckbox.click();

        Thread.sleep(2000);

        //5. Verify “Success – Check box is checked” message is displayed.
        if(successMessage.isDisplayed()){

            System.out.println("“Success – Check box is checked” is displayed.Verification passed!");
        }else{

            System.out.println("“Success – Check box is checked” is NOT displayed.Verification failed!");
        }

        driver.close();
    }

}
