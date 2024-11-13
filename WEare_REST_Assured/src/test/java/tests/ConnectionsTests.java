package tests;

import base.BaseTestSetup;
import org.junit.jupiter.api.Test;


public class ConnectionsTests extends BaseTestSetup {
    @Test
    public void sendConnectionTest() {
        // Rазгледайте методите и константите към тях
        createAndRegisterUser();
        createAndRegisterUser();
        loginUser();

        //TO DO
    }

    @Test
    public void acceptConnectionTest() {
        // Rазгледайте методите и константите към тях
        createAndRegisterUserReceiver();
        createAndRegisterUser();
        loginUser();
        sendRequest();
        loginUserReceiver();
        showReceivedRequests();

        //TO DO
    }
}
