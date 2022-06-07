package steps;

import cucumber.api.java.en.When;
import cucumbers.TestContext;
import managers.FileReaderManager;
import pages.CommonPage;
import pages.HomePage;

public class CommonStep {

    private TestContext testContext;
    private CommonPage commonPage;
    private HomePage homePage;

    public CommonStep(TestContext context) {
        testContext = context;
        commonPage = testContext.getPageManager().getCommonPage();
        homePage = testContext.getPageManager().getHomePage();
    }

    @When("^I stay at Tools QA Homepage$")
    public void iStayAtToolsQAHomepage() throws Throwable {
        commonPage.navigateToUrl(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL());
    }
}
