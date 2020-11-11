package test.day04_FindElementsRadioButtonCheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC15_FindElements_Apple {
      /*
    TC #15: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to iPhone
4. Print out the texts of all links
5. Print out how many link is missing text
6. Print out how many link has text
7. Print out how many total link
     */

    public static void main(String[] args) {

        //sets up driver and opens chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //makes screen full
        driver.manage().window().maximize();

        //waits until the html page is loaded
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //gets the given url in an open browser
        driver.get("https://www.apple.com");

        //locating iphone link usinf xpath
        WebElement iPhoneLink = driver.findElement(By.xpath("(//a[@href='/iphone/'])[1]"));
        //driver.findElement(By.xpath("//body//a[@class='ac-gn-link ac-gn-link-iphone']")).click();
        // driver.findElement(By.xpath("//span[.='iPhone']")).click();

        //Click to iPhone
        iPhoneLink.click();

        //Print out the texts of all links
        List<WebElement> listOfAllLinks = driver.findElements(By.xpath("//body//a"));

        //Print out how many total link
        int totalNumberOfLinks = listOfAllLinks.size();

        System.out.println("totalNumberOfLinks = " + totalNumberOfLinks);

        //Print out how many link is missing text
        //Print out how many link has text
        int totalNumberOfLinksWithoutText = 0;
        int totalNumberOfLinksWithText = 0;

        for (WebElement eachLink :  listOfAllLinks){

            String eachLinkText = eachLink.getText();

            if (eachLinkText.isEmpty()){

                totalNumberOfLinksWithoutText++;
            }else {

                totalNumberOfLinksWithText++;
            }
        }

        System.out.println("totalNumberOfLinksWithoutText = " + totalNumberOfLinksWithoutText);
        System.out.println("totalNumberOfLinksWithText = " + totalNumberOfLinksWithText);


        //Print out the texts of all links
        for (int i = 0; i < listOfAllLinks.size(); i++){

            String eachLinkText = listOfAllLinks.get(i).getText();

            System.out.println("eachLinkText = " + eachLinkText);
        }

        driver.close();
    }
}
