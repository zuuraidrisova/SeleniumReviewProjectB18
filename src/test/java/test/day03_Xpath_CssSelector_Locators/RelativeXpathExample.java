package test.day03_Xpath_CssSelector_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class RelativeXpathExample {
    /*
    	2- RELATIVE XPATH:
	- starts with double slash //
	- when you say // it allows you to start anywhere in the html code
	- more reliable
	- you can start from anywhere in the HTML code
	- more specific

	syntax : driver.findElement(By.xpath("xpath locator here"));

	1- //tagName[@attribute='value']
	2- //tagName[contains(@attribute, 'value')]
	3- //tagName[.='text']

	1- //tagName[@attribute='value'] --> looks for tagname attribute and value
	1- //*[@attribute='value'] --> * means look for all of the webElements
	2- //tagName[contains(@attribute, 'value')] --> locates all web elements with the given value
	3- //tagName[.='text'] --> looks for exact text match in webElement

ex:	<li class="nav-item">
      <a class="nav-link" href="/">Home</a>
    </li>


    tagName 		--> li
    attribute 		--> class
    attribute value --> nav-item

    - //tagName[@attribute='value']
    - //li[@class='nav-item']

    TO GO from parent to child using xpath: use /

    ex --> //li[@class='nav-item']/a

    TO GO from child to parent using xpath : use /..
    This will take you to the direct parent of the current web element

     */
    public static void main(String[] args) {

        //go to: http://practice.cybertekschool.com/multiple_buttons in chrome
        //verify if Home link is displayed

        WebDriver driver =  WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //locating home link using relative xpath
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        if(homeLink.isDisplayed()){

            System.out.println("Home Link is displayed.Passed!");

        }else{

            System.out.println("Home Link is not displayed.Failed!");
        }

        driver.close();

    }
}
