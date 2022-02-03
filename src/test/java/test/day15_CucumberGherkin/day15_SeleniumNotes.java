package test.day15_CucumberGherkin;

public class day15_SeleniumNotes {

    /*

    JULY 13TH, MONDAY

2 DAY'S SCHEDULE
	#1 -> RECAP
	#2 -> dryRun
	#3 -> TAGS : How to group scenarios and manage running them?
	#4 -> Background
	#5 -> Hooks
	#6 -> Parameterization
	#7 -> data tables
	#8 -> Scenario Outlines
	#9 -> Parallel testing/reports

===============================================================================

#1 -> RECAP

	--> Tell me about your framework?

	-> Java
	-> Selenium
	-> Maven -> pom.xml -> dependencies
	-> Singleton design pattern
	-> Page object model design pattern
	-> Cucumber to make our framework BDD (Behavior Driven)
	-> Gherkin language in feature files
	-> Data driven framework
		-> We can read data from configuration.properties
		-> We can read data from feature files
		-> We can read data from excel sheets


====================================================================================

	TDD vs BDD

-->	What is Test Driven Development (TDD)?

	-> First tests are written
	-> Tests are ran
	-> Tests fail, because there is no code
	-> Code implementation is done, just enough to pass the tests
	-> Repeat, refactor

	MVP --> Minimum viable product

--> What is Behavior Driven Development (BDD) ?

	-> BDD is an extension of TDD. We use similar approach for development.
	-> BUT there is a difference: Instead of writing tests, we write behaviors/scenario.
	-> We create scenarios from the end-users perspective.
	-> Gherkin language is used.

	There are two sides of BDD.
	1- Business side : FEATURE FILES
		-> Where we write scenarios in Gherkin language; Given, When, Then, And, But, *
		-> Understandable for non-technical team members
		-> Everything runs in the order of the feature files

	2- Implementation side : STEP DEFINITIONS
		-> We create JAVA classes to implement actual JAVA+SELENIUM+JUNIT... code to make it synchronized with browser
		-> Only for developers, SDET
		-> step definitions are just java methods
		-> we should not change anything from the signature of the method


--> What is a Feature?
	-> Agile stories, User stories

	Normally -> From one agile story, you create many test cases.

	In Feature file-> Usually that feature is one agile story.
		-> Then you create different SCENARIOS from that feature file

--> What is a Scenario?
	-> Each test case we create from a user story
	-> We don't call them test cases, we call them 'scenarios'

--> What are steps?
	-> Steps are how we create/re-create that scenario.
	-> Each step is like a re-usable method
	-> We write it once, and we call in anywhere in any feature file


Step by step how to create a scenario and implement it:
	1- Create a new feature file. Named something.feature --> extension should .feature
	2- Use Feature: keyword to define "agile story"
	3- Use Scenario: keyword to create new scenario, and add brief explanation if needed
	4- Using other Gherkin keywords such as Given, When, Then, And, But we create each step
	5- AFTER WE ARE DONE WITH FEATURE FILE, we run our code from Runner class
	6- This will generate us some auto generated SNIPPETS. (empty methods for us to implement)
	7- Copy/paste snippets into step_definitions class
	8- Implement java, selenium logic there

==============================================

#2 -> dryRun : just one keyword we pass into Runner class to allow our framework to RUN or NOT to RUN the actual code.

	dryRun = true  --> will not run the actual implementation of our code
		-> it will just check the feature file steps against step definitions

	dryRun = false --> will run our code

IF YOU ARE GETTING THIS-->	io.cucumber.junit.SkippedThrowable: This scenario is skipped
	CHECK DRYRUN VALUE.

================================================

MAC		: COMMAND + CLICK TO STEP FROM FEATURE FILE WILL TAKE YOU TO STEP DEFINITION
WINDOWS	: CONTROL + CLICK TO STEP FROM FEATURE FILE WILL TAKE YOU TO STEP DEFINITION


=============================

--> TAGS:

		or 		: it will find any matching tag and run all of the given tags
			tags = "@librarian or @admin"
			tags = "@librarian or @student"
			tags = "@student or @admin"

		and 	: it will run only if the scenario or feature file has all of the given tags
		-> whenever we use "and" keyword we are being more specific
		-> it expects all of the tags to be in that scenario to run it

		@librarian @employee
		Scenario:

		syntax:
			tags = "@librarian and @employee"

		not 	: is used to exclude any group of tags

			tags = "@login and not @student" ==> will run everything inside of
			the login feature, except the scenario(s) that has @student tag


IF I want to only run student and librarian, what should my tags be?

	tags = "@student or @librarian"


	ex: @employee and @sunday and not @librarian

		will run the scenarios that has both "@employee" and "@sunday" tags,
		 and will exclude the scenarios that has "@librarian"

====================================================================

#4 -> Background:

	-> If we have repeating steps for each scenario, we will write those
	     repeating SETUP steps under background.
	-> It will apply to all of the scenarios in the SAME feature file.
	-> Very similar to @BeforeMethod in TestNG.
	-> We are just putting the setup steps once, instead of repeating them many times
	-> We can put more than one step under background

====================================================================

#5 -> Hooks:
	- Hooks class is used to create pre and post condition for scenarios and even steps.
	- @Before, @After tags coming from cucumber, that will be applying to each scenario
	- @BeforeStep, @AfterStep tags, whatever we put will be applying to each STEP.


How the Hooks class is connected to the feature files?
	- Hooks class needs to be created in step_definitions package
	- CukesRunner contains glue="step defintions path"
	- Whenever we create Hooks class with @Before/@After (imported from cucumber), it will automatically check the GLUE PATH.
	- CukesRunners looks for the GLUE PATH for the HOOKS annotations.

---> Can we have more than one @Before and @After in one Hooks class?
	- Yes, we can have more than one.
	- By default it will check and run alphabetical order first.
	- If both methods start with same letter it will run top to bottom

	- WE CAN CHANGE RUNNING ORDER USING ===> "order" keyword
	- The smaller the number, the earlier the method will run

---> The whole purpose of being able to have more than one BEFORE/AFTER is to
 be able to apply different conditions to different scenarios.
	ex: Lets say we need to connect to database for only SOME of the scenarios.
		- In this case, if I just have one BEFORE, it will apply to all of the scenarios.
		- For this reason, we can create a separate Before where we do additional
		 configuration specific to those few scenarios.


---> BEFORESTEP :
	-> This annotation will apply BEFORE each step

---> AFTERSTEP :
	-> This annotaion will apply AFTER each step

	USE CASE: These two annotations could be useful for taking screenshots before and after each step
	-> But that is not the only purpose of these annotations. You can do pretty much anything you want to do.


=============================================================================

#6 -> Parameterization

	- Cucumber parameterization is being able to pass test data from feature files.
	- Parameterization allows us to pass test data and run our scenarios on
	different data sets without having to go into code and change anything

1-  #MAC : OPTION + ENTER --> ALLOWS YOU TO GENERATE STEP DEFINITIONS
    #WINDOWS : ALT + ENTER --> ALLOWS YOU TO GENERATE STEP DEFINITIONS
2-  Select create step definitions and PRESS ENTER
3-  Select the class you want the step definitions to be added

     */
}
