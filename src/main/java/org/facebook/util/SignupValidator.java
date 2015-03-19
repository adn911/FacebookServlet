package org.facebook.util;

import org.facebook.models.User;

/**
 * Created by bakhtiar.galib on 3/16/15.
 */
public class SignupValidator {

    public static User validate(String username, String firstName, String lastName,
                                           String email, String password, String DOB,String profilePicture) {
        User user = null;

        if (FormInputValidator.fieldsNotEmpty(username, firstName, lastName, email, password, DOB) && FormInputValidator.isValidEmail(email) ) {
            user = new User();
            user.setUsername(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setDOB(DOB);
            user.setProfilePicture(profilePicture);
        }
        return user;
    }
}
