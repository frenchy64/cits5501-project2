/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test;

import clojure.lang.IPersistentSet;
import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;

import clojure.lang.RT;

import org.ambrosebs.test.util.AssertionsNewUser;

/**
 *
 * @author ambrose
 */
public class DE3BadPasswordTest extends TestParent {
    
    /**
     * The set of error messages we expect here.
     */
    final Object validErrors =
            RT.set(AddUserData.badPwError1Digit,
                    AddUserData.badPwError1NonAlpha,
                    AddUserData.badPwError1Upper,
                    AddUserData.badPwError8long);

    @Test
    public void login() {
        user.loginAsAdmin();
    }
    
    /**
     * Add a new user and verify it shows in the user page.
     */
    @Test
    public void addUserBadPassword() {
        nav.navigateTreeMenuToAddNewUserPage();
        
        addNewUser.enterUserName(AddUserData.badUser3Username);
        addNewUser.enterPw(AddUserData.badUser3Pw);
        addNewUser.enterFirstname(AddUserData.badUser3Firstname);
        addNewUser.enterSurname(AddUserData.badUser3Surname);
        addNewUser.enterEmail(AddUserData.badUser3Email);
        addNewUser.enterCity(AddUserData.badUser3City);
        addNewUser.enterCountry(AddUserData.badUser3Country);
        addNewUser.clickSubmitButton();
        
        assertsUser.assertAllErrorsAppear(validErrors);

    }
    
}
