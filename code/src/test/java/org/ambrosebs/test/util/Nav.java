package org.ambrosebs.test.util;

import org.ambrosebs.test.data.Data;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Useful utility methods for navigating with Moodle.
 * 
 * @author ambrose
 */
public class Nav {
    
    final WebDriver driver;
    
    public Nav(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * NOTE: Copied/adapted from 'functional-test-suite'
     */
    /**
     * Intelligently navigate through the tree menu to 'Add New User'
     * i.e. if 'Add New User' option is available then click it, if not then navigate through the tree to find it.
     */
    public void navigateTreeMenuToAddNewUserPage() {
        navigateTree4DeepByXpath(
                ".//span[contains(.,'" + Data.treeSiteAdmin + "')]",
                ".//li[contains(.,'" + Data.treeSiteAdmin + "')]/ul//span[contains(.,'" + Data.treeUsers + "')]",
                ".//li[contains(.,'" + Data.treeSiteAdmin + "')]/ul//span[contains(.,'" + Data.treeAccounts + "')]",
                "//a[@title='" + Data.treeAddNewUser + "']");
    }

    /**
     * NOTE: Copied/adapted from 'functional-test-suite'
     */
    /**
     * Intelligently navigates to a tree menu to an item that is 4 levels deep e.g. "Add a new user". 
     * @param driver The WebDriver to use.
     * @param level1 The Xpath locator for the top level parent node in the tree e.g. "Site administration".
     * @param level2 The Xpath locator for the second level parent node in the tree e.g. "Users".
     * @param level3 The Xpath locator for the third level parent node in the tree e.g. "Browse list of users".
     * @param level4 The Xpath locator for the fourth level parent node in the tree e.g. "Add a new user".
     */
    public void navigateTree4DeepByXpath(String level1, String level2,
            String level3, String level4) {
        boolean itemVisible = false;
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            WebElement e = driver.findElement(By.xpath(level4));
            itemVisible = e.isDisplayed();
        } catch (NoSuchElementException ex) {
        }
        if (itemVisible) {
            WebElement level4Element = driver.findElement(By.xpath(level4));
            level4Element.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else {
            WebElement level1Element = driver.findElement(By.xpath(level1));
            level1Element.click();
            WebElement level2Element = driver.findElement(By.xpath(level2));
            level2Element.click();
            WebElement level3Element = driver.findElement(By.xpath(level3));
            level3Element.click();
            WebElement level4Element = driver.findElement(By.xpath(level4));
            level4Element.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }
}