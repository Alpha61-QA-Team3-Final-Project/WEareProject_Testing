package wearetests.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;
import weare.pages.*;

public class WEareBaseWebTest extends BaseWebTest {

    protected AboutUsPage aboutUsPage;
    protected AdminHomePage adminHomePage;
    protected HomePage homePage;
    protected LatestPostsPage latestPostsPage;
    protected RegisterPage registerPage;
    protected SignInPage signInPage;
    protected UserHomePage userHomePage;
    protected UserProfilePage userProfilePage;


    @BeforeEach
    public void beforeTests() {
        // perform some code before each test starts

        aboutUsPage = new AboutUsPage();
        adminHomePage = new AdminHomePage();
        homePage = new HomePage();
        latestPostsPage = new LatestPostsPage();
        registerPage = new RegisterPage();
        signInPage = new SignInPage();
        userHomePage = new UserHomePage();
        userProfilePage = new UserProfilePage();

        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"));
    }

    @BeforeAll
    public static void beforeAll() {
        // perform some code before all tests start
    }

    // close driver
    @AfterEach
    public void afterTest() {
        driver().close();
        // perform some code after each test has finished
    }

    @AfterAll
    public static void afterAll() {
        // perform some code after all tests have finished
    }

    // Extract methods that use multiple pages
//    public void authenticateWithUser(String username, String pass) {
//        loginPage.submitLoginForm(username, pass);
//        inventoryPage.waitForPageTitle();
//    }
}
