UI Automation Framework — DemoWebShop

UI test automation framework for demowebshop.tricentis.com, built with Java, Playwright, and TestNG using the Page Object pattern.

Stack:
- Java + Gradle (Kotlin DSL)
- Playwright
- TestNG
- Page Object + Steps pattern

Structure:
- Page/ — Page Objects (BasePage, HomePage, LoginPage, RegistrationPage)
- config/ConfigReader.java — reads settings from config.properties
- BaseLoginTest.java — opens/closes the browser before and after each test
- Test classes: LoginTest, LogoutTest, RegistrationTest, SearchTest
- 
Tests:
- Successful registration
- Successful login
- Logout
- Invalid login
- Search product

Configuration
Settings live in src/test/resources/config.properties: base.url, browser, headless, timeout.

Run
./gradlew test
