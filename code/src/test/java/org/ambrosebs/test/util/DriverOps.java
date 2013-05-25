package org.ambrosebs.test.util;

import org.ambrosebs.test.data.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Utilities for starting/stopping WebDrivers for use with Moodle.
 * 
 * @author ambrose
 */
public class DriverOps {

    /**
     * Returns a WebDriver pointing at the Moodle homepage.
     * 
     * @return The setup WebDriver
     */
    public static WebDriver createMoodleDriver() {
        final WebDriver driver = new FirefoxDriver();
        driver.get(Data.moodleHome);

        return driver;
    }

    /**
     * Teardown given driver.
     * 
     * @param w
     */
    public static void teardownDriver(WebDriver w) {
        w.quit();
    }
}
