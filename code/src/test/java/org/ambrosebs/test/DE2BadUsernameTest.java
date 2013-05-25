/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test;

import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author ambrose
 */
public class DE2BadUsernameTest extends TestParent {
    
    @Test
    public void login() {
        user.loginAsAdmin();
    }
    
    /**
     * Ensure correct error message is displayed.
     */
    @Test
    public void addUserWithBadUsername() {
        nav.navigateTreeMenuToAddNewUserPage();
        
        addNewUser.enterUserName(AddUserData.badUser2Username);
        addNewUser.enterPw(AddUserData.badUser2Pw);
        addNewUser.enterFirstname(AddUserData.badUser2Firstname);
        addNewUser.enterSurname(AddUserData.badUser2Surname);
        addNewUser.enterEmail(AddUserData.badUser2Email);
        addNewUser.enterCity(AddUserData.badUser2City);
        addNewUser.enterCountry(AddUserData.badUser2Country);
        addNewUser.clickSubmitButton();
        
        final WebElement error = driver.findElement(By.className("error"));
        
        assert(AddUserData.badUsernameError.equals(error.getText()));
    }
    
}
