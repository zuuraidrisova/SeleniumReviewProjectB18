package test.day04_FindElementsRadioButtonCheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC14_FindElements_MeriamWebster {
    /*
    TC #14: FINDELEMENTS
1. Open Chrome browser
2. Go to https://www.merriam-webster.com/
3. Print out the texts of all links
4. Print out how many link is missing text
5. Print out how many link has text
6. Print out how many total link
     */

    public static void main(String[] args) {

        //sets up the driver and opens the chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //makes screen full
        driver.manage().window().maximize();

        // implicit wait waits until page is loaded, upto 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //goes to given url
        driver.get("https://www.merriam-webster.com/");

        //store all links to the list of link web elements
       List<WebElement> listOfAllLinks =  driver.findElements(By.xpath("//body//a"));

        //Print out how many total link
        int totalNumberOfLinks = listOfAllLinks.size();

        System.out.println("totalNumberOfLinks = " + totalNumberOfLinks);

        //Print out how many link is missing text
        //Print out how many link has text
        int totalNumberOfLinksWithoutText = 0;
        int totalNumberOfLinksWithText = 0;

        for (WebElement eachLink : listOfAllLinks){

            if(!eachLink.getText().isEmpty()){ //condition to check if text of link is empty or not
                //String eachLinkText =  eachLink.getText();
                // eachLinkText.isEmpty();

                totalNumberOfLinksWithText++;

            }else{

                totalNumberOfLinksWithoutText++;
            }
        }

        System.out.println("totalNumberOfLinksWithText = " + totalNumberOfLinksWithText);
        System.out.println("totalNumberOfLinksWithoutText = " + totalNumberOfLinksWithoutText);

       //Print out the texts of all links

        for (int i =0 ; i < listOfAllLinks.size(); i++){

            String eachLinkText = listOfAllLinks.get(i).getText();

            System.out.println("eachLinkText = " + eachLinkText);
        }

        driver.close();


    }
}
