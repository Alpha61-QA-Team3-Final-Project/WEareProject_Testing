package testframework.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testframework.Driver;

public class AssertionUtils {

    public static void assertElementVisible(WebDriver driver, String locatorType, By locatorValue) {
        WebElement element = null;

        // Use Driver's findElement method to locate the element
        if (driver instanceof Driver) {
            Driver customDriver = (Driver) driver;

            // Call the overridden findElement method from the Driver class
            element = customDriver.findElement(locatorValue); // Using custom findElement
        } else {
            throw new IllegalArgumentException("Driver must be of type Driver");
        }

        // Check visibility
        if (!element.isDisplayed()) {
            throw new AssertionError("Element is not visible as expected.");
        }
    }

}

