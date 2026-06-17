package com.eeshanoor.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AppiumDriver driver;
    private static final String APPIUM_URL = "http://localhost:4723";

    @BeforeMethod
    @Parameters({"platform"})
    public void setUp(@Optional("android") String platform) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("android")) {
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:deviceName", "Android Emulator");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:app", System.getProperty("user.dir") + "/apps/SauceLabs.apk");
            caps.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.android");
            caps.setCapability("appium:appActivity", ".MainActivity");
            driver = new AndroidDriver(new URL(APPIUM_URL), caps);
        } else {
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:deviceName", "iPhone 14");
            caps.setCapability("appium:automationName", "XCUITest");
            caps.setCapability("appium:app", System.getProperty("user.dir") + "/apps/SauceLabs.app");
            caps.setCapability("appium:bundleId", "com.saucelabs.mydemoapp.ios");
            driver = new IOSDriver(new URL(APPIUM_URL), caps);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}