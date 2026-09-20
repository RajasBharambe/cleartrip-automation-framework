package com.cleartrip.automation.tests.flights;

import io.qameta.allure.*;
import com.cleartrip.automation.base.BaseTest;
import com.cleartrip.automation.pages.common.HomePage;
import com.cleartrip.automation.pages.flights.FlightsSearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Cleartrip Automation")
@Feature("Flights Search")
public class FlightsTest extends BaseTest {


    @DataProvider(name = "specialFareOptions")
    public Object[][] specialFareOptions() {
        return new Object[][]{
                {false, false, false, false, false},    // No special fare
                // cleartripWork, student, senior, armed, nonstop
                {false, true, false, false, false},   // Student fare
                {false, false, true, false, false},   // Senior citizen
                {false, false, false, true, false},   // Armed forces
                {true, false, false, false, true},   // Cleartrip Work + Non-stop
        };
    }

    @Test(dataProvider = "specialFareOptions")
    @Story("Search flights with special fare options")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify flight search behavior for different special fare combinations")
    public void verifyFlightSearchWithSpecialFares(
            boolean cleartripWork,
            boolean student,
            boolean senior,
            boolean armed,
            boolean nonStop) throws InterruptedException {

        HomePage homePage = new HomePage();
        FlightsSearchPage flights = new FlightsSearchPage();

        homePage.closePopup();
        flights.enterFromCity("Bengaluru");
        flights.enterToCity("Mumbai");

        flights.selectCleartripForWork(cleartripWork);

        // 🔴 AUTHENTICATION FLOW — STOP HERE
        if (cleartripWork) {
            flights.verifyLoginPopupDisplayed();
            return;
        }

        flights.selectStudentFare(student);
        flights.selectSeniorCitizenFare(senior);
        flights.selectArmedForcesFare(armed);
        flights.enableNonStopFlights(nonStop);

        flights.clickSearch();
    }
}