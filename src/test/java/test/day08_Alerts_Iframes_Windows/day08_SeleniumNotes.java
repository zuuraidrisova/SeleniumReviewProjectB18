package test.day08_Alerts_Iframes_Windows;

public class day08_SeleniumNotes {
    /*
    JUN 26TH, TGIFRIDAY
DROPDOWNS
HOW MANY TYPES OF DROPDOWNS ARE THERE?
2 types of dropdowns:
    1- HTML
    2- Select
How do we handle HTML dropdown?
    -> We handle HTML dropdown just as another web element.
    -> We locate using findElement(LOCATOR)
    -> We click.
How do we handle Select dropdown?
    -> Select dropdowns are different from other dropdowns.
    -> They are created using <select> tag.
    -> You have to create an object of Select class.
    -> After creating the object, we need to locate and pass the <select> web element into the constructor of the select object.
    -> Then using the object, we can do action on select dropdowns.
    -> Select class is coming from Selenium.
How many types of selecting options regarding Select dropdowns?
    -> 3 options
        - selectByVisibleText
        - selectByValue
        - selectByIndex
.getOptions : gets all the options in select dropdown.
    -> Return type is List of web elements.
JAVAFAKER:
    -> Javafaker is not coming from java, selenium or test ng.
    -> It is another external library by itself. Its javafaker library.
    -> Basically, it allows us to create/generate random data we can use for testing purposes.
    Syntax: Faker faker = new Faker();
How to handle dynamic web elements?
    1- First I would try to locate one of the static parents or childs if there are any. And then I would locate the desired web element from there.
    2- Xpath has its own methods which helps us to locate dynamic web elements by their attribute values.
        -> starts-with
        -> ends-with
        -> contains
How do we handle web tables?
    - By creating custom locators to get whatever I need to get from the table.
    -> If I need to get the whole row, I create a locator that returns me the whole row.
    -> If I need to get 1 single cell, I need to create a locator that returns me 1 single cell.
//table[@id='ctl00_MainContent_orderGrid']/tbody/tr
//table[@id='ctl00_MainContent_orderGrid']//tr
Assert.fail()
    --> is just another static assertion method.
    --> Where ever you call this method, it will directly FAIL the test.
=============================
all cybertek practices are here:

http://practice.cybertekschool.com/

================================
ALERTS
    There are two types of alerts.
    1- HTML Alerts:
        -> How do we handle: We just locate just as another web element on the page.
        -> Then we click.
    2- JavaScript Alerts:
    There are 3 types of JS alerts.
        1- Warning/Information : You only have 1 option. You have to accept.
        2- Confirmation : You can both accept or dismiss.
        3- Prompt : You can accept, dismiss, AND send keys.
    HOW DO WE HANDLE ALERTS?
        -> Using Alerts class coming from Selenium.
        -> JS alerts are not part of the HTML structure. Therefore we need to switch the driver focus to the alert itself.
        -> Otherwise the selenium driver will not be able to do any action on it.
        1- Create an instance of Alert, then switch to alert.
                Alert alert = driver.switchTo().alert();
        2- Use the instance of alert, to accept, dismiss, or sendkeys.
            alert.accept();
            alert.dismiss();
            alert.sendKeys("text goes here");
=====================================
IFRAMES
-> Iframe = Inline frame
-> Iframes are basically <html> inside of another <html>
-> Selenium can only focus one thing at a time. Therefore if we have iframe on the
 page, we need to SWITCH driver's focus to the inner iframe to be able to perform
  any action with Selenium.
-> There are 3 ways to switch to iframes
    1- Locating as WebElement then using that webElement to switch.
    WebElement iframe = driver.findElement(LOCATOR);
    driver.switchTo.frame(iframe);
    2- Switching by index. We pass the index number of the frame.
    -> if you have more than one iframe on the page, indexes are used.
    <iframe> --> index 0
    <iframe> --> index 1
    <iframe> --> index 2
    driver.switchTo.frame(0);
    3- Switching by id or name attribute value.
    driver.switchTo.frame("idValue");
    driver.switchTo.frame("nameValue");
==============================================================
WINDOWS/TABS
    -> Selenium can only focus on one thing at a time.
    -> Selenium creates something called window handle for each tab or window.
    -> For selenium, there is no difference between a tab, and a window. It treats both as the same thing.
    What is a window handle : Randomly generated string that is unique to each window.
    How to get current window handle?
        -> driver.getWindowHandle() --> will return current window handle as a string
    How to get all of the window handles of the currenly opened tabs/windows?
        -> driver.getWindowHandles() --> will return a SET OF STRINGS that contains all the window handles.
     */
}
