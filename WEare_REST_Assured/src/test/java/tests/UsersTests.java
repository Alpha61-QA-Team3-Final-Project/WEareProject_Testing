package tests;

import base.BaseTestSetup;
import com.weare.Endpoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static com.weare.Constants.*;


class UsersTests extends BaseTestSetup {

    Response response;

    @Test
    public void loginAndGetCookieTest() {
        ValidatableResponse responseBody = loginUser();
        int statusCode = responseBody.extract().statusCode();
        Assert.assertEquals(302, statusCode, "Expected status code to be 302");

    }

    @Test
    public void registerUserTest() {

        response = createAndRegisterUser();

        String responseReturnMessage = response.asPrettyString();
        String responseUsername = response.getBody().asString().split(" ")[3];
        String responseID = response.getBody().asString().split(" ")[6];

        System.out.println("Extracted Message: " + responseReturnMessage); // Отпечатване на съобщението
        System.out.println("Request URL: " + Endpoints.REGISTER_ENDPOINT);
        System.out.println("Extracted ID: " + responseID);
        System.out.println("Extracted Username: " + responseUsername);

        //Assert
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertNotNull(responseID, "Response should contain 'id'");
        Assert.assertEquals(responseUsername, RANDOM_USERNAME, "The username should match the expected value.");
    }

    @Test
    public void updateUserProfileTest() {
        createAndRegisterUser();
        loginUser();

        response = updateUserProfile(RANDOM_USERNAME);

        String responseBody = response.getBody().prettyPrint();
        System.out.println("Response body: " + responseBody);

        //Assert
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");

    }

}
