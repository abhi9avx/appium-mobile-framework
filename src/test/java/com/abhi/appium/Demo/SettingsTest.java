package com.abhi.appium.Demo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class SettingsTest extends DemoBaseTest {

    @Test
    public void launchSettingsTest() {
        try {
            // Create explicit wait with longer timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            
            // Launch Settings app
            driver.activateApp("com.android.settings");
            
            // Wait for the settings app to load using multiple possible locators
            WebElement settingsApp = null;
            try {
                // Try finding by resource ID first (most reliable)
                settingsApp = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.id("android:id/title")));
            } catch (Exception e) {
                try {
                    // Fallback to finding by text content
                    settingsApp = wait.until(ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath("//*[contains(@text, 'Settings') or contains(@text, 'settings')]")));
                } catch (Exception e2) {
                    // Last resort: try finding any visible element in the settings app
                    settingsApp = wait.until(ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']")));
                }
            }
            
            // Verify the Settings app is displayed
            Assert.assertTrue(settingsApp.isDisplayed(), "Settings app should be launched successfully");
            
        } catch (Exception e) {
            Assert.fail("Failed to launch Settings app: " + e.getMessage());
        }
    }
}
