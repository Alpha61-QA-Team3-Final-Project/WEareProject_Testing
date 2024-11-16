package wearetests.web;

import org.junit.jupiter.api.Test;
import testframework.DriverManager;
import weare.pages.LatestPostsPage;
import wearetests.core.AssertionUtils;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

import static weare.pages.LatestPostsPage.exploreLastPostButton;

public class PostsTests extends WEareBaseWebTest {

    @Test
    public void createNewPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickOnPostLikeButton();
        latestPostsPage.clickNewPublicPostButton();
        latestPostsPage.createNewPublicPost();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath", exploreLastPostButton);
    }

    @Test
    public void updatePublicPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickNewPublicPostButton();
        latestPostsPage.createNewPublicPost();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.clickEditPostButton();
        latestPostsPage.updatePublicPost();

        //Assert
        AssertionUtils.isTextVisible(DriverManager.getDriver(), LatestPostsPage.getUpdatedPost());

    }

    @Test
    public void userLikesPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickOnPostLikeButton();

        String likeButtonValue = latestPostsPage.getLikeButtonValue();

        //Assert
        AssertionUtils.assertEquals("The text of the like button should be 'Dislike'", likeButtonValue,
                "Dislike");
    }

    @Test
    public void userDislikesPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickOnPostLikeButton();
        latestPostsPage.clickOnPostLikeButton();
        String dislikeButtonValue = latestPostsPage.getLikeButtonValue();

        //Assert
        AssertionUtils.assertEquals("The text of the like button should be 'Like'", dislikeButtonValue,
                "Like");
    }

    @Test
    public void deletePostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickNewPublicPostButton();
        latestPostsPage.createNewPublicPost();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.deletePost();


        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",latestPostsPage.
                getDeletePostSuccessMessage());

    }
}
