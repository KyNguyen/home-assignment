package managers;

import enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import utils.Logging;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private WebDriver driver;
    private WebDriverWait wait;
    private static DriverType driverType;

    public DriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowserName();
    }

    public WebDriver getDriver() {
        return (driver == null) ? createDriver() : driver;
    }

    public WebDriverWait getWait() {
        return (wait == null) ? createWait() : wait;
    }

    private WebDriver createDriver() {
        setupProxy();
        switch (driverType) {
            case CHROME:
                Logging.info("Open Chrome Browser");
                WebDriverManager.chromedriver().proxy(getProxy()).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("disable-infobars");
                if (FileReaderManager.getInstance().getConfigFileReader().getHeadlessMode().equals("yes")) {
                    chromeOptions.setHeadless(true);
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                Logging.info("Open Firefox Browser");
                WebDriverManager.firefoxdriver().proxy(getProxy()).setup();
                FirefoxProfile profile = new FirefoxProfile();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);
                if (FileReaderManager.getInstance().getConfigFileReader().getHeadlessMode().equals("yes")) {
                    firefoxOptions.setHeadless(true);
                    firefoxOptions.addArguments("--window-size=1920,1080");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(FileReaderManager.getInstance().getConfigFileReader().getPageLoadTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(FileReaderManager.getInstance().getConfigFileReader().getScriptTimeout(), TimeUnit.SECONDS);
        return driver;
    }

    private WebDriverWait createWait() {
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigFileReader().getWebDriverWait());
        return wait;
    }

    public void closeDriver() {
        Logging.info("Close Browser");
        driver.close();
    }

    private void setupProxy() {
        Logging.info("Setup Proxy to access Internet and download library");
        System.setProperty(Constants.WDM_PROXY_HOST, FileReaderManager.getInstance().getConfigFileReader().getWDMProxyHost());
        System.setProperty(Constants.WDM_PROXY_USER, FileReaderManager.getInstance().getConfigFileReader().getWDMUsername());
        System.setProperty(Constants.WDM_PROXY_PASS, StringUtils.newStringUtf8(Base64.decodeBase64(FileReaderManager.getInstance().getConfigFileReader().getWDMPassword())));
        System.setProperty(Constants.WDM_NON_PROXY_HOSTS, FileReaderManager.getInstance().getConfigFileReader().getWDMNonProxyHosts());
    }

    public String getProxy() {
        String user = FileReaderManager.getInstance().getConfigFileReader().getWDMUsername();
        String pass = StringUtils.newStringUtf8(Base64.decodeBase64(FileReaderManager.getInstance().getConfigFileReader().getWDMPassword()));
        String proxyHostAndPort = FileReaderManager.getInstance().getConfigFileReader().getWDMProxyHost();
        return String.format("http://%s:%s@%s", user, pass, proxyHostAndPort);
    }
}