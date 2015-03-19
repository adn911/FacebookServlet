package org.facebook.util;

/**
 * Created by bakhtiar.galib on 3/16/15.
 */
public class FormInputValidator {

    private static final String emailPattern = "^[a-zA-z0-9._%]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}$";

    public static boolean fieldsNotEmpty(String ... params) {
       for(String param:params){
           if(param.isEmpty())return false;
       }
       return true;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches(emailPattern);
    }
}
