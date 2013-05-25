package org.ambrosebs.test;

import org.ambrosebs.test.util.AddNewUser;
import org.ambrosebs.test.util.DriverOps;
import org.ambrosebs.test.util.Nav;
import org.ambrosebs.test.util.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

/**
 * This class creates a driver and points it at the moodle homepage.
 * 
 * Test cases should extend this class.
 * 
 * @author ambrose
 */
public class TestParent {

    static WebDriver driver;
    
    final AddNewUser addNewUser = new AddNewUser(driver);    
    final User user = new User(driver);
    final Nav nav = new Nav(driver);
    
    @BeforeClass
    public static void setupDriver() {
        driver = DriverOps.createMoodleDriver();
    }
    
    @AfterClass
    public static void teardownDriver() {
        DriverOps.teardownDriver(driver);
    }
    
    
}
