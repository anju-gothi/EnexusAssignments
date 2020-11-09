package KayakAutomation.com.kayak.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//This class will return the object of browser based on the browser
public class BrowserInit {
    public WebDriver getDriver(String browser){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
       else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        else
            return null;
    }
}
