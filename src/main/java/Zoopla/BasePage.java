package Zoopla;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    WebDriver driver;
    Actions action;
    JavascriptExecutor js;
    public BasePage(WebDriver driver){
        this.driver=driver;
        action= new Actions(driver);
        js=(JavascriptExecutor)driver;

    }
    public void alertHandle(){


    }
}

