package TestKayakAutomation.com.kayak.testBase;

import KayakAutomation.com.kayak.base.BaseClass;
import KayakAutomation.com.kayak.pageClasses.FlightPage;
import KayakAutomation.com.kayak.pageClasses.Page1;
import KayakAutomation.com.kayak.util.BrowserInit;
import KayakAutomation.com.kayak.util.ExcelReader;
import KayakAutomation.com.kayak.util.ExtentReportUtility;
import KayakAutomation.com.kayak.util.ProprtyUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTestPage {
    public Page1 objPage1;
    public FlightPage flightpage;
    public WebDriver driver;
    public BrowserInit browserObject;
    public ProprtyUtil props;
    public ExcelReader reader;


    @BeforeTest
    public void setUp()
    {
        browserObject=new BrowserInit();
        //call method from PropertyUtil
        props= new ProprtyUtil();
        //Java Factory Pattern for initialing object of Webdriver.
        driver= browserObject.getDriver(props.getValue("browser"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //OBJECT OF Utility file reading data from Exel file.
        reader = new ExcelReader();
        objPage1 = new Page1(driver);
        flightpage = new FlightPage(driver);
        ExtentReportUtility.extentReport();
    }
    @BeforeMethod
    public void getPage(){
        driver.get(props.getValue("url"));
    }
   @AfterMethod
    public void tearDown(ITestResult result){
       ExtentReportUtility.generateReport(result,driver);
        driver.close();
    }

    @AfterTest
    public void endTest(){
        ExtentReportUtility.tearDown();
    }
}
