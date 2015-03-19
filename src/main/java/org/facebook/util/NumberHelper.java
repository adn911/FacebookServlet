package org.facebook.util;

/**
 * Created by bakhtiar.galib on 3/12/15.
 */
public class NumberHelper {

    public static int parseInteger(String numberString) {
        int number = 0;
        try {
            number = Integer.parseInt(numberString);
        } catch (NumberFormatException ex) {

        }
        return number;
    }
}
