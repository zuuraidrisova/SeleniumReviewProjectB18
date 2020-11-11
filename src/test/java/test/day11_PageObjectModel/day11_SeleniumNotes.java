package test.day11_PageObjectModel;

public class day11_SeleniumNotes {
    /*
    JULY 6TH, MONDAY-FUNDAY

TODAY'S SCHEDULE
-Recap about last class
-Solve tasks
-Page object model design pattern
-PracticeS

===========================================================================

HOW DO YOU HANDLE DOWNLOADS WITH SELENIUM?
-> WE DON'T/CAN'T.
-> Selenium cannot handle downloads except for the clicking the link part.
-> Since selenium can only work with browsers, and the file is downloaded to
 the computer file directory, we cannot verify a download using selenium.

HOW DO WE HANDLE UPLOADS WITH SELENIUM?
-> We can upload files using selenium by sending the path of the file into the upload web element.

syntax: uploadWebElement.sendKeys("path of the file");

===========================
JAVASCRIPTEXECUTOR:
-> WHAT IS JAVASCRIPTEXECUTOR?
- Just an interface with two methods.
-> What can we do with these methods?
- JavaScriptExecutor allows us to execute/inject javascript code into our java/selenium code.
-> When do we need this?
- Whenever selenium is not capable of some of the actions we need to do, such as scrolling down.

=================
ACTIONS:
-> WHY DO WE NEED ACTIONS CLASS? WHAT DOES IT DO?
-> Actions class allows us to handle complex/advanced mouse and keyboard actions. Such as:
-> hover over : moveToElement
-> right click: contextClick
-> dragAndDrop: allows us to drag and drop a web element
-> clickAndHold: clicks onto something and waits for next command
-> release :
How do we use Actions methods?
1- To be able to use any Actions method, we need to create the instance of the actions class.
2- Then we need to pass the current driver instance into the constructor.
3- We must use : perform() method at the end to be able to perform any actions method.

====================================================

How many ways to scroll down?
1- Using JavaScriptExecutor
2- Using Actions moveToElement method.

====================================================

WHAT TOOLS WE ARE USING IN OUR FRAMEWORK SO FAR
-> Java
-> Selenium
-> TestNg
-> Faker faker new faker
-> WebDriverManager (boni garcia)

What does our folder structure look like?

- seleniumprojectb18
    - src
        - test
             - java
                 - test --> this is where we keep our tests
                 - utilities --> this is where we keep our utils
    - configuration.properties
    - pom.xml

-> WHAT DESIGN PATTERN WE USED SO FAR?
-> We used Singleton Design Pattern
-> We created Driver utilities using Singleton Design Pattern.

-> How did we achieve singleton?
-> We created private constructor, and created a method to return the instance of that class. (WebDriver)

- A design pattern is not a framework. It is just the part of a framework.
- Usually just another layer in our framework to make "something" easy to handle for ourselves.

- The framework: is the overall folder structure, design patterns, utilities, and how all of this implemented and working together.

===========================================

PAGE OBJECT MODEL:

What is page object model design pattern:

-> Page object model is creating JAVA classes for the each page of the web application.
-> We will store web elements and methods related to that PAGE into its own JAVA CLASS.

TWO THINGS TO KEEP IN MIND WHEN CREATING PAGE OBJECT MODEL DESIGN:

1- Everytime you create a new class, you need to pass the line below into the constructor:

PageFactory.initElements(driver, this);

PageFactory --> is coming from selenium library

What does this line do?
- It creates connection in between our driver, and the object of the current class.

2- @FindBy annotation to locate webElements.
-> FindBy annotation also comes from Selenium library.
-> Using this FindBy annotation, we can use any 1 of 8 locators of selenium to locate web elements.

What are the advantages Page Object Model?

1-> Re-usability : we are creating one locator for each webElement and keep reusing the same object

2-> Easy to maintain : since we are creating and locating each web element only once
in its own related class, when we have issue with that web element we only go fix
it in one place.

3-> Easy to manage : we are managing all web elements of the relevant page from its own JAVA CLASS
     */
}
