package test.day04_FindElementsRadioButtonCheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC16_FindElements_AppleHeader {
      /*
    TC #16: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to all of the headers one by one
a. Mac, iPad, iPhone, Watch, TV, Music, Support
4. Print out how many links on each page with the titles of the pages
5. Loop through all
6. Print out how many link is missing text TOTAL
7. Print out how many link has text TOTAL
8. Print out how many total link TOTAL
     */
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.apple.com");

        //creating counters
        int numberOfLinksWithText = 0;
        int numberOfLinksWithoutText = 0;

        Thread.sleep(2000);

        List<WebElement> appleHeaders = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

        for (int i = 1; i < 8; i++){

            appleHeaders.get(i).click();

            Thread.sleep(1000);

            List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

            //4. Print out how many links on each page with the titles of the pages
            System.out.println("Number of links on page: "+driver.getTitle()+" "+listOfLinks.size());

            for (WebElement eachLink: listOfLinks){

                String eachLinkText = eachLink.getText();

                if(! eachLinkText.isEmpty()){

                    numberOfLinksWithText++;

                }else{

                    numberOfLinksWithoutText++;
                }
            }


            driver.navigate().back();
            appleHeaders = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

        }

        System.out.println("numberOfLinksWithText = " + numberOfLinksWithText);
        System.out.println("numberOfLinksWithoutText = " + numberOfLinksWithoutText);

        driver.close();

    }
}
