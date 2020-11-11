package test.day03_Xpath_CssSelector_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC9_ZeroBankUrlVerification {
     /*
    TC #9: Zero Bank URL verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Get attribute value of href from the “forgot your password” link
4. Verify attribute value contains
Expected: “/forgot-password.html”
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

       String hrefAttributeValue =  driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
       String attributeValueContains = "/forgot-password.html";

       if(hrefAttributeValue.contains(attributeValueContains)){

           System.out.println("href attribute value contains expected value.Passed!");
       }else{

           System.out.println("href attribute value does not contain expected value.Failed!");
       }

       driver.close();

    }
}
