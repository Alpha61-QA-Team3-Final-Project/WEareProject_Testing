package wearetests.web;

import org.junit.jupiter.api.Test;
import testframework.DriverManager;
import weare.pages.HomePage;
import weare.pages.RegisterPage;
import weare.pages.UserHomePage;
import wearetests.core.AssertionUtils;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;

public class AdminTests extends WEareBaseWebTest {
    @Test
    public void adminRegistrationTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.ADMIN_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.ADMIN_PASSWORD.getValue(), TestData.ADMIN_PASSWORD.getValue());

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                RegisterPage.getWelcomeMessage());
    }

    @Test
    public void adminLoginTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.ADMIN_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.ADMIN_PASSWORD.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                HomePage.getLogoutHomePageLocator());
    }

    @Test
    public void adminLogoutTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.ADMIN_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.ADMIN_PASSWORD.getValue(), TestData.ADMIN_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.ADMIN_USERNAME.getValue(), TestData.ADMIN_PASSWORD.getValue());
        userHomePage.clickLogout();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                UserHomePage.getYouAreLoggedOutMessage());
        System.out.println("Logout user: " + TestData.REGISTER_USERNAME.getValue());
    }
}
