package steps;

import cucumber.api.java.en.When;
import cucumbers.TestContext;
import managers.FileReaderManager;
import pages.CommonPage;

public class CommonStep {
    private final CommonPage commonPage;

    public CommonStep(TestContext context) {
        commonPage = context.getPageManager().getCommonPage();
    }

    @When("^I stay at Open Weather Map Dashboard page$")
    public void iStayAtOpenWeatherMapDashboardPage() {
        commonPage.navigateToUrl(FileReaderManager.getInstance().getConfigFileReader().getApplicationURL());
    }
}
