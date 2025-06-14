package com.abhi.appium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest {

    @Test
    public void launchSettingsTest() {
        // Get the current screen source
        String pageSource = driver.getPageSource();
        
        // Check if we're in the Settings app
        boolean isSettingsApp = pageSource.contains("com.android.settings");
        Assert.assertTrue(isSettingsApp, "Settings app should be launched");
    }
}
