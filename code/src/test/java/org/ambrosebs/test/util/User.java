package org.ambrosebs.test.util;

import org.ambrosebs.test.data.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Utilities for user interactions.
 * 
 * @author ambrose
 */
public class User {
    
    final WebDriver driver;
    
    public User(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Logs in to the Moodle page via the WebDriver with the given credentials.
     * 
     * Assumes the WebDriver is on a Moodle page with a Login button in sight.
     * 
     * @param w
     * @param user
     * @param pw 
     */
    public void loginWithCredentials(String user, String pw) {
        final WebElement loginLink = driver.findElement(By.partialLinkText(Data.loginLinkText));
        loginLink.click();
        final WebElement usernameTextbox = driver.findElement(By.id("username"));
        usernameTextbox.sendKeys(user);
        final WebElement pwTextbox = driver.findElement(By.id("password"));
        pwTextbox.sendKeys(pw);
    }

    /**
     * Logs in as the admin user.
     * 
     * @param w 
     */
    public void loginAsAdmin() {
        loginWithCredentials(Data.adminUser, Data.adminUser);
    }
    
    /**
     * Fills the new user form.
     * 
     * Assumes driver is navigated at the new user page.
     */
}
