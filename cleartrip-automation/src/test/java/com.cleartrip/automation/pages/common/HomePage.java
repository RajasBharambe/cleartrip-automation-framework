package com.cleartrip.automation.pages.common;

import com.cleartrip.automation.driver.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

//    Locators (top navigation tabs)
    private By popupLogin = By.xpath("//div[@class='pb-1 px-1 flex flex-middle nmx-1']");
    private By hotelsTab = By.xpath("//p[text()='Hotels']");
    private By backToHome = By.xpath("//a[.//*[local-name()='svg' and contains(@class,'flex-2')]]");
    private By busesTab = By.xpath("//p[text()='Buses']");
    private By holidaysTab = By.xpath("//p[text()='Holidays']");
    private By backToHomeholidaysTab = By.xpath("//div[contains(@class,'navbar-header')]//a[contains(@class,'logo-img')]");

//    Constructor
    public HomePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Close Popup
    public void closePopup() {
        wait.until(ExpectedConditions.elementToBeClickable(popupLogin)).click();
    }

    // Click Hotels
    public void goToHotels() {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsTab)).click();
    }

//    Go to HomePage
    public void goToHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(backToHome)).click();
    }

    //  Click Buses
    public void goToBuses() {
        wait.until(ExpectedConditions.elementToBeClickable(busesTab)).click();
    }

    //    Click Holidays
    public void goToHolidays() {
        wait.until(ExpectedConditions.elementToBeClickable(holidaysTab)).click();
    }

    public void goToHomePageFromHolidays() {
        wait.until(ExpectedConditions.elementToBeClickable(backToHomeholidaysTab)).click();
    }
}
