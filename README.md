# Appium Test Framework

A robust mobile automation testing framework built with Appium, Java, and TestNG for testing Android applications.

## 🚀 Project Overview

This framework is designed to automate testing of Android applications using Appium. It includes test cases for both the Android Settings app and a custom Slice app, demonstrating different automation scenarios.

## 🛠️ Technology Stack

- **Appium**: 9.4.0
- **Selenium**: 4.33.0
- **TestNG**: 7.11.0
- **Java**: Latest version
- **Maven**: For dependency management and build automation

## 📁 Project Structure

```
AppiumTestFramework/
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── abhi/
│                   └── appium/
│                       ├── Demo/
│                       │   ├── DemoBaseTest.java
│                       │   └── SettingsTest.java
│                       └── slice/
│                           ├── SliceBaseTest.java
│                           └── SliceAppTest.java
├── testng.xml
├── pom.xml
├── run_tests.sh
└── README.md
```

### Key Components

1. **Base Test Classes**
   - `DemoBaseTest.java`: Base class for Settings app tests
     - Handles driver initialization for Settings app
     - Manages Appium capabilities specific to Settings app
     - Provides common setup and teardown methods
   
   - `SliceBaseTest.java`: Base class for Slice app tests
     - Handles driver initialization for Slice app
     - Manages Appium capabilities specific to Slice app
     - Provides common setup and teardown methods

2. **Test Classes**
   - `SettingsTest.java`: Tests for Android Settings app
   - `SliceAppTest.java`: Tests for Slice app functionality

3. **Configuration Files**
   - `testng.xml`: TestNG suite configuration
   - `pom.xml`: Maven dependencies and project configuration
   - `run_tests.sh`: Shell script for running tests in loop

## 🏗️ Framework Features

1. **Base Test Classes**
   - `DemoBaseTest`:
     - Extends Appium's AndroidDriver
     - Configures capabilities for Settings app
     - Implements common test setup and teardown
     - Handles driver initialization and cleanup
     - Provides utility methods for Settings app testing
   
   - `SliceBaseTest`:
     - Extends Appium's AndroidDriver
     - Configures capabilities for Slice app
     - Implements common test setup and teardown
     - Handles driver initialization and cleanup
     - Provides utility methods for Slice app testing

2. **Test Scenarios**
   - Settings App:
     - Launch and verify Settings app
     - Element presence verification
     - Robust element location strategies
   
   - Slice App:
     - Initial button interaction
     - DLS button functionality
     - Multiple element verification

3. **Automation Features**
   - Explicit waits for better reliability
   - Multiple locator strategies
   - Error handling and reporting
   - Cross-device compatibility

## 🚀 Getting Started

### Prerequisites

1. Java JDK installed
2. Maven installed
3. Appium Server running
4. Android device/emulator connected
5. Android SDK installed

### Setup

1. Clone the repository:
   ```bash
   git clone [repository-url]
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

3. Start Appium server

4. Connect Android device/emulator

### Running Tests

1. **Single Run**
   ```bash
   mvn test -DsuiteXmlFile=testng.xml
   ```

2. **Multiple Runs**
   ```bash
   ./run_tests.sh
   ```
   This will execute the test suite 10 times in sequence.

## 📊 Test Reports

Test results are generated in the `target/surefire-reports` directory after each test run.

## 🔧 Configuration

### TestNG Suite
The `testng.xml` file contains two test suites:
1. Settings App Test
2. Slice App Test

### Maven Configuration
The `pom.xml` includes all necessary dependencies:
- Appium Java Client
- Selenium Java
- TestNG

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👥 Authors

- Abhinav - Initial work

## 🙏 Acknowledgments

- Appium team for the excellent automation framework
- TestNG team for the testing framework
- Selenium team for the web automation capabilities 