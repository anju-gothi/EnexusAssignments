package SalesForceAssignment;

import SalesForceAssignmentPages.HomePage;
import SalesForceAssignmentPages.MyProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    HomePage home;
    MyProfilePage profilepage;
    /* Launch https://www.login.salesforce.com and provide positive <username> and <password> data to SalesForce Application. 	SalesForce login page is launched and application home page is logged in with correct username.*/
    @BeforeTest
    public void testLaunchSite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
        home=new HomePage(driver);
        profilepage=new MyProfilePage(driver);
        home.launchSite();
    }
    @AfterTest
    public void tearDown(){
       // driver.quit();
    }

}
