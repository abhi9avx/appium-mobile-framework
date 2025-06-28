package com.abhi.appium.pages;

import com.abhi.appium.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * HomePage class contains all element locators and methods for the home screen
 * This demonstrates how to add new pages to the framework
 */
public class HomePage {

    private final AndroidDriver driver;
    private final WaitUtils waitUtils;

    // Element locators for the home screen
    private static final By AVATAR_IMAGE = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)");
    private static final By WELCOME_MESSAGE = AppiumBy.id("welcome_message");
    private static final By MENU_BUTTON = AppiumBy.accessibilityId("menu_button");
    private static final By LOGOUT_BUTTON = AppiumBy.accessibilityId("logout_button");

    /**
     * Constructor that initializes the driver and wait utilities
     * @param driver The Android driver instance
     */
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    /**
     * Checks if the user is successfully logged in by verifying avatar presence
     * @return true if avatar is displayed, false otherwise
     */
    public boolean isUserLoggedIn() {
        try {
            WebElement avatar = waitUtils.waitForElement(AVATAR_IMAGE);
            return avatar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the welcome message text from the home screen
     * @return The welcome message text
     */
    public String getWelcomeMessage() {
        try {
            WebElement welcomeElement = waitUtils.waitForElement(WELCOME_MESSAGE);
            return welcomeElement.getText();
        } catch (Exception e) {
            return "Welcome message not found";
        }
    }

    /**
     * Clicks the menu button to open the navigation menu
     */
    public void openMenu() {
        waitUtils.waitAndClick(MENU_BUTTON);
    }

    /**
     * Clicks the logout button to sign out
     */
    public void logout() {
        waitUtils.waitAndClick(LOGOUT_BUTTON);
    }

    /**
     * Performs a complete logout flow
     * This demonstrates how to combine multiple actions
     */
    public void performLogout() {
        openMenu();
        logout();
    }
} 