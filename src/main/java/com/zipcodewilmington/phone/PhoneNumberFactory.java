package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODOne - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) throws InvalidPhoneNumberFormatException {
        PhoneNumber[] res = new PhoneNumber[phoneNumberCount];
        for (int i = 0; i < phoneNumberCount; i++) {
            /// for each i make a new phone number
            // put it in the array
            /// return the array
            res[i] = createRandomPhoneNumber();
        }

        return res;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODOne - Implement logic
    public static PhoneNumber createRandomPhoneNumber() throws InvalidPhoneNumberFormatException {
        return createPhoneNumberSafely(RandomNumberFactory.createInteger(100, 999), RandomNumberFactory.createInteger(100, 999), RandomNumberFactory.createInteger(1000, 9999));
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODOne - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) throws InvalidPhoneNumberFormatException {
        String stringPhone = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
        try {
            return createPhoneNumber(stringPhone);
        } catch (InvalidPhoneNumberFormatException badPhone) {
            logger.info(String.format(" [%s] - is not a valid phone number", badPhone));
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODOne - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.info(String.format("Creating phone number with value [%s]", phoneNumberString));
        return new PhoneNumber(phoneNumberString);
    }
}
