package org.ambrosebs.test.editUserPage;

import org.ambrosebs.test.TestParent;
import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;

/**
 *
 * @author ambrose
 */
public class DEEUS14UserEditFirstName extends TestParent {
    @Test
    public void login() {
        user.loginWithCredentials(AddUserData.user1Username, AddUserData.user1Pw);
    }
    
    @Test
    public void updateFirstNameIsSuccessful() {
        nav.navigateTreeMenuToEditProfile();
        addNewUser.enterFirstname(AddUserData.user1AlternativeFirstname);
        addNewUser.clickSubmitButton();
        
        String expectedFullname
                = AddUserData.user1AlternativeFirstname + " " +
                  AddUserData.user1Surname;

        assertsUser.assertFullnameIsInProfileTitle(expectedFullname);
    }
}
