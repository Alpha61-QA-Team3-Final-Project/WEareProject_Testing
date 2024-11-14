package weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
    private static final By lastPostLikeButton = By.xpath("(//input[contains(@id, 'submit-val') and contains(@value, '')])[1]");
    private final By exploreLastPostButton = By.xpath("//body//section[@class='" +
            "ftco-section ftco-candidates ftco-candidates-2 bg-light']//div[@class='row']//div[@class='row']" +
            "//div[1]//div[1]//div[2]//p[3]//a[1]");
    private final By commentField = By.id("message");
    private final By postCommentButton = By.xpath("//input[@value='Post Comment']");
    private final By showComments = By.className("show-comments");
    public static int commentCounter = 0;
    public static String comment = "This is a new comment";
    //optional
    private final By registerButton = By.xpath("//a[normalize-space()='REGISTER']");


    public void clickPublicPostsButton() {
        driver().findElement(publicPostsBrowseButton).click();
    }

    public void clickLikeButton() {
        driver().findElement(lastPostLikeButton).click();
    }

    public void clickShowCommentsButton() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(showComments)).click();
    }

    public void clickExploreLastPostButton() {
        driver().findElement(exploreLastPostButton).click();
    }

    public void writeComment() {
//        String uniqueComment = "This is a new comment" + (commentCounter++);
//        String uniqueComment = "This is a new comment" + (commentCounter++);
//        commentCounter++;

        driver().findElement(commentField).sendKeys(comment);
        driver().findElement(postCommentButton).click();

//        return comment;
    }

    public static String getComment() {
//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(showComments)).click();
////        String lastCommentText = driver().findElement(By.xpath("//li//div//p[contains(text(), 'This is a new comment " + commentCounter + "')]")).getText();
        return comment;
    }

    public String getLikeButtonValue() {
        WebElement lastLikeButton = driver().findElement(lastPostLikeButton);
        return lastLikeButton.getAttribute("value");

    }

}

