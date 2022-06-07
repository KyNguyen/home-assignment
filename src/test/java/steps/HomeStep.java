package steps;

import cucumber.api.java.en.Then;
import cucumbers.TestContext;
import pages.CommonPage;
import pages.HomePage;
import utils.Logging;

import static org.junit.Assert.assertEquals;

public class HomeStep {

	private HomePage homePage;
	private CommonPage commonPage;
	private TestContext testContext;

	public HomeStep(TestContext context) {
		testContext = context;
		homePage = testContext.getPageManager().getHomePage();
		commonPage = testContext.getPageManager().getCommonPage();
	}

	@Then("^I verify total category cards is \"(\\d+)\" in homepage$")
	public void iVerifyTotalCategoryCardsIsInHomepage(int numberOfCards) throws Throwable {
		int actualNumberOfCards = homePage.getTotalCategoryCards();
		assertEquals("Total Category Cards is wrong", numberOfCards, actualNumberOfCards);
		Logging.info(String.format("Total Category Cards is %s", actualNumberOfCards));
	}
}