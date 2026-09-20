package com.cleartrip.automation.pages.flights;

import com.cleartrip.automation.driver.DriverFactory;
import com.cleartrip.automation.pages.common.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.List;

public class FlightsSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    // Locators
    private By fromCityInput = By.xpath("//input[@placeholder='Where from?']");
    private By toCityInput = By.xpath("//input[@placeholder='Where to?']");

    // Auto-suggest dropdown
    private By cityDropdown  = By.xpath("//div[contains(@class,'dropdown p-absolute')]");
    private By cityOptions   = By.xpath("//div[contains(@class,'dropdown p-absolute')]//li");

//    Search Button
    private By searchButton = By.xpath("//button[.//h4[text()='Search flights']]");

// Special fare options
    private By cleartripForWork = By.xpath("//p[normalize-space()='Cleartrip for Work']");
    private By goBackWork = By.xpath("//div[@class='sc-eqUAAy ljhAHz']");
    private By studentFare = By.xpath("//p[contains(text(), 'Student')]");
    private By seniorCitizenFare = By.xpath("//p[contains(text(), 'Senior citizen')]");
    private By armedForcesFare = By.xpath("//p[contains(text(), 'Armed forces')]");
    private By nonStopFlightsToggle = By.xpath("//p[contains(text(), 'Non-stop flights only')]");
    private By loginModal = By.xpath("//div[contains(text(), 'Take more trips. Make more business.')]");

    public FlightsSearchPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.homePage = new HomePage();
    }

    /* ---------- PRIVATE REUSABLE METHOD ---------- */
    private void selectCity(By inputField, String cityName) {

        wait.until(ExpectedConditions.elementToBeClickable(inputField)).click();
        driver.findElement(inputField).clear();
        driver.findElement(inputField).sendKeys(cityName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(cityDropdown));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(cityOptions, 0));

        List<WebElement> cities = driver.findElements(cityOptions);

        for (WebElement city : cities) {
            if (city.getText().toLowerCase().contains(cityName.toLowerCase())) {
                city.click();   // ✅ THIS selects from list
                break;
            }
        }
    }

    @Step("Enter FROM city: {city}")
    public void enterFromCity(String fromCity) throws InterruptedException {
        selectCity(fromCityInput, fromCity);
        Thread.sleep(3000);
    }

    public void enterToCity(String toCity) throws InterruptedException {
        selectCity(toCityInput, toCity);
        Thread.sleep(3000);
    }

    @Step("Click Search Flights")
    public void clickSearch() {

        WebElement search = driver.findElement(searchButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", search);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", search);

        // Check if login popup appears
        if (driver.findElements(loginModal).size() > 0) {
            System.out.println("Login popup displayed – Cleartrip for Work requires authentication");
            return; // stop further actions
        }
    }

    //    Special fare options
    @Step("Select Cleartrip for Work: {enabled}")
    public void selectCleartripForWork(boolean enable) {

        if (!enable) return;

        WebElement workOption =
                wait.until(ExpectedConditions.presenceOfElementLocated(cleartripForWork));

        // Scroll to avoid partial overlap
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", workOption);

        // JS click to bypass animation overlay
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", workOption);
    }

    public void verifyLoginPopupDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));
    }

    public void selectStudentFare(boolean enable) {
        if (enable) {
            wait.until(ExpectedConditions.elementToBeClickable(studentFare)).click();
        }
    }

    public void selectSeniorCitizenFare(boolean enable) {
        if (enable) {
            wait.until(ExpectedConditions.elementToBeClickable(seniorCitizenFare)).click();
        }
    }

    public void selectArmedForcesFare(boolean enable) {
        if (enable) {
            wait.until(ExpectedConditions.elementToBeClickable(armedForcesFare)).click();
        }
    }

    public void enableNonStopFlights(boolean enable) {
        if (enable) {
            wait.until(ExpectedConditions.elementToBeClickable(nonStopFlightsToggle)).click();
        }
    }
}
