package test.day21_LastDay;

public class day21_Notes {
    /*
    JULY 23rd, TGIT

BREAK UNTIL 11.00AM EST

#1-> Library app and the task suite

#2-> Tell me about your framework?

	Q#3
	- Page object model: organized, structured
		- class for each page of app
	- utils pack for utilities
	- java for main language
	- tools: maven for managing dependency from pom.xml
	- cucumber: for BDD
	- selenium : for automating browsers
	- junit & testng : for testing assertions and annotations
	- BDD with cucumber's gherkin language
		- approaching to develop the framework from the end user's perspective
	- DDT with Apache POI to get data from excel sheet
	- Different types of reports:
		-json
		-html
		-rerun
	- jira
	- grid for remote
	- jenkins for smoke tests

	#Q4:
	- Java
	- Selenium
	- BDD
		- Cucumber / Gherkin : for non-technical people
	- Maven : pom.xml for dependency management
		-dependencies
	- page object model
		-easy manage
		-easy access
		-easy maintain
	- singleton design pattern for driver
	- junit for testing
	- jenkins -> smoke & regression
	- cukes runner for running my framework

	#Q5:
	- java
	- selenium for automating browser
	- maven
		-pom.xml
	-singleton design pattern for driver
	- page object model for reusable
	- cucumber for BDD
		- especially helpful for non-technical people with gherkin language
	- configuration.properties
		- to keep important test data, browser type, login info
		- created utility class to read from properties

	- excel sheets for reading


============================================================

tell me about your framework

- I used java as my programming language in my framework.
- I used Selenium to automate my browsers.
- I used maven as my built automation tool. which has pom.xml file that allows me to manage my dependencies easyly.
- I used Page Object Model to simplify managing and maintaing my framework for myself and my team.
	- this design pattern allows me to locate web elements only once, in their respective classes.
	- so that if there are any problems with any web elements, I know exactly where to go and how to fix it.
- I created Singleton Design Pattern to allow my framework to pass the same instance of my webdriver in one session.
	- (one session: when you click run, selenium creates one session. the session will end when the driver stops.)

- I created a configuration.PROPERTIES type of file where I keep the important test data about my framework. I keep Test data that can change the running flow of the whole framework, such as:
	- browser
	- username/password
	- url: to change and run on different environments

- I created utility class from existing java library to read from properties type of file.
	- you should be ready to talk about how to read from properties file.
		- opening the file and passing the path of the file into FileInputStream
		- loading the file to properties class object.

- I implement BDD approach to simplify reading and understanding my framework for the non-technical teammates in my team.
	- I write my test cases as if they are scenarios from the end users perspective in Gherkin language in my feature files.
	- Gherkin is very similar to English. THerefore it is easy to understand for non-technical teammates.

	- I implemented the actual coding logic with JAVA-SELENIUM-JUNIT... inside of my step_definitions package and it their own respective/related classes

- I trigger my framework from my runner class.
- Runner class allows me to run different types of testing suites that I created with my tags, such as smoke, regression, mini-regression.

- I have different types of reports. But mainly I use "maven-cucumber-reporting" which is a very detailed reporting tool that has pie-charts, matrixes on which tests are passing and failing.
- Even has the option to show what percentage of which tags are failing and passing.

- Hooks class, where we implement some cucumber annotations such as Before, After, beforestep, afterstep to create outline for my scenarios.
- I also implemented a logic where my framework is taking a screenshot and attaching it to my report if a scenario is failing.
- APACHE POI
STARTING FROM JULY 24TH
- SQL
- API




#3-> Go over this one final time

#4-> Interview related experience sharing / KT (knowledge transfer)
	TIPS:
	-> BE CONFIDENT. but no too much?
	-> NEVER PANIC AND FREEZE. THAT IS THE WORST THING YOU CAN DO.
	-> RELAX, NOT TOO MUCH.
	-> whatever you put on your resume, you have to very comfortable talking about it.
	-> Be friendly and conversational.
	-> It is ok to say I don't know.
	-> Don't go for cheap price.
		Student A : $90,000
		STUDENT B : $150,000 (very minimum number of students %1-2)



#5-> Videos
		-> Video about doing parallel testing without multiple runner classes(we will adjust the driver class a little bit)


hard assert vs soft assert:
 - hard assertion fails the whole test flow when assertion fails.
 - soft assertion records the results, and continues to testing.
 - you just need to use assertAll to see the results.
 - soft assert comes from testng, junit does not have soft assert

What kind of music do you like?
ABC :
what is abc?
ANYTHING BUT COUNTRY

sprout social

     */
}
