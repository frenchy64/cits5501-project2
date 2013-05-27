package org.ambrosebs.test.editUserPage;

import clojure.lang.RT;
import org.ambrosebs.test.TestParent;
import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;

/**
 * Change a user's password to a new, invalid password. The 2 given pws match.
 * 
 * @author ambrose
 */
public class DEEUF2EditBadPasswordTest extends TestParent {
    
    final Object validErrors =
        RT.set(AddUserData.changePwNoMatchMsg);
    
    @Test 
    public void login() {
        user.loginWithCredentials(AddUserData.user1Username, AddUserData.user1Pw);
    }
    
    /**
     * Navigate to Edit User page and enter a bad username.
     */
    @Test
    public void enterBadPassword() {
        
        nav.navigateTreeToChangePassword();
        addNewUser.editPasswordAddOriginalPassword(AddUserData.user1Pw);
        addNewUser.editPasswordAddNewPasswordFirstTime("invalid");
        addNewUser.editPasswordAddNewPasswordSecondTime("invalidbutdifferent");
        addNewUser.clickSubmitButton();
        
        assertsUser.assertAllErrorsAppear(validErrors);
    }
}
