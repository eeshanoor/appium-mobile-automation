# Appium Mobile Automation
> **Eesha Noor** | SDET | Java + Appium + TestNG

## Tech Stack
- Java 11
- Appium 2.x
- TestNG
- Maven
- Page Object Model
- Android & iOS support

## Test Coverage (SauceDemo Mobile App)
- Login: valid/invalid credentials
- Products: listing, sorting, add to cart
- Cart: review and checkout

## Prerequisites
- Appium Server running: `appium`
- Android emulator / real device connected
- iOS Simulator (Mac only)

## Run Tests
```bash
mvn clean test -Dplatform=android
mvn clean test -Dplatform=ios
```

## Project Structure
```
src/test/java/com/eeshanoor/
├── base/       BaseTest.java
├── screens/    LoginScreen.java, HomeScreen.java, CartScreen.java
├── tests/      LoginTest.java, CartTest.java
└── utils/      AppiumUtils.java
```