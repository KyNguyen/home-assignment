# home.assignment

## Part 1: Test Design and Bug Challenge

Given the application under test (AUT): https://openweathermap.org/

### _**Feature**:_ Search weather in your city

1. Create a Test approach for the given feature based on your Exploratory
   Testing skill (Different Test Type, Test Level, Test Coverage) (Please provide
   your assumptions in the requirement as long as they are reasonable).

_Answer:_
   - **Test Approach** for Search weather feature.
     - Process of testing
       - Test Planning & Control
         - Scope: Given feature - Search weather feature.
         - Assumption
           - Unit Tests, Code Quality & Code Coverage are basically done by Developers to make sure their code is working fine and meet the user specifications.
           - Had Staging environment (Q server) to perform all testing activities before releasing on production (P server).
           - Focus testing on the given feature only - Search weather in your city.
           - Supported on Chrome / Firefox browser.
           - Supported on Windows (From window 7) operating system.
         - Test Tasks: testing Search weather feature using various types of testing.
         - Test Tools: 
           - Using software development tool JIRA.
           - Automation tools using Cucumber framework in Java.
         - Planning for testing budget.
         - Schedule time for test analysis, design, implementation, and closure process.
       - Test Analysis & Design
         - 3-step process to the Test Design process – Test Conditions, Test Cases, Test Procedures. 
           - **Test Conditions:** a test condition verifies a small section of the Search Functional. 
           - **Test Cases:** pre-conditions, a set of inputs, expected outcome and the post-conditions to verify the Test Condition 
           - **Test Procedure:** actual sequence of actions or steps to execute the test
       - Test Implementation & Execution
       - Evaluating Exit Criteria & Reporting
       - Test Closure Activities
     - Testing levels
       - Unit Test covered by Developers.
       - Integration / System / Acceptance Testing covered by Testers.
     - Roles and responsibilities of each team member
       - QA Leader
         - Represents the software testing team as well as enables customer relationship.
         - Identifying the testing activities for team members.
         - Planning the entire testing process.
         - Preparing the status report of testing activities.
         - Sharing updates on testing with the project manager.
         - Planning pre and post-test meetings.
       - Test Lead
         - Technical expertise related to the test program and approach.
         - Provides support for customer interface, staff planning, and supervision, as well as progress status reporting.
         - Validating the quality of the testing requirements such as testability, test design, and script, test automation, etc.
         - Assisting the software testing team to be aware of the latest trends in the world of software testing. 
         - Arranging walk-through for test design and procedure.
         - Implementing the test process.
         - Ensuring that test-product documentation is complete.
       - Manual Test Engineer
         - With a clear understanding of the Graphical User Interface (GUI) design and its standards.
         - Using associated test data to design and develop test procedures and cases.
         - Manually executing the test procedures.
         - Attending test-procedure walk-through.
         - Following the required set standards.
         - Find a Bug and Raise Bug to test management tool.
       - Automated Test Engineer
         - Designing and developing test procedures automatically on the basis of requirements.
         - Following rest-design standards.
         - Attending test procedure walk-throughs.
         - Executing the tests and preparing reports for the same.
         - Find a Bug and Raise Bug to test management tool.
     - Types of Testing
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
     - Define Test management & automation tools for test execution.
       - test management tool on JIRA and automation tools is build a Cucumber framework
     - Adding new defects, re-testing, Defect triage, Regression Testing and test sign off

2. Design test cases for given feature by using different testing techniques (E.g.
   black-box, white-box, ...) for UI / API testing.

