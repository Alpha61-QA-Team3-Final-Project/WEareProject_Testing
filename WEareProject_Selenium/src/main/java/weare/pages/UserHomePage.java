package weare.pages;

import org.openqa.selenium.By;

public class UserHomePage extends HomePage{

    public UserHomePage() {
        super("");
    }

    // Locators
    private final By personalProfileLink = By.xpath("//a[contains(text(),'Personal')]");
    private final By addNewPostLink = By.xpath("//a[contains(text(),'Add New')]");
    private final By logoutLink = By.xpath("//a[normalize-space()='LOGOUT']");
    private final By newFriendRequestsLink = By.xpath("//input[@value='New Friend Requsts']");
    private final By approveRequestsLink = By.xpath("//input[@value='Approve Request']");


    // Actions
    public void clickPersonalProfile(){
        driver().findElement(personalProfileLink).click();
    }

    public void clickAddNewPost(){
        driver().findElement(addNewPostLink).click();
    }

    public void clickLogout(){
        driver().findElement(logoutLink).click();
    }

    public void clickNewFriendRequests(){
        driver().findElement(newFriendRequestsLink).click();
    }

    public void clickApproveRequests(){
        driver().findElement(approveRequestsLink).click();
    }





}
