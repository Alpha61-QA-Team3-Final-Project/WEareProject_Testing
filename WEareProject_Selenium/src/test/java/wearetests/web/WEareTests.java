package wearetests.web;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;
import testframework.DriverManager;
import testframework.enums.AssertionUtils;
import weare.pages.HomePage;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;


public class WEareTests extends WEareBaseWebTest {

    @Test
    //Faker to be implemented
    public void userRegister() throws InterruptedException {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(),TestData.REGISTER_EMAIL.getValue(),
        TestData.REGISTER_PASSWORD.getValue(),TestData.REGISTER_PASSWORD.getValue());

        Thread.sleep(5000);
    }

    @Test
    public void userLogin() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getHeaderLocator());
        Thread.sleep(5000);
    }

    @Test
    public void userLogout() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        userHomePage.clickLogout();
        Thread.sleep(5000);
    }

    @Test
    public void updateUserProfile() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        userHomePage.clickPersonalProfile();
        userProfilePage.clickEditProfile();
        userProfilePage.editProfile(TestData.UPDATE_FIRSTNAME.getValue(),TestData.UPDATE_LASTNAME.getValue(),
                TestData.UPDATE_BIRTHDAY.getValue(),TestData.UPDATE_EMAIL.getValue(),TestData.UPDATE_ABOUT_ME.getValue());
        Thread.sleep(5000);
        //No info about assertion and how to check successfully updated profile
    }

    @Test
    //same locator for like/dislike
    public void userLikesPost() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickLikeButton();
        Thread.sleep(5000);
    }

    @Test
    //same locator for like/dislike
    public void userDislikesPost() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickLikeButton();
        Thread.sleep(5000);
    }

    @Test
    public void userCommentsPost() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.writeComment("This is a new comment!");
        Thread.sleep(5000);
    }

    @Test
    //to replace single profile link with list
    public void userConnectsOtherUser() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        searchPage.clickSearchButton();
        searchPage.clickUserProfile();
        Thread.sleep(5000);
    }

    @Test
    public void userConnectRequest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        searchPage.clickSearchButton();
        searchPage.clickUserProfile();
        searchPage.clickConnectLink();
        Thread.sleep(5000);
    }

    @Test
    //Pending connection request required
    public void userConnectAccept() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_ACCEPT_CONNECTION_USER.getValue(),TestData.USER_ACCEPT_CONNECTION_PASSWORD.getValue());
        userHomePage.clickPersonalProfile();
        userHomePage.clickNewFriendRequests();
        userHomePage.clickApproveRequests();
        Thread.sleep(5000);
    }

    @Test
    public void userDisconnectsWithoutApproval() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(),TestData.USER_PASSWORD.getValue());
        searchPage.clickSearchButton();
        Thread.sleep(5000);
        searchPage.clickUserProfile();
        searchPage.clickDisconnect();
        Thread.sleep(5000);
    }

}
