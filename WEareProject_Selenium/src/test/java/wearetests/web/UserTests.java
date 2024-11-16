package wearetests.web;

import org.junit.jupiter.api.Test;
import testframework.DriverManager;
import weare.pages.*;
import wearetests.core.AssertionUtils;
import wearetests.core.WEareBaseWebTest;
import wearetests.enums.TestData;


public class UserTests extends WEareBaseWebTest {

    @Test
    public void userRegisterTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                RegisterPage.getWelcomeMessage());
    }

    @Test
    public void userLoginTest() {

        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                HomePage.getLogoutHomePageLocator());
    }

    @Test
    public void userLogoutTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickLogout();

        //Assert
        AssertionUtils.assertElementVisible(DriverManager.getDriver(), "xpath",
                UserHomePage.getYouAreLoggedOutMessage());
        System.out.println("Logout user: " + TestData.REGISTER_USERNAME.getValue());
    }

    @Test
    public void updateUserProfileTest() {
        homePage.navigate();
        homePage.clickRegister();
        registerPage.registerUser(TestData.REGISTER_USERNAME.getValue(), TestData.EMAIL.getValue(),
                TestData.REGISTER_PASSWORD.getValue(), TestData.REGISTER_PASSWORD.getValue());
        homePage.clickSigIn();
        signInPage.signIn(TestData.REGISTER_USERNAME.getValue(), TestData.REGISTER_PASSWORD.getValue());
        userHomePage.clickPersonalProfile();
        userProfilePage.clickEditProfile();
        userProfilePage.editProfile(TestData.UPDATE_FIRSTNAME.getValue(), TestData.UPDATE_LASTNAME.getValue(),
                TestData.UPDATE_BIRTHDAY.getValue(), TestData.UPDATE_EMAIL.getValue(), TestData.UPDATE_ABOUT_ME.getValue());
        //Assert
        AssertionUtils.isTextVisible(DriverManager.getDriver(), "Profile updated successfully.");

    }
}
