# nab.assignment - UI Automation Guideline
Application Under Test - AUT:
- url = https://openweathermap.org/

Setup Environments:
- Download & Install IntelliJ Community on your machine via link https://www.jetbrains.com/idea/download/#section=windows

Clone Source Code from IntelliJ
- Install Maven, OpenJDK, SDK on your machine
- Install plugin/add-on Cucumber in Intellij IDE
- Check proxy network of Intellij and Maven.
- Run maven to download all dependencies.

Check Configuration:
- Input your username and password in a "configuration.properties" file if it needs proxy to execute
- The password should be encoded using Base64 (https://www.base64encode.org)

How to execute:
- Go to src/test/java/runners and open TestRunner.java class
- Run All: right click and run TestRunner class
- Run 1 Scenario: input value in "tags = {},". e.g: "tags = {"@Demo_001"}," and right click TestRunner class to run

How to read the report:
- The report will be generated in "target/cucumber-report" folder
- Open index.html in Chrome/Firefox browser to see the normal report
- Open report.html in Chrome/Firefox browser to see the custom report with Cucumber format

# Cucumber Framework

Techniques in Framework:
- Using Selenium in Java and WebDriverManager to manage WebDriver in cross-browsers.
- Using Gherkin language to define test cases/scenarios in feature file.
- Using Cucumber to support BDD style.
- Using PageFactory provide implementation of POM Design Pattern.
- Using @FindBy to find web element using.

How to write scripts:
- Create a new branch to write a new script for each feature
- All scenarios/test cases/use cases will be defined inside *.feature file at "src/test/resources/features"
- All steps will be defined inside **Step.java class at "src/test/java/steps"
- **Step.java class will be called methods from PageFactory in "src/main/java/pages"
- Using logging to record in log file with 5 levels (info/warn/error/fatal/debug)
- Input Test Data in ***.feature files or store on Json file to read