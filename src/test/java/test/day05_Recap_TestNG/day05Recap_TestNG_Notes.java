package test.day05_Recap_TestNG;

public class day05Recap_TestNG_Notes {
        /*

3- TEST NG

--> What is Selenium?
    - Collection of jar files that allows us to automate browsers.

--> Why are we using Selenium? What advantages Selenium has over other tools?
    - Selenium is open source, which means it is free to use.
    - It supports multiple programming languages, such as: Java, C#, Python, Ruby, JS...
    - It supports multiple browsers.
    - It supports different operation systems (OS), such as: Mac, Windows, Linux.

--> What is a WebElement?
    - Everything we see on the webpage such as links, buttons, input boxes, checkboxes,
    images are web elements on the page.
    I.Q. --> How do you pair with the developers? / How do you communicate with developers
     in your team?
        -> Usually I communicate with the developers in my team via Slack. Occasionally
        the developer or me can walk up to the desk to explain some things.

--> Which method we are using to locate web elements?
    ->  We use findElement method
    ->   findElement method comes from Selenium Libraries.

--> What happens when findElement method cannot locate a webElement?
    -> It throws NoSuchElementException

--> What is the return type of findElement method?
    -> The return type of findElement method is WebElement object-type coming from SELENIUM.

--> GETTEXT VS GETATTRIBUTE

--> .getText() : returns the text of given web element.

        --> Which text does getText() method gets us?
        -> .getText returns us the text that is in between opening and closing tags.

        syntax:
         <openingTag> TEXT </closingTag>
        returns: "TEXT"
    -> it does not accept any arguments
    -> Return type: STRING

--> .getAttribute("attribute value"): returns the attribute value of the given web element
    -> Accepts one String argument
    -> Return type: String
    syntax:
        <openingTag attributeName="value"> TEXT </closingTag>
        driver.findElement(By.Locator).getAttribute("attributeName");
        returns: "value"
ex:
        <div class="h461" id="h7">
            <div name="h131">
                <a href="https://www.google.com"> Click here to go Google </a>
            </div>
        </div
-->  driver.findElement(By.tagName("a")).getText();

        returns : Click here to go Google

    <-----finds the webelement--------><--returns attribute value->
--> driver.findElement(By.tagName("a")).getAttribute("href");

        returns : https://www.google.com

--> What do we have to use to locate web elements with findElement method?
    We need to use locators with findElements method to locate webElements.

--> What is a locator?
    - Code/Statement that allows us to locate web elements.

--> How many types of locators in Selenium?
    - 8 Locators in Selenium.

--> Why do we have 8 locators?
    - The reason we have 8 locators is because in some cases some of the other locators
    are not working due to attribute value being dynamic, more than one etc...
    - Having 8 locators ensures us many different ways to locate all web elements.

 1- id :
    -> ID attribute value is unique to that specific webElement.
    -> Sometime id attribute value can be dynamic(changing).

    How do we know if id attribute value is dynamic or not?
    -> Refresh the page and check if the id attribute value is changing or not.
    normal id  --> id="search-input"
    dynamic id --> id="searchk0192347810938974"
    dynamic id --> id="searchk3897123712938713"
    dynamic id --> id="3897123712938713searchk"
Dynamic attribute value :  if the attribute values are changing everytime we refresh
 the page, the webelement attribute value is dynamic, usually looks fake, or auto-generated

2- name : looks for the value of the name attribute and returns the matching web element
    - it is not always unique.

3- className: looks for the value of class attribute.
    - "class" keyword is reserved keyword in many programming languages.
    - we say "className", but it looks for the value of the "class" attribute.
        <div class="h461" id="h7">
            <div name="h131">
                <a href="https://www.google.com"> Click here to go Google </a>
            </div>
        </div>
ex#1:   driver.findElement(By.name("h131")); --> locates using name attr value
ex#2:   driver.findElement(By.className("h461")); --> locates using class attr value

4- tagName: locates the webElement by tagName itself.
    - returns the first matching tagName
    - Useful usually when you want to return the same type of webelements and store them
     in a List and do some action on them.
    ex: looping through and getting specific web element

5- linkText: locates the webElement by the TEXT OF THE LINK
    - This locator ONLY works on LINKS.
    - If the web element is not stored in <a> tag, we cannot use this locator.
    - Looks for EXACT match! Similar to .equals method in java.
    driver.findElement(By.linkText("Click here to go Google"));

6- partialLinkText:
    - This locator allows us to locate LINKS by their text, BUT it does not expect the
     exact TEXT to be passed.
    - Only checks if the given text is contained in the link.
    - LOOKS FOR PARTIAL MATCH.
    - Similar to .contains() method in java. It only checks if partial text is matching
     or not.
    String word = "one";
    String sentence ="I bought one chocolate yesterday.";
    sentence.equals(word) --> false
    sentence.contains(word) --> true

7- cssSelector:
    -> One of the 8 locators in Selenium webDriver.
    -> It has its own syntax.
    -> It helps us create custom locators to locate webElements using different attributes and values.
    -> We are not just stuck using: id, name, class, linkText.
    -> We can use any attribute and their values to locate.
    -> Common cssSelector syntaxes:
        1- tagName[attribute='value']
        2- tagName.value ==> looks for tagName with given class attribute value
        3- tagName#value ==> looks for tagName with given id attribute value
ex:
A       <div class="h461" id="h7" data-rid="1" data-pos="0">
B           <div name="h131">
C               <a href="https://www.google.com"> Click here to go Google </a>
            </div>
        </div>

    TO LOCATE WEBELEMENT ON LINE A:

--> 1- tagName[attribute='value']    --> div[class='h461']
--> 2- tagName.value                 --> div.h461
--> 3- tagName#value                 --> div#h7 --> #h7

How do we go from parent to child using cssSelector?
ex:
A       <div class="h461" id="h7" data-rid="1" data-pos="0">
B           <div name="h131">
C               <a href="https://www.google.com"> Click here to go Google </a>
            </div>
        </div

-> Locating web element at line A and moving to its child at Line C.
    div[class='h461'] --> this is locating me web element on line A
    div[class='h461'] > div --> locates web element at Line B
    div[class='h461'] > div > a --> locates web element at Line C

How do we go from child to parent using cssSelector?
    -> You can NOT go to parent from child using cssSelector.

8. XPATH->

    How many different  types of xpath are there?
    1- Absolute Xpath:
        - Absolute xpath starts from root element.
        - html is the root element
        - It starts with / "single slash"
        - It is not recommended to use absolute xpath
        - Because it is very fragile. Easily breaks when there is any minimal structural
        changes on HTML code.

ex:     html / body
A       <div class="h461" id="h7" data-rid="1" data-pos="0">
B           <div name="h131">
C               <a href="https://www.google.com"> Click here to go Google </a>
D               <a href="https://www.google.com"> GOOGLE2 </a>
            </div>
        </div
        --> /html/body/div/div/a --> This would return line C.
        --> /html/body/div/div/a[2] --> This would return lind D.


    2- Relative xpath:
        -> Starts with // "double slash"
        -> When we say // it allows us to start from anywhere in the html code.
        -> Basically it searches through the HTML code, and jumps to the webElement we ask to find.
            //tagName
            //body//a
        -> When we say //, it will jump and return all of the given webElements inside of the HTML
        -> When we say /, it will go to the direct child of the given webElement


Commonly used relative xpath syntaxes:
    1- //tagName[@attribute='value'] -> locates the webelement with given tagname, attribute and value.
        ex: //button[@onclick='button1()']
    2- //*[@attribute='value'] --> this does not look for specific webElement(tagName)
    --> JUST returns matching attribute and value
    3- //tagname[.='text'] --> this is locating using text of the given webElement
ex:     html / body
A       <div class="h461" id="h7" data-rid="1" data-pos="0">
B           <div name="h131">
C               <a href="https://www.google.com"> Click here to go Google </a>
D               <a href="https://www.google.com"> GOOGLE2 </a>
            </div>
        </div
If we are using attribute value with xpath, and it is returning us more than 1 option:
    1- We need to surround the whole xpath with paranthesis.
        ---> (//button[@class='btn btn-primary'])
    2- We need to give the index number of the webelement we want to get
        --> [2] or [1] or [4]
ex: (//button[@class='btn btn-primary'])[3]

HOW TO GO FROM PARENT TO CHILD USING XPATH:
    -> To go to child web element using xpath we need to pass / "single slash"
ex:     html / body
A       <div class="h461" id="h7" data-rid="1" data-pos="0">
B           <div name="h131">
C               <a href="https://www.google.com"> Click here to go Google </a>
D               <a href="https://www.google.com"> GOOGLE2 </a>
            </div>
        </div
LOCATING WEBELEMENT ON LINE B:
    - //div[@name='h131'] --> locates the web element on line B
GOING TO LINE C:
    - //div[@name='h131']/a[1] --> returns web element at line C
    - //div[@name='h131']/a[2] --> returns web element at line D


HOW TO GO TO PARENT USING XPATH: /..
ex:     html / body
A       <div class="h461" id="h7" data-rid="1" data-pos="0">
B           <div name="h131">
C               <a href="https://www.google.com"> Click here to go Google </a>
D               <a href="https://www.google.com"> GOOGLE2 </a>
            </div>
        </div


LOCATING WEBELEMENT ON LINE B:
    - //div[@name='h131'] --> locates the web element on line B
Going from line B to A:
    - //div[@name='h131']/.. --> locates the web element on line A

- When we are using xpath and it gets kind of complicated, and you don't know where to start and what to do: OUR GOAL is to find one stable/unique webElement. And move to our target webElement from that point.
- It does not have to be parent, or child, or direct parent, or direct child, as long as it is stable and unique we can use it.
Why you should not use locator tools such as Chropath, firepath etc?
-> Locating web elements are the responsibility of testers
-> First of all, those tools are not always giving you dependable results.

IS CSS SELECTOR OR XPATH BETTER?
-> They both have their advantages and disadvantages.
-> Depends on your situation, or your personal preference you can use either one.
-> Both will allow you to locate webElement
-> You cannot go to parent from child using css, but you can do that with xpath /..
https://stackoverflow.com/questions/16788310/what-is-the-difference-between-cssselector-xpath-and-which-is-better-with-resp#:~:text=3%20Answers&text=CSS%20selectors%20perform%20far%20better,well%20documented%20in%20Selenium%20community.&text=Xpath%20engines%20are%20different%20in,for%20compatibility%20of%20its%20API.
------------------------

HOW DO WE MANUALLY CREATE PROJECTS?

1- Create folder structure
2- We add libraries
3- We create class files
4- We compile those files
5- Test
6- Deploy
WHAT IS MAVEN? A BUILT AUTOMATION TOOL
WHAT IS A BUILT?
    -> The process of Creating, adding libraries, compiling, testing, and deploying.
    -> This whole process is called a BUILT.
Are there any similar tools like MAVEN?
    - YES.
    - Gradle, Ant are two of the other popular built automation tools.
You can run your maven project from terminal using commands, such as;
    - mvn test
    - mvn clean
But to do that you need to download and install maven.
Is Maven for test automation engineers?
    -> No.
    -> Maven was created for developers.
    -> But as testers we take advantage of the automated steps.
pom.xml
    -> writes and reads pom.xml
    -> stands for: project object model
    -> This file centralizes managing dependencies and version controls
    -> We are able to add libraries(dependencies) and change versions from just 1 file
-> When you create a maven project, maven automatically creates a folder called:
    ~./m2
-> this is a hidden file where maven downloads your dependencies.

--> IMPLICIT WAIT VS THREAD.SLEEP

     -> Thread.sleep();
	- This comes from java
	- Thread.sleep makes the whole code stop & wait for the given duration
	- It does not look for any conditions. It only wait for the given duration.
	ex: Thread.sleep(2000); --> will wait for 2 seconds

-> Implicit wait
	- Where does implicit wait come from?
	- It comes from Selenium.
	- This will wait UPTO given time duration, and check DOM(HTML).
	- Continues when all webElements are loaded on the page.

	syntax: driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

	-> Lets say if the page is loaded at 3 seconds in, what happens?
	-> It just moves on with the execution of the rest of the lines.

findElements()-->
	-> What is the return type of this method?
	-> This returns List of WebElements
	-> So if we have to store whatever this method is returning, we have to create a JAVA List, with the type <org.openqa.selenium.WebElement>

	Syntax: List<WebElement> listA = driver.findElements(By.locator);

	-> What happens if it does not find a web element?
	-> It does NOT throw an exception.
	-> It returns an empty list.


- Checkboxes and radio buttons
	- checkbox:
		- allows for multiple selection
		- checkboxes act independently from each other
	- radio buttons:
		- allows only one of the options to be selected
		- the reason is, the radio button options are acting as a group

HOW DO WE HANDLE CHECKBOXES AND RADIO BUTTONS USING SELENIUM?
	- We locate, and we click on them.

	-> isSelected()
		- This method checks if the checkbox/radiobutton is selected or not selected.
		- The return type of this method is: boolean
		- If the checkbox/radio button is selected --> isSelected()--> true
																else --> false
	-> isEnabled()
		- This method checks if the checkbox/radiobutton is enabled to be clicked.
		- The return type of this method is: boolean
		- If the checkbox/radiobutton is clickable/enabled --> isEnabled -> true
																else --> false

	syntax: driver.findElement(LOCATOR).isSelected();
	syntax: driver.findElement(LOCATOR).isEnabled();


org.openqa.selenium.StaleElementReferenceException:
	-> A stale element reference exception is thrown in one of two cases, the first being more common than the second:

		1- The element has been deleted entirely.
		2- The element is no longer attached to the DOM.
			- If there are any type of navigations that happened on the page, where your driver previously was able to locate the web element, after navigations StaleElementReferenceException will be thrown.

--> For this exception to be thrown, the driver is supposed to locate this web element first.
	- Then some kind of action happens, such as: web element is deleted from the page OR some simple navigation happens (refresh, forward, back). Then, your driver will not be able to locate the same web element even though it is in the HTML.

	WebElement checkbox = driver.findElement(LOCATOR);

	checkbox.click;

	driver.navigate().refresh();
	checkbox = driver.findElement(LOCATOR);//so, we have to refresh selenium mind
	checkbox.click();  <--stale element reference exception will be thrown


// after refresh, driver will not be able to do any action on checkbox webelement, UNTIL WE RELOCATE/REFRESH the reference.

-If the web element is completely removed we just need to use try/catch and catch the exception and do our verification



        TESTNG --> NG STANDS FOR NEXT GENERATION


WE ARE NOW ADDING TESTNG LIBRARY TO OUR PROJECT
	1- GO TO MVNREPOSITORY.COM
	2- Type : "TestNG" into the search box
	3- Get the first dependency
	4- Add it into our project pom.xml file

If your TestNG dependency is still RED
	 Right click on project name > MAVEN > Re-import

TestNG ->
	- Is a unit testing tool
	- Allows us to create test structure using annotations, and provides assertions for verifying

ANNOTATIONS:
	-> What are annotations?
		- Annotations are a way of controlling the flow of tests.

1- @Test :
	 -> Allows us to create TestNG tests
	 -> We create java methods, and put @Test on top of it
	 -> Import from TestNG
	 -> That method becomes a TestNG test
	 -> Therefore we can run independent tests without needing main method.


2- @BeforeMethod:
	 -> This annotation makes the method run before each @Test in the class
	 -> You declare and write it just once, but it will be ran however many times
	  you have @Test in the class.

	In which case this is useful?
	 -> This is useful when you want to do any driver setups.
	  ex:
	  	-> creating and instantiang webDriver
	  	-> opening browser

3- @AfterMethod:
	-> This annotation makes the method run AFTER each @Test in the class
	 -> You declare and write it just once, but it will be ran however many times you
	 have @Test in the class.

	In which case this is useful?
	 -> This is useful when you want to do tearDown stuff.
	 -> When you are finalizing your method, you want to close drivers, browsers etc.
	  ex:
	  	-> closing/quitting driver
	  	-> closing browser
         */
}
