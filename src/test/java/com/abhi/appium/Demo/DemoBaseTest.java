package com.abhi.appium.Demo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class DemoBaseTest {

    protected AndroidDriver driver;
    private static final String SERVER_URL = "http://127.0.0.1:4723";

    @BeforeMethod
    public void setUp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:deviceName", "emulator-5556");
            caps.setCapability("appium:appPackage", "com.android.settings");
            caps.setCapability("appium:appActivity", "com.android.settings.Settings");
            caps.setCapability("appium:noReset", true);
            caps.setCapability("appium:newCommandTimeout", 3600);
            caps.setCapability("appium:autoGrantPermissions", true);
            caps.setCapability("appium:ensureWebviewsHavePages", true);
            caps.setCapability("appium:nativeWebScreenshot", true);
            caps.setCapability("appium:connectHardwareKeyboard", true);
            caps.setCapability("appium:skipDeviceInitialization", true);
            caps.setCapability("appium:skipServerInstallation", true);
            caps.setCapability("appium:disableWindowAnimation", true);

            driver = new AndroidDriver(new URL(SERVER_URL), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            throw new RuntimeException("DemoBaseTest setup failed: " + e.getMessage(), e);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
