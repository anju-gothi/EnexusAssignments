package TestKayakAutomation.com.kayak.testPages;

import KayakAutomation.com.kayak.pageClasses.FlightOptionsPage;
import KayakAutomation.com.kayak.pageClasses.FlightPage;
import KayakAutomation.com.kayak.util.ExcelReader;
import KayakAutomation.com.kayak.util.ExtentReportUtility;
import TestKayakAutomation.com.kayak.testBase.BaseTestPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class TestFlightPage extends BaseTestPage {
    FlightPage fg;
    FlightOptionsPage options;

    @Test(dataProvider = "getDatafromExcel")
    public void testEnterOrigin(String origin,String dest,String depDate,String retunDate) throws InterruptedException {
        ExtentReportUtility.extentTest=ExtentReportUtility.extent.startTest("testEnterOrigin");
        fg = objPage1.clickOnFlight();
        fg.enterOrigin(origin);
        Thread.sleep(1000);
        //fg.enterDestination(dest);
        //fg.enterDate(depDate,retunDate);
        fg.clickOnNearbyAirport("SFO");
        //options=fg.clickOnSearch();
        Thread.sleep(2000);
    }

    @DataProvider
    @Test()
    public Iterator<Object[]> getDatafromExcel() throws IOException {
        reader.writeinExcel();
        List<Object[]> list=reader.readFile();
        return list.iterator();
    }
}
