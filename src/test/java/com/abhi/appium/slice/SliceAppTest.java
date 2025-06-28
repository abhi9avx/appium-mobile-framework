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
    public void testSliceAppFlowWithDuration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // ⏱️ Start timer
            long startTime = System.currentTimeMillis();

            // Step 1: Click system OK dialog (optional - might not appear)
            try {
                wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1"))).click();
                System.out.println("✅ System OK dialog clicked");
            } catch (Exception e) {
                System.out.println("ℹ️ System OK dialog not found, continuing...");
            }

            // Step 2: Click DLS button
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("indwin.c3.shareapp.test:id/dls_button_label"))).click();

            // Step 3: Click Primary Button
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("primaryButton"))).click();

            // Step 4: Allow Permissions (first time)
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"))).click();

            // Step 5: Allow Permissions (second time)
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"))).click();

            // Step 6: Click Cancel (from dialog)
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Cancel"))).click();

            // Step 7: Enter Mobile Number
            WebElement mobileInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.className("android.widget.EditText")));
            mobileInput.sendKeys("8278650784");
            mobileInput.click();

            // Step 8: Click on View (index 6)
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)"))).click();

            // Wait for 2 seconds
            Thread.sleep(2000);

            // Step 9: Enter OTP
            WebElement otpInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.className("android.widget.EditText")));
            otpInput.sendKeys("0000");

            // Wait for 2 seconds
            Thread.sleep(2000);

            // Step 10: Enter MPIN
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.accessibilityId("mpin_id_pin_input_field"))).sendKeys("2580");

            // Step 11: Final permission allow
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"))).click();

            // Step 12: Final check — wait for avatar ImageView
            WebElement avatarImage = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)")));
            Assert.assertTrue(avatarImage.isDisplayed(), "Avatar ImageView is not visible — login may have failed.");

            // ⏱️ Stop timer and calculate duration
            long endTime = System.currentTimeMillis();
            long durationInMillis = endTime - startTime;

            System.out.println("⏱️ App launch to avatar icon display took: " + durationInMillis + " ms");

        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }
}
