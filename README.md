# home.assignment

## Part 1: Test Design and Bug Challenge

Given the application under test (AUT): https://openweathermap.org/

### _**Feature**:_ Search weather in your city

1. Create a Test approach for the given feature based on your Exploratory
   Testing skill (Different Test Type, Test Level, Test Coverage) (Please provide
   your assumptions in the requirement as long as they are reasonable).

_Answer:_ 
   - My assumption for the requirement as below:
     - Unit Tests, Code Quality & Code Coverage are basically done by Developers to make sure their code is working fine and meet the user specifications.
     - Had Staging environment (Q server) to perform all testing activities before releasing on production (P server).
     - Focus testing on the given feature only - Search weather in your city.
     - Only supported on Chrome (version)/Firefox (version) browser.
     - Only supported on Windows (From window 7)/macOS (from ) operating system.


   - **Test Approach** for Search weather feature.
     - _Functionality Testing_ - Search weather feature must be tested. 
       - Any values that are being typed in by the user must be checked for proper validation. 
       - Also, other basic requirements such as setting default values for each field, proper error messages displayed on wrong entry, if applicable, must also be verified.
       - Tester must also ensure that the cookies can be enabled/disabled. Also, encryption of cookies must be tested. 
       - One needs to also delete the cookies and see if security stays intact. 
       - Miscellaneous testing with respect to fetching/updating data to the database and HTML/CSS validation must also be done.
     - _Compatibility Testing_ - An application will be accessed over the globe and so its compatibility is of prime importance.
       - The Search feature must be checked for operating system compatibility, browser compatibility.
       - Test the website’s appearance on different inched monitors. Also, may try different font sizes on browsers.
     - _Usability Testing_ 
       - Testing for correct navigation within the webpage must be carried out in order to validate proper surfing of the web pages, consistency between various web pages and presence of proper user help at relevant places. 
       - Also, presence of content on the pages must be tested for accuracy, logical/structural display, any spelling/grammatical errors and coordinated font sizes/colors.
       - Image sizes and shapes, tables and charts must look in place within the webpages.
     - _Interface Testing_ 
       - Interactions between web server interfaces and application server interfaces must be tested properly. Also, relevant error messages must be shown incase any problem arises during the interactions. 
       - Interactions between application servers and database servers must also be checked for correctness. Proper data updates/fetches from the backend database must be validated. 
       - Check for proper handling of errors such as maintenance time, accidental/intentional resets and other broken connection between the servers.
     - _Security Testing_ - Internet is where crime rate is on a steady rise, and so the website must be tested for good and strong security in place. 
       - Login bypasses must be tested, direct URL modification must be tested, and entry into the website through invalid login details must be tested. 
       - Testing must be done to include SQL injection, cross-site scripting, spoofing and password cracking on the website.
     - _Performance/Load Testing_
       - Response time and latency during normal hours must be tested on a website. 
       - It is extremely important to ensure that the website does not crumble under the pressure of many users browsing it. 
       - Tester must ensure that when the maximum number of users that the website can support access the website at the same time, its performance does not deteriorate. 
       - Also, when this maximum number of allowed users is exceeded, the website must be tested for proper crash recovery.
     - _Acceptance testing_
       - Acceptance testing are basically done to ensure that the requirements of the specification are met.

2. Design test cases for given feature by using different testing techniques (E.g.
   black-box, white-box, ...) for UI / API testing.

_Answer:_
  - Test cases for Search weather in your city feature
  - UI testing
    - Functional testing
    - Non-functional testing
    - Regression testing
  - API testing
    - verify status code, response time and accuracy data.

3. Find bugs of the application/ features and report them in your desired bug
   template. Explain how you triage your defect in terms of priority/ severity as
   the higher priority/ severity bug, the higher score you get.

