# 📱 Appium Test Framework

> A streamlined mobile automation testing framework built with Appium, Java, and TestNG for Android application testing.

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Appium](https://img.shields.io/badge/Appium-9.4.0-blue.svg)](https://appium.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.11.0-green.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-red.svg)](https://maven.apache.org/)

## 🎯 Overview

This framework provides a focused foundation for Android mobile test automation. It demonstrates best practices for mobile testing with a real-world example of the Slice app, featuring a complete login flow automation.

### ✨ Key Features

- 🤖 **Android-Focused** - Optimized for Android test execution
- 🏗️ **Clean Architecture** - Streamlined test structure
- 🎯 **Real-World Example** - Complete Slice app automation flow
- 📊 **Comprehensive Reporting** - Detailed test execution reports
- 🔧 **Simple Configuration** - Easy test suite management with TestNG
- ⚡ **Robust Error Handling** - Graceful handling of optional UI elements
- 🧪 **Performance Monitoring** - Built-in execution time tracking

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
│       └── 📁 slice/                          # Slice app tests
│           ├── SliceBaseTest.java             # Base class for Slice app
│           └── SliceAppTest.java              # Slice app test scenarios
├── 📄 android-testng.xml                      # Android test suite
├── 📄 pom.xml                                 # Maven configuration
└── 📄 README.md                               # Project documentation
```

## 🏗️ Architecture

### Base Test Class

#### 🔷 `SliceBaseTest` (Slice App)
- Manages AndroidDriver lifecycle for Slice app
- Configures custom app capabilities
- Uses UiAutomator2 automation engine
- Handles setup and teardown operations
- **Device**: emulator-5554
- **App Package**: indwin.c3.shareapp.test
- **App Activity**: com.slice.android.main.SingleActivity

### Test Class

| Test Class | Platform | Purpose | Status |
|------------|----------|---------|--------|
| `SliceAppTest` | Android | Slice app complete login flow | ✅ Active |

### Test Flow

The `SliceAppTest` implements a comprehensive login flow:

1. **App Launch** - Initialize Slice app
2. **System Dialog Handling** - Gracefully handle optional system dialogs
3. **DLS Button** - Navigate to login section
4. **Primary Button** - Proceed to login
5. **Permission Handling** - Grant necessary permissions
6. **Mobile Number Input** - Enter phone number (8278650784)
7. **OTP Input** - Enter verification code (0000)
8. **MPIN Setup** - Set up security PIN (2580)
9. **Final Verification** - Confirm successful login via avatar display

## 🚀 Quick Start

### Prerequisites

Ensure you have the following installed:

- ☕ **Java JDK 17+**
- 📦 **Maven 3.6+**
- 📱 **Android SDK**
- 🔧 **Appium Server**
- 📲 **Android emulator or device**

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

4. **Start Android emulator**
   ```bash
   # Ensure emulator-5554 is running
   adb devices
   ```

5. **Verify app installation**
   ```bash
   # Check if Slice app is installed
   adb shell pm list packages | grep indwin.c3.shareapp.test
   ```

## 🎮 Running Tests

### Command Line Execution

#### Run All Tests
```bash
mvn clean test
```

#### Run Specific Test Class
```bash
mvn test -Dtest=SliceAppTest
```

#### Run with Debug Information
```bash
mvn test -X
```

### IDE Execution

1. **IntelliJ IDEA / Eclipse**
   - Right-click on `SliceAppTest.java` → Run
   - Use TestNG plugin for suite execution

2. **TestNG Suite File**
   - Run `android-testng.xml` for test suite execution

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
    <test name="Slice App Test">
        <classes>
            <class name="com.abhi.appium.slice.SliceAppTest"/>
        </classes>
    </test>
</suite>
```

### Maven Configuration

The framework uses a simplified Maven configuration:

```xml
<configuration>
    <suiteXmlFiles>
        <suiteXmlFile>android-testng.xml</suiteXmlFile>
    </suiteXmlFiles>
    <testFailureIgnore>false</testFailureIgnore>
</configuration>
```

## 🔧 Customization

### Adding New Tests

1. **Create test class** extending `SliceBaseTest`
2. **Add test methods** with `@Test` annotation
3. **Update TestNG suite** files to include new tests
4. **Run tests** to verify implementation

### Modifying Test Flow

The current test flow can be customized by modifying `SliceAppTest.java`:

```java
@Test
public void testSliceAppFlowWithDuration() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    
    // Add your custom test steps here
    // Example: wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
}
```

### Performance Monitoring

The framework includes built-in performance tracking:

```java
// Start timer
long startTime = System.currentTimeMillis();

// Your test steps here

// Calculate duration
long endTime = System.currentTimeMillis();
long durationInMillis = endTime - startTime;
System.out.println("⏱️ Execution took: " + durationInMillis + " ms");
```

## 🐛 Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| **Appium server not running** | Start Appium: `appium` |
| **Device not detected** | Check `adb devices` output |
| **App not installed** | Verify app package: `indwin.c3.shareapp.test` |
| **Element not found** | Check locator strategies and wait conditions |
| **System dialog issues** | Framework handles missing dialogs gracefully |

### Debug Mode

Enable debug logging:
```java
System.setProperty("appium.debug", "true");
```

### Device Configuration

#### Android Device
- **Device**: emulator-5554
- **Automation**: UiAutomator2
- **App Package**: indwin.c3.shareapp.test
- **App Activity**: com.slice.android.main.SingleActivity

### Test Data

Current test uses these credentials:
- **Mobile Number**: 8278650784
- **OTP**: 0000
- **MPIN**: 2580

## 📈 Performance Metrics

### Recent Test Executions

| Run | Duration | Status |
|-----|----------|--------|
| 1st | 37,051 ms | ✅ Pass |
| 2nd | 35,132 ms | ✅ Pass |
| 3rd | 35,966 ms | ✅ Pass |
| 4th | 35,966 ms | ✅ Pass |

**Average Execution Time**: ~36,050 ms

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
- Include performance monitoring

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