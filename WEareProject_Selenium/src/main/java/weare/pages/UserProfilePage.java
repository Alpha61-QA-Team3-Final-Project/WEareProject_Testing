package weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;

public class UserProfilePage extends BaseWEarePage{

    public UserProfilePage() {
        super("/auth/users/41/profile");
    }

    // Locators
    private final By homeLink = By.xpath("//a[normalize-space()='Home']");
    private final By latestPostsLink = By.xpath("//a[normalize-space()='Latest Posts']");
    private final By aboutUsLink = By.xpath("//a[normalize-space()='About us']");
    private final By navbarLink = By.xpath("//a[@class='navbar-brand']");
    private final By addNewPostLink = By.xpath("//a[contains(text(),'Add New')]");
    private final By logoutLink = By.xpath("//a[normalize-space()='LOGOUT']");
    private final By editProfileLink = By.xpath("//a[contains(text(),'edit')]");
    private final By firstName = By.id("nameE");
    private final By lastName = By.id("lastnameE");
    private final By birthday = By.id("birthDayE");
    // Select
    private final By gender = By.id("selectE");
    private final By userEmail = By.id("emailE");
    private final By userInfo = By.id("publicinfoE");
    // Select
    private final By city = By.id("selectC");
    private final By updateMyProfileButton = By.xpath("//button[contains(text(),'Update My')]");


    // Actions
    public void clickEditProfile(){
        driver().findElement(editProfileLink).click();
    }

    public void editProfile(String fName, String lName, String date, String email, String aboutMe) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(birthday)).sendKeys(date);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(userEmail)).clear();
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(userEmail)).sendKeys(email);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(userInfo)).sendKeys(aboutMe);
        driver().findElement(updateMyProfileButton).click();
    }

}
