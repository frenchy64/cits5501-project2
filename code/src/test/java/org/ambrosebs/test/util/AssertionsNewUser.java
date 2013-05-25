/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test.util;

import clojure.lang.IPersistentSet;
import clojure.lang.RT;
import java.util.List;
import mikera.cljutils.Clojure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ambrose
 */
public class AssertionsNewUser extends AssertionsParent {
    
    final private WebDriver driver;
    
    public AssertionsNewUser(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * Collects all error messages on the current page (using the CSS
     * class "error", and ensures that each message contained in the sequence
     * expected errors appears.
     * 
     * @param expectedErrors  The sequence of error messages to appear on the page.
     */
    public void assertAllErrorsAppear(Object expectedErrors) {
        
        // get the errors on the page
        final List<WebElement> errors = 
                driver.findElements(By.className("error"));
        
        // implemented in org/ambrosebs/clj-util.clj
        ASSERT_ALL_ERRORS_APPEAR.invoke(expectedErrors, errors);
    }
}
