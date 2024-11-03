package weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BaseWEarePage {

    public SignInPage() {
        super("/login");
    }

    // Locators
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//input[@value='Login']");

    //optional
    private final By signInLink = By.xpath("//a[contains(text(),'SIGN')]");
    private final By homeLink = By.xpath("//a[@class='nav-link'][normalize-space()='Home']");
    private final By latestPostsLink = By.xpath("//a[normalize-space()='Latest Posts']");
    private final By navbarLink = By.xpath("//a[@class='navbar-brand']");
    private final By registerLink = By.xpath("//a[normalize-space()='REGISTER']");

    public void signIn(String username, String password) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driver().findElement(loginButton).click();
    }
}
