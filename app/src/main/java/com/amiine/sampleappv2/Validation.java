package com.amiine.sampleappv2;

import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by G507041 on 03/01/2017.
 */

public class Validation {

    // Regular expressions used to validate the content of fields

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "\\d{3}-\\d{7}";
    private static final String TEXT_REGEX = "^[A-z]+$";
    private static final String DATE_REGEX ="MM/dd/yyyy";

    // Error messages to be displayed in case of error
    private static final String REQUIRED_MSG = "This field is required";
    private static final String EMAIL_MSG = "Invalid email  XXX@XXX.XXX";
    private static final String TEXT_MSG = "Only alphabets allowed";
    private static final String PHONE_MSG = "Accepted format ###-#######";
    private static final String DATE_MSG_INVALID = "The date you provided is in an invalid date format.";
    private static final String DATE_MSG_FORMAT = "The date format must be "+DATE_REGEX;

    // call this method when you need to check email validation
    public static boolean isTextValid(EditText editText) {
        return isValid(editText, TEXT_REGEX, TEXT_MSG);
    }
    // call this method when you need to check email validation
    public static boolean isEmailValid(EditText editText) {
        return isValid(editText, EMAIL_REGEX, EMAIL_MSG);
    }

    // call this method when you need to check phone number validation
    public static boolean isPhoneValid(EditText editText) {
        return isValid(editText, PHONE_REGEX, PHONE_MSG);
    }

    // call this method when you need to check date validation
    public static boolean isDateValid(EditText editText) {
        return dateValidation(editText, DATE_REGEX);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (!hasText(editText) ) return false;

        // pattern doesn't match so returning false
        if (!Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        };

        return true;
    }
    public static boolean dateValidation(EditText editText, String regex)
    {
        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        if (!hasText(editText) ) return false;

        SimpleDateFormat sdf = new SimpleDateFormat(regex);

        // declare and initialize testDate variable, this is what will hold
        // our converted string

        Date testDate = null;

        // we will now try to parse the string into date form
        try
        {
            testDate = sdf.parse(text);
        }

        // if the format of the string provided doesn't match the format we
        // declared in SimpleDateFormat() we will get an exception

        catch (ParseException e)
        {
            editText.setError(DATE_MSG_INVALID);
            return false;
        }

        // dateformat.parse will accept any date as long as it's in the format
        // you defined, it simply rolls dates over, for example, december 32
        // becomes jan 1 and december 0 becomes november 30
        // This statement will make sure that once the string
        // has been checked for proper formatting that the date is still the
        // date that was entered, if it's not, we assume that the date is invalid

        if (!sdf.format(testDate).equals(text))
        {
            editText.setError(DATE_MSG_FORMAT);
            return false;
        }

        // if we make it to here without getting an error it is assumed that
        // the date was a valid one and that it's in the proper format

        return true;

    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }
}