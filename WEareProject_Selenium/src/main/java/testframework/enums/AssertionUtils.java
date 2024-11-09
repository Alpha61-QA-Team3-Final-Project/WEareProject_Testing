package testframework.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertionUtils {

    public static void assertElementVisible(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);

        if (!element.isDisplayed()) {
            throw new AssertionError("Element is not visible as expected.");
        }
    }
}
