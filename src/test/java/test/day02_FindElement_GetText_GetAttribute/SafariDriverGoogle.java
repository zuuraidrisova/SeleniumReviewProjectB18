package test.day02_FindElement_GetText_GetAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverGoogle {

    public static void main(String[] args) {

        //we dont have to set up web driver manager, safari already comes with it
        WebDriver driver = new SafariDriver();

        driver.manage().window().maximize();

        driver.get("https://google.com");

        String text = driver.findElement(By.linkText("About")).getText();

        System.out.println("text = " + text);

        driver.close();
    }

}
