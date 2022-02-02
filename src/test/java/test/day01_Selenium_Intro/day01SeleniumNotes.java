package test.day01_Selenium_Intro;

public class day01SeleniumNotes {

    /*
    JUN 2, TUESDAY

HTML -->
- Hypertext markup language
- It is a MARK UP language.
- Mark up languages are created using TAGS.

TAG -->
- Tags act like containers
- Tags allow users to apply specific structure to HTML content

What kind of tags we have seen so far?

- Two types of tags
1- Paired tag; aka- non-self closing
syntax: <openingTag> content </closingTag>

ex: <p> lorem ipsum </p>
<h1> content </h1>
table, body, li, title, div
<a href=""> link text </a>

2- Unpaired tag; aka SELF CLOSING TAGS
sytax : <tagName/> usually has some attribute and value to provide further information about the tag
ex:
<input type="text">
<img src="" />


What is attribute and attribute value?
- Attributes are used to provide further information about the tags.
snytax: <tag attribute="attributeValue"/>
<openingTag attribute="attributeValue"> content </closingTag>

ex #1:
<a href="link">CLICK HERE TO GO GOOGLE</a>

a --> tag
href --> attribute
link --> attribute value
content always goes in between the opening tag and the closing tag

ex #2:
<table border = "1px"> </table>

table --> tag
border --> attribute
1px --> attribute value

WHAT IS PARALLEL TESTING?
- Parallel testing is when you increase the number of machines/testers to reduce the time of testing.
- If you have 1 machine running 4 tests (1 hour each) it would take 4 hours total
- You can create 4 machines running 1 test each, all of the tests would be completed in 1 hours.

ex: 1 machine --> 4 tests (1 hour each)--> total time spend 4 hours
2 machine --> 4 tests (1 hour each)--> total time spend 2 hours
4 machine --> 4 tests (1 hour each)--> total time spend 1 hour

how to write on different lines at the same time :

FOR MAC: press option and click different lines
FOR WINDOWS : press ctrl+alt and different lines

My application is developed with C#. Can I use Selenium with Java to automate my application

- YES. Selenium does not care what programming language was used in the BACK-END to create the business logic.
- Selenium works on HTML.
- HTML is created by TAGS.
- TAGS create WEBELEMENTS.
- Selenium works on WEBELEMENTS.

What is a web element? --> Everything we see on a web page is a web element of its own.
ex: buttons, links, tables etc.

What is Selenium?
- Selenium is a set of jar files/libraries.
- These libraries consists of CLASSES and METHODS.
- Selenium allows user to automate browser based application.
- If you can reach a page using web browser (chrome, firefox etc) you can automate it using selenium.

TO BE ABLE TO USE SELENIUM:
- You need to download Selenium to your project.

What is the difference between web based application vs desktop application?
- WebAPP/Web based applications: are reach through web browsers. And created using HTML+CSS+JS + all the others
- Desktop applications : basically everything you see on your desktop/computer such as calculator, calender, maps, numbers, pages etc.
- These cannot be automated using selenium.
- UFT (unified functional testing) can automate desktop applications only on windows.

What is BrowserDriver?
- BrowserDriver can be considered as the translator in between your JAVA+SELENIUM code and your browsers.
- It allows you to execute your test automation code in your browser.
- Without the BrowserDriver you cannot execute Selenium code on the browser.

The official page of selenium --> https://www.selenium.dev/
Selenium documentation --> https://www.selenium.dev/documentation/en/

DIFFERENT WAYS TO DOWNLOAD SELENIUM:
1- Create normal java project. Download selenium jar files, and browser drivers. And add it into your project MANUALLY.

2- Create a MAVEN project. And add dependencies(jar files, libraries) in POM.xml file.

Part 1. CreateProject
1. Open IntelliJ Idea
2. Go to File —> New —> Project...
3. Select project type Maven
4. If project SDK is not already selected, select any available from the dropdown list. If project SDK is already selected, do not change it since any version equal to or bigger than 1.8 is fine.
5. Click Next.
6. Enter name to ARTIFACT ID : seleniumprojectb18
ARTIFACT ID MEANS : PROJECT NAME
GROUP ID MEANS : COMPANY THAT OWNS THIS PROJECT
7. Click Artifact coordinates.
8. Enter GroupId: com.cybertek
9. Enter ArtifactId: seleniumprojectb18
10. Click Finish


//1- This line creates the connection between driver and selenium.
// And sets up the driver.
WebDriverManager.chromedriver().setup();

//2- Creating the instance of ChromeDriver to be able to do action on ChromeBrowser

WebDriver driver = new ChromeDriver();

-> this is the line that is opening the browser session.
-> each session is brand new session. And no cache or history is stored.
-> cache: browser history.
-> every time you run, a new session is created with NO HISTORY SAVED.

--> driver.get("url");
-> This methods gets the given URL in an open browser.

--> driver.navigate().back() --> takes us to the previous page
forward() --> takes to the next page
refresh() --> refreshes the page
to("accepts a string for URL") --> and take you to that page


driver.get("URL") vs driver.navigate().to("URL")
- They both do exactly the same thing.
- driver.get() will wait the page to be loaded before continuing
- driver.navigate().to() --> does not wait the whole page to be loaded, just continues. Which sometimes creates issues.
- For example: if there is a link that you want to click, but if your code is trying
  to click it before it is loaded to the page, it will throw an exception.

driver.getTitle();
- returns the title of the current page as a String
- return type is String
- it does not accept any parameter
- The title of the page is usually used to confirm what page the user is on
- We can compare actual title vs expected title and confirm if we are on the page that we want to be

driver.getCurrentUrl();
- gets the URL of the current page and returns it as a String
- return type is String
- it does not accept any parameters
- The URL of the page is usually used to confirm what page the user is on
- We can compare actual URL vs expected URL and confirm if we are on the page that we want to be

driver.getPageSource(); --> this method will return the page source of the current page as a String.

driver.manage().window().maximize();
driver.manage().window().fullscreen();
--> These methods do exactly the same thing
--> They maximize the currently opened browser tab/page


driver.close() --> will close the current browser tab
driver.quit() --> will close all of the tabs, and ends the session

pkill -9 Google Chrome --> Closes all the chrome browsers at once


FOR MAC : GO PREFERENCES > SEARCH JAVA COMPILER > delete Target ByteCode Version
press enter
press OK/APPLY
re-import project > right click to project name > MAVEN > re-import
     */
}
