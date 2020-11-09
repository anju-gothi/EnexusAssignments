package TestKayakAutomation.com.kayak.testPages;

import KayakAutomation.com.kayak.util.ExcelReader;
import KayakAutomation.com.kayak.util.ExtentReportUtility;
import TestKayakAutomation.com.kayak.testBase.BaseTestPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class TestPage1 extends BaseTestPage {

    @Test()
    public void clickOnFlight() throws IOException {
        //this line we have to write in each Test method.First line
        ExtentReportUtility.extentTest=ExtentReportUtility.extent.startTest("clickOnFlight");
        objPage1.clickOnFlight();
    }

}
