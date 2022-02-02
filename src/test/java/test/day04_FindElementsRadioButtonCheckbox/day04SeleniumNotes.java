package test.day04_FindElementsRadioButtonCheckbox;

public class day04SeleniumNotes {

    /*
    JUN 12, FRIDAY

    findElement() ==> method is used to locate a single web element
                        returns a single web element
                        return type => web element
                        if it cannot find any webElement, throws NoSuchElementException

   findElements() ==> method is used to find more than one webElement
                   locates and returns all the matching web element as a list
                   return type => list<WebElement>
                   if it cannot find webElements, it does not throw any exception, it just returns empty list

        Thread.sleep(2000) ==>comes from java, not Selenium
                              stops running of the code for the given milliseconds
                              it is not recommended to use

      implicit wait: ==> driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
                            type of Selenium wait, comes from Selenium not java
                            implicit wait will check DOMain(html) and wait until given seconds
                             if there are any web elements not available
                             implicit wait will continue until when the page is loaded
                             it does not have to wait until given seconds, if the page loaded


        RadioButtons: type = "radio"
                radio buttons allow users to pick one of options
                when we choose one of the options ==> radio button

        Checkbox: type ='checkbox"
                checkboxes allow users to select one or  several options
                when we can choose couple of option ==>checkbox

    how do we handle checkboxes and radio buttons in Selenium?

        isSelected() ==> if checkbox is selected it will return true, else false
        isEnabled() ==> if checkbox is enabled on the page, it will return true, else false

    Absolute xpath :
                -> starts with : /
                -> starts from the very beginning of  <html>
                -> u can only go from parent to child

   Relative xpath:
               -> starts with: //
               -> looks thru everything in html code
               -> returns all matching results
               -> u can start from anywhere in the html code
-> Where ever you use // (relative xpath) is looking to jump and return all the matching results
ex : //body//a

Side note;
-> When there is a task, download the pdf then copy paste text task into intelliJ.
-> This will help keeping the number structure of the task

Commonly used xpaths
1- //tagName[@attribute='value']
2- //tagName[.='text'] --> looks for matching text value

//a[.='iPhone']
//span[.='iPhone']

. --> means class in cssSelector. Not in xpath.

--> Locating the same webElement using this syntax:
//tagName[@attribute='value']
//*[@attribute='value']

-> when we use * instead of tagName, it will not check tagName.
->It will only check attributes and values. And return matching one(s).

#1 -> using class attribute value :
//a[@class='ac-gn-link ac-gn-link-iphone']

#2 -> using href attribute value :
//a[@href='/iphone/']

(//a[@href='/iphone/'])[1] --> this is returning me two web elements
If your xpath is returning you more than one web elements and you want
to specify which one you get, you surround the xpath with (), and pass
the index number in []

#3 -> //a[@data-analytics-title='iphone']
(//a[@data-analytics-title='iphone'])[1]
-> If the webelements are siblings to each other, you dont have to surround with paranthesis. You can directly pass index number using []

#4 -> Locating a child and going to parent : We need to use /.. to go to parent
//span[.='iPhone']/..

#5 -> Using * instead of tagName
//*[@class='ac-gn-link ac-gn-link-iphone']

FINDING FROM PARENT: //li[@class='ac-gn-item ac-gn-item-menu ac-gn-iphone']/a
Basically locate a unique parent, then move to the child using / until you reach desired web element

--> Why different people getting different number of links even we all go to same page?
-> could be because OS difference: MAC vs Windows
-> could be different browsers
-> could be same browser but different version etc.
-> could be the screen size effecting something

     */

}
