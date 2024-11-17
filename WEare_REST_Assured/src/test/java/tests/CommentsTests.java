package tests;

import base.BaseTestSetup;
import com.weare.Constants;
import com.weare.JSONRequests;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CommentsTests extends BaseTestSetup {
    // TO DO
    Response response;

    @Test
    public void createCommentTest(){
//        createAndRegisterUserReceiver();
        createAndRegisterUser();
        loginUser();
        createPost();
//        loginUserReceiver();
        //createComment("This is a comment");
        response = createComment();
        System.out.println("Comment body is" + JSONRequests.COMMENT_BODY);
        System.out.println("Response body is " + response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertTrue(response.getBody().asString().contains(Constants.COMMENT_DESCRIPTION),"Expected response body to contains Comment");
    }

    @Test
    public void getCommentsForPostTest(){
        response = getComment();
        System.out.println("Response body is " + response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertTrue(response.getBody().asString().contains("commentId"),"Expected response body to contains commentID");
    }

    @Test
    public void editCommentTest(){
//        createAndRegisterUserReceiver();
        createAndRegisterUser();
        loginUser();
        createPost();
//        loginUserReceiver();
        //createComment("This is a comment");
        response = createComment();
        System.out.println("Comment body is" + JSONRequests.COMMENT_BODY);
        System.out.println("Response body is " + response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 200, "Expected status code to be 200");
        Assert.assertTrue(response.getBody().asString().contains(Constants.COMMENT_DESCRIPTION),"Expected response body to contains Comment");
    }

}

