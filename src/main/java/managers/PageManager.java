package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.HomePage;

public class PageManager {
    private WebDriver driver;
    private WebDriverWait wait;
    private CommonPage commonPage;
    private HomePage homePage;

    public PageManager(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public CommonPage getCommonPage() {
        return (commonPage == null) ? commonPage = new CommonPage(driver, wait) : commonPage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver, wait) : homePage;
    }
}