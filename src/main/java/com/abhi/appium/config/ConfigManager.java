package com.abhi.appium.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigManager class handles configuration properties for the test framework
 * This makes the framework more maintainable and configurable
 */
public class ConfigManager {

    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "config.properties";

    // Default configuration values
    private static final String DEFAULT_SERVER_URL = "http://127.0.0.1:4723";
    private static final String DEFAULT_PLATFORM_NAME = "Android";
    private static final String DEFAULT_AUTOMATION_NAME = "UiAutomator2";
    private static final String DEFAULT_DEVICE_NAME = "emulator-5554";
    private static final String DEFAULT_APP_PATH = "/Users/abhinav/Downloads/appAndroid.apk";
    private static final String DEFAULT_APP_PACKAGE = "indwin.c3.shareapp.test";
    private static final String DEFAULT_APP_ACTIVITY = "com.slice.android.main.SingleActivity";
    private static final int DEFAULT_IMPLICIT_WAIT = 10;
    private static final int DEFAULT_EXPLICIT_WAIT = 15;

    static {
        loadProperties();
    }

    /**
     * Loads configuration properties from the config file
     * Falls back to default values if the file is not found
     */
    private static void loadProperties() {
        try {
            FileInputStream input = new FileInputStream(CONFIG_FILE);
            properties.load(input);
            input.close();
        } catch (IOException e) {
            System.out.println("Config file not found, using default values: " + e.getMessage());
        }
    }

    /**
     * Gets a property value, returning the default if not found
     * @param key The property key
     * @param defaultValue The default value to return if key not found
     * @return The property value or default
     */
    private static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Gets an integer property value, returning the default if not found
     * @param key The property key
     * @param defaultValue The default value to return if key not found
     * @return The property value as integer or default
     */
    private static int getIntProperty(String key, int defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer value for " + key + ", using default: " + defaultValue);
            }
        }
        return defaultValue;
    }

    // Configuration getter methods
    public static String getServerUrl() {
        return getProperty("appium.server.url", DEFAULT_SERVER_URL);
    }

    public static String getPlatformName() {
        return getProperty("platform.name", DEFAULT_PLATFORM_NAME);
    }

    public static String getAutomationName() {
        return getProperty("automation.name", DEFAULT_AUTOMATION_NAME);
    }

    public static String getDeviceName() {
        return getProperty("device.name", DEFAULT_DEVICE_NAME);
    }

    public static String getAppPath() {
        return getProperty("app.path", DEFAULT_APP_PATH);
    }

    public static String getAppPackage() {
        return getProperty("app.package", DEFAULT_APP_PACKAGE);
    }

    public static String getAppActivity() {
        return getProperty("app.activity", DEFAULT_APP_ACTIVITY);
    }

    public static int getImplicitWait() {
        return getIntProperty("implicit.wait", DEFAULT_IMPLICIT_WAIT);
    }

    public static int getExplicitWait() {
        return getIntProperty("explicit.wait", DEFAULT_EXPLICIT_WAIT);
    }

    public static boolean getAutoGrantPermissions() {
        return Boolean.parseBoolean(getProperty("auto.grant.permissions", "false"));
    }

    public static boolean getNoReset() {
        return Boolean.parseBoolean(getProperty("no.reset", "false"));
    }

    public static int getNewCommandTimeout() {
        return getIntProperty("new.command.timeout", 3600);
    }
} 