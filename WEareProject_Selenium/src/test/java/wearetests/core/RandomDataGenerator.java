package wearetests.core;

import org.apache.commons.lang3.RandomStringUtils;
import wearetests.enums.TestData;

import java.util.Random;

public class RandomDataGenerator {
    public static String generateRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            result.append(alphabet.charAt(index));
        }

        return result.toString();
    }


    public static String generateUsername() {
        return generateRandomString(8);
    }

    public static String generateEmail() {
        return generateRandomString(5) + "@test.com";
    }

    public static void main(String[] args) {
        System.out.println("Generated Register Username: " + TestData.REGISTER_USERNAME.getValue());
        System.out.println("Generated Register Email: " + TestData.REGISTER_EMAIL.getValue());

        System.out.println("Login Username: " + TestData.USER_USERNAME.getValue());
        System.out.println("Login Email: " + TestData.USER_EMAIL.getValue());
    }

}
