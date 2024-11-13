package com.weare;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;
import java.util.Random;


public class RandomDataGenerator {
    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }

    public static String getRandomEmail() {
        String randomUsername = getRandomString(5);
        return randomUsername + "@test.com";
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static String getUserPassword() {
        return "test123";
    }

    public static String getAdminPassword() {
        return "admin123";
    }

    public static void generateRandomConstants(String usernamePattern, String passwordPattern,
                                               String uniqueNamePattern, String skillDescriptionPattern,
                                               String emailPattern) {
        Faker faker = new Faker(new Locale("en-GB"));
        Constants.USERNAME = faker.bothify(usernamePattern);
        Constants.USER_PASSWORD = faker.bothify(passwordPattern);
        Constants.UNIQUE_NAME = faker.bothify(uniqueNamePattern);
        Constants.SKILL_DESCRIPTION = faker.bothify(skillDescriptionPattern);
        Constants.SKILL_DESCRIPTION_EDITED = Constants.SKILL_DESCRIPTION + Constants.UNIQUE_NAME;
        Constants.RANDOM_EMAIL = faker.bothify(emailPattern);
    }

    public static boolean isValid(String json) {
        try {
            new JSONObject(json);  // Check if JSON is valid
        } catch (JSONException e) {
            return false;  // Return false if there is an exception
        }
        return true;
    }

}
