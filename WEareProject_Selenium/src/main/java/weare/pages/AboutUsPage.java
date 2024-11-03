package weare.pages;

import org.openqa.selenium.By;

public class AboutUsPage extends BaseWEarePage{

    public AboutUsPage() {
        super("/about-us");
    }

    //locators
    //optional
    private final By registerLink = By.xpath("//li[@class='nav-item cta mr-md-1']" +
            "//a[@class='nav-link'][normalize-space()='REGISTER']");
    private final By signInLink = By.xpath("//a[contains(text(),'SIGN')]");
    private final By homeLink = By.xpath("//a[normalize-space()='Home']");
    private final By latestPostsLink = By.xpath("//a[normalize-space()='Latest Posts']");
    private final By navbarLink = By.xpath("//a[@class='navbar-brand']");


    // Actions
    public void clickRegister(){
        driver().findElement(registerLink).click();
    }

    public void clickSigIn(){
        driver().findElement(signInLink).click();
    }

    public void clickHome(){
        driver().findElement(homeLink).click();
    }

    public void clickLatestPosts(){
        driver().findElement(latestPostsLink).click();
    }

    public void clickNavBar(){
        driver().findElement(navbarLink).click();
    }

}
