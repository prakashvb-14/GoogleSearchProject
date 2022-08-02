# **Google Search Test project**

This repository contains selenium-cucumber-java project and libraries that demonstrate the Google search functionality and results validation using the Cucumber BDD framework with Java as programming language.

## **Installation (pre-requisites)**

1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set)
3. IntelliJ
4. IntelliJ Plugins for
5. Maven
6. Cucumber
7. Browser driver (make sure you have your desired browser driver and class path is set)

## **Implemented Browsers**

The webdrivermanager used will supports the following browsers and automatically downloads OS specific binaries for:

* To execute in chrome browser : mvn clean test -Dbrowser=chrome
* To execute in firefox browser : mvn clean test -Dbrowser=firefox
* To execute in internet explorer : mvn clean test -Dbrowser=ie (will work on windows machines only)
* To execute in edge browser : mvn clean test -Dbrowser=edge (will work on windows machines only)

## **How to execute the test**

To execute the tests just browse to the path where the TestRunner is located via terminal and type ./maven clean test or execute the tests in your IDE.
The Project will use Chrome Browser by default / if no other browser is stated
(see list of implemented browsers for more info on how to use them).

## **How to view the results**

To view the result after the test execution, just navigate to cucumber folder under target. Three format of reports are available HTML, JSON & XML.
