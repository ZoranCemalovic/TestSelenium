package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPracticeTest extends BaseTest {
    String validUsername="student";
    String validPassword="Password123";
    String invalidUsername="pogresan username";
    String invalidPassword="pogresan password";

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }
    @Test
    public void successfulLoginAndLogout() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(logoutPage.getLogoutButton());
        Assert.assertTrue(logoutPage.getLogoutButton().isDisplayed());
        logoutPage.clickOnLogoutButton();
        visibilityWait(logoutPage.getMessage());
        Assert.assertTrue(logoutPage.getMessage().isDisplayed());
    }

    @Test
    public void unsuccessfulLoginInvalidUsernameValidPassword() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(validPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(loginPage.getErrorNotification());
        Assert.assertTrue(loginPage.getErrorNotification().isDisplayed());
    }

    @Test
    public void unsuccessfulLoginValidUsernameInvalidPassword() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(invalidPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(loginPage.getErrorNotification());
        Assert.assertTrue(loginPage.getErrorNotification().isDisplayed());
    }

    @Test
    public void unsuccessfulLoginInvalidUsernameInvalidPassword() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(invalidPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(loginPage.getErrorNotification());
        Assert.assertTrue(loginPage.getErrorNotification().isDisplayed());
    }

    @Test
    public void unsuccessfulLoginNoUsernameNoPassword() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.insertUsername("");
        loginPage.insertPassword("");
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(loginPage.getErrorNotification());
        Assert.assertTrue(loginPage.getErrorNotification().isDisplayed());
    }

    @Test
    public void unsuccessfulLoginNoUsernameValidPassword() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.insertUsername("");
        loginPage.insertPassword(validPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(loginPage.getErrorNotification());
        Assert.assertTrue(loginPage.getErrorNotification().isDisplayed());
    }

    @Test
    public void unsuccessfulLoginValidUsernameNoPassword() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword("");
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(loginPage.getErrorNotification());
        Assert.assertTrue(loginPage.getErrorNotification().isDisplayed());
    }

}
