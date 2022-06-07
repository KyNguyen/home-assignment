package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logging;

import java.util.List;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='desktop-menu']//input[@placeholder='Weather in your city']")
	private WebElement txbSearchWeather;

	public String searchWeatherInCity(String cityName) {
	    txbSearchWeather.
		return lstCard.size();
	}
}
