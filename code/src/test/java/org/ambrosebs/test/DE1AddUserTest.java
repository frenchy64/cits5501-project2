/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test;

import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;

/**
 *
 * @author ambrose
 */
public class DE1AddUserTest extends TestParent {
    
    
    @Test
    public void login() {
        user.loginAsAdmin();
    }
    
    /**
     * Add a new user and verify it shows in the user page.
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
        
        
    }

}
