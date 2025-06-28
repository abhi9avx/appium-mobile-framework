# 📱 Appium Test Framework

> A comprehensive mobile automation testing framework built with Appium, Java, and TestNG for cross-platform mobile application testing.

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Appium](https://img.shields.io/badge/Appium-9.4.0-blue.svg)](https://appium.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.11.0-green.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-red.svg)](https://maven.apache.org/)

## 🎯 Overview

This framework provides a robust foundation for mobile test automation, supporting both Android and iOS platforms. It demonstrates best practices for mobile testing with real-world examples including system apps (Settings) and custom applications (Slice app).

### ✨ Key Features

- 🔄 **Cross-Platform Support** - Android & iOS test execution
- 🏗️ **Modular Architecture** - Separate base classes for different app types
- 🎯 **Page Object Pattern** - Maintainable and scalable test structure (framework structure ready)
- 📊 **Comprehensive Reporting** - Detailed test execution reports
- 🔧 **Flexible Configuration** - Easy test suite management with TestNG
- ⚡ **Parallel Execution** - Support for concurrent test runs
- 🧪 **Real-World Examples** - Settings app and custom Slice app testing

## 🛠️ Technology Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 17+ | Programming language |
| **Appium** | 9.4.0 | Mobile automation framework |
| **Selenium** | 4.33.0 | WebDriver implementation |
| **TestNG** | 7.11.0 | Testing framework |
| **Maven** | 3.6+ | Build and dependency management |

## 📂 Project Structure

```
AppiumTestFramework/
├── 📁 src/
│   ├── 📁 main/java/com/abhi/appium/          # Main source code
│   └── 📁 test/java/com/abhi/appium/          # Test classes
│       ├── 📁 Demo/                           # Android Settings app tests
│       │   ├── DemoBaseTest.java              # Base class for Android Settings
│       │   └── SettingsTest.java              # Android Settings test scenarios
│       ├── 📁 ios/                            # iOS specific tests
│       │   ├── iOSBaseTest.java               # iOS base test class
│       │   └── SettingsIOSTest.java           # iOS Settings tests
│       ├── 📁 slice/                          # Slice app tests
│       │   ├── SliceBaseTest.java             # Base class for Slice app
│       │   └── SliceAppTest.java              # Slice app test scenarios
│       └── 📁 framework/                      # Framework components (structure ready)
│           ├── 📁 base/                       # Base classes
│           ├── 📁 drivers/                    # Driver management
│           ├── 📁 enums/                      # Enumerations
│           ├── 📁 pages/                      # Page Object Model
│           │   ├── 📁 common/                 # Common page elements
│           │   │   ├── 📁 android/
│           │   │   └── 📁 ios/
│           │   ├── 📁 dashboard/              # Dashboard pages
│           │   ├── 📁 login/                  # Login pages
│           │   └── 📁 upi/                    # UPI pages
│           ├── 📁 tests/                      # Test classes
│           │   ├── 📁 dashboard/
│           │   ├── 📁 login/
│           │   └── 📁 upi/
│           └── 📁 utils/                      # Utility classes
├── 📄 android-testng.xml                      # Android test suite
├── 📄 ios-testng.xml                          # iOS test suite
├── 📄 pom.xml                                 # Maven configuration
└── 📄 README.md                               # Project documentation
```

## 🏗️ Architecture

### Base Test Classes

#### 🤖 `DemoBaseTest` (Android Settings)
- Manages AndroidDriver lifecycle for Settings app
- Configures Android Settings app capabilities
- Uses UiAutomator2 automation engine
- Handles setup and teardown operations
- **Device**: emulator-5556
- **App Package**: com.android.settings

#### 🍎 `iOSBaseTest` (iOS Settings)
- Manages IOSDriver lifecycle for iOS Settings
- Configures iOS Settings app capabilities
- Uses XCUITest automation engine
- Handles iOS setup and teardown
- **Device**: iPhone 16 Pro (iOS 18.5)
- **Bundle ID**: com.apple.Preferences

#### 🔷 `SliceBaseTest` (Custom Slice App)
- Manages AndroidDriver for Slice app
- Configures custom app capabilities
- Uses UiAutomator2 automation engine
- Handles custom app setup and teardown
- **Device**: emulator-5554
- **App Package**: indwin.c3.shareapp.test

### Test Classes

| Test Class | Platform | Purpose | Status |
|------------|----------|---------|--------|
| `SettingsTest` | Android | System Settings app automation | ✅ Active |
| `SettingsIOSTest` | iOS | iOS Settings app automation | ✅ Active |
| `SliceAppTest` | Android | Custom Slice app functionality | ✅ Active |

### Framework Structure (Ready for Extension)

The framework includes a comprehensive structure for implementing Page Object Model:

- **Pages**: Organized by feature (login, dashboard, UPI, common)
- **Platform-specific**: Separate Android and iOS implementations
- **Tests**: Feature-based test organization
- **Utils**: Reusable utility classes
- **Drivers**: Driver management utilities
- **Enums**: Configuration enumerations

## 🚀 Quick Start

### Prerequisites

Ensure you have the following installed:

- ☕ **Java JDK 17+**
- 📦 **Maven 3.6+**
- 📱 **Android SDK** (for Android testing)
- 🍎 **Xcode** (for iOS testing)
- 🔧 **Appium Server**
- 📲 **Connected device or emulator**

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd AppiumTestFramework
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Start Appium server**
   ```bash
   appium
   ```

4. **Connect your device**
   - For Android: Connect device via USB or start emulator
   - For iOS: Connect device or start iOS simulator

## 🎮 Running Tests

### Command Line Execution

#### Run All Android Tests
```bash
mvn clean test -Dplatform=android
```

#### Run All iOS Tests
```bash
mvn clean test -Dplatform=ios
```

#### Run Specific Test Classes
```bash
# Slice app tests only (currently active)
mvn test -Dtest=SliceAppTest

# Android Settings tests (commented out in suite)
mvn test -Dtest=SettingsTest

# iOS Settings tests
mvn test -Dtest=SettingsIOSTest
```

#### Run with Custom Parameters
```bash
mvn test -Dtest=SliceAppTest -DdeviceName="Pixel 6" -DplatformVersion="13"
```

### IDE Execution

1. **IntelliJ IDEA / Eclipse**
   - Right-click on test class → Run
   - Use TestNG plugin for suite execution

2. **TestNG Suite Files**
   - Run `android-testng.xml` for Android tests
   - Run `ios-testng.xml` for iOS tests

### Current Test Suite Status

#### Android Suite (`android-testng.xml`)
- ✅ **Slice App Tests**: Active
- ⏸️ **Settings Tests**: Commented out (can be enabled)

#### iOS Suite (`ios-testng.xml`)
- ✅ **iOS Settings Tests**: Active

## 📊 Test Reports

After test execution, reports are available in:

```
target/
├── surefire-reports/           # Maven Surefire reports
│   ├── index.html             # Test summary
│   └── TEST-*.xml             # Detailed XML reports
└── test-output/               # TestNG reports
    ├── index.html             # TestNG HTML report
    └── emailable-report.html   # Email-friendly report
```

## ⚙️ Configuration

### TestNG Suite Configuration

#### `android-testng.xml`
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Appium Suite" parallel="false">
    <!-- Settings Tests (currently disabled) -->
    <!-- <test name="Settings App Test">
        <classes>
            <class name="com.abhi.appium.Demo.SettingsTest"/>
        </classes>
    </test> -->

    <!-- Slice App Tests (active) -->
    <test name="Slice App Test">
        <classes>
            <class name="com.abhi.appium.slice.SliceAppTest"/>
        </classes>
    </test>
</suite>
```

#### `ios-testng.xml`
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="iOS Only Suite" parallel="false">
    <test name="iOS Settings App Test">
        <classes>
            <class name="com.abhi.appium.ios.SettingsIOSTest"/>
        </classes>
    </test>
</suite>
```

### Maven Configuration

The framework uses dynamic suite selection through Maven properties:

```xml
<properties>
    <!-- Default to android suite if no platform is provided -->
    <platform>android</platform>
</properties>
```

## 🔧 Customization

### Adding New Tests

1. **Create test class** extending appropriate base class
2. **Add test methods** with `@Test` annotation
3. **Update TestNG suite** files to include new tests
4. **Run tests** to verify implementation

### Adding New Apps

1. **Create new base test class** for the app
2. **Configure app-specific capabilities**
3. **Implement app-specific utilities**
4. **Create test classes** extending the new base class

### Using the Framework Structure

The framework provides a ready-to-use Page Object Model structure:

```java
// Example: Creating a new page class
public class LoginPage {
    private AndroidDriver driver;
    
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }
    
    // Page methods
    public void enterUsername(String username) {
        // Implementation
    }
}
```

## 🐛 Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| **Appium server not running** | Start Appium: `appium` |
| **Device not detected** | Check USB debugging / device connection |
| **App not installed** | Verify app package name and installation |
| **Element not found** | Check locator strategies and wait conditions |
| **Settings test fails** | Ensure Settings app is accessible on device |

### Debug Mode

Enable debug logging by adding to your test:
```java
System.setProperty("appium.debug", "true");
```

### Device Configuration

#### Android Devices
- **Settings App**: emulator-5556
- **Slice App**: emulator-5554
- **Automation**: UiAutomator2

#### iOS Devices
- **Settings App**: iPhone 16 Pro (iOS 18.5)
- **Automation**: XCUITest

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

### Coding Standards

- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Write meaningful test descriptions
- Maintain consistent code formatting
- Use explicit waits for element interactions
- Handle exceptions gracefully

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Abhinav**
- 📧 Email: [your-email@example.com]
- 🐙 GitHub: [@your-github-username]

## 🙏 Acknowledgments

- 📱 [Appium](https://appium.io/) - Mobile automation framework
- 🧪 [TestNG](https://testng.org/) - Testing framework
- 🌐 [Selenium](https://selenium.dev/) - WebDriver implementation
- ☕ Java Community - For continuous support and resources

---

<div align="center">
  <p>⭐ Star this repository if you find it helpful!</p>
  <p>🐛 Found a bug? <a href="../../issues">Report it here</a></p>
</div> 