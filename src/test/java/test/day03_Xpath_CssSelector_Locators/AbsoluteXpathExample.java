package test.day03_Xpath_CssSelector_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;
/*
8- xpath:
	When to use xpath? --> When you are not able to use other 6 locators.
	-> xpath has its own syntax different from cssSelector
	THERE ARE TWO TYPES OF XPATH LOCATORS
	1- ABSOLUTE XPATH:
		-> Absolute xpath starts with single slash -> /
		-> It starts from the very beginning of the HTML code
		-> Absolute xpath is not reliable, because if there is any minimal structural change in your HTML code, your locator will not work
		-> Try avoid using it

		<html>
			<head></head>
			<body>
				<div>
					<div>
						<h3> this is my header </h3>
					</div>
				</div>
			</body>
		</html>

ex: if I want to locate using absolute xpath:
	/html/body/div/div/h3
	/html/body/div/div[3]
	/html/body/div[1]/div[5]/div[1]/div/div[3]/ul/li[1]/a

--> You use the [] in your xpath, when you have more than one sibling, and you are specifying which sibling you are trying to get

 */
public class AbsoluteXpathExample {

    public static void main(String[] args) {

        //go to: http://practice.cybertekschool.com/multiple_buttons in chrome
        //verify if Home link is displayed

       WebDriver driver =  WebDriverFactory.getDriver("chrome");

       driver.manage().window().maximize();

       driver.get("http://practice.cybertekschool.com/multiple_buttons");

       //locating home link using absolute xpath
      WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));

      if(homeLink.isDisplayed()){

          System.out.println("Home Link is displayed.Passed!");
      }else{

          System.out.println("Home Link is not displayed.Failed!");
      }

      driver.close();
    }
}
