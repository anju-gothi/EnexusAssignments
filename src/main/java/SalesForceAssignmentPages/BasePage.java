package SalesForceAssignmentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions action;
    public  BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,15);

    }


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

    public List<WebElement> getElements(By locator){
        List<WebElement> elements=null;
        try {
            elements= driver.findElements(locator);
        }catch (Exception e){
            System.out.println("Element not found");
            e.printStackTrace();
        }
        return elements;

    }

    //wrapper class for Explicit wait
    public void wait(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //wrapper class for Action class
    public Actions takeAction(){
        action=new Actions(driver);
        return action;
    }

        //wrapper class for javascriptexecuter
        public void jsclick(WebElement element){
            js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].click()",element);

}
}
