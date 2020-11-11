package test.day06_TestNG_Dropdowns;

public class day06_SeleniumNotes {
    /*
    JUN 19TH, FRIDAY, TGIF (THANK GOD ITS FRIDAY)

What is TestNG?
-> TestNG stands for Test NextGeneration.
-> TestNG is a unit testing tool that allows us create test flow using Annotations.
-> First we create methods, then we use TestNG annotations to create running flow.
- We decide which method is test
- Which method runs before tests
- Which method runs after tests
- And so on and so forth

What are annotations?
-> Annotations are a way of controlling the flow of the test.

@Test annotation:
-> Makes the annotated method a TestNG test.
-> Which allows us to run those methods(tests) without main method.
-> All of the tests are independent from each other, UNLESS we create dependency.

@Test
public void test1(){

}
@BeforeMethod:
-> Makes the annotated method run before each @Test method.
-> Usually used for setting up conditions, getting browsers, and pages.

syntax:

@BeforeMethod
public void setUp(){
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.get("");
            maximize
            implicit wait
}

@AfterMethod:
-> After method makes the annotated method run AFTER each @Test method.
-> Usually used to close things down such as closing/quitting the browser

syntax:

@AfterMethod
public void tearDown(){
        -close/quit browser
}


@BeforeClass:
-> BeforeClass makes the annotated method run ONCE before all of test in the class.
-> Runs even before the BeforeMethod
-> Used for setting up environments, opening browsers etc.

-> If you want to open just one browser and run all of your tests in that browser, you can put WebDriver driver = new ChromeDriver(); into before class
-> If you need to open a browser for EACH TEST, you need to put that line into BeforeMethod.

@AfterClass:
-> After class makes the annotated method run once after the tests in the class.


ASSERTIONS:
-> Assertions are coming from TestNG
-> Assertions allows us to do our verification between actual and expected results
-> If assertions pass, there will be no output in the console
-> If assertions fail, it will tell us what failed, and why.
-> Assert class is the class that provides us with all of the assertions.

Assert.assertEquals(actual, expected);

-> If we do static import, we don't have to use the class name to call the methods.

-> You can pass an additional argument into assertion methods just to provide additional information about what failed.
-> This is OPTIONAL. You don't have to.

--> assertEquals :
- This method expected two arguments to be passed: actual, expected.
- It compares these two values and if they are exact match, it will pass.

Assert.assertEquals(1,1);
Assert.assertEquals("title","title");
Assert.assertEquals("title", driver.getTitle());

--> assertTrue :
- This method expects you to pass a boolean value. Or you have to pass a method that returns a boolean value.
- If the boolean value is TRUE, it will pass. If not it will fail.

Methods returning boolean values: isSelected, isDisplayed, isEmpty, contains, equals, startsWith etc...

--> assertFalse :
- This method expects you to pass a boolean value.
- If the boolean value is FALSE, IT WILL PASS. If not, it will fail.


--> If your assertion fails, it will stop executing the current test in the same line where it failed.
--> It will move to the next test. And start running that one.
--> For this reason it is not suggested to do multiple assertions in one test, unless you have to.

How to ignore a test?

1- Add @Ignore on top of the test.
- Tests that have @Ignore annotation on top of it will be ignored.

2- You can comment out the @Test annotation on top of a test method.
- It will not be recognized as a TestNG test anymore.
- Therefore it will be ignored in runtime.


In what order the tests are running if we have multiple tests?
-> By default tests are running in alphabetical order.

priority => You can change the running order using priority.
- By default priority is 0
- We can change the priority which will change the running order of the tests
- The lower the priority, the earlier the test will run
- You can even pass negative numbers in priority
- Also you can pass math operations like (priority = 2+2) etc

priority (2+2) == priority(4)


==========================================================================

How do we handle dropdowns using Selenium?

HOW MANY TYPES OF DROPDOWN ARE THERE? 2

1- Select dropdowns: are created by using <select> tag in HTML

<select>
<option value="1"> ORANGE </option>
<option value="2"> APPLE </option>
<option value="3"> KIWI </option>
</select>

2- HTML dropdowns: these are the dropdowns that are created NOT USING <select>
- These dropdowns are handled just like any other webElement.

What can be tested about a dropdown?
- What is selected by default?
- What options are avaiable in the dropdown?
- When you select an option, is it selected?

How do we handle SELECT dropdowns using Selenium?
1- We need to locate the dropdown using findElement();
2- We need to create an object of Select class. (Select from Selenium Library)
3- We need to pass the located webElement into Select object

Syntax #1:
WebElement dropdown = driver.findElement(LOCATOR);
Select select = new Select(dropdown);

select. --> do some actions on dropdown

Syntax #2:

Select select = new Select(driver.findElement(LOCATOR));

How do we actually select an option from DROPDOWN?
- There are 3 ways of selecting options.
1- selectByVisibleText(String arg);

- This method accepts a String argument
- And selects the option with the given text

syntax:

select.selectByVisibleText("Option 1");

2- byIndex(int arg);
- This method accepts an int argument as the index number of the option
- Indexes start from 0. So always think about that if you are using this method.

<select>
<option value="1"> ORANGE </option> index 0
<option value="2"> APPLE </option> index 1
<option value="3"> KIWI </option> index 2
</select>

syntax: for selecting KIWI option

select.byIndex(2); --> this will select KIWI option
select.byIndex(0); --> this will select ORANGE option

3- byValue:
- This method uses the value of the attribute "value" to select options.

<select>
<option value="1"> ORANGE </option> index 0
<option value="2"> APPLE </option> index 1
<option value="3"> KIWI </option> index 2
</select>

syntax:
select.byValue("2"); --> This will select APPLE option
select.byValue("3"); --> This will select KIWI option


====> .getFirstSelectedOption() --> this method returns the selected option.
-> Useful for getting the default value of option of a dropdown
-> You can also select something, and get the value using the method.

====> .getOptions();
-> This method will return all the options in given select dropdown
-> Return type: List<WebElement>

====> .getAllSelectedOptions();
-> This will return all of the selected options as a WebElement.
-> This is useful when you have a dropdown that allows you to select multiple options

====> .deSelectAll();
-> This will deselect all the options that are selected.
     */

}
