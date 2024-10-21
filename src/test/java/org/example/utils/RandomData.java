package org.example.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String randomString(){
        return "test_" + RandomStringUtils.randomAlphabetic(11);
    }
    public static String randomZipCode() {
        return RandomStringUtils.randomNumeric(6);
    }

    public static String randomSSN() {
        return RandomStringUtils.randomNumeric(9);
    }

    public static String randomPhoneNumber() {
        return RandomStringUtils.randomNumeric(11);
    }

    public static String randomUsername() {
        return "user_" + RandomStringUtils.randomAlphanumeric(8);
    }

    public static String randomPassword() {
        return "user_" + RandomStringUtils.randomAlphanumeric(10);
    }
}
