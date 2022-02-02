package test.day02_FindElement_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC6_SmartBearTitleVerification_NameLocator {

     /*
    TC#5:	Basic	login	authentication
    1-Open	a	chrome	browser
    2-Go	to:	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3-Verify	title	equals:
            Expected:	Web	Orders Login
    4-Enter	username:	Tester
    5-Enter	password:	test
    6-Click	“Sign	In”	button
    7-Verify	title equals:
        Expected:	Web	Orders
     */

    public static void main(String[] args) {
/*
1- name: This locator will be looking into the whole HTML code, and return the
     WebElement with matching name attribute value
        - it will find and return the first webelement it finds
    syntax: driver.findElement(By.name("name attribute value"))
 */
        //creates connection between selenium and browser
        WebDriverManager.chromedriver().setup();

        //opens chrome browser
        WebDriver driver = new ChromeDriver();

        //makes fullscreen
        driver.manage().window().maximize();

        //opens given url in an open browser
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //title verification using if else

        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){

            System.out.println("Smart Bear Title Verification Passed!");
        }else{

            System.out.println("Smart Bear Title Verification Failed!");
        }

        //locating inputs and sending keys

        // Enter	username:	Tester
        WebElement usernameInput = driver.findElement(By.name("ctl00$MainContent$username"));

        usernameInput.sendKeys("Tester");

        //Enter	password:	test
        WebElement passwordInput = driver.findElement(By.name("ctl00$MainContent$password"));

        passwordInput.sendKeys("utilities");

        //click sing in button
        WebElement signInButton = driver.findElement(By.name("ctl00$MainContent$login_button"));

        signInButton.click();

        //title verification in a new page

        String expectedLandingPageTitle = "Web Orders";
        String actualLandingPageTitle = driver.getTitle();

        if(actualLandingPageTitle.equals(expectedLandingPageTitle)){

            System.out.println("Landing Page Title Verification Passed!");

        }else{

            System.out.println("Landing Page Title Verification Failed!");

        }

        driver.close();

    }
}
