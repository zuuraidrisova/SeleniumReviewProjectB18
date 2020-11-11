package test.day09_TestBase_Properties_DriverUtil;

public class day09_SeleniumNotes {
    /*
    JUNE 30TH, TUESDAY

TODAY ->

   -TESTBASE
   -PROPERTIES CLASS/UTIL
   -DRIVER UTIL /--> SINGLETON DESIGN PATTERN
   -MINOR TOPIC

NOT TODAY -> REST OF THE SCHEDULE

   - SYNCHRONIZATION
   - PAGE OBJECT MODEL
   - CUCUMBER -> in detail
   - PARALLEL TESTING
   - GENERATING REPORTS
   - JENKINS
   - SELENIUM GRID


- ALERTS

   HOW MANY TYPES OF ALERTS ARE THERE?
      - We have two types of alerts.
      1- HTML Alerts
      2- JavaScript Alerts

   HOW DO WE HANDLE HTML ALERTS?
   -> HTML Alerts are inside of the HTML.
   -> Therefore we can locate using one of eight locators of Selenium.
   -> And do any action needed, such as click & close.

   HOW DO WE HANDLE JAVASCRIPT ALERTS?
   -> We handle JS Alerts using Alerts class that is coming from Selenium.
   -> We need to use this Alerts class BECAUSE JS alerts are not stored inside of the HTML code.
   -> So we cannot locate them using selenium locators. We need to use special class
    that was created for this purpose. --> Alerts

   HOW MANY TYPES OF ALERTS DO WE HAVE?
   -> 3 types of alerts.
      1- Warning/Information Alerts: We have only accept option.
      2- Confirmation Alerts: We can either accept or dismiss.
      3- Prompt Alerts: We have input box which allows us to give our input before accepting or dismissing.

   Syntax:

      //This line will switch to the currently opened alert.
      Alert alert = driver.switchTo().alert();

      //Then we get to choose the related method to handle the alert depending on its type.

      -> alert.accept();
      -> alert.dismiss();
      -> alert.sendKeys("text to be sent before accepting or dismissing");


- IFRAMES (Inline Frame)
-> What is an iframe?
   -> HTML inside of another HTML.
   -> Iframes are used to create independent html sections for usually ads,
   maps, and sometimes videos.
   -> <iframe> tag is used to create the iframe.
   -> Selenium is able to focus only one thing at a time.
   -> Therefore selenium will not be able to locate any webELements in an iframe,
    UNTIL we explicitly switch to it.
-> How many ways to switch to an iframe?
   -> We have 3 ways to switch to an iframe.
   1- Locating it (the iframe), just as another webelement.
   syntax:
      WebElement iframe = driver.findElement(By.locator);

      driver.switchTo().frame(iframe); --> we pass the webelement of iframe

   2- byIndex number of the iframe:
      -> Indexes start from 0.
      -> We just need to understand which iframe we need to switch to,
       then we just pass the index number of it.

      driver.switchTo().frame(0); -> this will be switching to the first iframe in the html

   3- byId or byName attribute value:
      -> We directly pass the idValue or nameValue to switch to an iframe.

      driver.switchTo().frame("idValue");
      driver.switchTo().frame("nameValue");

-> After switching to an iframe and doing some actions in it, we need
to EXPLICITLY switch Selenium's focus back to the main frame(parent frame, default content)
   - To do this, we have multiple options:
   1- driver.switchTo().defaultContent(); --> will switch back to the default frame
   2- driver.switchTo().parentFrame(); --> will switch back to the parent frame

1  html
2     html
3        html --> driver.switchTo().parentFrame(); --> this will switch to line 2
            driver.switchTo().defaultContent(); --> this will switch to line 1

   html
      html
      html


- WINDOWS/TABS
   -> From selenium's perspective, there is no difference between a tab, and a window.
    It treats both as the same thing.
   -> Therefore we handle both tabs, and windows the same way.

->     How do we handle windows/tabs?
   -> We handle windows and tabs using their "window handles".

-> What is a window handle?
   -> A randomly generated unique string that belongs to its window.
   -> Similar to SSN being unique to each person, window handles are unique to each
   window/tab.
   -> Selenium can only focus to one thing at a time.
   -> Therefore we need to switch its focus explicitly to the window that we want
   to perform any actions.
-> How do we get the handle of the current window?
   syntax: driver.getWindowHandle(); -> will return us the handle of the current window.
   String mainHandle = driver.getWindowHandle();

-> How do we get all of the handles of the currently opened windows' handles?
   syntax: driver.getWindowHandles();

   -> What is the return type of this method? -> Set of Strings
   -> It will return all of the handles of the currently opened windows.

-> How do we switch to another window using its handle?

   -> driver.switchTo().window(handleOfTabWeWantToSwitch);
   -> We need to create a loop to switch to windows that is opening later on.

   -> To switch back to the main window (default window):
      driver.switchTo().window(mainHandle);


TESTBASE:
   PROBLEM: We have many repeated lines just to setup the driver and be able to use it.
      -> Create instance variable of the driver
      -> setUp:
         driver -> manager -> open with chrome
      -> maximize
      -> implicitWait

   How to handle this problem:
   All of these lines can be simplified by creating a TestBase class where we store
    them and get them(all of the setup, and/or teardown) when we need it.

   The OOP concepts we are using in our project are
   -> Inheritance     : Where we inherit from TestBase
   -> Abstract       : With the TestBase
   -> Polymorphism : We are using with our driver
      -> WebDriver driver = new ChromeDriver();
   -> Encapsulation: We will use this with Driver utility

=========================================

PROPERTIES

.getProperty(Key) ==> is accepting a key and returns its value

key=value
name=john
browser=chrome

How we have been passing our test data?

What is test data?
   - The data we use to test our application.
   ex: username, password, url, browser and any other information we pass

How we have been passing?

   url --> qa1.vytrack.com
   url --> qa2.vytrack.com

   usernameInput.sendKeys("john");
   passwordInput.sendKeys("12345something!");
   loginButton.click();

What is hardcoding?
   -> Hardcoding is putting our test data into our TESTS.
   -> When you hard code, to be able to change the test data you have to go to
        each and every single test and change the data from there.

The idea is how to keep these values somewhere outside of our sourcecode(tests),
 but inside of the project itself.

Data Driven Testing ==> is running the same test against different data sets.
   - You get your test data from outside of your code
   - We will create a properties file, and keep our test data in that file.

What is properties file?
   - Just another type of file such as .txt, .doc, .xml, .csv
   - .properties
   - What's special about properties type of file?
      -> The values are stored in key and value format.

   configuration        .properties
   <-name of the file>    <extension (type of the file)>


for windows> right click on configuration.properties
          > copy
             > path from content root : this will give you the relative path

relative path: relative to whatever project we are working
absolute path: is path from the source, user/desktop/..

ConfigurationReader utility class
   - What we did in that class
   -> to be able to read from .properties type of file, we have to do some setup.
   -> step by step how to read from properties file:
      1- Creating the object from Properties class
      Properties properties = new Properties();

      2- We need to OPEN the file in JVM memory
         - To do this we need the path of the file
         FileInputStream file = new FileInputStream("path");

      3- We need to load the file to properties object.
         properties.load(file);

      4- We close the previously opened file
         file.close();


   UP UNTIL HERE: WE did this all to load the file to properties object

   We created our custom method, and used java getProperty method to read from our file.

    //Our own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord){
       method on line 239 is coming from JAVA Properties class.
        return properties.getProperty(keyWord);
    }


==========================================
DRIVER UTILITY

Some challenges:
- We have too many lines to just to initialize the driver
- Being able to pass the same driver instance when calling methods from other classes

get amazon page - Webdriver driver1.get
find search bar - Webdriver driver2.search
send keys       - Webdriver driver3.sendKey

SOLUTION: Creating a driver utility that guarantees a single instance of the driver
 and does the initial setup as well. (maximize, implicitWait etc)

Singleton Design pattern:

   What happens if you create private constructor?
   -> You cannot create an object of that class.

What singleton is?
   -> We create a private constructor, and we also create a getter method
   to allow users to create the instance of this class in OUR WAY.

REASONS:
   idea of driver: we want to get the same driver instance whenever we want where ever we want

We achieve this with Driver utility:

Driver utility:

1- Private constructor : ensures that no one else can create an instance of the WebDriver
   -We will allow reach to this driver only through our getter method.

2- We create a logic to ensure that the same driver instance is passed every single time:
   if(driver==null){
      //this statement will ensure that the new instance will be created only if the driver object is empty

      String browser = ConfigurationReader.getProperty("browser");
      //this line will read what browser we want to run on dynamically from configuration.properties

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
   }
     */
}
