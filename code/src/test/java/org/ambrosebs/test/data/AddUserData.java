/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test.data;

/**
 *
 * @author ambrose
 */
public class AddUserData {
    public static final String user1Username = "bob";
    public static final String user1Pw = "Moodle123$";
    public static final String user1Firstname = "Bob";
    public static final String user1Surname = "Martin";
    public static final String user1Email = "bobo@martin.org";
    public static final String user1City = "Perth";
    public static final String user1Country = "Australia";

    public static final String badUser2Username = "Foobar";
    public static final String badUser2Pw = "Moodle123$";
    public static final String badUser2Firstname = "Second";
    public static final String badUser2Surname = "Dude";
    public static final String badUser2Email = "dude@martin.org";
    public static final String badUser2City = "Perth";
    public static final String badUser2Country = "Australia";

    public static final String badUser3Username = "goodname";
    public static final String badUser3Pw = "badpw";
    public static final String badUser3Firstname = "Third";
    public static final String badUser3Surname = "Dude";
    public static final String badUser3Email = "dude@martin.org";
    public static final String badUser3City = "Perth";
    public static final String badUser3Country = "Australia";
    
    
    /** 
     * Errors
     */
    public static final String badUsernameError = "Only lowercase letters allowed";
    
    public static final String badPwError8long = 
      "Passwords must be at least 8 characters long.";
    public static final String badPwError1Digit = 
      "Passwords must have at least 1 digit(s).";
    public static final String badPwError1Upper = 
      "Passwords must have at least 1 upper case letter(s).";
    public static final String badPwError1NonAlpha = 
      "Passwords must have at least 1 non-alphanumeric character(s).";
    
}
