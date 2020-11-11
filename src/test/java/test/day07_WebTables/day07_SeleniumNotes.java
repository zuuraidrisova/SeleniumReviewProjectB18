package test.day07_WebTables;

public class day07_SeleniumNotes {
    /*
    JUN 23, TUESDAY
-> findElement vs findElements
    -> findElement
        - return type is WebElement
        - throws NoSuchElementException if it cannot find web element
    -> findElements
        - return type is List of WebElements
        - does NOT throw exception. It will return empty List.

How many types of dropdowns do we have? 2
1-  HTML Dropdowns :
    - HTML dropdown are just another html webElement.
    - These dropdowns are created usually with divs and links.
    - When you inspect, if you see it is not created using <select> tag, it means it is not SELECT dropdown.
    - Therefore we cannot use SELECT class methods on it.

-> How do we handle HTML dropdowns?
    - We handle just as another HTML tag. We just locate using any locator. And we click.

2-  Select Dropdowns
    - Select dropdowns are the dropdowns created using <select> tag.
    - If a dropdown is created using <select> in order to be able to handle it with Selenium, you MUST use SELECT class.

    What is SELECT class?
    - It is a class coming from Selenium library.
    - It has ready methods in it.
    - We use it to handle SELECT dropdowns.

->How do you handle select dropdown, explain verbally:
1- I would create an instance of Select class.
2- And locate the select dropdown, and pass the dropdown webElement into the select instance.
3- Then using instance, we can do actions on select dropdown.

-> How many ways to select an option from a select dropdown?
    - There are 3 ways to select in dropdown.
    1- selectByIndex -> accepts int arg. and selects by the index of web element.
    2- selectByValue -> selects by the value of the attribute "value"
    3- selectByVisibleText -> literally selects with the text of the option.

-> How do we get all of the options inside of select dropdown?
    -> .getOptions() : this method will return all of the options in a select dropdown
    -> Return type is List of WebElements
-> How do we get which option is selected?
    -> .getFirstSelectedOption() : this method will return the currently selected option.
=====================================
HOW DO YOU HANDLE DYNAMIC WEBELEMENTS?
- If attribute values are changing when you refresh the page, it means values are dynamic.
ex #1:
    <div id="abc1233523" name="289374code"> </div>
    <div id="abc2342454" name="324213code"> </div>

Two ways to handle dynamic web elements:

1- Locate one static web element (either parent or child), and go to desired web element.
    - If coming from a parent: use single slash / -> to go to child until we reach desired web element
    - If coming from a child: use single slash with two dots /.. ->to go to parent until we reach desired webelement

2- We have 3 xpath locators to handle dynamic attribute values.

    1 -> //element[contains(@attribute, 'value')]
        ex: <div id="abc1233523" name="289374code"> </div>
        //div[contains(@id, 'abc')]
    2 -> //element[starts-with(@attribute, 'value')]
        ex: <div id="abc1233523" name="289374code"> </div>
        //div[starts-with(@id, 'abc')]
    3 -> //element[ends-with(@attribute, 'value')]
        ex: <div id="abc1233523" name="289374code"> </div>
        //div[ends-with(@id, 'code')]
==============================================================
HOW MANY DIFFERENT TYPES OF DEPENDENCIES WE USED IN OUR PROJECT?
    ->3

WHAT ARE THOSE DEPENDENCIES?
    -> java-selenium
    -> bonigarcia : WebDriverManager
    -> TestNG

We are adding a 4th dependency today:
    JAVAFAKER: is used to create fake data for testing purposes.
    -> It is a small library that has the ability to create randomly generated data.
    -> Useful when you have a bunch of inputs that you need to enter on a page.
    -> You can use JavaFaker for this purpose. It will generate random data for you.
        - fullname
        - first name
        - last name
        - address
        - phone number
        - email
        - and dozens of other different options

 .clear(); //just deletes if there is any existing input in the input box.
===================================================
WEBTABLES

<table>
    <thead></thead>
    <tbody>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </tbody>
</table>

Order of creating web table:
1- Create <table>
2- create <thead> , <tbody>
3- Create rows
4- Create cells

P1_LOCATING THE WHOLE TABLE ITSELF
//table[@class='SampleTable']

P2_LOCATING ALL THE ROWS IN THE TABLE
//table[@class='SampleTable']/tbody/tr

P3_LOCATING ALL OF CELLS IN ALL OF THE ROWS
//table[@class='SampleTable']/tbody/tr/td

P4_LOCATE PAUL BROWN FROM THE TABLE
    Locating with text:
    //table[@class='SampleTable']/tbody/tr/td[.='Paul Brown']
    Locating using numbers(indexes)
    //table[@class='SampleTable']/tbody/tr[2]/td[2]
    /tr[2] ==> get me the second row
    /td[2] ==> get me the second cell

P5_LOCATE LAS VEGAS WITHOUT USING ANY TEXT
    //table[@class='SampleTable']/tbody/tr[2]/td[7]

P6_LOCATE STEVE JOHNS WITHOUT USING ANY TEXT
    //table[@class='SampleTable']/tbody/tr[4]/td[2]

P7_LOCATE STEVE JOHNS WITH USING TEXT (ACKNOWLEDGE THERE IS ONLY THIS TABLE)
    //td[.='Steve Johns']

P8_LOCATE STEVE JOHNS' ORDER DATE USING ITS TEXT:
    your base: //td[.='Steve Johns']
    Two ways of achieving this:
    1- //td[.='Steve Johns']/../td[5]
    2- //td[.='Steve Johns']/following-sibling::td[3]

P9_LOCATE CLARE JEFFERSON'S CITY:
    1- //td[.='Clare Jefferson']/../td[7]
    2- //td[.='Clare Jefferson']/following-sibling::td[5]

P10_LOCATE STEVE JOHNS' CHECKBOX
    1- //td[.='Steve Johns']/../td[1]
    2- //td[.='Steve Johns']/preceding-sibling::td

/following-sibling::tagName -> this will only go to the siblings that is AFTER
/preceding-sibling::tagName -> this will only go to the siblings that is BEFORE

     */
}
