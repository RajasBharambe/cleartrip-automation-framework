package com.cleartrip.automation.tests;

import com.cleartrip.automation.base.BaseTest;
import com.cleartrip.automation.pages.common.HomePage;
import org.testng.annotations.Test;

public class SanityTest extends BaseTest {

    @Test
    public void verifyNavigationTabs() {

        HomePage homePage = new HomePage();

        homePage.closePopup();
//      homePage.goToFlights();
        homePage.goToHotels();
        homePage.goToBuses();
        homePage.goToHomePage();
        homePage.goToHolidays();
        homePage.goToHomePageFromHolidays();
    }
}
