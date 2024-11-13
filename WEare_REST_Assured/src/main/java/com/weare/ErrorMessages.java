package com.weare;

import static com.weare.Constants.*;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_MOVED_TEMPORARILY;
import static org.apache.http.HttpStatus.SC_OK;

    public class ErrorMessages {
        public static final String ERROR_MESSAGE_INCORRECT_STATUS = format("Incorrect status code. Expected %s.", SC_OK);
        public static final String ERROR_MESSAGE_INCORRECT_STATUS_LOGIN = format("Incorrect status code. Expected %s.", SC_MOVED_TEMPORARILY);
        public static final String ERROR_MESSAGE_RESPONSE_BODY = "Response body does not match the expected. Expected %s";
        public static final String ERROR_MESSAGE_USER_ID = "User Id does not match the expected ID";
        public static final String ERROR_MESSAGE_USERNAME = "Username does not match the expected username";
        public static final String ERROR_MESSAGE_LIKED_POST = "Expected status should be true for liked post";
        public static final String ERROR_MESSAGE_FOR_DISLIKE_POST = "Expected status should be false for disliked comment";
        public static final String ERROR_MESSAGE_COMMENT_ID = format("Incorrect comment ID. Expected %s", COMMENT_ID);
        public static final String ERROR_MESSAGE_LIKED_SHOULD_BE_FALSE = "Expected status should be false for disliked comment";
        public static final String ERROR_MESSAGE_LIKED_SHOULD_BE_TRUE = "Expected status should be true for liked comment";
        public static final String ERROR_MESSAGE_RESPONSE_CONTENT = format("Response body content does not match the expected. Expected %s", COMMENT_DESCRIPTION);
        public static final String ERROR_MESSAGE_STATUS_CODE = format("Incorrect status code. Expected %s.", SC_OK);
        public static final String ERROR_MESSAGE_RESPONSE_BODY_EMPTY = "Response body should be empty";
        public static final String ERROR_MESSAGE_BODY_NOT_VALID_JSON = "Body is not a valid JSON";
        public static final String ERROR_MESSAGE_POST_DESCRIPTION = format("Response body content does not match the expected. Expected %s", POST_DESCRIPTION);
        public static final String ERROR_MESSAGE_JOB_TITLE = format("Response body content does not match the expected. Expected %s", RANDOM_JOB_TITLE);
        public static final String ERROR_MESSAGE_RESPONSE_BODY_POST_ID = format("Response body content does not match the expected. Expected %s", POST_ID);
}


/*package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.weare.Constants.*;
import static com.weare.Endpoints.*;
import static com.weare.ErrorMessages.ERROR_MESSAGE_INCORRECT_STATUS;
import static com.weare.ErrorMessages.ERROR_MESSAGE_INCORRECT_STATUS_LOGIN;
import static com.weare.JSONRequests.REGISTRATION_BODY;
import static com.weare.ShowMessages.ERROR_MESSAGE_COOKIE_VALUE_IS_NOT_PRESENT;
import static com.weare.ShowMessages.SHOW_MESSAGE_LOGIN_USED_USERNAME_PASSWORD_COOKIE;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_MOVED_TEMPORARILY;
import static org.testng.Assert.assertEquals;

public class UserTest extends BaseTestSetup {

    Logger logger = Logger.getLogger("");
    Response response;

    @BeforeSuite
    public void setup() {
        super.setup();
    }

    @Test
    public void testUserRegistration() {
        // Използваме методите за генериране на случайни стойности
        String registrationBody = String.format(REGISTRATION_BODY, USER_PASSWORD, RANDOM_EMAIL, USER_PASSWORD, USERNAME);

        // Изпращаме POST заявка за регистрация
        response = given()
                .baseUri(BASE_URL + REGISTER_ENDPOINT)
                .contentType("application/json")
                .body(registrationBody)
                .post();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Проверка дали отговорът съдържа полето "id"
        String responseUsername = responseBody.split(" ")[3]; // Извличане на потребителското име от отговора
        String responseId = responseBody.split(" ")[6]; // Извличане на userId (или id)

        System.out.println("Generated Username: " + responseUsername);
        System.out.println("Generated User ID: " + responseId);

        // Валидация
        assertEquals(response.getStatusCode(), SC_OK, ERROR_MESSAGE_INCORRECT_STATUS);
    }

    @Test
    public void loginAndFetchCookiesTest() {
        loginUser();
//        Response responseBody = loginUser();

        int statusCode = response.statusCode();

        assertEquals(statusCode, SC_MOVED_TEMPORARILY, ERROR_MESSAGE_INCORRECT_STATUS_LOGIN);
        Assert.assertFalse(COOKIE_VALUE.isEmpty(), ERROR_MESSAGE_COOKIE_VALUE_IS_NOT_PRESENT);

        System.out.println("Logged in with COOKIE: " + COOKIE_VALUE);

//        logger.info(SHOW_MESSAGE_LOGIN_USED_USERNAME_PASSWORD_COOKIE);

    }

//    @Test
//    public void updateUserProfileTest() {
//        // Логваме се и обновяваме профила
//        createAndRegisterUser();
//        loginUser();
//
//        // Актуализиране на потребителския профил
//        response = updateUserProfile(SEARCHABLE_NAME);
//
//        int statusCode = response.getStatusCode();
//        assertEquals(statusCode, SC_OK, ERROR_MESSAGE_INCORRECT_STATUS);
//    }

//@Test
//public void upgradeExpertiseProfileTest() {
//
//        createAndRegisterUser();
//        loginUser();
//
//        response = upgradeExpertiseProfile();
//
//        JsonObject jsonObject = (JsonObject) JsonParser.parseString(response.asString());
//        String skill1Content = String.valueOf(jsonObject.getAsJsonArray("skills").get(0).getAsJsonObject().get("skill"));
//        skill1Content = skill1Content.replaceAll("[\"<>,]", "");
//
//        int statusCode = response.getStatusCode();
//        assertEquals(statusCode, SC_OK, ERROR_MESSAGE_INCORRECT_STATUS);
//        assertEquals(skill1Content, RANDOM_JOB_TITLE, ERROR_MESSAGE_JOB_TITLE);
//
//    }
//
//    @Test
//    public void updateUserProfileTest() {
//
//        createAndRegisterUser();
//        loginUser();
//
//        response = updateUserProfile(SEARCHABLE_NAME);
//
//        int statusCode = response.getStatusCode();
//        assertEquals(statusCode, SC_OK, ERROR_MESSAGE_INCORRECT_STATUS);
//
//    }

} */