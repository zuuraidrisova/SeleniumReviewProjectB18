package test.day02_FindElement_GetText_GetAttribute;

public class day02SeleniumNotes {

    /*
    JUN 5, FRIDAY
Selenium -->
    - Basically a collection of jar files
    - The jar files have classes
    - And these classes have ready methods
    - We use these jar files to allow ourselves to do action on the browsers with the help of browser drivers

Maven -> Maven is a built automation tool
    - Normally maven is used by developers to develop the application
    - Maven helps us automating creating projects
    - It gives us pre-configured folder structure with pom.xml
    - pom.xml file is the most important file in the maven project
    - it helps us manage & add dependencies
    - it helps us control versions on the tools and dependencies we are using
    - you should always know what version of which tool you are using
    currently used version:
        -> java 8
        -> selenium 3.141.59
        -> WebDriverManager 4.0.0

Built automation tool: What is built?
    Built is the repeated processes when you are creating a project
        -creating folder structure
        -compiling
        -adding jarfiles, dependencies
Is maven for testers?
    - No. it is for developers. But we will take advantage of some of the functionalities provided by maven.
    Such as pom.xml file and the existing folder structure
Are we going to use maven to its full extent?
    - No. We will not be using maven's all of the functionalities.

What is the folder structure of your current framework?
Interview Question: Gave pen and paper. And was told to draw the folder structure of the current framework.
    projectName
        src
            main --> this folder is used by developers to develop the application
            test --> this folder is used by developers to write their UNIT tests
                java
                    test
                        day1_selenium_intro
        pom.xml

So in real world, if developers use both the main and test folders,  what folder the testers work on?
    - In the real work environment, you will not be working on the the project where the application is being developed.
    - You will create your own project, and work on the that one.

System.setProperty("the type of driver", "path to the driver");
WebDriverManager.chromedriver().setup(); -->
    - This line is creating the connection between the browser driver and the selenium
    - These two lines are doing the same thing.

intranet -> repository -> get dependencies from there==> if company is concerned abt their privacy

WebDriver driver = new ChromeDriver(); --> opens chrome browser
WebDriver driver = new FirefoxDriver(); --> opens firefox browser

driver.get("URL") -->
    - this method allows us to go any URL we want to on an open browser
    - Accepts a String parameter

PROJECT DOCUMENTATION:
    - It is better to document what your classes and methods are created about.
ex: web element name-->  manageInterestCollectionButtonHomePage

driver.getTitle() -->
    - Returns the title of the page as a String
    - Does not accept any arguments
    - Return type: String

driver.getCurrentUrl() -->
    - Returns the currentURL of the page as a String
    - Does not accept any arguments
    - Return type: String

driver.navigate().forward()
driver.navigate().back()
driver.navigate().refresh()
driver.navigate().to("URL")
    -> to method, does exactly the same thing with .get("url") method
    -> it accepts a String argument
    -> the difference between .get and navigate().to() is get method will wait the page to
     be loaded, but navigate().to() method will not wait. It will just continue to the page.

driver.manage().window().maximize() --> makes the opened browser page full screen

driver.close() --> closes the currently opened browser page

driver.quit() --> will close all of the opened browser pages (tabs)

- To be able to do any action on any web element we need to locate that web element
 for the selenium webdriver.
- We will use findElement method that comes from Selenium to locate web elements
.findElement(By.locator) -->
    - This method finds and returns a single WebElement
    - return type is WebElement
    - Whenever it cannot find a webElement by given locator, it will throw NoSuchElement exception

.sendKeys("text to be sent here") ==> this method will send the keys to the located web element
    --> accepts a string parameter to be sent
    syntax: driver.findElement(By.locator).sendKeys("text here");

.click();
    --> clicks to the webelement that we located
    --> does not accept any arguments
    --> does not have a return type

LOCATORS : There are 8 different types of locators in Selenium

    1- name: This locator will be looking into the whole HTML code, and return the
     WebElement with matching name attribute value
        - it will find and return the first webelement it finds
    syntax: driver.findElement(By.name("name attribute value"))

2- linkText:
    --> linkText is one of the 8 locators of Selenium
    --> this locator allows us to locate LINKS by their texts
    --> this locator will ONLY WORK ON LINKS
    How do I know if the webELement is a link or not?
        ->If it is stored inside of <a> tag, it is a link
    <a href="https://www.google.com"> TEXT HERE </a>
    TagName --> a --> anchor tag --> used for HTML links
    attribute --> href
    attribute value --> https://www.google.com
    LINK TEXT --> TEXT HERE
    ex: driver.findElement(By.linkText("TEXT HERE"));

3- partialLinkText:
    --> partialLinkText is one of the 8 locators of Selenium
    --> this locator allows us to locate LINKS by their texts, BUT it does not expect
    the exact text to be passed. Only check if the given text is contained in the link
    ex: <a href="https://www.google.com"> TEXT HERE </a>
        driver.findElement(By.partialLinkText("TEXT"));
        driver.findElement(By.partialLinkText("HERE"));
    You can compare this with .equals and .contains methods from Java.
    linkText --> .equals --> checks for the exact match
    partialLinkText --> .contains --> checks for partial match of the text

4- id:
    --> id is one of the 8 locators in Selenium
    --> id will locate by matching id attribute's value
    --> id is unique for that specific web element
    --> if you have id and it is not dynamic (meaning the attribute value is not
    changing when you refresh the page) you should always use id
    syntax: driver.findElement(By.id("id attribute's value"))

5- className:
    --> className is one of the 8 locators in Selenium
    --> className is not unique, there could be multiple values of the same attribute value
    --> this locator will return the first one it finds
    syntax: driver.findElement(By.className("class attribute's value"))

6- tagName :
    --> tagName is one of the 8 locators in the Selenium
    --> tagName locates using the tagName itself
    --> the use case for this locator is very small
    --> usually good for when you want to locate all of the same type of web Elements
    --> for example : if you want to return all of the links on the page you can use it with findElements
    syntax : driver.findElements(By.tagName("a"))
    syntax : driver.findElements(By.tagName("div"))
    syntax : driver.findElements(By.tagName("input"))
    syntax : driver.findElements(By.tagName("h1"))

.getText() -->
    --> This method will be getting the text of the given web element
    --> It does NOT accept any arguments
    --> It returns the text of the web element as a STRING
    --> Return type : String
    syntax: how to use this method.
    <a id="ubt7" href="https://www.google.com">CLICK HERE TO GOOGLE</a>
    driver.findElement(By.id("ubt7")).getText();
        --> return "CLICK HERE TO GOOGLE" as a String

.getAttribute("attribute name") -->
    --> This method will be returning the value of given attribute
    --> Accepts a string as an argument
    --> Returns a string value
    How to use .getAttribute("") -->
    1- we need to locate the webelement
    2- we decide which attribute value we get
    3- we pass the attribute name inside of the method
    4- this method will be returning the value of the attribute
    syntax:
    <a id="ubt7" href="https://www.google.com">CLICK HERE TO GOOGLE</a>
    driver.findElement(By.linkText("CLICK HERE TO GOOGLE")).getAttribute("id")
    returns --> ubt7

how to duplicate lines in intelliJ
    --> MAC : Command + D
    --> Windows : Cntrl + D

How to search anything in the HTML inspection?
    - while inspecting page is open, press cmd + F or cntrl+ F to open the search bar.
    - type your keywords to check if it is unique or not

     */
}
