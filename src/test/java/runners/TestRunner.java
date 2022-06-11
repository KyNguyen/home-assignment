package runners;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.Constants;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"."},
        glue= {"steps"},
        tags = {"@TestCase_001", "@TestCase_002"},
        plugin = {"pretty",
                  "html:target/cucumber-reports",
                  "json:target/cucumber-reports/cucumber.json",
                  "junit:target/cucumber-reports/cucumber.xml",
                  "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true)
public class TestRunner {
    @AfterClass
    public static void writeExtendReport() {
        Reporter.loadXMLConfig(Constants.EXTENDS_REPORT_PATH);
        Reporter.setSystemInfo("User Name", System.getProperty(Constants.USER_NAME));
        Reporter.setSystemInfo("Time Zone", System.getProperty(Constants.USER_TIMEZONE));
        Reporter.setSystemInfo("Machine", String.format("%s %s", System.getProperty(Constants.OS_NAME), System.getProperty(Constants.OS_ARCHITECTURE)));
        Reporter.setSystemInfo("Selenium", Constants.SELENIUM_VERSION);
        Reporter.setSystemInfo("Maven", Constants.MAVEN_VERSION);
        Reporter.setSystemInfo("Java Version", System.getProperty(Constants.JAVA_VERSION));
    }
}