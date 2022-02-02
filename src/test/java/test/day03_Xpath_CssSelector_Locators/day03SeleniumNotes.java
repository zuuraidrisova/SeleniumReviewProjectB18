package test.day03_Xpath_CssSelector_Locators;

public class day03SeleniumNotes {
  /*
  JUN 9, TUESDAY

MAVEN :
	- Built automation tool
	- It helps us with automating the steps we repeat every time we create the project
		-> create the project
		-> create the folder structure
		-> we add libraries
		-> maven comes with pre-created folder structure

		src
			main
			test
		pom.xml > project object model
			> it helps us add new libraries(dependencies)
			> it helps us control versions of the tools that we add into our project

.findElement(LOCATOR) ->
	- Finds and returns a specific web element
	- It accepts a String parameter as a locator
	- It returns 1 web element
	- It throws NoSuchElementException if it cannot find the element
	- What is the return type of the find element method?
		-> It returns WebElement

.sendKeys("text here") -> this method will send the given String to the located webElement

Keys.ENTER > allows us to imitate pressing ENTER key from keyboard action
	-> usually you apply this within sendKeys, and it is applied to some kind of form or input box

.click() > you have to locate the button to click and it will imitate the mouse click
	-> you need to locate another button (or web element) to be able to click

LOCATORS : We have 8 locators in Selenium
	1- id			: looks for the id attribute's value.
	2- name 		: looks for the name attribute's value.
	3- className	: looks for the class attribute's value.
	4- linkText 	: looks for the text of the link (anchor tags)
		-> linkText and partialLinkText can only be used on <a> tags
		-> looks for the exact text itself
		<a href=""> text </a>
		driver.findElement(By.linkText("text"));
	5- partialLinkText : looks for the partial text of the web element
	6- tagName 		: looks for the TAGNAME of the web element.
		-> usually returns more than one web element

.getText() ->
	-> gets the TEXT of the given web element, WHATEVER IS DISPLAYED ON THE PAGE
	-> it will not return any kind of attribute or attribute value
 	-> it does not accept any parameters
 	-> return type is String
 	-> if the text you want to get is IN BETWEEN the opening tag and closing tag, you need to use getText() method
 	ex:
 	<div class="uh7" id="fa83" name="uk94">
 		<a href="www.tesla.com"> TESLA WEBPAGE! </a>
	</div>

	driver.findElement(By.id("fa83")).getText();

.getAttribute("attribute goes here");
	-> get the TEXT value from any attribute value
	-> if the text value that you want to get is INSIDE of the opening tag, meaning it is some kind of an attribute value
	-> return type is String

	ex:
 	<div class="uh7" id="fa83" name="uk94">
 		<a href="www.tesla.com"> TESLA WEBPAGE! </a>
	</div>

	driver.findElement(By.id("fa83")).getAttribute("class"); --> returns uh7
	driver.findElement(By.id("fa83")).getAttribute("name"); --> returns uk94
	driver.findElement(By.name("uk94")).getAttribute("name"); --> returns uk94

	driver.findElement(By.linkText("TESLA WEBPAGE!")).getAttribute("href");
		--> locates the <a> tag and returns me the value of href attribute
			-> www.tesla.com > returned as a String

what is an email format?
	username@domain.com

	String sentence = "this is a sentence";
    sout -> sentence.split();
    String splitSentence = sentence.split();

    WebElement element = driver.findElement(LOCATOR);

WebElement : driver.findElement returns us a WebElement type
	- We can store this type into "WebElement" coming from Selenium
	- Everytime we use this "WebElement" there will be a "freshness" check

.isDisplayed();
	-> Check if a web element is displayed on the page or not
	-> Return type is boolean
	-> If web element is displayed, it returns true
	-> If web element is not displayed, it returns false
	-> It does not accept any arguments
	-> This method does not do any content verification, such as checking/comparing string values etc.
	-> It has only one job! It is to check if the given webElement is displayed on the page or not.

UTILITIES:
	-> We create and add repeated actions/methods inside of this package
	-> good for repeated actions: write once, use repeatedly as needed
	-> good for maintaining your code: in the future if you need to change something from your code, lets say
	->from this:
		WebDriverManager.chromedriver().setup();
	->to this:
        WebDriverManager.chromedriverA().setup();

    You would have to go in all the different classes where you used that specific line and update/change it in hundreds of different places.

    -> But if you have a utility class, and you are getting your method from there, all you need to do is to go to your utility and update 1 or 2 lines to make everything work.

	Shoe factory --> shoe
	cell phone factory --> cell phones
	WebDriverFactory --> it creates and returns web drivers

	Task :
	- Write a static method in WebDriverFactory class
	- Return type is WebDriver
	- method name getDriver
	- it accepts one String argument, and returns the browser according to what string is passed
	- if "chrome" --> returns chrome browser
	- if "firefox" --> returns firefox browser

	geckodriver --> download --> add into your project --> and do same system.setproperty

LAST TWO LOCATORS IN SELENIUM
	When do we use these last two selectors?
	-> When you do not have any other option, you need to go for cssSelector or xpath.
	-> They both have their own syntaxes.
	-> These two locators allows you to create your own CUSTOM locator. Which allows you to locate pretty much everything you need to locate.

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

ex for 1. driver.findElement(By.cssSelector("div[class ='uh7']"));
ex for 2. driver.findElement(By.cssSelector("div.uh7"));
ex for 3. driver.findElement(By.cssSelector("div#fa83"));

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

}
