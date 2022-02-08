package test.day16_CucumberTopics;

public class day16_SeleniumNotes {

    /*
    JULY 14TH, TUESDAY

	#1 - RECAP
	#2 - SOLVE TASKS
	#3 - dataTables
	#4 - ScenarioOutlines

===========================================

TAGS --> Are used to group and run the feature files, and scenarios.
	-> We can group to include the scenarios, or we can group and exclude the scenario from running test suite.

	Which keywords we have for tags?
		- or : is similar to || from java.
		ex:
			-> tags = "@scenarioA or @scenarioB"
			-> if a scenario has either one of the given tags, it will be executed.


		- and : is similar to && from java.
			-> it wants to have the both sides of the condition to be true.

		ex:
			-> tags = "@scenarioA and @scenarioB"
			-> What this tag says is: "The scenario I want to execute MUST have both scenarioA tag AND scenarioB tag"
			-> If the scenario has only one of the tags above, it will NOT BE executed.
			-> Therefore, AND is used to be more specific with the selection of scenarios.

		- and not : similar to --> !&& in java
			-> If we want to exclude some scenarios we will be using "and not" keyword

			ex: "@scenarioA or @scenarioB and not @scenarioC"
			-> This statement will find and run any @scenarioA and @ScenarioB

			@scenarioA
	1-		Scenario: something1

			@scenarioB
	2-		Scenario: something2

			@scenarioA @scenarioC
	3-		Scenario: something3

			@scenarioA @scenarioB @scenarioC
	4- 		Scenario: something4

	ex: "@scenarioA or @scenarioB and not @scenarioC"

	Which one of the scenarios will be ran with this statement?

	-> #3 (something3) is not running for sure.
	-> #1 will run
	-> #2 will run as well


	ex: "@scenarioA and @scenarioB and not @scenarioC"
	-> This statement will NOT execute any scenario from above example

	ex: "@scenarioA and @scenarioB"
	-> This statement will only run #4 from the above example.

======================================================================

BACKGROUND:
	-> If we have any repeating steps that applies to ALL OF THE scenarios in the SAME feature file,
	 we use background

	-> Does creating "background" in one feature file apply to the other feature files?
		- NO. It does not. It only applies to each scenario in the same feature file.

	-> Background is very similar to @BeforeMethod from TestNG. The steps we put under background will be
	applied to the following scenarios in the same feature file.

	-> When you want to use background, you need to make sure that steps you put under background applies to
	 all of the scenarios in the same feature file.

======================================================================

HOOKS :
	-> Hooks class is used to create before and after conditions for each scenario and each step if we need to.
	-> We have different set of annotations that we can use in hook

	All of the below are coming from CUCUMBER, NOT JUNIT.

	@Before 	: Whatever condition we put here applies before each scenario.
		ex: setup anything that the test needs to run.
		-> webdriver setup, maximize browser, database connection setup

	@After 		: Whatever condition we put here applies AFTER each scenario.
		ex: used for tearDown purposes.
			-> we can close any connection we open.
			-> We can close driver
			-> We can close browser


	@BeforeStep	: Whatever condition/statement we put here will be applied before each step.

	@AfterStep 	: Whatever condition/statement we put here will be applied AFTER each step.

	EX: -> we can take screenshots before and after each step.
		-> we can time how long each step are taking

-> How does hook work without any inheritance or extending?
	-> the glue path is used to run Hooks class
	-> the class name is not important, but we need to make sure to get all of the annotations from CUCUMBER.

======================================================================================

PARAMETERIZATION :

	-> In simple terms, parameterization is just being able to pass test data to a scenario from feature files
	 without having to go to step definitions.

	-> We can change the test data from feature file, and immediately run the feature with a new set of test data.

	-> We just avoid hard coding test data into our step definitions.


======================================================================================

	#3 - dataTables
		-> Cucumber allows us to pass multiple data under one step.
		-> We can accept that data and store it under many different categories such as, list, map...

		syntax:

		Given something is happening user should see all of the following
		|apple|
		|orange|
		|kiwi|
		|cucumber|

		--> Whatever data we pass on the feature file will always come from feature files as EXPECTED DATA
			-> It can be some list of links that we are trying to verify
			-> It can be some options from a dropdown that we are trying to verify
			-> it can be any set of data that we are trying to verify from the browser.
			-> We pass the expected data in feature file. Then we get the actual data from browser and we compare.

		ACTUAL IS COMING FROM BROWSER

========================================================

	Verify that on the google search page footer contains 6 links

=========================================================

SCENARIO OUTLINE:

	Scenario Outline is used to run the same scenario against different data sets

	How to achieve scenario outline:
		1- Use Scenario Outline keyword --> or Scenario Template
		2- Use diamond brackets in parameter outlines "<expectedValue>"
		3- Create examples and pass the outlines --> Examples or Scenarios

	Scenario Outline: Search functionality header verification
    When User searches "<searchValue>" in the wiki search page
    Then User should see "<expectedTitle>" in the wiki title
    Then User should see "<expectedMainHeader>" in the main header
    Then User should see "<expectedImageHeader>" in the image header

    Examples: example test data for wikipedia search
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs          |
      | John Travolta   | John Travolta   | John Travolta      | John Travolta       |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein     |
      | Keanu Reeves    | Keanu Reeves    | Keanu Reeves       | Keanu Reeves        |
      | Bruce Lee       | Bruce Lee       | Bruce Lee          | Bruce Lee           |
      | Dua Lipa        | Dua Lipa        | Dua Lipa           | Dua Lipa            |
      | Thomas Edison   | Thomas Edison   | Thomas Edison      | Thomas Edison       |
      | Sam Heughan     | Sam Heughan     | Sam Heughan        | Sam Heughan         |










     */
}
