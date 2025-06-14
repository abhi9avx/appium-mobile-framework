# 🚀 Appium Test Framework for Android Settings App

A robust test automation framework using Appium for testing Android Settings application.

## 🎯 Tech Stack

- ☕ Java 21
- 🏗️ Maven
- 🤖 Appium
- 📱 Android Studio
- 🔧 TestNG

## 📋 Prerequisites

### ☕ Java Setup
1. **Install Java JDK 21**
   ```bash
   # For macOS using Homebrew
   brew install openjdk@21

   # Verify installation
   java -version
   ```

2. **Set JAVA_HOME**
   ```bash
   # For macOS
   echo 'export JAVA_HOME=$(/usr/libexec/java_home)' >> ~/.zshrc
   source ~/.zshrc
   ```

### 🏗️ Maven Setup
1. **Install Maven**
   ```bash
   # For macOS using Homebrew
   brew install maven

   # Verify installation
   mvn -version
   ```

2. **Maven Configuration**
   - Create `settings.xml` in `~/.m2/`:
   ```xml
   <settings>
     <localRepository>${user.home}/.m2/repository</localRepository>
     <interactiveMode>true</interactiveMode>
     <offline>false</offline>
   </settings>
   ```

### 📱 Android Studio Setup

1. **Install Android Studio**
   - Download from [Android Studio Website](https://developer.android.com/studio)
   - Install and launch Android Studio

2. **Create Android Virtual Device (AVD)**
   - Open Android Studio
   - Click on "Tools" > "Device Manager"
   - Click "Create Virtual Device"
   - Select a phone (e.g., Pixel 4)
   - Select system image (e.g., API 33)
   - Complete the AVD creation

3. **Start Emulator**
   - In Device Manager, click the play button next to your AVD
   - Wait for emulator to start completely

### 🤖 Appium Setup

1. **Install Node.js and npm**
   ```bash
   # For macOS using Homebrew
   brew install node

   # Verify installation
   node -v
   npm -v
   ```

2. **Install Appium**
   ```bash
   npm install -g appium
   ```

3. **Install Appium Doctor**
   ```bash
   npm install -g appium-doctor
   ```

4. **Verify Installation**
   ```bash
   appium-doctor
   ```

5. **Start Appium Server**
   ```bash
   appium
   ```

## 🏗️ Project Setup

1. **Clone Repository**
   ```bash
   git clone [your-repository-url]
   cd AppiumTestFramework
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

## 📁 Project Structure

```
AppiumTestFramework/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── abhi/
│   │               └── appium/
│   │                   └── utils/
│   └── test/
│       └── java/
│           └── com/
│               └── abhi/
│                   └── appium/
│                       ├── BaseTest.java
│                       └── SettingsTest.java
├── pom.xml
└── README.md
```

## 🏃‍♂️ Running Tests

1. **Start Appium Server**
   ```bash
   appium
   ```

2. **Start Android Emulator**
   - Launch from Android Studio Device Manager
   - Or use command line:
   ```bash
   emulator -avd [your-avd-name]
   ```

3. **Run Tests**
   ```bash
   # Run all tests
   mvn test

   # Run specific test class
   mvn test -Dtest=SettingsTest

   # Run with debug logs
   mvn test -Dmaven.surefire.debug
   ```

## 🔧 Configuration

### BaseTest.java
Contains the core setup for Appium:
- Driver initialization
- Capabilities configuration
- Basic setup and teardown methods

### SettingsTest.java
Contains test cases for Android Settings app:
- App launch verification
- Basic functionality tests

## 🛠️ Troubleshooting

### ☕ Java Issues
- Verify JAVA_HOME is set correctly
- Check Java version compatibility
- Ensure PATH includes Java bin directory

### 🏗️ Maven Issues
- Clear Maven cache: `mvn clean`
- Update Maven dependencies: `mvn dependency:purge-local-repository`
- Check Maven settings.xml configuration

### 📱 Emulator Issues
- Ensure AVD is properly created
- Check system image compatibility
- Verify hardware acceleration is enabled

### 🤖 Appium Issues
- Verify Appium server is running
- Check Appium doctor for environment issues
- Ensure correct capabilities are set

### 🧪 Test Failures
- Check emulator/device connection
- Verify app package and activity names
- Check Appium server logs

## 📝 Notes

- Always ensure Appium server is running before executing tests
- Keep emulator running during test execution
- Check logs for detailed error information

## 🔗 Useful Links

- [Java Documentation](https://docs.oracle.com/en/java/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Appium Documentation](http://appium.io/docs/en/about-appium/intro/)
- [Android Studio Guide](https://developer.android.com/studio/intro)
- [TestNG Documentation](https://testng.org/doc/)

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details 