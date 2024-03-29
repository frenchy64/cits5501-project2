package org.ambrosebs.test.addUserPage;

import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;

import clojure.lang.RT;

import org.ambrosebs.test.TestParent;

/**
 * Make a user with an invalid password that:
 *  - does not contain at least 1 digit
 *  - DOES contain a non-alphanumeric character
 *  - DOES contain an upper case letter
 *  - IS at least 8 characters long
 * 
 * @author ambrose
 */
public class DENUF3dBadPasswordTest extends TestParent {
    
    /**
     * The set of error messages we expect here.
     */
    final Object validErrors =
            RT.set(AddUserData.badPwError1Digit);
    
    /**
     * We don't want to see these errrors.
     */
    final Object invalidErrors =
            RT.set(AddUserData.badPwError8long,
                    AddUserData.badPwError1Upper,
                    AddUserData.badPwError1NonAlpha);

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
        addNewUser.enterPw("longenoughforeight##CAPITAL");
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
