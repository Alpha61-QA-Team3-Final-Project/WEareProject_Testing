package wearetests.web;

import org.junit.jupiter.api.Test;
import testframework.DriverManager;
import weare.pages.SearchPage;
import weare.pages.UserHomePage;
import wearetests.core.AssertionUtils;
import wearetests.core.RandomDataGenerator;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class ConnectionTests extends WEareBaseWebTest {


    @Test
    public void userConnectsOtherUserTest() {
        homePage.navigate();
        homePage.clickRegister();
        String username = TestData.REGISTER_USERNAME.getValue();
        String password = TestData.REGISTER_PASSWORD.getValue();
        registerPage.registerUser(username, TestData.EMAIL.getValue(),
                password, password);

        homePage.clickSigIn();
        signInPage.signIn(username, password);
        searchPage.clickSearchButton();
        userHomePage.clickLatestPosts();
        latestPostsPage.clickSeeProfileButton();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", SearchPage.getConnectLink());
    }

    @Test
    public void userConnectRequestTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        searchPage.clickSearchButton();
        userHomePage.clickLatestPosts();
        latestPostsPage.clickSeeProfileButton();
        searchPage.clickConnectLink();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                SearchPage.getSentFriendRequest());
    }

    @Test
    public void userConnectAcceptTest() {
        //User1
        homePage.navigate();
        homePage.clickRegister();
        String username = RandomDataGenerator.getRandomString(6);
        String password = TestData.REGISTER_PASSWORD.getValue();

        registerPage.registerUser(username, TestData.EMAIL.getValue(), password, password);
        homePage.clickSigIn();
        signInPage.signIn(username, password);
        userHomePage.clickLogout();

        //User2
        homePage.navigate();
        homePage.clickRegister();
        String username2 = RandomDataGenerator.getRandomString(6);

        registerPage.registerUser(username2, TestData.EMAIL.getValue(), password, password);
        homePage.clickSigIn();
        signInPage.signIn(username2, password);
        searchPage.clickSearchButton();
        searchPage.clickSecondProfileLink();
        searchPage.clickConnectLink();
        userHomePage.clickLogout();

        //User 1 again
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(username, password);
        userHomePage.clickPersonalProfile();
        userHomePage.clickNewFriendRequests();
        userHomePage.clickApproveRequests();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                UserHomePage.getApproveRequestsLink());
    }

    @Test
    public void userDisconnectsTest() {
        //User 1
        homePage.navigate();
        homePage.clickRegister();
        String username = RandomDataGenerator.getRandomString(6);

        String password = TestData.REGISTER_PASSWORD.getValue();
        registerPage.registerUser(username, TestData.EMAIL.getValue(), password, password);
        homePage.clickSigIn();
        signInPage.signIn(username, password);
        userHomePage.clickLogout();

        //User 2
        homePage.navigate();
        homePage.clickRegister();

        String username2 = RandomDataGenerator.getRandomString(6);

        registerPage.registerUser(username2, TestData.EMAIL.getValue(), password, password);
        homePage.clickSigIn();
        signInPage.signIn(username2, password);
        searchPage.clickSearchButton();
        searchPage.clickSecondProfileLink();
        searchPage.clickConnectLink();
        userHomePage.clickLogout();

        //User 1 again
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(username, password);
        userHomePage.clickPersonalProfile();
        userHomePage.clickNewFriendRequests();
        userHomePage.clickApproveRequests();

        homePage.navigate();
        searchPage.clickSearchButton();
        searchPage.clickUserProfile();
        searchPage.clickDisconnect();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                SearchPage.getConnectLink());
    }
}
