package pages;

import dataTypes.TestCaseData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	private TestCaseData testCaseData;

	public CommonPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
		this.testCaseData = new TestCaseData();
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "category-cards")
	private WebElement cardsCategory;

	public void navigateToUrl(String applicationURL) {
		driver.get(applicationURL);
	}
}

