package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumbers.TestContext;
import org.junit.Assert;
import pages.DashboardPage;

public class DashboardStep {
	private final DashboardPage dashboardPage;

	public DashboardStep(TestContext context) {
		dashboardPage = context.getPageManager().getDashboardPage();
	}

	@When("^I search the weather of \"([^\"]*)\" city$")
	public void iSearchTheWeatherOfCity(String cityName) {
		dashboardPage.searchWeatherInCity(cityName);
	}

	@And("^I click on the link in result list$")
	public void iClickOnTheLinkInResultList() {
		dashboardPage.clickOnTheFirstLinkOfWeather();
	}

	@Then("^I verify the current date is displayed correct$")
	public void iVerifyTheCurrentDateIsDisplayedCorrect() {
		Assert.assertTrue(dashboardPage.verifyTheCurrentDateDisplayedCorrect());
	}

	@And("^I verify the city name \"([^\"]*)\" is displayed correct$")
	public void iVerifyTheCityNameIsDisplayedCorrect(String cityName) {
		Assert.assertTrue(dashboardPage.verifyTheCityNameDisplayedCorrect(cityName));
	}

	@And("^I verify the temperature \"([^\"]*)\" is displayed correct$")
	public void iVerifyTheTemperatureOfWeatherIsDisplayedCorrect(String temperatureSign) {
		Assert.assertTrue(dashboardPage.verifyTheTheTemperatureDisplayedCorrect(temperatureSign));
	}
}