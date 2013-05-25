/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ambrose
 */
public class AddNewUser {
    
    final WebDriver driver;
    
    public AddNewUser(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * Enter the username string in the username box.
     * @param username 
     */
    public void enterUserName(String username) {
        final WebElement usernameBox
                = driver.findElement(By.id("id_username"));
        usernameBox.sendKeys(username);
    }
    
    /**
     * Enter the password string in the pw box.
     * 
     * @param pw 
     */
    public void enterPw(String pw) {
        final WebElement pwBox
                = driver.findElement(By.cssSelector("#id_newpassword"));
        pwBox.sendKeys(pw);
    }
    
}
