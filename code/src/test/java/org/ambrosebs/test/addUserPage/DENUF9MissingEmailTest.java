package org.ambrosebs.test.addUserPage;

import clojure.lang.RT;
import org.ambrosebs.test.TestParent;
import org.ambrosebs.test.data.AddUserData;
import org.junit.Test;

/**
 * Cannot leave out email when creating user.
 * @author ambrose
 */
public class DENUF9MissingEmailTest extends TestParent {
    
    /**
     * The set of error messages we expect here.
     */
    final Object validErrors =
            RT.set("Required");

    @Test
    public void login() {
        user.loginAsAdmin();
    }
    
    /**
     * Add a new user without city and verify it fails.
     */
    @Test
    public void addUserNoCity() {
        nav.navigateTreeMenuToAddNewUserPage();
        
        addNewUser.enterUserName(AddUserData.badUser3Username);
        addNewUser.enterPw(AddUserData.badUser3Pw);
        addNewUser.enterFirstname(AddUserData.badUser3Firstname);
        addNewUser.enterSurname(AddUserData.badUser3Surname);
        addNewUser.enterEmail(AddUserData.badEmail);
//        addNewUser.enterCity(AddUserData.badUser3City);
        addNewUser.enterCountry(AddUserData.badUser3Country);
        addNewUser.clickSubmitButton();
        
        assertsUser.assertAllErrorsAppear(validErrors);
    }
    
}
