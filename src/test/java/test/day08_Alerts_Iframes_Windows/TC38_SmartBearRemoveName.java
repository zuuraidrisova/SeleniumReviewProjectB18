package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC38_SmartBearRemoveName {
     /*
    TC #38 : Create a method called removeName()
1. Accepts two parameters: WebDriver, String name
2. Method will remove the given name from the list of Smartbear
3. Create a new TestNG test, and call your method.
4. Assert that your method removed the given name
     */

    public static void removeName(WebDriver driver, String name){


        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));


    }
}
