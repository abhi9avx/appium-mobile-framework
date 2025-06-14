package com.abhi.appium.ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SettingsIOSTest extends iOSBaseTest {

    @Test
    public void launchSettingsIOSTest() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Activate the iOS Settings app
            driver.activateApp("com.apple.Preferences");

            // Wait for the "General" option to appear
            WebElement generalOption = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'General'`]"))
            );

            Assert.assertTrue(generalOption.isDisplayed(), "'General' should be visible in iOS Settings app");
        } catch (Exception e) {
            Assert.fail("iOS Settings app test failed: " + e.getMessage());
        }
    }
}
