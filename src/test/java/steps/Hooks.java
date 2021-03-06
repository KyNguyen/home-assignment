package steps;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumbers.TestContext;
import data.types.TestCaseData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Logging;

import java.io.File;
import java.io.IOException;

public class Hooks {
    public static TestCaseData testCaseData;
    public TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before(order = 1)
    public void setUp() {
        Reporter.assignAuthor("Test - NAB Assignment");
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourceFile = ((TakesScreenshot) testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);

                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationFile = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");

                //Copy taken screenshot from source location to destination location
                FileUtils.copyFile(sourceFile, destinationFile);

                //This attach the specified screenshot to the test
                Reporter.addScreenCaptureFromPath("./screenshots/" + screenshotName + ".png");
            } catch (IOException e) {
                Logging.error(e.getMessage());
            }
        }
    }

    @After(order = 0)
    public void tearDown() {
        testContext.getDriverManager().closeDriver();
    }
}
