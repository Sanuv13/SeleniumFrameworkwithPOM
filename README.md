**SeleniumFrameWorkWithPOm**

A complete Selenium automation framework built using Page Object Model (POM), TestNG, Maven, Allure Reports, Log4j2, Assertions, Listeners, and Excel-based Test Data.

This framework automates the OpenCart application (https://awesomeqa.com/ui/
) with a scalable and maintainable structure suitable for SDET-level interview and real-time project usage.

**Tech Stack**

Java 17+
Selenium WebDriver
TestNG
Maven
Page Object Model (POM)
Log4j2
Allure Reports
Apache POI (Excel Data Reading)
WebDriverManager
Custom TestNG Listeners
Assertions (Hard & Soft)

**Project Structure**
SeleniumFrameWorkWithPOm
└── src
├── test
│    ├── java
│    │    ├── base
│    │    ├── pages
│    │    ├── tests
│    │    ├── utils
│    │    └── listeners
│    └── resources
│         ├── testdata
│         │     └── TestData.xlsx
│         ├── config.properties
│         └── log4j2.xml
└── pom.xml

****Framework Features**
-Page Object Model (POM)
Each page is separated into independent classes with clean locators & methods.
-TestNG Used for:Test execution ,Parallel execution
-Assertions -Grouping test cases
DataProviders
-Log4j2 Logging- Centralized logging for debugging & execution tracking.
-Excel Sheet for Test Data (Apache POI)- Read data for login, address book, form filling, etc.
Supports DataProvider → Excel integration.
-Allure Reporting
Beautiful HTML reports showing:
Steps
Screenshots
Failed/Passed test details
-Listeners
Custom listeners added for:Screenshot on failure
Logging
Report attachments
Configuration File (config.properties)

Example:

baseURL = https://awesomeqa.com/ui/
browser = chrome
username = test@example.com
password = Test@123
implicitWait = 20
pageLoadTimeout = 30

Automated Modules
OpenCart – Address Book Module
Login
Navigate to Account → Address Book
Add new address
Edit address
Delete address
Validate UI elements
Mandatory field validation
Test Scenarios Covered

✔ Verify user can login
✔ Verify navigation to Address Book
✔ Verify user can add a new address
✔ Verify user can edit an existing address
✔ Verify user can delete an address
✔ Verify validations for mandatory fields
✔ Verify UI elements like textboxes, dropdowns, buttons
-How to Run Tests
Run tests using Maven:
mvn clean test
Run a specific TestNG XML:
mvn clean test -DsuiteXmlFile=testng.xml
Generate Allure Report
After running tests:
allure serve allure-results
POM Dependencies
Your pom.xml should include:
Selenium
TestNG
Log4j2
WebDriverManager
Apache POI
Allure
Author

Sanu Sachan
SDET | Automation Engineer