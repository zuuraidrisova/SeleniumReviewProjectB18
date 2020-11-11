package test.day09_TestBase_Properties_DriverUtil_Review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class day09_ReviewNotes {
    /*
    JUL 1, WEDNESDAY

TESTBASE -> BASE-> just one parent class to tests that has the common setups, and teardowns.

What is test data?
- Test data is all the information we use to test the application.

How we are currently passing test data to our application?
- We are currently HARDCODING our test data.

What is hard coding?
- We are literally entering the test data into our CODE.
- If we are putting the data itself into the ACTUAL CODE, it means we are hard coding.

How do we understand if we are hard coding test data?
- If you have to go inside of the test to change the data,
   it means you hardcoded the data into your source.

WHAT IS PROPERTIES TYPE OF FILE?
--> PROPERTIES FILE is just another type of file.
--> There are different types of TEXT storing files such as:
-txt
-doc
-csv
-xml
--> Properties file is storing information in KEY=VALUE format.
--> Key has to be exact match in order to be able to read the value.
--> Also be careful on passing value 100% correct as well.

configuration.properties --> this file we will only store important test data
      that will change the flow of the tests:url, browser, username, password

environments (different urls) =>
qa1.vytrack.com
qa2.vytrack.com
staging1.vytrack.com
staging2.vytrack.com
production (PROD) --> www.vytrack.com

configuration --> name of the file
.properties --> type of the file

ex:
url= if I change the url i can make the whole test suite run on different environment
username= if I change the username/password I can run the whole test suite against different accounts.
password=
browser= chrome/firefox --> if I change the browser type, I could be running the whole test suite against a different browser.

WHAT IS CROSS BROWSER TESTING?
=> Running same test suite against different browsers.
ex: 90% chrome
5% firefox-safari
%5 rest (IE, edge)

PARALLEL TESTING --> is running your tests on multiple machines.
ex : lets say you have 100 tests to run.
1 test taking 1 min to run.

-> 1 machine takes = 100 mins
-> 2 machines takes = 50 mins
-> 4 machines takes = 25mins total run time of all test suite

WHERE DO WE CREATE PROPERTIES FILE AND WHY?

-> We store it in the project folder level, and NOT inside of any of our code package.
-> Because this is not JAVA code, this is just test data we want to pass to our java
   code from outside.

WHY DO WE NEED? WHAT ARE WE GOING TO DO WITH IT?
--> #1 REASON : Is not having to hardcode your configuration test data into your code itself.

            What is configuration test data?
            -> Important test data that can change running flow of the test suite.
            ex: Changing 1 string value of key URL => helps you run your test
            on different environment

--> #2 REASON: Easy to fix any issue. You just need to go 1 file, (configuration.properties) and fix it there

--> #3 REASON: East to do DATA DRIVEN TESTING

WHAT IS DATA DRIVEN TESTING?
-> Running the same tests with different data sets.

ex: login test:
username1, password1
username2, password2
username3, password3
username4, password4


HOW DO WE READ FROM THE PROPERTIES?

=> There is an existing java class called Properties that helps us read properties file.
-> Properties class was created to read ".properties" type of file

--> When we create an object of this class, and load the configuration.properties file
 into this object, it has its ready methods to help us read key=value format.

What is framework?
-> Is the combination of the tools, and utilities that we use in and project makes our framework.
-> What kind of logic you created in your project.

--> STEP BY STEP HOW TO READ FROM PROPERTIES
1- Create an instance of Properties class
private static Properties properties = new Properties();

2- Get the path of the configuration.properties file
String path = "configuration.properties";

3- We need to open the configuration.properties file in JVM memory
FileInputStream file = new FileInputStream(path);

4- We have to load the file we opened using fileInputStream, to properties object.
properties.load(file);

5- We close the opened file (by FileInputStream)
file.close();

All of the logic above goes into static block. But why?
- IF something is static what happens to it? When Does it run?
-> It runs ONCE and before everything else.
-> All the important information we store in configuration.properties file must be ready before we start running our tests.

We put everything in try/catch just because FileInputStream constructor,
and properties object has checked exception. Thats why we handle with try/catch.

CREATING OUR CUSTOM .getProperty() --> method

WHY-> Without this method, we still would not be able to read from configuration.properties.

1 - public static String getProperty(String keyWord){
2 - return properties.getProperty(keyWord);
}

Line 2 explanation : properties.getProperty coming from Properties object which is coming from JAVA.

Line 1 explanation : we are creating our own custom getter method
public -> because we want it to be usable from everywhere
static -> because we want to be able to call the method with classname
String -> because we want this method to return a String-> value of keyWord we are passing.

========================================================
DRIVER UTILITIES

CHALLENGES:
#1-> Too many repeated lines just to get a driver instance.
#2-> NOT REUSABLE: Our driver instance is not re-usable.
-> When we create a driver instance in class, currently it lives and dies in the same class.
-> Even if we want to use this in a method that is coming from another class, we must pass the driver instance

ex: SmartBearUtils.login(driver);

SINGLETON DESIGN PATTERN:
-> Making the constructor private to limit the user access to the object of the class.
-> Then we create our own logic with our getter method, to allow user to use the instance we are creating.
     */

    private static Properties properties = new Properties();

    static {

        String path = "configuration.properties";

        try{

            FileInputStream file = new FileInputStream(path);

            properties.load(file);

            file.close();

        }catch (IOException e){

            System.out.println("Properties file not found!");
        }
    }

    //it is like getter method to read our private variable
    public static String getProperty(String keyWord){

        return properties.getProperty(keyWord);

    }


}
