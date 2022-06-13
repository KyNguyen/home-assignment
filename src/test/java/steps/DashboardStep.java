package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumbers.TestContext;
import org.junit.Assert;
import pages.DashboardPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
		String currentDate = new SimpleDateFormat("MMM dd").format(Calendar.getInstance().getTime());
		Assert.assertEquals(currentDate, dashboardPage.getTheCurrentDateDisplayed());
	}

	@And("^I verify the city name \"([^\"]*)\" is displayed correct$")
	public void iVerifyTheCityNameIsDisplayedCorrect(String cityName) {
		Assert.assertEquals(cityName, dashboardPage.getTheCityNameDisplayed());
	}

	@And("^I verify the temperature \"([^\"]*)\" is displayed correct$")
	public void iVerifyTheTemperatureOfWeatherIsDisplayedCorrect(String temperatureSign) {
		// Note: Only validate the temperature display regardless its number
		Assert.assertTrue(dashboardPage.getTheTemperatureDisplayed().contains(temperatureSign));
	}
}