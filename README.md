# Cleartrip Automation Framework

A Selenium WebDriver + TestNG test automation framework in Java for [Cleartrip.com](https://www.cleartrip.com), built using the **Page Object Model (POM)** design pattern. The framework automates flight search scenarios across multiple fare types and validates core site navigation.

## ✨ Features

- **Page Object Model** structure for maintainable, reusable page interactions
- **Data-driven testing** for flight search using TestNG `@DataProvider`, covering combinations of:
  - Student fare
  - Senior citizen fare
  - Armed forces fare
  - Non-stop flights filter
  - Cleartrip for Work (with login-popup verification)
- **Sanity suite** validating core navigation across Flights, Hotels, Buses, and Holidays tabs
- **Automatic failure screenshots** captured via TestNG `@AfterMethod` hooks
- **Test reporting** via [Allure](https://allurereport.org/) and [ExtentReports](https://www.extentreports.com/)
- **Logging** via Log4j2

## 🛠 Tech Stack

| Category         | Tools                                  |
|-------------------|-----------------------------------------|
| Language          | Java 11                                 |
| Test Framework    | TestNG                                  |
| Browser Automation| Selenium WebDriver 4                    |
| Build Tool        | Maven                                   |
| Reporting         | Allure, ExtentReports                   |
| Logging           | Log4j2                                  |

## 📁 Project Structure

```
cleartrip-automation-framework/
├── src/
│   ├── main/java/com/cleartrip/automation/
│   │   └── driver/
│   │       └── DriverFactory.java        # WebDriver initialization & teardown
│   └── test/java/com.cleartrip/automation/
│       ├── base/
│       │   └── BaseTest.java             # Common setup/teardown, screenshot-on-failure
│       ├── pages/
│       │   ├── common/HomePage.java      # Top-nav interactions
│       │   └── flights/FlightsSearchPage.java
│       └── tests/
│           ├── SanityTest.java           # Navigation sanity checks
│           └── flights/FlightsTest.java  # Data-driven flight search tests
├── drivers/
│   └── chromedriver.exe                  # Local ChromeDriver binary
└── pom.xml
```

## ▶️ Getting Started

### Prerequisites

- Java 11+
- Maven
- Google Chrome (matching version to the bundled ChromeDriver)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/RajasBharambe/cleartrip-automation-framework.git
   cd cleartrip-automation-framework
   ```
2. Ensure the ChromeDriver in `/drivers` matches your installed Chrome version. Update the path in `DriverFactory.java` if running on a non-Windows OS (currently points to `chromedriver.exe`).
3. Run the test suite:
   ```bash
   mvn clean test
   ```

### Viewing Reports

**Allure:**
```bash
mvn allure:serve
```

**ExtentReports:** generated report will be available under `target/` after a test run (configure output path as needed).

## 🚧 Known Limitations / Roadmap

This is an actively evolving personal project — a few things are still in progress:

- [ ] `DriverFactory` currently hardcodes a Windows-style ChromeDriver path; needs to be made OS-agnostic (e.g., via WebDriverManager)
- [ ] Flights navigation from the homepage is not yet wired into `SanityTest` (currently commented out)
- [ ] No CI pipeline yet — tests are run locally via Maven
- [ ] Assertions in `FlightsTest` could be expanded beyond navigation/popup checks to validate actual search results

## 📄 License

Personal/portfolio project — free to reference for learning purposes.

## 👤 Author

**Rajas Bharambe**
QA Automation Engineer | [LinkedIn](https://linkedin.com/in/rajas-bharambe-0b8a87208/) | [GitHub](https://github.com/RajasBharambe)
