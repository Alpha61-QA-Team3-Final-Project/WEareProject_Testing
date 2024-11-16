package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static com.weare.Constants.*;

public class CommentsTests extends BaseTestSetup {
    @Test
    public void createCommentTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        Response response = createComment();

        System.out.println("Response body is " + response.getBody().asPrettyString());

        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertTrue(response.getBody().asString().contains(COMMENT_DESCRIPTION), "Expected response body to contains Comment");
    }

    @Test
    public void getCommentsForPostTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        createComment();

        Response response = getComment();
        String createdCommentID = response.getBody().jsonPath().getString("commentId");
        System.out.println("Response body is " + response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(createdCommentID, COMMENT_ID, String.format("Incorrect comment ID. Expected %s", COMMENT_ID));
    }

    @Test
    public void editCommentTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        createComment();
        Response response = editComment();

        //Assert
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(response.getBody().asString(), "", "Expected response body should be empty");
    }

    @Test
    public void deleteCommentTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        createComment();
        Response response = deleteComment();

        //Assert
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(response.getBody().asString(), "", "Expected response body should be empty");
    }

    @Test
    public void likeCommentTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        createComment();

        Response response = likeComment();

        int commentIdFromResponse = response.jsonPath().getInt("commentId");
        int expectedCommentId = Integer.parseInt(COMMENT_ID);
        boolean isLiked = response.jsonPath().getBoolean("liked");

        //Assert
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(commentIdFromResponse, expectedCommentId,
                String.format("Expected comment ID to be: %s", expectedCommentId));
        Assert.assertTrue(isLiked, "Status should be TRUE for liked comment");
    }
    @Test
    public void dislikeCommentTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        createComment();

        Response response = likeComment();
        Response dislikeResponse = likeComment();

        int commentIdFromResponse = dislikeResponse.jsonPath().getInt("commentId");
        int expectedCommentId = Integer.parseInt(COMMENT_ID);
        boolean isLiked = dislikeResponse.jsonPath().getBoolean("liked");

        //Assert
        Assert.assertEquals(dislikeResponse.statusCode(), 200, "Expected status code to be 200");
        Assert.assertEquals(commentIdFromResponse, expectedCommentId,
                String.format("Expected comment ID to be: %s", expectedCommentId));
        Assert.assertFalse(isLiked, "Status should be FALSE for disliked comment");
    }
}

