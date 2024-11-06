package weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends HomePage {

    public RegisterPage() {
        super("/register");
    }

    // Locators
    private final By usernameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirm");
    //Options for the list????
    private final By categoryList = By.id("category.id");
    private final By registerButton = By.xpath("//input[@value='Register']");

    public void registerUser(String username, String email, String password, String confirmPassword) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(confirmPassword);
//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(categoryList)).click();
        driver().findElement(registerButton).click();
    }

}
