package AutoamteDropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownList {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //Run the test case in Headless mode
       ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        //option.addArguments("--headless");
        driver=new ChromeDriver(option);
        //Run the test case in non-Headless mode
       // driver=new ChromeDriver();
        driver.get("https://www.xe.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void aDropDown() throws InterruptedException {
        //find the locator of down arrow
        WebElement dropButton=driver.findElement(By.xpath("(//div[@class='css-ty0g2a-control converterform-dropdown__control']//*[name()='svg' and @data-id='icon-chevron-down'])[1]"));
        dropButton.click();
        //collect all the drop down elements in the list
        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@id,'react-select')]/span"));
        for(WebElement ele:list){
            System.out.println(ele.getText());
           if(ele.getText().contains("HKD")){
               System.out.println("StrtsWith:"+ele.getText());
               ele.click();
               Thread.sleep(5000);
               break;
           }
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}


//https://developers.google.com/web/tools/chrome-devtools/sources?utm_source=devtools&utm_campaign=2018Q1
//https://stackoverflow.com/questions/44263360/running-cucumber-tests-on-headless-chrome/51201387
