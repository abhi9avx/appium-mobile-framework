package com.abhi.appium.pages;

import com.abhi.appium.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * LoginPage class contains all element locators and methods for the login screen
 * This follows the Page Object Model pattern to separate element locators from test logic
 */
public class LoginPage {

    private final AndroidDriver driver;
    private final WaitUtils waitUtils;

    // Element locators for the login screen
    private static final By SYSTEM_OK_BUTTON = AppiumBy.id("android:id/button1");
    private static final By DLS_BUTTON = AppiumBy.id("indwin.c3.shareapp.test:id/dls_button_label");
    private static final By PRIMARY_BUTTON = AppiumBy.accessibilityId("primaryButton");
    private static final By PERMISSION_ALLOW_BUTTON = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
    private static final By CANCEL_BUTTON = AppiumBy.accessibilityId("Cancel");
    private static final By MOBILE_INPUT_FIELD = AppiumBy.className("android.widget.EditText");
    private static final By VIEW_ELEMENT_INDEX_6 = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(6)");
    private static final By MPIN_INPUT_FIELD = AppiumBy.accessibilityId("mpin_id_pin_input_field");
    private static final By AVATAR_IMAGE = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)");

    /**
     * Constructor that initializes the driver and wait utilities
     * @param driver The Android driver instance
     */
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    /**
     * Clicks the system OK dialog if it appears (optional step)
     * This handles the case where a system dialog might appear
     */
    public void clickSystemOkDialog() {
        try {
            waitUtils.waitAndClick(SYSTEM_OK_BUTTON);
            System.out.println("✅ System OK dialog clicked");
        } catch (Exception e) {
            System.out.println("ℹ️ System OK dialog not found, continuing...");
        }
    }

    /**
     * Clicks the DLS button to start the login process
     */
    public void clickDlsButton() {
        waitUtils.waitAndClick(DLS_BUTTON);
    }

    /**
     * Clicks the primary button to proceed with login
     */
    public void clickPrimaryButton() {
        waitUtils.waitAndClick(PRIMARY_BUTTON);
    }

    /**
     * Allows permissions when prompted by the system
     */
    public void allowPermissions() {
        waitUtils.waitAndClick(PERMISSION_ALLOW_BUTTON);
    }

    /**
     * Clicks the cancel button from any dialog
     */
    public void clickCancelButton() {
        waitUtils.waitAndClick(CANCEL_BUTTON);
    }

    /**
     * Enters the mobile number in the input field
     * @param phoneNumber The phone number to enter
     */
    public void enterPhoneNumber(String phoneNumber) {
        WebElement mobileInput = waitUtils.waitForElement(MOBILE_INPUT_FIELD);
        mobileInput.sendKeys(phoneNumber);
        mobileInput.click();
    }

    /**
     * Clicks on the view element at index 6 to proceed
     */
    public void clickViewElement() {
        waitUtils.waitAndClick(VIEW_ELEMENT_INDEX_6);
    }

    /**
     * Enters the OTP code in the input field
     * @param otp The OTP code to enter
     */
    public void enterOtp(String otp) {
        WebElement otpInput = waitUtils.waitForElement(MOBILE_INPUT_FIELD);
        otpInput.sendKeys(otp);
    }

    /**
     * Enters the MPIN in the input field
     * @param mpin The MPIN to enter
     */
    public void enterMpin(String mpin) {
        waitUtils.waitAndSendKeys(MPIN_INPUT_FIELD, mpin);
    }

    /**
     * Waits for the avatar image to be displayed, indicating successful login
     * @return The avatar WebElement if found
     */
    public WebElement waitForAvatarImage() {
        return waitUtils.waitForElement(AVATAR_IMAGE);
    }

    /**
     * Checks if the avatar image is displayed (login success indicator)
     * @return true if avatar is displayed, false otherwise
     */
    public boolean isAvatarDisplayed() {
        try {
            WebElement avatar = waitUtils.waitForElement(AVATAR_IMAGE);
            return avatar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
} 