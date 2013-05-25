/*
 * CONTAINS CODE ADAPTED FROM 'functional-test-suite'
 */
package org.ambrosebs.test.util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void enterFirstname(String firstname) {
        final WebElement firstnameBox
                = driver.findElement(By.cssSelector("#id_firstname"));
        firstnameBox.sendKeys(firstname);
    }

    public void enterSurname(String surname) {
        final WebElement surnameBox
                = driver.findElement(By.cssSelector("#id_lastname"));
        surnameBox.sendKeys(surname);
    }

    public void enterEmail(String email) {
        final WebElement emailBox
                = driver.findElement(By.cssSelector("#id_email"));
        emailBox.sendKeys(email);
    }

    public void enterCity(String city) {
        final WebElement cityBox
                = driver.findElement(By.cssSelector("#id_city"));
        cityBox.sendKeys(city);
    }
    
    public void enterCountry(String country) {
        final Select countryBox
                = new Select(driver.findElement(By.id("id_country")));
        countryBox.selectByVisibleText(country);
    }
    
    /**
     * Click the submit button on the Add User page.
     */
    public void clickSubmitButton() {
        final WebElement submitButton
                = driver.findElement(By.id("id_submitbutton"));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    }
     
}
