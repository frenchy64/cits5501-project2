/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test.addUserPage;

import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;

import clojure.lang.RT;

import org.ambrosebs.test.TestParent;

/**
 * Make a user with an invalid password that:
 *  - does not contain at least 1 digit
 *  - does not contain a non-alphanumeric character
 *  - does not contain an upper case letter
 *  - IS at least 8 characters long
 * 
 * @author ambrose
 */
public class DENUF3bBadPasswordTest extends TestParent {
    
    /**
     * The set of error messages we expect here.
     */
    final Object validErrors =
            RT.set(AddUserData.badPwError1Digit,
                    AddUserData.badPwError1NonAlpha,
                    AddUserData.badPwError1Upper);
    
    /**
     * We don't want to see these errrors.
     */
    final Object invalidErrors =
            RT.set(AddUserData.badPwError8long);

    @Test
    public void login() {
        user.loginAsAdmin();
    }
    
    /**
     * Add a new user and verify it shows in the user page.
     */
    @Test
    public void addUserWithBadPassword() {
        nav.navigateTreeMenuToAddNewUserPage();
        
        addNewUser.enterUserName(AddUserData.badUser3Username);
        addNewUser.enterPw("longenoughforeight");
        addNewUser.enterFirstname(AddUserData.badUser3Firstname);
        addNewUser.enterSurname(AddUserData.badUser3Surname);
        addNewUser.enterEmail(AddUserData.badUser3Email);
        addNewUser.enterCity(AddUserData.badUser3City);
        addNewUser.enterCountry(AddUserData.badUser3Country);
        addNewUser.clickSubmitButton();
        
        assertsUser.assertAllErrorsAppear(validErrors);
        assertsUser.assertNoErrorsAppear(invalidErrors);
    }
    
}
