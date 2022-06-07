# nab.assignment - Part 2: UI Automation
Application Under Test - AUT:
- url = https://openweathermap.org/

Check Configuration:
- Check proxy network in "settings.xml" file, Eclipse or IntelliJ config and your machine
- Input username and password in a "configuration.properties" file
- The password should be encoded using Base64 (https://www.base64encode.org)

How to execute:
- Go to src/test/java/runners and open TestRunner.java class
- Run All: right click and run TestRunner class
- Run 1 Scenario: input value in "tags = {},". e.g: "tags = {"@Demo_001"}," and right click TestRunner class to run

How to write scripts:
- Create a new branch to write a new script for each feature
- All scenarios will be defined inside *.feature file at "src/test/resources/features"
- All steps of scenarios will be defined inside **Step.java class at "src/test/java/steps"
- *Step.java class will be called methods from PageFactory in "src/main/java/pages"
- Using logging to record in log file with 5 levels (info/warn/error/fatal/debug)

How to read the report:
- The report will be generated in "target/cucumber-report" folder
- Open index.html in Chrome browser to see the normal report
- Open report.html in Chrome browser to see the custom report with Cucumber format