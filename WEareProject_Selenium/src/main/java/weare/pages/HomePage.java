package weare.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testframework.enums.AssertionUtils;

public class HomePage extends BaseWEarePage {

    public HomePage(String s) {
        super("");
    }

    // Locators
    private final By registerLink = By.xpath("//li[@class='nav-item cta mr-md-1']" +
            "//a[@class='nav-link'][normalize-space()='REGISTER']");
    private final By signInLink = By.xpath("//a[contains(text(),'SIGN')]");
    private final By homeLink = By.xpath("//a[normalize-space()='Home']");
    private final By latestPostsLink = By.xpath("//a[normalize-space()='Latest Posts']");
    private final By aboutUsLink = By.xpath("//a[normalize-space()='About us']");
    private final By navbarLink = By.xpath("//a[@class='navbar-brand']");
    private static final By header = By.xpath("/html/body/section[1]/div/div/div[1]/p[1]/i");
    private final By professionField = By.id("searchParam1");
    private final By nameField = By.id("searchParam2");
    private final By searchButton = By.xpath("//button[@type='submit']");


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

    public void clickAboutUs(){
        driver().findElement(aboutUsLink).click();
    }

    public void clickNavBar(){
        driver().findElement(navbarLink).click();
    }

    public void clickSearchButton(){
        driver().findElement(searchButton).click();
    }
    public static By getHeaderLocator(){
        return header;
    }
    //Veli asserts
//    public void verifyRegisterLinkVisible() {
//        AssertionUtils.assertElementVisible(driver(), registerLink);
//    }
//    public void verifyHeaderVisible() {
//        AssertionUtils.assertElementVisible(driver(), header);
//    }


    // There is a bug, not displaying the correct result
//    public void findProfessional(String profession, String name) {
//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(professionField)).sendKeys(profession);
//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
//        driver().findElement(searchButton).click();
//    }


}