_Answer:_
   - **List Bugs** of the application/features as below:
     - propose my bug template
   - **Priority** - is the order in which the developer should resolve a defect.
     - Low − The flaw is an annoyance, but it can be repaired once the more important flaw has been addressed.
     - Medium − A flaw should be corrected throughout the usual course of development operations. It will have to wait till a new version is released.
     - High − The problem must be corrected as soon as feasible since it has a significant impact on the system and cannot be utilized until it is fixed.
   - **Severity** - is the degree of impact that a defect has on the operation of the product.
     - Critical - if the application crashes, or it becomes unusable / not able to proceed further
     - Major - Any major feature implemented that is not meeting its requirements/use case(s) and behaves differently than expected.
     - Moderate - A moderate defect occurs when the product or application does not meet certain criteria or still exhibits some unnatural behavior, however, the functionality as a whole is not impacted.
     - Minor - Any feature implemented that is not meeting its requirements/use case(s) and behaves differently than expected but the impact is negligible to some extent, or it does not have a major impact on the application.
     - Cosmetic - Any cosmetic defects including spelling mistakes or alignment issues or font casing.

_______________________________________________________________________________________

## Part 2: UI Automation

Write UI automated tests for the feature "search weather in your city" with following step:
1. Searching for a city of your choice (E.g. Ha Noi)
2. Click on the link in result list
3. Verify the current date (E.g. Jun 9), city name and the weather display correct. (Note: Only validate the temperature display regardless its number)

_______________________________________________________________________________________

### Setup Environments
- Download & Install IntelliJ Community on your machine via link https://www.jetbrains.com/idea/download/#section=windows
- Make sure Chrome & Firefox browser already installed in your machine
- Make sure Maven, OpenJDK are installed on your machine
- Check proxy network configuration for Intellij and Maven.
- Install SonarLint for static checking code

### Clone Source Code from Git Repository to IntelliJ IDEA
- Open Intellij and select File > New > Project from Version Control...
- Select "Git" option for Version Control and input URL to clone project https://github.com/KyNguyen/home-assignment.git
- Install all suggestions add-ons, dependencies from IntelliJ during cloning my source code.
- You can execute Maven to download all dependencies again.

### Setup Proxy Configuration
- Input your username and password in a "configuration.properties" file if it needs proxy to execute
- The password should be encoded using Base64 (https://www.base64encode.org)

### How to execute
- Input browser name Chrome/Firefox in configs/configuration.properties file.
- Go to src/test/java/runners and open TestRunner.java class.
- Run All: right click and run TestRunner class
- Run 1/list Scenario: input value in "tags = {},".
  - 1 Scenario: tags = {"@DPassedCase"} and right click TestRunner class to run.
  - list Scenario: tags = {"@PassedCase,@FailedCase"} and right-click TestRunner class to run.
- Run by command line: mvn verify

### How to read the Test report
- The report will be generated in "target/cucumber-report" folder.
- Open index.html in Chrome/Firefox browser to see the normal report.
- Open **report.html** in Chrome/Firefox browser to see the custom report with Cucumber format.
- For failed case in report, we can see the attached image at step failed.
- We can use information or chart from Cucumber report to do the specific report for customer or client.

_______________________________________________________________________________________

# Cucumber Framework

### Techniques in Framework
- Using Selenium in Java and WebDriverManager to manage WebDriver in cross-browsers.
- Using Gherkin language to define test cases/scenarios in feature file.
- Using Cucumber to support BDD style.
- Using PageFactory provide implementation of POM Design Pattern.
- Using @FindBy to find web element using.

### How to write scripts
- Create a new branch to write a new script for each feature
- All scenarios/test cases/use cases will be defined inside *.feature file at "src/test/resources/features"
- All steps will be defined inside **Step.java class at "src/test/java/steps"
- **Step.java class will be called methods from PageFactory in "src/main/java/pages"
- Using logging to record in log file with 5 levels (info/warn/error/fatal/debug)
- Input Test Data in ***.feature files or store on Json file to read