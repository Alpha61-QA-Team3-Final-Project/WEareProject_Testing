package wearetests.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testframework.Driver;
import testframework.DriverManager;
import weare.pages.*;
import wearetests.core.AssertionUtils;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import static weare.pages.LatestPostsPage.*;
import static wearetests.enums.TestData.*;


public class WEareTests extends WEareBaseWebTest {

    @Test
    //Faker to be implemented
    public void userRegisterTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        //assertion works
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", RegisterPage.getCovidMessage());
        Thread.sleep(5000);
    }

    @Test
    public void userLoginTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(USER_USERNAME.getValue(), USER_PASSWORD.getValue());
        //assertion works
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", HomePage.getLogoutHomePageLocator());
        Thread.sleep(5000);
    }

    @Test
    public void userLogoutTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        userHomePage.clickLogout();
        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", UserHomePage.getYouAreLoggedOutMessage());
        Thread.sleep(5000);
    }

    @Test
    public void updateUserProfileTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        userHomePage.clickPersonalProfile();
        userProfilePage.clickEditProfile();
        userProfilePage.editProfile(TestData.UPDATE_FIRSTNAME.getValue(), TestData.UPDATE_LASTNAME.getValue(),
                TestData.UPDATE_BIRTHDAY.getValue(), TestData.UPDATE_EMAIL.getValue(), TestData.UPDATE_ABOUT_ME.getValue());
        //Assert
        Thread.sleep(5000);
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Profile updated successfully.");

    }

    @Test
    public void userLikesPostTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickLikeButton();
        String likeButtonValue = latestPostsPage.getLikeButtonValue();

        if ("Like".equals(likeButtonValue)) {
            AssertionUtils.assertEquals("The value of the like button should be 'Like'", likeButtonValue, "Like");
        } else {
            throw new AssertionError("Unexpected value for the button: " + likeButtonValue);
        }

//        Thread.sleep(5000);
    }

    @Test
    public void userDislikesPostTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        String likeButtonValue = latestPostsPage.getLikeButtonValue();

        if ("Dislike".equals(likeButtonValue)) {
            AssertionUtils.assertEquals("The value of the like button should be 'Dislike'", likeButtonValue, "Dislike");
        } else {
            throw new AssertionError("Unexpected value for the button: " + likeButtonValue);
        }

//        Thread.sleep(5000);
    }

    @Test
    public void userCommentsPostTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.writeComment();

        latestPostsPage.clickShowCommentsButton();
//        String uniqueCommentText = "This is a new comment " + commentCounter;
//        String actualCommentText = latestPostsPage.getComment();
        Thread.sleep(5000);
//        AssertionUtils.assertEquals("The comment text should match", comment, actualCommentText);
        AssertionUtils.isTextVisible(DriverManager.getDriver(), LatestPostsPage.getComment());
        Thread.sleep(5000);

    }

    @Test
    public void userConnectsOtherUserTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        searchPage.clickSearchButton();
        searchPage.clickUserProfile();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", SearchPage.getConnectLink());
//        Thread.sleep(5000);
    }

    @Test
    public void userConnectRequestTest() throws InterruptedException {
        homePage.navigate();
//        homePage.clickRegister();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        searchPage.clickSearchButton();
        searchPage.clickUserProfile();
        searchPage.clickConnectLink();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", SearchPage.getSentFriendRequest());
//        Thread.sleep(5000);
    }

    @Test
    //Pending connection request required
    public void userConnectAcceptTest() throws InterruptedException {
        homePage.navigate();
//        homePage.clickRegister();
//        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_EMAIL.getValue(),
//                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_ACCEPT_CONNECTION_USER.getValue(), TestData.USER_ACCEPT_CONNECTION_PASSWORD.getValue());
        userHomePage.clickPersonalProfile();
        userHomePage.clickNewFriendRequests();
        userHomePage.clickApproveRequests();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(),"xpath", UserHomePage.getApproveRequestsLink());
//        Thread.sleep(5000);
    }

    @Test
    public void userDisconnectsTest() throws InterruptedException {
        homePage.navigate();
        homePage.clickSigIn();
        signInPage.signIn(TestData.USER_USERNAME.getValue(), TestData.USER_PASSWORD.getValue());
        searchPage.clickSearchButton();
        Thread.sleep(5000);
        searchPage.clickUserProfile();
        searchPage.clickDisconnect();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(),"xpath", SearchPage.getConnectLink());
//        Thread.sleep(5000);
    }
}
