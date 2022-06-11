package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logging;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class DashboardPage {
	private final WebDriverWait wait;

	public DashboardPage(WebDriver driver, WebDriverWait wait) {
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='desktop-menu']//input[@placeholder='Weather in your city']")
	protected WebElement txbSearchWeather;

	@FindBy(id = "search_str")
	protected WebElement txtSearchString;

	@FindBys({@FindBy(xpath = "//a[contains(@href,'/city/')]")})
	protected List<WebElement> lstCityLink;

	@FindBy(xpath = "//*[@id='weather-widget']//*[contains(@class,'current-container')]")
	protected WebElement divCurrentContainer;

	@FindBy(className = "orange-text")
	protected WebElement txtCurrentDate;

	@FindBy(xpath = "//*[contains(@class,'current-container')]//h2")
	protected WebElement txtCityName;

	@FindBy(xpath = "//*[@class='current-temp']//span")
	protected WebElement txtTemperature;

	public boolean searchWeatherInCity(String cityName) {
		txbSearchWeather.sendKeys(cityName + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(txtSearchString));
		Logging.info(String.format("Search the weather of %s city successful", cityName));

		return txtSearchString.getAttribute("value").equals(cityName);
	}

	public boolean clickOnTheFirstLinkOfWeather() {
		if (lstCityLink.size() >= 1) {
			lstCityLink.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(divCurrentContainer));
			Logging.info("Clicked on the first link of the weather list successful");

			return true;
		} else {
			Logging.warn("Not found the weather link with your city. Please check the name of city again");

			return false;
		}
	}

	public boolean verifyTheCurrentDateDisplayedCorrect() {
		String currentDate = new SimpleDateFormat("MMM dd").format(Calendar.getInstance().getTime());
		String actualDate = txtCurrentDate.getText().split(",")[0];
		Logging.info(String.format("The actual date is %s and the current date is %s.", actualDate, currentDate));

		return actualDate.equals(currentDate);
	}

	public boolean verifyTheCityNameDisplayedCorrect(String cityName) {
		String cityNameHeading = txtCityName.getText();
		Logging.info(String.format("The actual city name is %s and the expected city name is %s.", cityNameHeading, cityName));

		return cityNameHeading.equals(cityName);
	}

	public boolean verifyTheTheTemperatureDisplayedCorrect(String temperatureSign) {
		// Note: Only validate the temperature display regardless its number
		String temperature = txtTemperature.getText();
		Logging.info(String.format("The temperature is %s.", temperature));

		return temperature.contains(temperatureSign);
	}
}
