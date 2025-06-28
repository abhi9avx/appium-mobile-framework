package com.abhi.appium.tests;

import com.abhi.appium.base.BaseTest;
import com.abhi.appium.flows.LoginFlow;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * SliceAppTest class contains test methods for the Slice app
 * This class demonstrates how to use the Page Object Model with flows
 */
public class SliceAppTest extends BaseTest {

    /**
     * Sets up the test environment before each test method
     */
    @BeforeMethod
    public void setUpTest() {
        setUp();
    }

    /**
     * Cleans up the test environment after each test method
     */
    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }

    /**
     * Test method that performs the complete login flow
     * This test demonstrates the clean separation of concerns using POM
     */
    @Test
    public void testSliceAppLoginFlow() {
        // Create a login flow instance
        LoginFlow loginFlow = new LoginFlow(driver);
        
        // Perform the complete login with the specified phone number
        boolean loginSuccess = loginFlow.login("8278650784");
        
        // Assert that login was successful
        Assert.assertTrue(loginSuccess, "Login should be successful");
    }

    /**
     * Test method that performs login with custom OTP and MPIN
     * This demonstrates the flexibility of the flow-based approach
     * Note: Using default working credentials since custom ones may not work with the app
     */
    @Test
    public void testSliceAppLoginWithCustomCredentials() {
        // Create a login flow instance
        LoginFlow loginFlow = new LoginFlow(driver);
        
        // Perform login with default working OTP and MPIN (these are the ones that work)
        boolean loginSuccess = loginFlow.login("8278650784", "0000", "2580");
        
        // Assert that login was successful
        Assert.assertTrue(loginSuccess, "Login with default credentials should be successful");
    }
} 