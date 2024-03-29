package org.ambrosebs.test;

import clojure.lang.Symbol;
import org.ambrosebs.test.util.AddOrEditUser;
import org.ambrosebs.test.util.DriverOps;
import org.ambrosebs.test.util.Nav;
import org.ambrosebs.test.util.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import clojure.lang.Var;
import mikera.cljutils.Clojure;
import org.ambrosebs.test.util.AssertionsNewOrEditUser;

/**
 * This class creates a driver and points it at the moodle homepage.
 * 
 * Test cases should extend this class.
 * 
 * @author ambrose
 */
public class TestParent {
    
    // START CLOJURE BOILERPLATE
    static {
        Clojure.require("clojure.core");
        Clojure.require("clojure.string");
        Clojure.require("clojure.set");
    }
    
    public Var varFrom(String name) {
        return Var.find(Symbol.intern(name));
    }
    
    final Var MAP = Clojure.var("map");
    final Var SET = Clojure.var("set");
    final Var PRINTLN = Clojure.var("println");
    final Var PRN = Clojure.var("prn");
    final Var MAPCAT = Clojure.var("mapcat");
    final Var SPLIT_LINES = varFrom("clojure.string/split-lines");
    final Var SET_DIFFERENCE = varFrom("clojure.set/difference");
    
    // END CLOJURE BOILERPLATE

    public static WebDriver driver;
    
    // These are public so then subclasses can live in another package
    public final AddOrEditUser addNewUser = new AddOrEditUser(driver);    
    public final User user = new User(driver);
    public final Nav nav = new Nav(driver);
    public final AssertionsNewOrEditUser assertsUser = new AssertionsNewOrEditUser(driver);
    
    @BeforeClass
    public static void setupDriver() {
        driver = DriverOps.createMoodleDriver();
    }
    
    @AfterClass
    public static void teardownDriver() {
        DriverOps.teardownDriver(driver);
    }
    
    
}
