package ZooplaAssignmentTest;

import Zoopla.ZooplaPge;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZooplaTest {
    WebDriver driver;
    ZooplaPge page;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("https://www.zoopla.co.uk/");
         page=new ZooplaPge(driver);
        // driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void  inputBox() throws InterruptedException {
         page.setInputBox("London");
    }
    @Test(priority = 2)
    public  void verifyTitle(){
        System.out.println(page.getTitle());
        Assert.assertEquals("Property for Sale in London - Buy Properties in London - Zoopla",page.getTitle());
    }
    @Test(priority = 3)
    public void getPriceList(){
       List<Integer> list= page.printPrice();
       System.out.println(list);
    }
    @Test(priority = 4)
    public void testSelectProperty(){
        page.selectProperty(5);
        System.out.println(page.getTitle());
    }
    @Test(priority = 5)
    public void testAgentInfo() throws InterruptedException {
        page.clickOnAgentname();
        System.out.println(page.getTitle());
        //Assert.assertEquals("Location Location, N16 - Estate and Letting Agents - Zoopla",page.getTitle());
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}
