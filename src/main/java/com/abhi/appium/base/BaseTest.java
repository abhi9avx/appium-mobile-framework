package com.abhi.appium.base;

import com.abhi.appium.config.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

/**
 * BaseTest class handles the setup and teardown of the Android driver
 * This class is extended by all test classes to get access to the driver
 */
public class BaseTest {

    protected AndroidDriver driver;

    /**
     * Sets up the Android driver before each test method
     * Configures all necessary capabilities for the Slice app using ConfigManager
     */
    public void setUp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", ConfigManager.getPlatformName());
            caps.setCapability("appium:automationName", ConfigManager.getAutomationName());
            caps.setCapability("appium:deviceName", ConfigManager.getDeviceName());
            caps.setCapability("appium:app", ConfigManager.getAppPath());
            caps.setCapability("appium:appPackage", ConfigManager.getAppPackage());
            caps.setCapability("appium:appActivity", ConfigManager.getAppActivity());
            caps.setCapability("appium:autoGrantPermissions", ConfigManager.getAutoGrantPermissions());
            caps.setCapability("appium:noReset", ConfigManager.getNoReset());
            caps.setCapability("appium:newCommandTimeout", ConfigManager.getNewCommandTimeout());
            caps.setCapability("appium:ensureWebviewsHavePages", true);
            caps.setCapability("appium:nativeWebScreenshot", true);
            caps.setCapability("appium:connectHardwareKeyboard", true);

            driver = new AndroidDriver(new URL(ConfigManager.getServerUrl()), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigManager.getImplicitWait()));
        } catch (Exception e) {
            throw new RuntimeException("BaseTest setup failed: " + e.getMessage(), e);
        }
    }

    /**
     * Cleans up the driver after each test method
     * Ensures the app is closed and resources are freed
     */
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 