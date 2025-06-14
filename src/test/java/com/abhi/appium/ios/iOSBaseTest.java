package com.abhi.appium.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class iOSBaseTest {

    protected IOSDriver driver;
    private static final String SERVER_URL = "http://127.0.0.1:4723";

    @BeforeMethod
    public void setUp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:automationName", "XCUITest");
            caps.setCapability("appium:deviceName", "iPhone 16 Pro");
            caps.setCapability("appium:platformVersion", "18.5");
            caps.setCapability("appium:bundleId", "com.apple.Preferences");
            caps.setCapability("appium:noReset", true);
            caps.setCapability("appium:newCommandTimeout", 3600);
            caps.setCapability("appium:connectHardwareKeyboard", true);

            driver = new IOSDriver(new URL(SERVER_URL), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            throw new RuntimeException("iOSBaseTest setup failed: " + e.getMessage(), e);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
