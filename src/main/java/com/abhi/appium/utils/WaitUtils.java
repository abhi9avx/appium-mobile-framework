package com.abhi.appium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WaitUtils class provides common wait operations for Appium tests
 * This helps avoid code duplication and makes tests more readable
 */
public class WaitUtils {

    private final WebDriverWait wait;

    /**
     * Constructor that creates a WebDriverWait with default timeout
     * @param driver The Android driver instance
     */
    public WaitUtils(org.openqa.selenium.WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /**
     * Constructor that creates a WebDriverWait with custom timeout
     * @param driver The Android driver instance
     * @param timeoutInSeconds Custom timeout in seconds
     */
    public WaitUtils(org.openqa.selenium.WebDriver driver, int timeoutInSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    /**
     * Waits for an element to be clickable and clicks it
     * @param locator The element locator
     */
    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Waits for an element to be present and returns it
     * @param locator The element locator
     * @return The found WebElement
     */
    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits for an element to be present and sends keys to it
     * @param locator The element locator
     * @param text The text to send
     */
    public void waitAndSendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.sendKeys(text);
    }

    /**
     * Waits for an element to be clickable
     * @param locator The element locator
     * @return The clickable WebElement
     */
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
} 