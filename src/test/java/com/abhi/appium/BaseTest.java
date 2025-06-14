package com.abhi.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected AndroidDriver driver;
    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            
            // Basic capabilities needed for Android
            caps.setCapability("platformName", "Android");
            
            // Appium specific capabilities
            Map<String, Object> appiumOptions = new HashMap<>();
            appiumOptions.put("automationName", "UiAutomator2");
            appiumOptions.put("deviceName", "emulator-5554");
            appiumOptions.put("appPackage", "com.android.settings");
            appiumOptions.put("appActivity", "com.android.settings.Settings");
            
            caps.setCapability("appium:options", appiumOptions);

            // Initialize the driver
            driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            // Wait for app to launch
            Thread.sleep(3000);
            
        } catch (Exception e) {
            System.err.println("Failed to initialize Appium driver: " + e.getMessage());
            if (driver != null) {
                driver.quit();
            }
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