_Answer:_
  - Description of Search engine is very flexible. How it works:
    - To make it more precise put the city's name, comma, 2-letter country code (List of ISO3166 country codes). 
    - You will get all proper cities in chosen country.
    - The order is important - the first is city name then comma then country. 
    - Example - London, GB or New York, US.
  - Assumption
    - Test cases for Search on "Weather in your city" in the top-menu.
    - Test cases for Search on "Search city" in the weather widget.
    - Test Cases are designed in High-level contains Title / Summary only.
    - Test Case have to cover the description of Search engine above.
    - OpenWeatherMap is the latest version (I called is version 1.0).
    - Perform testing on the latest version of Chrome/Firefox browser.
    - Using Windows 10 Enterprise to perform testing.
  - UI testing
    - Functional testing
      1. Verify the search field present and aligned.
      2. Verify placeholder text added on search or not.
      3. Verify spelling and grammar should be correct for placeholder text.
      4. Verify search icon is present on the field.
      5. Verify cursor should present on click on the search field.
      6. Verify search is functional and generating the correct result for valid city name.
      7. Verify search working by adding city name and pressing the Enter key from the keyboard.
      8. Verify search working by adding city name and click on the search button/icon.
      9. Verify the result when user enter partial searched city name and click on search button/icon.
      10. Verify if the user can paste the city name with the mouse.
      11. Verify an error message display by entering invalid city name in the search field and clicking the search button/icon.
      12. Verify an error message should display for blank input.
      13. Verify and observe how much time required for getting the search result.
      14. Verify a loader added if it takes time to get the result.
      15. Verify the search result generated by the search in the correct order as per requirement.
      16. Verify pagination added in case if the search result goes on the number of pages.
      17. Verify pagination is accessible or not by clicking on the Next, Previous and number.
      18. Verify the max and min range for the search city name.
      19. Verify the search functionality when user enter negative value and click on search (try with all possible way .(A-Z, a-z , 0-9 symbol etc.)
      20. Verify auto-suggestion shown on adding a city name or not.
      21. Verify the format of results when search the city name by the city's name, comma, 2-letter country code.
      22. Verify the order of city name, the first is city name then comma then country after searching.
    - Non-functional testing
      1. Verify Response time and latency during normal hours.
      2. Verify the website does not crumble under the pressure of many users browsing it.
      3. Verify that when the maximum number of users that the website can support access the website at the same time, performance of Search feature does not deteriorate.
      4. Verify that application load time should not be more than 5 secs up to 1000 users accessing it simultaneously.
      
  - API testing - using Postman tool
    - GET method - URI = https://openweathermap.org/find ; KEY = q ; VALUE = city name 
      1. Verify the response HTTP status code 200 OK after Search feature.
      2. Verify the response time of Search feature not greater than 5s.
      3. Verify the expires of cookie for Search feature in a day.

3. Find bugs of the application/ features and report them in your desired bug
   template. Explain how you triage your defect in terms of priority/ severity as
   the higher priority/ severity bug, the higher score you get.

_Answer:_
   - **List Bugs** of the application/features as below:
     - Reference in the Excel file - **`bugs_report.xlsx`**.
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
- Run by command line to support integrate with CI/CD system like Jenkins
  - Run 1 scenario: mvn test -Dcucumber.options="--tags '@Test_01_Passed'"
  - RUn 2 scenario: mvn test -Dcucumber.options="--tags '@Test_01_Passed and @Test_02_Failed'"

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

_______________________________________________________________________________________

# Integration on CI/CD System - Jenkins

### How to integrate on Jenkins
- Download & Install Apache Maven via link https://maven.apache.org/download.cgi.
- Download Jenkins from link https://www.jenkins.io/download/ and following steps in https://www.guru99.com/download-install-jenkins.html to install Jenkins server.
- Login to Jenkins and create a new job to integrate this maven project.
- In **Configure** menu of this job, we provide some information needed to integrate
  - _Source Code Management_ - Git, URL, account and branch.
  - _Build Triggers_ - Checked Build periodically and provides a cron-like feature to periodically execute this project.
  - _Build_ - Select Maven, provide Root POM file and Goals to execute {mvn test -Dcucumber.options="--tags '@Test_01_Passed'"}
  - _Post-build Actions_ - select Editable Email Notification and provide Recipient list, content, subject to send email result.
- When receiving the result via email, we can click the link inside email and navigate to see the details.