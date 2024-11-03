package weare.pages;

import org.openqa.selenium.By;

public class UserHomePage extends BaseWEarePage{

    public UserHomePage() {
        super("");
    }

    // Locators
    private final By homeLink = By.xpath("//a[normalize-space()='Home']");
    private final By latestPostsLink = By.xpath("//a[normalize-space()='Latest Posts']");
    private final By aboutUsLink = By.xpath("//a[normalize-space()='About us']");
    private final By navbarLink = By.xpath("//a[@class='navbar-brand']");
    private final By personalProfileLink = By.xpath("//a[contains(text(),'Personal')]");
    private final By addNewPostLink = By.xpath("//a[contains(text(),'Add New')]");
    private final By logoutLink = By.xpath("//a[normalize-space()='LOGOUT']");
    private final By professionField = By.id("searchParam1");
    private final By nameField = By.id("searchParam2");
    private final By searchButton = By.xpath("//button[@type='submit']");

    // Actions
    public void clickHome(){
        driver().findElement(homeLink).click();
    }

    public void clickLatestPosts(){
        driver().findElement(latestPostsLink).click();
    }

    public void clickAboutUs(){
        driver().findElement(aboutUsLink).click();
    }

    public void clickNavBar(){
        driver().findElement(navbarLink).click();
    }

    public void clickPersonalProfile(){
        driver().findElement(personalProfileLink).click();
    }

    public void clickAddNewPost(){
        driver().findElement(addNewPostLink).click();
    }

    public void clickLogout(){
        driver().findElement(logoutLink).click();
    }

}
