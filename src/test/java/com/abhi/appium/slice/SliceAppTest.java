package com.abhi.appium.slice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class SliceAppTest extends SliceBaseTest {

    @Test
    public void testSliceApp() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Wait for and click the initial button if present
            try {
                WebElement initialButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.id("indwin.c3.shareapp.test:id/initial_button")));
                initialButton.click();
            } catch (Exception e) {
                // Continue if initial button is not found
            }
            
            // Wait for and click the DLS button
            WebElement dlsButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("indwin.c3.shareapp.test:id/get_started_button")));
            dlsButton.click();
            
            // Add any additional assertions or verifications here
            
        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }
}
