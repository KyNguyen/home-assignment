package cucumbers;

import managers.DriverManager;
import managers.PageManager;

/**
 * TextContext - to define Page and Driver manager.
 * @author kynguyen
 */
public class TestContext {

    /**
     * The driver manager to use
     */
    private final DriverManager driverManager;

    /**
     * The page manager to use
     */
    private final PageManager pageManager;

    /**
     * constructor for class TestContext
     */
    public TestContext() {
        driverManager = new DriverManager();
        pageManager = new PageManager(driverManager.getDriver(), driverManager.getWait());
    }

    /**
     * Gets the driver manager
     * @return DriverManager
     */
    public DriverManager getDriverManager() {
        return driverManager;
    }

    /**
     * Gets the page manager
     * @return PageManager
     */
    public PageManager getPageManager() {
        return pageManager;
    }
}
