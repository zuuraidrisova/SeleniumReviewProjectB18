package test.day17_CucumberRecap;

public class day17_SeleniumNotes {
    /*
    July 16th, Thursday

#1 - Recap Cucumber
#2 - Screenshot for reports
#3 - Rerun -> being able to run the failed tests only
#4 - Parallel testing / Cucumber HTML reports

-> Weekend video publish: APACHE POI -->
-> Friday : Jenkins
-> Monday : Git
-> Tuesday: Selenium GRID
-> Thursday: Final framework review

================================================

-->RECAP
	-> Different types of development frameworks:
	1- Test Driven Development (TDD)
		-> Write tests
		-> Run the code: it fails. because there is no code.
		-> Write code
		-> Run the tests again: they will pass.
		-> Refactor, and re-do.

	2- Behavior Driven Development: BDD is extension of TDD.
		-> Only difference is instead of writing tests, we write scenarios.
		-> In TDD tests are written in whatever programming language is used(JAVA).
		-> In BDD, SCENARIOs are written in Gherkin language.
		-> In BDD, we approach from the end-user's perspective. What should the user be able to do.

		BDD process:
		#1 -> We write scenarios first in feature files.
		#2 -> We run the scenarios, tests are failing.
		#3 -> We get empty auto-generated snippets in the console.
		#4 -> We implement java-selenium...
		#5 -> We run again. Tests should pass.
		#6 -> Refactor &/ add more scenarios.

	3- Hybrid framework:
		-> Hybrid framework is when we implement the logic of different type of frameworks such as TDD, BDD, Data driven etc we call that framework: HYBRID FRAMEWORK.

		-> In time, usually most of the frameworks turn into a hybrid framework.


Step by step how to create a scenario and implement it:
	1- Create a new feature file. Named something.feature --> extension should .feature
	2- Use Feature: keyword to define "agile story"
	3- Use Scenario: keyword to create new scenario, and add brief explanation if needed
	4- Using other Gherkin keywords such as Given, When, Then, And, But we create each step
	5- AFTER WE ARE DONE WITH FEATURE FILE, we run our code from Runner class
	6- This will generate us some auto generated SNIPPETS. (empty methods for us to implement)
	7- Copy/paste snippets into step_definitions class
	8- Implement java, selenium logic there


-------------------------------------------------------------------

There are two parts in BDD:

	1- Business 		: feature file is the business side.
		-> Everyone in the team comes together and works on feature files to minimize misunderstandings.
		-> We always start from feature files to be able to develop automation framework as well.

	2- Implementation	:
		-> Implementation side is where we actually implement the code.
		-> Step definitions is where we implement the actual code.

What is the triggering point of your framework? Where do you start running your tests?
	-> CukesRunner
	-> We created one java class, and converted it into Cucumber scenario runner class.

-> How to convert normal java class to cucumber runner class?
	#1--> @RunWith(Cucumber.class) : run with cucumber makes the class run with cucumber

	#2--> We are passing additional required options to allow our runner class to know where the feature files and where the step definitions are.

		- we pass feature files path into features keyword
				--> features = "src/test/resources/features",
		- we pass step definitions path into glue
				-->  glue = "com/cybertek/step_definitions",

--> What is "plugin" used for?
	-> It is used for cucumber reports. The reports are coming from cucumber, not selenium or junit.
		-> "html:target/filename.html"
		-> "json:target/filename.json"

--> tags: are used to group and manage our testing suite.
	-> or
	-> and
	-> and not

------------------------------------

Background: It is simply applying precondition to scenarios that are in the same feature file.
	-> if we have repeating steps that applies to all of the scenarios in the feature file, we can put those steps under background.
	-> Similar to BeforeMethod coming from TestNG.

-------------------------------------


Hooks : Hooks allows us to add additional pre/post conditions to our scenarios or even our steps.

	-> Before, BeforeStep
	-> After, AfterStep

-> We just have them as option to use as we need.

-------------------------------------

PARAMETERIZATION:
	-> PARAMETERIZATION is being able to pass test data directly into feature files.

	What is the advantage of being able to pass the test data into feature file?
	-> Not hardcoding: We do not have to go in the implementation(java-selenium)
	to run the same test on different test data.
	-> Allows us to do easy data driven testing.
		Data driven testing: running the same test against different data sets.

		Scenario: Login with correct credentials
		 Given User is on the login page
		 When User enters correct username "truckdriver412"
		 And User enters correct password "UserUser123"
		 Then User should see title is something

		Scenario: Login with correct credentials
		 Given User is on the login page
		 When User enters correct username "storemanager"
		 And User enters correct password "UserUser123"
		 Then User should see title is something

	 	Scenario: Login with correct credentials
		 Given User is on the login page
		 When User enters correct username "salesmanager"
		 And User enters correct password "UserUser123"
		 Then User should see title is something


SCENARIO OUTLINES:
	-> Scenario outlines allows us to create OUTLINES for one scenario.
	-> We give multiple examples under the scenario to be able to run same scenario with different data sets.

	-> How to achieve scenario outline?
		#1 -> We need to use "Scenario Outline" keyword instead of "Scenario" keyword
		#2 -> We need to pass "Examples" section to provide additional test data.

	-> You can use "Scenario Template" keyword, instead of "Scenario Outline"
	-> You can use "Scenarios" keyword instead of "Examples"

	Scenario Outline: Login with correct credentials
		 Given User is on the login page
		 When User enters correct username "<username>"
		 And User enters correct password "<password>"
		 Then User should see title is something

	Examples:
	|username         |    password	   |
	|truckdirver123   |    UserUser123 |
	|storemanger123   |    UserUser123 |
	|salesmanger123   |    UserUser123 |

OFFICIAL CUCUMBER PAGE:
https://cucumber.io/

================================================================

Scenario class coming from Cucumber allow us to have information about the currently running scenario
	-> whether if we want to get the name, what tags are used, is the scenario passing or failing etc.

	-> scenario.getName() --> returns the scenario name as a String
	-> scenario.isFailed() --> returns me the boolean value of if the scenario is passing or failing.
		-> if scenario passes: it returns false
		-> if scenario fails : it returns true

//#1 we need to take a screen shot using SELENIUM -->
// getScreenshotAs: to be able to use this method we have to cast our driver type to TakesScreenshot
        byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

//#2 we are going to attach it into our report: using attach method
//attach method accepts 3 arguments. #1: Screenshot itself #2: image type #3 current scenario's name

        scenario.attach(screenshot, "image/png", scenario.getName());


MAC 	: press command  -  --> will make things smaller on the page
WINDOWS : press control  -  --> will make things smaller on the page

====

JSON REPORT PLUGIN:

	-> cucumber has built in option to generate json type of report
	-> this is not for human brain consumption.
	-> this is to be used by third party tools so that we can generate better test reports. better than the default HTML Report coming from cucumber.
	-> to open the json file:
		1- Add plugin: "json:target/cucumber.json",
		2- RUN cukes runner
		3- json file will be created by cucumber
		4- if you want to open, you can doubleclick and open the file. (but you don't have to)

========

RERUN : IS BUILT IN PLUGIN IN CUCUMBER
	-> Allows us to run FAILED TESTS again.
	-> Lets say I am running 100 tests
	-> 10 of those tests are failing.


	#1 --> You need to run tests and something MUST FAIL.
		The whole logic of having cucumber Rerun plugin is to be able to run FAILED TESTS.
	#2 --> You need to run FailedTestRunner after something has failed.

	->If your rerun.txt is empty, it means you dont have any tests failing.
	->Make some tests failing by changing some expected/actual data
	-> Which will cause your tests to fail, therefore cucumber rerun plugin will save the failed tests in to the rerun.txt file.
	-> Next time when we want to run ONLY failing tests, we use "FailedTestRunner" class.
	-> This class does not have regular feature file path in the features.
	-> we pass the path of the rerun.txt file that is generated by cucumber.
	-> Therefore this file will only run the failed tests.






     */
}
