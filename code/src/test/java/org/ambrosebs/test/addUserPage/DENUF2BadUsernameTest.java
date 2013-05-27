package org.ambrosebs.test.addUserPage;

import clojure.lang.RT;
import org.ambrosebs.test.TestParent;
import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;

/**
 * Cannot give a bad username when creating user.
 * @author ambrose
 */
public class DENUF2BadUsernameTest extends TestParent {
    
    /**
     * These errors are required
     */
    final Object validErrors =
        RT.set(AddUserData.badUsernameError);
    
    /**
     * These errors cannot occur.
     */
    final Object forbiddenErrors =
            RT.set(AddUserData.missingFieldError);
    
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
        
        assertsUser.assertAllErrorsAppear(validErrors);
        assertsUser.assertNoErrorsAppear(forbiddenErrors);
    }
    
}
