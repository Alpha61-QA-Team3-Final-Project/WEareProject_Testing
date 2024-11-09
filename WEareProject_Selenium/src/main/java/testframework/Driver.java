package testframework;

import dev.failsafe.internal.util.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Driver implements WebDriver {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    private final Actions actions;
    private Boolean isDisposed;
    private static final Logger LOGGER = LogManager.getRootLogger();

    public Driver(WebDriver driver, Integer defaultTimeoutSeconds) {
        Duration timeout = Duration.ofSeconds(defaultTimeoutSeconds);
        webDriver = driver;
        webDriverWait = new WebDriverWait(driver, timeout);
        actions = new Actions(driver);
        isDisposed = false;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }
    public WebDriverWait getDriverWait() {
        return this.webDriverWait;
    }

    public Boolean isDisposed() {
        return isDisposed;
    }

    @Override
    public void get(String s) {
        LOGGER.info("Navigating to page: " + s);
        webDriver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        String currentUrl = webDriver.getCurrentUrl();
        LOGGER.info("Getting current URL: " + currentUrl);
        return currentUrl;
    }

    @Override
    public String getTitle() {
        String currentTitle = webDriver.getTitle();
        LOGGER.info("Getting Title: " + currentTitle);
        return currentTitle;
    }

    @Override
    public List<WebElement> findElements(By by) {
        LOGGER.info("Finding all element with locator: " + by.toString());
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        LOGGER.info("Finding element with locator: " + by.toString());
        WebElement elementFound = webDriver.findElement(by);
        return webDriverWait.until(ExpectedConditions.visibilityOf(elementFound));
    }

    @Override
    public String getPageSource() {
        LOGGER.info("Getting page source...");
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        if (webDriver != null && !isDisposed) {
            LOGGER.info("Closing Browser...");
            webDriver.close();
            isDisposed = true;
        }
    }

    @Override
    public void quit() {
        LOGGER.info("Quiting driver...");
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        LOGGER.info("Getting Window handles...");
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }

    //public void assertion(String locator){
        //WebElement element = getWebDriver().findElement(By.id(locator));  // Locate the element first
        //if (!element.isDisplayed()) {
            //throw new AssertionError("Element is not visible as expected.");
        //}
    //}

    public static void assertElementVisible(WebDriver driver, String locatorType, String locatorValue) {
        WebElement element;

        switch (locatorType.toLowerCase()) {
            case "id":
                element = driver.findElement(By.id(locatorValue));
                break;
            case "class":
                element = driver.findElement(By.className(locatorValue));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(locatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(locatorValue));
                break;
            case "name":
                element = driver.findElement(By.name(locatorValue));
                break;
            case "tag":
                element = driver.findElement(By.tagName(locatorValue));
                break;
            case "linktext":
                element = driver.findElement(By.linkText(locatorValue));
                break;
            case "partiallinktext":
                element = driver.findElement(By.partialLinkText(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }

        if (!element.isDisplayed()) {
            throw new AssertionError("Element is not visible as expected.");
        }
    }


    // Add custom Driver methods
    public void scrollToElement(By locator) {
        actions.scrollToElement(webDriver.findElement(locator)).perform();
    }
}
