package com.eeshanoor.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginScreen {
    private final AppiumDriver driver;
    private final WebDriverWait wait;

    @AndroidFindBy(accessibilityId = "test-Username")
    @iOSXCUITFindBy(accessibilityId = "Username")
    private WebElement usernameField;

    @AndroidFindBy(accessibilityId = "test-Password")
    @iOSXCUITFindBy(accessibilityId = "Password")
    private WebElement passwordField;

    @AndroidFindBy(accessibilityId = "test-LOGIN")
    @iOSXCUITFindBy(accessibilityId = "LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Error message']")
    @iOSXCUITFindBy(accessibilityId = "test-Error message")
    private WebElement errorMessage;

    public LoginScreen(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void tapLogin() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLogin();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

    public boolean isErrorDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}