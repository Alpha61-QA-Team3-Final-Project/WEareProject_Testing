package wearetests.core;

import org.apache.commons.lang3.RandomStringUtils;
import wearetests.core.Constants.*;

import java.util.Random;

public class RandomDataGenerator {

    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }
    public static String generateEmail() {
        String randomUsername = getRandomString(5);
        return randomUsername + "@test.com";
    }

    public static void main(String[] args) {
//        System.out.println("Generated Register Username: " + REGISTER_USERNAME.getValue());
//        System.out.println("Generated Register Email: " + REGISTER_EMAIL.getValue());
//
//        System.out.println("Login Username: " + USER_USERNAME.getValue());
//        System.out.println("Login Email: " + USER_EMAIL.getValue());
    }

}
