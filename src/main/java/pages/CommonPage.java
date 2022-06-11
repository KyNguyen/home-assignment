package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logging;

public class CommonPage {
	private final WebDriver driver;

	public CommonPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToUrl(String applicationURL) {
		driver.get(applicationURL);
		Logging.info(String.format("Navigate to url %s successful", applicationURL));
	}
}

