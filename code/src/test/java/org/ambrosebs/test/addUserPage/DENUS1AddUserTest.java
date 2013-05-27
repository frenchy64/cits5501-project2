/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test.addUserPage;

import junit.framework.Assert;
import org.ambrosebs.test.TestParent;
import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 *
 * @author ambrose
 */
public class DENUS1AddUserTest extends TestParent {
    
    
    @Test
    public void login() {
        user.loginAsAdmin();
    }
    
    /**
     * Add a new user and verify no errors are shown.
     */
    @Test
    public void addUser() {
        nav.navigateTreeMenuToAddNewUserPage();
        
        addNewUser.enterUserName(AddUserData.user1Username);
        addNewUser.enterPw(AddUserData.user1Pw);
        addNewUser.enterFirstname(AddUserData.user1Firstname);
        addNewUser.enterSurname(AddUserData.user1Surname);
        addNewUser.enterEmail(AddUserData.user1Email);
        addNewUser.enterCity(AddUserData.user1City);
        addNewUser.enterCountry(AddUserData.user1Country);
        addNewUser.clickSubmitButton();

        Assert.assertTrue(driver.findElements(By.className("errors")).isEmpty());
    }

}
