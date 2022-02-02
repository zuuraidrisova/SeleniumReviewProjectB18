package test.day03_Xpath_CssSelector_Locators;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class ExampleWebDriverFactory {

    public static void main(String[] args) {

        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        instead of writing double lines like above, we created a custom method
        to avoid repetition
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        driver.close();

    }
}
