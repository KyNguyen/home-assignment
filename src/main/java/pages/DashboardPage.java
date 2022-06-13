package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logging;

import java.util.List;

/**
 *
 */
public class DashboardPage {

	private final WebDriverWait wait;

	private final WebDriver driver;

	private final JavascriptExecutor jsExecutors;

	public DashboardPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.jsExecutors = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Weather in your city']")
	protected WebElement txbSearchWeather;

	@FindBy(css = "#search_str")
	protected WebElement txtSearchString;

	protected WebElement getTxtSearchStringByJavaScript() {
		WebElement txtSearch = (WebElement)jsExecutors.executeScript("return document.querySelector('#search_str');");
		return txtSearch;
	}

	@FindBys({@FindBy(xpath = "//a[starts-with(@href,'/city/')]")})
	protected List<WebElement> lstCityLink;

	@FindBy(xpath = "//*[@id='weather-widget']//*[contains(@class,'current-container')]")
	protected WebElement divCurrentContainer;

	@FindBy(css = ".orange-text")
	protected WebElement txtCurrentDate;

	@FindBy(xpath = "//*[contains(@class,'current-container')]//h2")
	protected WebElement txtCityName;

	@FindBy(xpath = "//*[@class='current-temp']//span")
	protected WebElement txtTemperature;

	/**
	 * Method to implement searching the weather of city.
	 *
	 * @author kynguyen
	 * @param cityName the name of city that user want to find the weather.
	 * @return true if the weather link is displayed, otherwise returned false.
	 */
	public boolean searchWeatherInCity(String cityName) {
		txbSearchWeather.sendKeys(cityName + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(txtSearchString));
		Logging.info(String.format("Search the weather of %s city successful", cityName));

		return getTxtSearchStringByJavaScript().getAttribute("value").equals(cityName);
	}

	/**
	 * This method to implement clicking on the first link after
	 *
	 * @author kynguyen
	 * @return true if the click on the first link of weather success, otherwise returned false.
	 */
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

	/**
	 *
	 * @return
	 */
	public String getTheCurrentDateDisplayed() {
		String actualCurrentDate = txtCurrentDate.getText().split(",")[0];
		Logging.info(String.format("The current date is %s.", actualCurrentDate));

		return actualCurrentDate;
	}

	public String getTheCityNameDisplayed() {
		String cityNameHeading = txtCityName.getText();
		Logging.info(String.format("The city name is %s.", cityNameHeading));

		return cityNameHeading;
	}

	public String getTheTemperatureDisplayed() {
		String temperature = txtTemperature.getText();
		Logging.info(String.format("The temperature is %s.", temperature));

		return temperature;
	}
}
