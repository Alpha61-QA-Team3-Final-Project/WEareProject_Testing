package weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends HomePage {

    public SignInPage() {
        super("/login");
    }

    // Locators
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//input[@value='Login']");
    private final By wrongUserOrPassMessage = By.xpath("//i[normalize-space()='Wrong username or password.']");

    public void signIn(String username, String password) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }
    public By getLoginErrorMessage() {
       return wrongUserOrPassMessage;
    }
}

