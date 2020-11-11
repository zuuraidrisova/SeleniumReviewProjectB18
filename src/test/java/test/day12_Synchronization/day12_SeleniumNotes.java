package test.day12_Synchronization;

public class day12_SeleniumNotes {
    /*
    JULY 7TH, TUESDAY

TODAY'S SCHEDULE
-RECAP
-SOLVE TASKS
-SYNCHRONIZATION
-JUNIT

FRIDAY
-DIFFERENT TYPES OF FRAMEWORKS
-WHAT IS BEHAVIOR DRIVEN DEVELOPMENT FRAMEWORK
-CUCUMBER
-CREATE A NEW PROJECT AND IMPLEMENT CUCUMBER

=======================================================

- PAGE OBJECT MODEL DESIGN PATTERN

- WHAT IS PAGE OBJECT MODEL?
-> PAGE OBJECT MODEL IS NOT A FRAMEWORK, IT IS A DESIGN PATTERN.
-> We implement design patterns into our existing frameworks.
-> Simply put, page object model is creating Java classes for each page of the web application we are working on.
-> We put relevant web elements and actions belonging to these pages.

LOGIN PAGE
-> LoginPage.java
    -> username input
    -> password input
    -> login button
    -> forgot password link
    -> remember me
    -> error message when we enter username/password wrong
    -> create and store login method into this class

HOME PAGE
-> HomePage.java
DRIVERS
-> DriversPage.java
SALES
-> SalesPage.java

- HOW DID YOU/DO YOU IMPLEMENT IT INTO YOUR FRAMEWORK?
- We implement page object model in 2 steps.
Step #1:
-> We create a public constructor of the class.
-> Then we use PageFactory.initElements();

-> What does PageFactory.initElements(); this line do?
-> This method accepts two arguments.
-> driver instance, and the object reference of the class
-> AND => IT CREATES CONNECTION BETWEEN THE DRIVER AND THE OBJECT REFERENCE OF THE CLASS.

public class HomePage{

        public HomePage(){

                    PageFactory.initElements(Driver.getDriver(), this);
        }

       WEBELEMENTS;
}


CLASS B
HomePage homePage = new HomePage();

homePage.webelement.sendKeys();

-> STEP #2:
- We use @FindBy annotation to locate web elements
- We are able to use one of 8 locators of selenium to locate web elements

syntax:

@FindBy(id="something")
public WebElement searchBox;

homePage.searchBox.sendKeys(); -->

=> handling more than one web element

@FindBys(xpath = "//some xpath")
public List<WebElement> listOfSomething;

How do we achieve PAGE OBJECT MODEL DESIGN PATTERN?

Step1: Create constructor and add PageFactory.initElements method
Step2: Use @FindBy annotation to locate web elements.

- ADVANTAGES:
#1: Re-usability : it reduces the code duplication
#2: Easy to maintain : if something changes, we go 1 class and fix there
#3: Easy to read-understand (for ourselves, and the team)

- DISADVANTAGES:
-> In the beginning it takes more time to get to the writing the tests phase.
(advantage coming from the disadvantage)
-> But the more web elements we create in the beginning, the less work is left
for us in the future. So later on, we will just keep re-using the methods.

HOW DO WE KNOW WE ARE ON A NEW PAGE?
-> If either the title or the URL is changing it means we are on a new page.

--> One selenium session starts, when we run our code. And ends when we do final assertion and the code stops.

===========================================================

SYNCHRONIZATION:
SYNCHRONIZATION means moving, working, acting together at the same time.

->In our case: We want the webdriver and the browser to be synchronized.

What can we do to achieve different types of SYNCHRONIZATION?

-> OPTION #1: Thread.sleep
- Coming from JAVA, not Selenium.
- Stops the execution of the code with no conditions checked.
- If we say wait for 10 seconds, it will stop the execution of the whole code for 10 seconds.
- It is not considered a good practice to use Thread.sleep.
- You should not use it UNLESS you have to.

-> OPTION #2: Implicit Wait
- Implicit wait is coming from selenium.
- The default value is 0.
- Every time findElement, findElements method is used, this implicitlyWait method is triggered.
- We set this once, and it applies to every time we are trying to find element.

to understand further:
When we use find element method:

findElement():
-> takes a locator for WebElement

if (web element is found)
-> returns the webElement
if (web element is not found)
-> throw NoSuchElementException

--> if you already have set implicit wait:

-> if WebElement is not found yet
-> it will trigger the implicitlyWait method. (10, TimeUnit.sec)
-> it will wait for the given time
-> in that given seconds if driver can find the web element we are looking for,
    it will return the web element and continue with the execution of the code
else (if it cannot find)
-> it throws NoSuchElementException

Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

--> It will wait UPTO given seconds.
--> Let's say I gave 20 seconds wait, but web element was found 5 seconds into it:
-> driver will continue with the execution. It will not wait for the rest of the 15 seconds.

command + shift + c ==> for immediately inspecting a web element
control + shift + c ==> for immediately inspecting a web element

================================================================

WEBDRIVERWAIT CLASS
-> When do we need to use WebDriverWait class?
-> If we are waiting for some specific situation to happen, we can use WebDriverWait class.
-> For example:
- visibility of web element
- invisibility of web element
- titleIs --> looks for exact title match
- titleContains --> looks for partial title match
- elementToBeClickable
- URL Contains something
- attribute value to be something specific

- We should always try to use WebDriverWait whenever we can, to save time.
- This will wait UPTO given seconds, just like implicit wait.
- It will immediately continue after the condition is true.
- It will throw TimeOutException when the condition does not happen.

HOW TO USE WEBDRIVERWAIT / EXPLICIT WAIT IN SELENIUM WEBDRIVER?

- We need to remember 2 steps:
1- To create the object of the WebDriverWait class.

syntax:

WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

2- To use the object we just created "wait", to be able to create our explicit wait condition.

wait.until(ExpectedConditions.invisibilityOf());
wait.until(ExpectedConditions.visibilityOf());
wait.until(ExpectedConditions.titleIs());
wait.until(ExpectedConditions.titleContains());

WHAT COULD BE REASONS FOR GETTING NoSuchElementException?
#1 - Wrong locator
#2 - Page loading slowly : whenever we are checking web element is not in html yet
#3 - findElement : everytime we try to locate a webelement, if web element
        is not found, it will throw no such element exception
#4 - iframe : if there is an iframe, and we don't switch to it, even with correct
        locators we will get NoSuchElementException.

========================================================

JUNIT : is unit testing framework/tool
-> Very similar to TestNG. In fact, TestNG was inspired by JUNIT
-> JUNIT is a light weight version of TestNG

@Test : same as TestNG
- Used to make methods a test

@Before :
-> Similar to BeforeMethod in TestNG, it runs BEFORE each Test.

@After :
-> Same as the AfterMethod in TestNG, it runs after each Test.

@BeforeClass, @AfterClass : Runs before and after class same as TestNG.
-> The only difference is these methods should be static

@BeforeClass
public static void setUpClass(){

}

     */
}
