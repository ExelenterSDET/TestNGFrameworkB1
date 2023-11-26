package com.exelenter.testcases;

import com.exelenter.base.BaseClass;
import com.exelenter.utils.ConfigsReader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * High Level explanation of the feature in User Story (US).
 * Detailed explanation is described in the Acceptance Criteria (ACs) of the story.
 * US 16457: As an Admin User, I should not be able to login to the application using invalid credentials.
 * AC 1. When a user tries to log in using valid credentials
 *  - User enters valid username in the username field
 *  - User enters valid password in the password field
 *  - User clicks on the Login button
 *  - User is successfully logged in and the user dashboard is displayed
 *  AC 2. When a user tries to log in using invalid credentials...
 */
public class LoginTest extends BaseClass {
    @Test(groups = {"smoke", "singleTest", "regression"})
    public void validAdminLogin() {
        loginPage.loginToWebsite(ConfigsReader.getProperties("username"), ConfigsReader.getProperties("password"));
        String expectedText = "Dashboard";
        String actualText = dashboardPage.dashboardHeaderText.getText();
        Assert.assertEquals(actualText, expectedText, "User login failed");
    }

    @Test(groups = "smoke", dependsOnMethods = "validUserEmptyPassword")
    public void validUserInvalidPassword() {
        String invalidPassword = "Pass1234"; // <-- Not good practice, in-line hard code used, can be optimized later.
        String expectedErrorMessage = "Invalid credentials";
        sendText(loginPage.username, ConfigsReader.getProperties("username"));    // Valid Username
        sendText(loginPage.password, invalidPassword);                                // Invalid Password
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(), expectedErrorMessage, "Login Error message is incorrect");
    }

    @Test(groups = "smoke")
    public void validUserEmptyPassword() {
        String passwordBlankTextHint = "Required";   // <-- Not good practice, in-line hard code used, can be optimized later.
        sendText(loginPage.username, ConfigsReader.getProperties("username"));   // Valid Username, Password empty (skipped).
        click(loginPage.loginBtn);
        waitForVisibility(loginPage.passwordBlankErrorMessage);
        if (loginPage.passwordBlankErrorMessage.getText().contains("Required")) {
            Assert.assertEquals(loginPage.passwordBlankErrorMessage.getText(), passwordBlankTextHint, "Password field cannot be blank");
        }
//        Assert.fail();   // <== I am intentionally failing this test for the report.
    }

}
