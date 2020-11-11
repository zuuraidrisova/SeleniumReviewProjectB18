package test.day13_FullReviewSession;

public class day13_SeleniumReviewNotes {
    /*
    JULY 9TH, THURSDAY

TODAY WILL BE FULL REVIEW SESSION

--> WHAT IS SELENIUM?
-> Selenium is a collection of jar files that allows us to automate browsers

--> WHY ARE WE USING SELENIUM? What are the advantages of Selenium?

-> OPEN SOURCE --> It is FREE
-> It supports multiple programming languages
-> It supports multiple BROWSERS
-> It supports multiple OS : MAC, Windows, Linux, ...
-> There is a huge community behind it supporting, and advancing selenium libraries.

--> What is a web element?
-> Everything we see on a web page such as images, buttons, links, inputs etc.

--> GETTEXT VS GETATTRIBUTE VALUE METHODS
-> What are the return types? And similarities, differences?
- First we need to say what they actually do.

- getText():
- getText ==> get the text of the webElement that is in between the OPENING TAG AND CLOSING TAG
- getText does not accept any argument
- Return type is String
EX:
<a href="https://google.com"> LINK TEXT </a>

--> getText would return : LINK TEXT

- getAttribute("attribute"):
- getAttribute returns the value of given attribute as a String
- Accept a string as an argument
- RETURN TYPE: STRING

EX:
<a href="https://google.com" class="hm45"> LINK TEXT </a>

webelement.getAttribute("href") --> https://google.com
webelement.getAttribute("class") --> hm45

---> WHAT ARE LOCATORS? AND HOW MANY LOCATORS IN SELENIUM?
-> Locators ARE methods,or code statements to locate a web element and we have 8 locators
-> id, name, classname, tagname, linktext, partialLinkText, cssSelector, xpath

---> WHY DO WE HAVE 8 LOCATORS?
-> The reason we have 8 locators is because to have flexibility.
-> Where one doesn't work, the other one will work.

---> How many types of XPATH are there?
-> 2 types of xpath

1- Absolute xpath :
- Starts from the root web element : HTML. and goes down 1 by 1 from parent to child.
- / starts with single slash

ex: /html/body/div/div/div/img

- Why should we avoid using absolute xpath?
- Not reliable, because it will easily break with any changes in HTML structure change.

2- Relative xpath:
- // starts with double slash
- it allows us to start anywhere in the html code, it is more reliable because
 we are starting from either the webelement itself OR one of the static parents or childs.
- // when we say // it will jump to the the given web element

//div --> this will jump to the first div it finds

//div[@attribute='value'] --> more specific relative xpath
//button[.='text'] --> locates the webelement with the given text

- instead of giving tagName, if you pass *, it will only check for attributes and values.

- Whenever you are having hard time locating with xpath, always try to find a
static (stable/non changing) parent or child to the desired web element we are
trying to locate. And go from there

====================================================

---> WHAT IS MAVEN?
-> BUILT AUTOMATION TOOL
-> MAVEN HELPS US CREATE AND MANAGE PROJECTS EASiLY

---> WHAT IS BUILT?
- Creating, adding, compiling, testing, AND deploying a project: all of these steps are called A BUILT.
- Since maven is BUILT AUTOMATION TOOL it helps us automate all of these steps.

---> Similar tools like maven : Gradle, Ant, and many others.

---> We can run maven in terminal as well. We need to install the maven into our computers.
- The maven that comes inside of IntelliJ is limited inside of IntelliJ.

---> What is pom.xml and what do we do with this file?
-> pom.xml stands for PROJECT OBJECT MODEL
-> It is an .xml type of file
-> xml stand for Extensible mark up language
-> We manage all the dependencies in our project from pom.xml
-> It also helps us to manage versions of our dependencies

----> When you create a maven project, maven automatically creates a folder called :
--> .m2
--> hidden folder

---> Differences between findElement and findElements:

--> findElement:
-> Return type is WebElement
-> if it does not find anything with the given locator, it will throw NoSuchElementException

--> findElements:
-> Return type is List<WebElement> : list of web elements
-> it does not throw exception if web element is not found.
-> it will simply return an empty List.

---> Checkboxes and radio buttons:
- How do we handle?
- We just locate as any other web element and we use click method to click them.
- isSelected() method verifies if checkboxes or radiobuttons are selected or not.
-> return type of isSelected(): -- boolean
- if given checkbox/radiobutton selected, it will return true, if not false.
- isEnabled() method:
-> This method just checks if the checkbox is clickable or not.
-> if it is enabled, it will return true if not false.

syntax: checkbox.isSelected();
        checkbox.isEnabled();

---> TESTNG --> TEST NEXT GENERATION

- WHAT IS TESTNG?
- TestNG is a unit testing tool
- TestNG allows us to create test structure using its annotations

- To add TestNG we need to add libraries of it. If we are using maven,
all we need to do is to add the dependency into our project.

---> What are some of the annotations in TestNG?
- There are around 15 annotations in TestNG.

@Test : makes the annotated method a TestNG test.
- So that we can do assertions inside that test method.

---> DROPDOWNS

HOW MANY TYPES OF DROPDOWNS DO WE HAVE?
- 2 types of dropdowns

1- HTML dropdown :
2- Select dropdown

How do we know if it is select or html dropdown?
- We inspect. If we see <select> tag, it is select dropdown

1- How do we handle HTML dropdown?
- We just locate it as any other web element using one of the 8 locators
    of selenium. And click.Subject to the same methods as other web elements.

2- How do we handle Select dropdowns?
- We need to create and object of the Select dropdown.

Select dropdown = new Select(WebElement);
Select dropdown = new Select(driver.findElement(By.id("drowdown")));

How many ways there are to select from a dropdown?
-> We have 3 ways to select from dropdowns.

1- SelectByVisibleText --> select.selectByVisibleText(“option1”);
-->this method accept a String argument and select the option with thw given text.

2- SelectbyIndex --> This method accepts an int argument as the index number of the option.

<select id="dropdown">
0 <option value="0">Please select an option</option>
1 <option value="1">Option 1</option>
2 <option value="2">Option 2</option>
</select>

--> Indexes start from 0.
EX: if we want to select option at number 2 : we need to pass index 2

3-By value --> this method uses the value of the attribute “value” to select options
-->

<select id="dropdown">
0 <option value="IL">ILLINOIS</option>
1 <option value="VA">VIRGINIA</option>
2 <option value="NY">NEW YORK</option>
</select>

EX: need to pass NY

select.selectByValue("NY") --> this will select New york option from dropdown

-----------------

-> How to get the currently selected option?
- select.getFirstSelectedOption();

-> How to get all of the options from a dropdown?
- select.getOptions(); --> this will return all of the options
- What is the return type of this method?
- List of webelements

===============================================

ALERTS:

HOW MANY TYPES OF ALERTS ARE THERE?
- TWO TYPES OF ALERTS

1- HTML ALERTS : We just locate it as another web element. Then click to handle.

2- JavaScript Alerts : We cannot locate this from the html using regular selenium locators.

How do we handle JS Alerts?
- We handle alerts using Alerts class.
- Alerts coming from selenium.

- We need to switch to the alert using Alert instance.

syntax : Alert alert = driver.switchTo().alert();

Alert alert = Driver.getDriver().switchTo().alert();

How many types of JS Alerts?
- 3 types of JS Alerts.

1- Warning/Information : We have only one option: to accept.
2- Confirmation : We have two options: to accept or dismiss.
3- Prompt : We can accept, dismiss AND sendKeys as additional information.

alert.accept();
alert.dismiss();
alert.sendKeys("text goes here");

====================

IFRAME: INLINE FRAME

-> HTML INSIDE OF ANOTHER HTML
-> WHY DO WE HAVE TO SWITCH TO ANOTHER IFRAME?
- Because selenium can only focus one thing at a time.
- To be able to do any action inside of the inner frame we need to switch to it.

syntax: driver.switchTo().frame();

We have 3 ways to switch to iframe:

1- INDEX: We pass the index number of the frame we want to switch
driver.switchTo().frame(0);

2- ID OR NAME ATTRIBUTE VALUE:
driver.switchTo().frame("idValue");
driver.switchTo().frame("nameValue");

3- Locating the <iframe> web element with any of the locators and passing it into
.frame() method

driver.switchTo().frame(WebElement);

=================================

WINDOWS/TABS:
-> windowHandle/windowHandles
-> We have to change selenium's focus to the window/tab we want to work on.

How do we do that?
-> Using windowHandles.

A windowHandle : is randomly generated string that is unique to each window.

syntax to get window handle:
driver.getWindowHandle();

What is the return type:
- Returns a String which is the handle of current window

How to get all of the window handles?
- driver.getWindowHandles();
- Return type:
-> Set of Strings : set does not allow to store any duplicate values.
-> Everything must be unique inside the set.

syntax to switch to window:

driver.switchTo().window(windowHandle);

===========================================

PROPERTIES:
-> What kind of data (what format) does the properties file store?
-> KEY AND VALUE FORMAT
-> We want to avoid hard coding some of the important test data.
-> For this reason, we use properties file to pass some important test data that
    can change the flow of running of our test.

- configuration.properties:
-> browser : by changing one value of a key, we run on different browser
-> url
-> username, password

- What is cross browser testing?
- Running the same tests on different browsers.

- What is called running the same TESTS on different data sets?
- DATA DRIVEN TESTING

- What is parallel testing?
- Running tests on different machines.

- Why do we do parallel testing?
- To save time.

===================================

What is Singleton design pattern and how do we achieve it?

-> The singleton pattern is a software design pattern that restricts
    the instantiation of a class to one "single" instance.
-> We want to get the same instance everytime we call that object.

This is useful when exactly one object is needed to coordinate actions across the system.
 The term comes from the mathematical concept of a singleton

-> We used Singleton Design pattern in our Driver utility.
-> We can decide which web driver instance will be used

How do we achieve it?
-> We create a private constructor. And create a getter method to return the same object.

======================================

ACTIONS:
What does Actions class allow us to do?
- Allows us to handle advanced mouse and keyboard actions.
- Such as:
- hover over
- drag and drop
- double click
- right click

How do we use Actions?
    - We create an instance of Actions class and pass our driver reference
        into its constructor

syntax: Actions action = new Actions(Driver.getDriver());

action.methodName.perform();
action.moveToElement(webElement).perform();
action.doubleClick(WebElement).perform();


     */

}
