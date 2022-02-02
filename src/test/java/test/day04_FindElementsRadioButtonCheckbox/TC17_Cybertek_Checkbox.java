package test.day04_FindElementsRadioButtonCheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC17_Cybertek_Checkbox {
     /*
    TC17: Practice: Cybertek Checkboxes
1. Go to http://practice.cybertekschool.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 =  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        WebElement checkBox2 =  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //  Confirm checkbox #1 is NOT selected by default
        if(! checkBox1.isSelected()){

            System.out.println("Checkbox 1 is not selected.Verification passed!");
        }else{

            System.out.println("Checkbox 1 is selected.Verification failed!");

        }

        //Confirm checkbox #2 is SELECTED by default.
        if(checkBox2.isSelected()){

            System.out.println("Checkbox 2 is selected by default.Verification passed!");
        }else{

            System.out.println("Checkbox 2 is not selected by default.Verification failed!");
        }

        // Click checkbox #1 to select it.
        //Click checkbox #2 to deselect it.
        checkBox1.click();
        checkBox2.click();

        System.out.println("==================================================");

        //Confirm checkbox #1 is SELECTED.
        if(checkBox1.isSelected()){

            System.out.println("Checkbox 1 is selected.Verification passed!");

        }else{

            System.out.println("Checkbox 1 is not selected.Verification failed!");

        }

        //Confirm checkbox #2 is NOT selected.
        if(! checkBox2.isSelected()){

            System.out.println("Checkbox 2 is not selected.Verification passed!");
        }else{

            System.out.println("Checkbox 2 is selected.Verification failed!");

        }

        driver.close();
    }
}
