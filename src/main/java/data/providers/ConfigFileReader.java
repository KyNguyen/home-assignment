package data.providers;

import enums.DriverType;
import utils.Constants;
import utils.Logging;
import utils.ErrorMessages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigFileReader - to read data from configuration file
 * @author kynguyen
 */
public class ConfigFileReader {

    /**
     * The properties to use
     */
    private Properties properties;

    /**
     * The full path of property file to use
     */
    private final String propertyFilePath = String.format("%s%s%s",System.getProperty(Constants.USER_DIR),
            Constants.CONFIGURATION_PROPERTIES_PATH, Constants.CONFIGURATION_PROPERTIES_FILE);

    /**
     * constructor for class ConfigFileReader
     */
    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format(ErrorMessages.FILE_NOT_FOUND_AT_PATH,
                    Constants.CONFIGURATION_PROPERTIES_FILE, propertyFilePath));
        }
    }

    /**
     * Method to get browser name from configuration file
     * @return enums DriverType: CHROME, FIREFOX and INTERNET_EXPLORER
     */
    public DriverType getBrowserName(){
        Logging.info(String.format("Get %s from properties file", Constants.BROWSER_NAME));
        String browserName = properties.getProperty(Constants.BROWSER_NAME).toLowerCase();
        if(browserName.equals("chrome")) return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if (browserName.equals("ieplorer")) return DriverType.INTERNET_EXPLORER;
        else throw new RuntimeException(String.format(ErrorMessages.KEY_IS_NOT_MATCHED,
                    Constants.BROWSER_NAME, Constants.CONFIGURATION_PROPERTIES_FILE, browserName));
    }

    /**
     * Method to get Implicit Wait values from configuration file
     * @return long as a signed decimal long
     */
    public long getImplicitWait() {
        Logging.info(String.format("Get %s from properties file", Constants.IMPLICIT_WAIT));
        String implicitWait = properties.getProperty(Constants.IMPLICIT_WAIT);
        if(implicitWait != null) return Long.parseLong(implicitWait);
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.IMPLICIT_WAIT,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get Page Load Timeout values from configuration file
     * @return long as a signed decimal long
     */
    public long getPageLoadTimeout() {
        Logging.info(String.format("Get %s from properties file", Constants.PAGE_LOAD_TIMEOUT));
        String pageLoadTimeout = properties.getProperty(Constants.PAGE_LOAD_TIMEOUT);
        if(pageLoadTimeout != null) return Long.parseLong(pageLoadTimeout);
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.PAGE_LOAD_TIMEOUT,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get Script Timeout values from configuration file
     * @return long as a signed decimal long
     */
    public long getScriptTimeout() {
        Logging.info(String.format("Get %s from properties file", Constants.SCRIPT_TIMEOUT));
        String pageLoadTimeout = properties.getProperty(Constants.SCRIPT_TIMEOUT);
        if(pageLoadTimeout != null) return Long.parseLong(pageLoadTimeout);
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.SCRIPT_TIMEOUT,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get WebDriver Wait values from configuration file
     * @return long as a signed decimal long
     */
    public long getWebDriverWait() {
        Logging.info(String.format("Get %s from properties file", Constants.WEB_DRIVER_WAIT));
        String webDriverWait = properties.getProperty(Constants.WEB_DRIVER_WAIT);
        if(webDriverWait != null) return Long.parseLong(webDriverWait);
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.WEB_DRIVER_WAIT,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get Headless Mode values from configuration file
     * @return String yes/no value
     */
    public String getHeadlessMode() {
        Logging.info(String.format("Get %s from properties file", Constants.HEADLESS_MODE));
        String headlessMode = properties.getProperty(Constants.HEADLESS_MODE);
        if (headlessMode != null) return headlessMode;
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.HEADLESS_MODE, Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get WDM proxy host values from configuration file
     * @return String proxy hot
     */
    public String getWDMProxyHost() {
        Logging.info(String.format("Get %s from properties file", Constants.WDM_PROXY_HOST));
        String proxyHost = properties.getProperty(Constants.WDM_PROXY_HOST);
        if(proxyHost!= null) return proxyHost;
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.WDM_PROXY_HOST,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get WDM username values from configuration file
     * @return String username
     */
    public String getWDMUsername() {
        Logging.info(String.format("Get %s from properties file", Constants.WDM_PROXY_USER));
        String username = properties.getProperty(Constants.WDM_PROXY_USER);
        if(username!= null) return username;
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.WDM_PROXY_USER,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get WDM password values from configuration file
     * @return String password
     */
    public String getWDMPassword() {
        Logging.info(String.format("Get %s from properties file", Constants.WDM_PROXY_PASS));
        String password = properties.getProperty(Constants.WDM_PROXY_PASS);
        if(password!= null) return password;
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.WDM_PROXY_PASS,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get WDM non-proxy hosts values from configuration file
     * @return String non-proxy hosts
     */
    public String getWDMNonProxyHosts() {
        Logging.info(String.format("Get %s from properties file", Constants.WDM_NON_PROXY_HOSTS));
        String nonProxyHosts = properties.getProperty(Constants.WDM_NON_PROXY_HOSTS);
        if(nonProxyHosts!= null) return nonProxyHosts;
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.WDM_NON_PROXY_HOSTS,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get Application URL values from configuration file
     * @return String Application URL
     */
    public String getApplicationURL() {
        Logging.info(String.format("Get %s from properties file", Constants.APPLICATION_URL));
        String applicationURL = properties.getProperty(Constants.APPLICATION_URL);
        if(applicationURL!= null) return applicationURL;
        else throw new RuntimeException(String.format(ErrorMessages.PROPERTIES_NOT_SPECIFIED,
                Constants.APPLICATION_URL,Constants.CONFIGURATION_PROPERTIES_FILE));
    }

    /**
     * Method to get path of test data resource values from configuration file
     * @return String path of test data resource
     */
    public String getTestDataResourcePath() {
        Logging.info(String.format("Get %s from properties file", Constants.TEST_DATA_RESOURCE_PATH));
        String testDataPath = properties.getProperty(Constants.TEST_DATA_RESOURCE_PATH);
        if(testDataPath != null) return testDataPath;
        else throw new RuntimeException(String.format(ErrorMessages.KEY_IS_NOT_MATCHED,
                Constants.TEST_DATA_RESOURCE_PATH, Constants.CONFIGURATION_PROPERTIES_FILE, testDataPath));
    }
}