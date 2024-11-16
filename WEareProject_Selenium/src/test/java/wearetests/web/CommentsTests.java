package wearetests.web;

import org.junit.jupiter.api.Test;
import testframework.DriverManager;
import weare.pages.LatestPostsPage;
import wearetests.core.AssertionUtils;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class CommentsTests extends WEareBaseWebTest {
    @Test
    public void createCommentOnPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.writeComment();
        latestPostsPage.clickShowCommentsButton();

        //Assert
        AssertionUtils.isTextVisible(DriverManager.getDriver(), LatestPostsPage.getComment());
    }

    @Test
    public void likeCommentOnPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.writeComment();
        latestPostsPage.clickShowCommentsButton();
        latestPostsPage.clickOnCommentsLikeButton();

        String likeButtonValue = latestPostsPage.getCommentLikeButtonValue();

        //Assert
        AssertionUtils.assertEquals("The text of the like button should be 'Dislike'", likeButtonValue, "Dislike");

    }

    @Test
    public void dislikeCommentOnPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.writeComment();
        latestPostsPage.clickShowCommentsButton();
        latestPostsPage.clickOnCommentsLikeButton();
        latestPostsPage.clickOnCommentsLikeButton();

        String likeButtonValue = latestPostsPage.getCommentLikeButtonValue();

        //Assert
        AssertionUtils.assertEquals("The text of the like button should be 'Like'", likeButtonValue, "Like");
    }

    @Test
    public void editCommentOnPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.writeComment();
        latestPostsPage.clickShowCommentsButton();
        latestPostsPage.editComment();
        latestPostsPage.clickOnEditedCommentButton();
        //Assert
        AssertionUtils.isTextVisible(DriverManager.getDriver(), LatestPostsPage.getEditedComment());

    }
    @Test
    public void deleteCommentOnPostTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLatestPosts();
        latestPostsPage.clickPublicPostsButton();
        latestPostsPage.clickExploreLastPostButton();
        latestPostsPage.writeComment();
        latestPostsPage.clickShowCommentsButton();
        latestPostsPage.deleteComment();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",latestPostsPage.
                getDeleteCommentSuccessMessage());
    }
}
