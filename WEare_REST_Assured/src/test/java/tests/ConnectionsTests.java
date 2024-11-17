package tests;

import base.BaseTestSetup;
import com.weare.Constants;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static com.weare.Constants.*;
import static com.weare.JSONRequests.*;


public class ConnectionsTests extends BaseTestSetup {

    @Test
    public void sendConnectionTest() {
        createAndRegisterUserReceiver();
        createAndRegisterUser();
        loginUser();

        Response response = sendRequest();


        //Assert
        Assert.assertNotNull(USER_ID_RECEIVER, "USER_ID_RECEIVER should not be null");
        Assert.assertNotNull(USERNAME_RECEIVER, "USERNAME_RECEIVER should not be null");
        Assert.assertNotNull(CONNECTION_ID, "CONNECTION_ID should not be null");

        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(response.getBody().asString(), RANDOM_USERNAME + " send friend request to "
                + USERNAME_RECEIVER, "Expected message");
    }

    @Test
    public void acceptConnectionTest() {
        createAndRegisterUserReceiver();
        createAndRegisterUser();
        loginUser();
        sendRequest();
        loginUserReceiver();
        showReceivedRequests();

        Response response = approveRequest();

        Assert.assertNotNull(COOKIE_VALUE_RECEIVER, "COOKIE_VALUE_RECEIVER should be present");
        Assert.assertNotNull(USER_ID_RECEIVER, "USER_ID_RECEIVER should not be null");
        Assert.assertTrue(EMAIL_RECEIVER.contains("@test.com"), "EMAIL_RECEIVER should contain '@test.com'");
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(response.getBody().asString(), USERNAME_RECEIVER + " approved request of "
                + RANDOM_USERNAME, "Expected message");
    }
}
