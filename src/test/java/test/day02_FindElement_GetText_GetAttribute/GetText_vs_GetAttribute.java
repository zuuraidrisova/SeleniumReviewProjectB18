package test.day02_FindElement_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetText_vs_GetAttribute {

    public static void main(String[] args) {

        //creates connection between selenium and browser
        WebDriverManager.chromedriver().setup();

        //creating an instance of ChromeBrowser
        WebDriver driver = new ChromeDriver();

        //below line makes the window fullscreen
        driver.manage().window().maximize();

        //gets the given url and opens it
        driver.get("https://google.com");

        //locating gmail web element
        String text =  driver.findElement(By.linkText("Gmail")).getText();

        System.out.println("get text method= " + text);

        String attributeValue = driver.findElement(By.linkText("Gmail")).getAttribute("href");

        System.out.println("get attribute Value = " + attributeValue);

        driver.close();

    }
}
