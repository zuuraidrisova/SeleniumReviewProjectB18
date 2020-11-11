package test.day02_FindElement_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_GoogleTitleVerification_NameLocator {
    /*
    TC#3:	Google	search
    1-Open	a	chrome	browser
    2-Go	to:	https://google.com
    3-Write	“apple”	in	search	box
    4-Click	google	search	button5-Verify	title:
    Expected:	Title	should	start	with	“apple”
     */

    public static void main(String[] args) throws InterruptedException{

        /*
           1- name: This locator will be looking into the whole HTML code, and return the
     WebElement with matching name attribute value
        - it will find and return the first webelement it finds
    syntax: driver.findElement(By.name("name attribute value"))
         */

        //creates connection between selenium and browser
        WebDriverManager.chromedriver().setup();

        //creating an instance of ChromeBrowser
        WebDriver driver = new ChromeDriver();

        //below line makes the window fullscreen
        driver.manage().window().maximize();

        //gets the given url and opens it
        driver.get("https://google.com");

        //finding web element
        WebElement searchBox = driver.findElement(By.name("q"));

        //writing apple to search box and pressing Enter
        searchBox.sendKeys("apple");

        //searchBox.sendKeys("apple"+ Keys.ENTER); also works

        //locating search button
        WebElement searchButton = driver.findElement(By.name("btnK"));

        Thread.sleep(2000);

        //click google search button
        searchButton.click();



        String expectedInTitle = "apple";
        String actualTitle = driver.getTitle();

        if(actualTitle.startsWith(expectedInTitle)){

            System.out.println("Google Title Verification Passed!");
        }else{

            System.out.println("Google Title Verification Failed!");
        }

        driver.close();



    }
}
