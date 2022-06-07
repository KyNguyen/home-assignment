package steps;

import cucumber.api.java.en.When;
import cucumbers.TestContext;
import managers.FileReaderManager;
import pages.CommonPage;
import pages.HomePage;

public class CommonStep {

    private TestContext testContext;
    private CommonPage commonPage;
    private LoginPage loginPage;

    public CommonStep(TestContext context) {
        testContext = context;
        commonPage = testContext.getPageManager().getCommonPage();
        loginPage = testContext.getPageManager().getLoginPage();
    }

    @When("^I stay at Dashboard$")
    public void iStayAtToolsQAHomepage() throws Throwable {
        commonPage.navigateToUrl(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL());
    }
}
