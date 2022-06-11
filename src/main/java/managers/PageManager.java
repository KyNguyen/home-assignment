package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.DashboardPage;

public class PageManager {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private CommonPage commonPage;
    private DashboardPage dashboardPage;

    public PageManager(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public CommonPage getCommonPage() {
        return (commonPage == null) ? commonPage = new CommonPage(driver, wait) : commonPage;
    }

    public DashboardPage getDashboardPage() {
        return (dashboardPage == null) ? dashboardPage = new DashboardPage(driver, wait) : dashboardPage;
    }
}