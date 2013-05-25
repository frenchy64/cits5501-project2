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
public class AddUserTest extends TestParent {
    
    
    
    public AddUserTest() {
    }
    

    
    @Test
    public void addUserAndVerify() {
        user.loginAsAdmin();
        nav.navigateTreeMenuToAddNewUserPage();
        addNewUser.enterUserName(AddUserData.user1Username);
        addNewUser.enterPw(AddUserData.user1Pw);
    }

}
