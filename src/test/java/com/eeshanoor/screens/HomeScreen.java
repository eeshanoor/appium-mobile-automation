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
import java.util.List;

public class HomeScreen {
    private final AppiumDriver driver;
    private final WebDriverWait wait;

    @AndroidFindBy(accessibilityId = "test-Cart drop zone")
    @iOSXCUITFindBy(accessibilityId = "test-Cart drop zone")
    private WebElement cartIcon;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    @iOSXCUITFindBy(accessibilityId = "test-Item")
    private List<WebElement> productItems;

    @AndroidFindBy(accessibilityId = "test-ADD TO CART")
    @iOSXCUITFindBy(accessibilityId = "test-ADD TO CART")
    private List<WebElement> addToCartButtons;

    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cartIcon));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getProductCount() {
        return productItems.size();
    }

    public void addFirstItemToCart() {
        if (!addToCartButtons.isEmpty()) {
            addToCartButtons.get(0).click();
        }
    }

    public void tapCart() {
        cartIcon.click();
    }
}