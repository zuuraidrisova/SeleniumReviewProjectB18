package test.day03_Xpath_CssSelector_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;
/*
7- cssSelector
	-> it has its own syntax
	syntaxes for commonly used cssSelectors;

		1- tagName[attribute='value']
		2- tagName.value --> . in css selector means class
			--> looks for the tagnames that has given class attribute values

		3- tagName#value --> # is css selector looks for id attribute value

ex:
 	<div class="uh7" id="fa83" name="uk94">
 		<a href="www.tesla.com"> TESLA WEBPAGE! </a>
	</div>

	1-> div[class='uh7'] --> driver.findElement(By.cssSelector("div[class='uh7']"));
	2-> div.uh7
	3-> div#fa83
		to go to child with cssSelector: you need to use > sign, and pass the child name you want to go
  		div[class='uh7'] > a

ex:
		<div class="container"></div>
		- tagName[attribute='value']
		- div[class='container'] > div > div

	<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="" class="nav-input" dir="auto" tabindex="19">

	- tagName[attribute='value']
	--> input[tabindex='19']

 */
public class CssSelectorExample {
/*
    Search Amazon
1.Open browser
2. Go to https://amazon.com
3. Enter any search term (use cssSelector to locate search box)
4.Verify title contains the search term
 */
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://amazon.com");

        // driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("wooden spoons"+ Keys.ENTER);
        //this CssSelector: input#twotabsearchtextbox also works

        //Enter any search term
        driver.findElement(By.cssSelector("input[type ='text']")).
                sendKeys("wooden spoon" + Keys.ENTER);

        //4.Verify title contains the search term
        String expectedInTitle = "wooden spoon";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedInTitle)){

            System.out.println("Expected search term is contained.Passed!");
        }else{

            System.out.println("Expected search term is not contained.Failed!");

        }

        driver.close();


    }
}
