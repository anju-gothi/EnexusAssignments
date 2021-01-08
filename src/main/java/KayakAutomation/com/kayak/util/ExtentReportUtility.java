package KayakAutomation.com.kayak.util;

import KayakAutomation.com.kayak.base.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ExtentReportUtility {
    //there are two classes of ExtentReport we are using:Extentreport and ExtentTest.
    public static ExtentReports extent;
    public static ExtentTest extentTest;

    public static void extentReport(){
        extent= new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\java\\KayakAutomation\\com\\kayak\\reports\\extentreport.html",true);
    //we can pass parameters to show on the report
        extent.addSystemInfo("Host name","Anju Gothi");
        extent.addSystemInfo("User name","Global");
        extent.addSystemInfo("EnvironmentName","QAEnvironment");    }

    //All the status of all the testcase stored in ITestResult.
    //we can use result.getStatus(),result.getName() for any testMethod
    //This is TestNg Listeners

    public static void generateReport(ITestResult result,WebDriver driver){
        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL,"Test case Failed is "+result.getName());
            //result.getThrowable() will print error or Exception
            extentTest.log(LogStatus.FAIL,"The Test Case failed "+result.getThrowable());
           //attach Screenshot with extent Report.TestMethod Name is Screenshot name
          String scrPath= ScreenShotUtility.takeScreenshot(driver,result.getName());
          //next step will attach the screenShot in the report using addScreencast()
            extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(scrPath));
            //for attaching video we use addScreencast
         // extentTest.log(LogStatus.FAIL,extentTest.addScreencast(scrPath));
        }else if(result.getStatus()==ITestResult.SKIP){

            extentTest.log(LogStatus.SKIP,"Test Case Skipped "+result.getName());

        }else if(result.getStatus()==ITestResult.SUCCESS){
            extentTest.log(LogStatus.PASS,"Test case pass "+result.getName());
        }
        //ending the test
        extent.endTest(extentTest);
    }
    public static void tearDown(){
        extent.flush();//close the connection and close
        extent.close();
    }

}
