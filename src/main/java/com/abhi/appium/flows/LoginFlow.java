package com.abhi.appium.flows;

import com.abhi.appium.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * LoginFlow class orchestrates the complete login sequence
 * This combines multiple page actions to perform a full login flow
 */
public class LoginFlow {

    private final LoginPage loginPage;

    /**
     * Constructor that initializes the login page
     * @param driver The Android driver instance
     */
    public LoginFlow(AndroidDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    /**
     * Performs the complete login flow with the given phone number
     * This method handles all steps from app launch to successful login
     * @param phoneNumber The phone number to use for login
     * @return true if login was successful, false otherwise
     */
    public boolean login(String phoneNumber) {
        try {
            // ⏱️ Start timer for performance measurement
            long startTime = System.currentTimeMillis();

            // Step 1: Handle system OK dialog (optional)
            loginPage.clickSystemOkDialog();

            // Step 2: Click DLS button to start login process
            loginPage.clickDlsButton();

            // Step 3: Click primary button to proceed
            loginPage.clickPrimaryButton();

            // Step 4: Allow first permission request
            loginPage.allowPermissions();

            // Step 5: Allow second permission request
            loginPage.allowPermissions();

            // Step 6: Click cancel from dialog
            loginPage.clickCancelButton();

            // Step 7: Enter mobile number
            loginPage.enterPhoneNumber(phoneNumber);

            // Step 8: Click on view element to proceed
            loginPage.clickViewElement();

            // Step 9: Wait for 2 seconds (as in original test)
            Thread.sleep(2000);

            // Step 10: Enter OTP code (using default "0000")
            loginPage.enterOtp("0000");

            // Step 11: Wait for 2 seconds (as in original test)
            Thread.sleep(2000);

            // Step 12: Enter MPIN (using default "2580")
            loginPage.enterMpin("2580");

            // Step 13: Allow final permission
            loginPage.allowPermissions();

            // Step 14: Verify successful login by checking for avatar
            WebElement avatarImage = loginPage.waitForAvatarImage();
            boolean loginSuccess = avatarImage.isDisplayed();

            // ⏱️ Calculate and log duration
            long endTime = System.currentTimeMillis();
            long durationInMillis = endTime - startTime;
            System.out.println("⏱️ App launch to avatar icon display took: " + durationInMillis + " ms");

            return loginSuccess;

        } catch (Exception e) {
            System.err.println("Login flow failed: " + e.getMessage());
            return false;
        }
    }

    /**
     * Performs login with custom OTP and MPIN values
     * @param phoneNumber The phone number to use for login
     * @param otp The OTP code to enter
     * @param mpin The MPIN to enter
     * @return true if login was successful, false otherwise
     */
    public boolean login(String phoneNumber, String otp, String mpin) {
        try {
            // ⏱️ Start timer for performance measurement
            long startTime = System.currentTimeMillis();

            // Step 1: Handle system OK dialog (optional)
            loginPage.clickSystemOkDialog();

            // Step 2: Click DLS button to start login process
            loginPage.clickDlsButton();

            // Step 3: Click primary button to proceed
            loginPage.clickPrimaryButton();

            // Step 4: Allow first permission request
            loginPage.allowPermissions();

            // Step 5: Allow second permission request
            loginPage.allowPermissions();

            // Step 6: Click cancel from dialog
            loginPage.clickCancelButton();

            // Step 7: Enter mobile number
            loginPage.enterPhoneNumber(phoneNumber);

            // Step 8: Click on view element to proceed
            loginPage.clickViewElement();

            // Step 9: Wait for 2 seconds (as in original test)
            Thread.sleep(2000);

            // Step 10: Enter custom OTP code
            loginPage.enterOtp(otp);

            // Step 11: Wait for 2 seconds (as in original test)
            Thread.sleep(2000);

            // Step 12: Enter custom MPIN
            loginPage.enterMpin(mpin);

            // Step 13: Allow final permission
            loginPage.allowPermissions();

            // Step 14: Verify successful login by checking for avatar
            WebElement avatarImage = loginPage.waitForAvatarImage();
            boolean loginSuccess = avatarImage.isDisplayed();

            // ⏱️ Calculate and log duration
            long endTime = System.currentTimeMillis();
            long durationInMillis = endTime - startTime;
            System.out.println("⏱️ App launch to avatar icon display took: " + durationInMillis + " ms");

            return loginSuccess;

        } catch (Exception e) {
            System.err.println("Login flow failed: " + e.getMessage());
            return false;
        }
    }
} 