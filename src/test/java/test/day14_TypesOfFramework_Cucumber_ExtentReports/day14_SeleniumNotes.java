package test.day14_TypesOfFramework_Cucumber_ExtentReports;

public class day14_SeleniumNotes {
    /*
    JULY 1OTH, TGIFRIDAY

TODAYS TOPICS:
1- WE WILL SEE DIFFERENT TYPES OF FRAMEWORKS
2- WE WILL UNDERSTAND WHICH ONE WE ARE GOING TO USE
3- WHY ARE USING IT?
4- WE WILL CREATE A NEW PROJECT: CUCUMBER & JUNIT
5- WE WILL DO A FEW SIMPLE EXAMPLES
6- I WILL GO OVER "TELL ME ABOUT YOUR FRAMEWORK" QUESTION

MVP --> MINIMUM VIABLE PRODUCT
A minimum viable product (MVP) is a version of a product with just enough
 features to satisfy early customers and provide feedback for future product

project-folder
    src
        main : developers are developing application in this folder
        test : developers write unit tests in this folder

TDD : TEST DRIVEN DEVELOPMENT
1- Before writing any actual development code, they write unit tests.
2- Run the project.
3- It will fail because there is no code at all.
4- Then they write some code just enough to make the tests pass.
5- Run again.
6- It will PASS.
7- Refactor- re-DO.

======================================================
HOW TO CREATE A NEW PROJECT FROM SCRATCH STEP BY STEP:

1 - FILE -> NEW -> PROJECT
2 - SELECT MAVEN (IF NOT SELECTED) -> CLICK NEXT
3 - ADD PROJECT NAME : CYBERTEK18-CUCUMBER-JUNIT

    if you have group id: com.cybertek
    for artifact id : cybertek18-cucumber-junit

4 - CLICK FINISH
5 - Select new window
6 - Create dependencies tag in pom.xml
7 - If you get enable auto-import, ENABLE it.
    If not, we will enable manually.

    IntelliJ --> Preferences --> search "auto import"

    select: Imports

8- we add new dependencies from mvn repositories

    search: cucumber-java

9 - select from cucumber.io
10 - get most upto date one without alpha/beta version , and pass it into project

    currently : v6.2.2

11 - search for next dependency : "cucumber junit"

    this needs to match version with "cucumber java" dependency

    currently : v6.2.2

12- add java-selenium
13- add webdrivermanager/bonigarcia
14- add javafaker

15- create new package under test -> java -> com.cybertek
16- Create new package under 'cybertek' -> pages
17- Create new package under 'cybertek' -> utilities
18- Create new package under 'cybertek' -> runners
19- Create new package under 'cybertek' -> step_definitions

20- right click on the test --> new --> directory

        name: resources

21- right click on the resources --> new --> directory

        name: features

    MAC GO TO PREFERENCES --> PLUGINS --> marketplace
    SEARCH "CUCUMBER FOR JAVA"

    windows GO TO file/settings/plugins -> marketplace
    SEARCH "CUCUMBER FOR JAVA"

22- add "Cucumber for java" plug-in

23- add "Gherkin" plug-in

    RESTART IDE

24- REMOVE Substeps plug in (IF YOU HAVE IT)

    search in installed window:
    Substeps: IF INSTALLED. UNCHECK AND REMOVE

25- right click on features folder-> new -> file:

    file name: Search.feature

    FEATURE FILE KEYWORDS:
    GIVEN, WHEN, THEN, AND

26- right click on runners package:
    create new java class:
    name : CukesRunner

27 - add @RunWith(Cucumber.class) above the class
28 - add @CucumberOptions() below @RunWith
29 - pass the path of the features directory into the features = "" keyword value:
     right click -> copy -> copy path from CONTENT ROOT
30 - pass the path of the step_definitions package in the glue = “” keyword value

    COPY FROM THE SOURCE ROOT

31 - right click on step_definitions package: new --> java class
        name: GoogleStepDefinitions

32 - copy DRIVER utility class from previous project and paste it into new project
33 - copy ConfigurationReader class from previous project and paste it into new project
34 - copy configuration.properties file and paste it into new project

CUCUMBER Behavior Driven Dev (BDD) HAS TWO PARTS:

1- FEATURE FILES : WHERE WE WRITE SCENARIOS IN GHERKIN LANGUAGE
2- STEP_DEFINITIONS : WHERE WE IMPLEMENT THE ACTUAL JAVA_SELENIUM CODE
     */
}
