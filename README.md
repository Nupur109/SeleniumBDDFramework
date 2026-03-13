# Selenium BDD Automation Framework

## Overview
A robust test automation framework built using Selenium WebDriver, Cucumber BDD, TestNG and Java. Designed for web application testing with a config driven approach and detailed reporting.
Application Under Test: SauceDemo (https://www.saucedemo.com)
 
## Technologies Used
- Java 17
- Selenium WebDriver 4.41.0
- Cucumber BDD 7.34.3
- TestNG
- Extent Reports
- Maven
- Page Object Model (POM)

## Framework Structure

SeleniumBDDFramework/
├── src/test/java
│   ├── base/          → BaseClass, driver setup
│   ├── pageObjects/   → Page Object classes
│   ├── stepDefinitions/ → Cucumber step definitions
│   ├── runners/       → TestNG runner
│   └── utils/         → Utility methods
├── src/test/resources
│   ├── features/      → Cucumber feature files
│   └── config/        → config.properties
```

## How to Run
1. Clone the repository
2. Open project in Eclipse as Maven project
3. Update config.properties to change browser(chrome/firefox/edge)
4. Run RunnerClass.java as TestNG Test

## Reports
- Extent Report generated in /reports folder
- Cucumber HTML report also generated
