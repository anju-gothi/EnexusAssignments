package TestKayakAutomation.com.kayak.testPages;

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

    @Test(dataProvider = "getDatafromExcel")
    public void testEnterOrigin(String origin,String dest,String depDate,String retunDate) throws InterruptedException {
        ExtentReportUtility.extentTest=ExtentReportUtility.extent.startTest("testEnterOrigin");
        fg = objPage1.clickOnFlight();
        fg.enterOrigin(origin);
        fg.enterDestination(dest);
        fg.enterDate(depDate,retunDate);
        //fg.clickOnNearbyAirport("SFO");
        fg.clickOnSearch();
    }

    @DataProvider
    @Test()
    public Iterator<Object[]> getDatafromExcel() throws IOException {
        reader.writeinExcel();
        List<Object[]> list=reader.readFile();
        return list.iterator();
    }


    /*@Test(priority = 2)
    public void testEnterDestination() throws InterruptedException {
        ExtentReportUtility.extentTest=ExtentReportUtility.extent.startTest(" testEnterDestination");
        fg.enterDestination("Hawaii");
    }
    @Test(priority = 3)
    public void testEnterDate() throws InterruptedException {
        ExtentReportUtility.extentTest=ExtentReportUtility.extent.startTest("testEnterDate");
        fg.enterDate("November 30","January 30");
    }
    @Test(priority = 4)
    public void testNearbyAirport() throws InterruptedException {
        ExtentReportUtility.extentTest=ExtentReportUtility.extent.startTest("testNearbyAirport");
        fg.clickOnNearbyAirport("SFO");
    }
    @Test(priority = 5)
    public void testSearch(){
        ExtentReportUtility.extentTest=ExtentReportUtility.extent.startTest("testSearch");
        fg.clickOnSearch();
    }*/
}
