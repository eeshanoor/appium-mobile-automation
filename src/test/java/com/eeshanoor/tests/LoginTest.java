package com.eeshanoor.tests;

import com.eeshanoor.base.BaseTest;
import com.eeshanoor.screens.HomeScreen;
import com.eeshanoor.screens.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Valid credentials navigate to home screen")
    public void testValidLogin() {
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.login("bob@example.com", "10203040");
        HomeScreen homeScreen = new HomeScreen(driver);
        Assert.assertTrue(homeScreen.isLoaded(), "Home screen should be displayed after login");
    }

    @Test(description = "Invalid credentials show error message")
    public void testInvalidLogin() {
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.login("invalid@email.com", "wrongpassword");
        Assert.assertTrue(loginScreen.isErrorDisplayed(), "Error message should be visible");
        Assert.assertTrue(loginScreen.getErrorMessage().contains("Provided credentials do not match"));
    }

    @Test(description = "Empty username shows validation error")
    public void testEmptyUsername() {
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.login("", "10203040");
        Assert.assertTrue(loginScreen.isErrorDisplayed());
    }
}