package weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends HomePage{

    public SearchPage() {
        super("/search?searchParam1=&searchParam2=&index=0&size=10");
    }

    // Locators

//    List is not working - have to check. Only one element is working.
//    List<WebElement> profileLinks = driverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy
//        (By.xpath("//a[contains(normalize-space(text()), 'See Profile')]")));
    //
//    WebElement firstProfileLink = profileLinks.get(0);

    //this to be replaced by list
    private final By profileLink = By.xpath("//a[contains(text(), 'See Profile')]");
    private static By connectLink = By.xpath("//input[@value='connect']");
    private static final By disconnectLink = By.xpath("//input[@value='disconnect']");
    private static final By sentFriendRequest = By.xpath("//div[normalize-space()='Good job! You have send friend request!']");


    public void clickUserProfile(){
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(profileLink)).click();
    }

    public void clickConnectLink(){
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(connectLink)).click();
    }

    public void clickDisconnect(){
        driver().findElement(disconnectLink).click();
    }

    public static By getSentFriendRequest() {
        return sentFriendRequest;
    }
    public static By getDisconnectLink() {
        return disconnectLink;
    }
    public static By getConnectLink() {
        return connectLink;
    }

}
