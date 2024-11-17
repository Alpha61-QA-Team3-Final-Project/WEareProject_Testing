package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static com.weare.Constants.*;


public class PostsTests extends BaseTestSetup {

    @Test
    public void createPublicPostTest() {
        createAndRegisterUser();
        loginUser();
        Response response = createPost();

        //Assert
        Assert.assertEquals(200, response.statusCode(), "Expected status code to be 200");
        Assert.assertEquals(response.getBody().jsonPath().getString("content"), POST_DESCRIPTION, "Response body content does not match the expected.");
    }

    @Test
    public void getAllPostsTest() {
        Response response = showAllPosts();

        Assert.assertEquals(200, response.statusCode(), "Expected status code should be 200");
    }

    @Test
    public void updatePublicPostTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        Response response = editProfilePost();

        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        System.out.println("Successfully updated post with ID: " + POST_ID);

    }

    @Test
    public void likeAPublicPostTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        editProfilePost();
        Response response = likePost();
        boolean liked = response.jsonPath().getBoolean("liked");

        String responseBody = response.getBody().prettyPrint();
        System.out.println("Response body: " + responseBody);

        Assert.assertEquals(response.statusCode(), 200, "Expected statuc code to be 200");
        Assert.assertTrue(liked, "Expected status should be true for liked post");

    }

    @Test
    public void deletePublicPostTest() {
        createAndRegisterUser();
        loginUser();
        createPost();
        editProfilePost();
        Response response = deletePost();

        String responseBody = response.getBody().prettyPrint();
        System.out.println("Successfully deleted post with ID: " + POST_ID);
        Assert.assertEquals(200, response.statusCode(), "Expected status code to be 200");
        Assert.assertEquals(responseBody, "", "Response body should be empty");
    }
}