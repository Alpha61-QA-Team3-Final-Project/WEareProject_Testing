package weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testframework.DriverManager;

public class LatestPostsPage extends HomePage {

    public LatestPostsPage() {
        super("/posts");
    }

    //Locators
    //Options for the list????
    private final By categoryList = By.id("name");
    private final By categoryBrowseButton = By.xpath("//input[@value='Browse']");
    private final By publicPostsBrowseButton = By.xpath("//div[@class='col-lg-4 sidebar']//div[1]//form[1]//input[1]");
    //same locator for like/dislike
    private static final By lastPostLikeButton = By.xpath("//input[@id='submit-val64']");
    private final By exploreLastPostButton = By.xpath("//body//section[@class='" +
            "ftco-section ftco-candidates ftco-candidates-2 bg-light']//div[@class='row']//div[@class='row']" +
            "//div[1]//div[1]//div[2]//p[3]//a[1]");
    private final By commentField = By.id("message");
    private final By postCommentButton = By.xpath("//input[@value='Post Comment']");
    private final By showComments = By.className("show-comments");
    private static String comment = "This is a new comment!";
    //optional
    private final By registerButton = By.xpath("//a[normalize-space()='REGISTER']");

    public void clickPublicPostsButton(){
        driver().findElement(publicPostsBrowseButton).click();
    }

    public void clickLikeButton(){
        driver().findElement(lastPostLikeButton).click();
    }
    public void clickShowCommentsButton(){
        //driver().findElement(showComments).click();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(showComments)).click();
    }

    public void clickExploreLastPostButton(){
        driver().findElement(exploreLastPostButton).click();
    }

    public void writeComment(){
        driver().findElement(commentField).sendKeys(comment);
        driver().findElement(postCommentButton).click();
    }
    public static String getComment(){
        return comment;
    }
    public static By getLikeButtonLocator(){
        return lastPostLikeButton;
    }
}
