package test.day10_Actions_JavaScriptExecutor_Uploading;

public class day10_SeleniumNotes {

    /*
    JULY 2ND, THURSDAY, TGIT

Today:
-> Finishing Driver class
-> JavaScriptExecutor
-> How to upload using Selenium
-> Actions class

--> Headless browser: The only difference between regular chrome, firefox and
chrome-headless, firefox-headless is: headless ones does not open visually.

--> JavaScriptExecutor :
-> is just an interface with 2 methods.
-> This interface allows us to execute JavaScript code in our Selenium code.
-> We pass the javascript scripts as strings into the methods we call from JavaScriptExecutor.
-> If we are using WebDriver interface reference, we must cast our driver type
to JavaScriptExecutor.

SYNTAX OF HOW TO USE JavaScriptExecutor:

1- We create javascriptExecutor object and we cast our WebDriver type instance
        into JavascriptExecutor type.

JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();

2- Then we have access to the methods that are coming from JavascriptExecutor interface.

javascriptExecutor.executeScript("arguments[0].scrollIntoView( true);", cybertekSchoolLink);

What is executeScript method?
-> Method coming from JavascriptExecutor, allows us to apply actual javascript code in our selenium code.

-> This method expects 2 arguments.
-> First arg: String. We pass JS code in as a string
-> Second arg: We can pass OBJ Type if we want to do specific action on something specific

How many ways you know to scroll in Selenium?
1- Using JSExecutor

============================
HOW DO YOU DOWNLOAD AND VERIFY USING SELENIUM?
-> YOU DONT.
-> Selenium can click to a link to download some files.
-> BUT Selenium CAN NOT verify that a file has been downloaded into your computer.
-> Selenium only works in browsers/HTML code. Folder directory of your computer
            is OUT OF SCOPE for Selenium.

============================
HOW TO HANDLE UPLOADS USING SELENIUM?

-> We locate upload webelement
-> We sendKeys of the file path as a string arg
-> Then we click upload button

 how to get path in Mac: right click + press and hold Option

chooseFile.sendKeys("/Users/cybertekchicago-1/Desktop/test");

==================================================

ACTIONS

Actions selenium documentation:

https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html

-> Is a class coming from SELENIUM
-> Allows us to handle advanced mouse and keyboard actions
-> Actions class can do:
-> hover over
-> double click
-> context click (right click)
-> drag and drop
-> keydown : to simulate that pressing a key and holding it down

TO USE :
-> 1- We need to create an object of the ACTIONS class
-> 2- We need to pass the current driver instance into the constructor

        Actions actions = new Actions(Driver.getDriver());

-> 3- Then we can use any method using "actions" instance that we created

        actions.methodname.build().perform();

-> you can chain lots of methods using actions.

actions.moveTo(element).clickAndHold().moveTo(somewhereelse).perform();
     */

}
