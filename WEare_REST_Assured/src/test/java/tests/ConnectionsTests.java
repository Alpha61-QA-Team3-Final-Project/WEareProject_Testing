package tests;

import base.BaseTestSetup;
import com.weare.Constants;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class ConnectionsTests extends BaseTestSetup {

    @Test
    public void sendConnectionTest() {
        createAndRegisterUserReceiver();
        createAndRegisterUser();
        loginUser();

        Response response = sendRequest();

        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(response.getBody().asString(), Constants.RANDOM_USERNAME + " send friend request to "
                + Constants.USERNAME_RECEIVER, "Expected message");
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

        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(response.getBody().asString(), Constants.USERNAME_RECEIVER + " approved request of "
                + Constants.RANDOM_USERNAME, "Expected message");
    }
}
