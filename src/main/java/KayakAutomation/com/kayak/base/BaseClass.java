package KayakAutomation.com.kayak.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    public JavascriptExecutor js;
    public WebDriverWait wait;

    public BaseClass(WebDriver driver){
        this.driver=driver;
        js= (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver,15);
        //this configuration line is required for log 4j
       // PropertyConfigurator.configure("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\main\\resource\\log4j.properties");
    }

    //wrapper class for elements
    public WebElement getElement(By locator){
        WebElement element=null;
        try {
            element = driver.findElement(locator);
        }catch (Exception e){
            System.out.println("Element not found");
            e.printStackTrace();
        }
        return element;
    }

    public List<WebElement> getElementlist(By locator){
       List<WebElement> elementsList=null;
        try {
            elementsList=driver.findElements(locator);
        }catch (Exception e){
            e.printStackTrace();
        }
        return elementsList;
    }
  //wrapper class for Explicit wait
     public void wait(WebElement element){
         wait.until(ExpectedConditions.visibilityOf(element));

     }


}
