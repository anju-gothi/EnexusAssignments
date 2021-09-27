package SalesForceAssignmentPages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    By usernameLogin=By.id("username");
    By passwordLogin=By.id("password");
    By submitButton=By.id("Login");
    By userName= By.id("userNavLabel");
    By menuItems=By.cssSelector("#userNav-menuItems a");
    By editLink=By.cssSelector(".contactInfoLaunch.editLink");

    public HomePage(WebDriver driver){
        super(driver);
    }

    //Methods to return webElements

    public WebElement getusernameLogin(){
        return getElement(usernameLogin);
    }

    public WebElement getpasswordLogin(){
        return getElement(passwordLogin);
    }

    public WebElement getsubmitButton(){
        return getElement(submitButton);
    }

    public WebElement getusername(){
        return getElement(userName);
    }

    public List<WebElement> getmenuItems(){
        return getElements(menuItems);
    }
    //Method to launch Site
    public void launchSite(){
        driver.get("https://login.salesforce.com/");
        getusernameLogin().sendKeys("anju@tc.com");
        getpasswordLogin().sendKeys("project112");
        getsubmitButton().click();

    }

    public  List<String> dropDown(){
        getusername().click();
        List<WebElement> dropdownMenu= getmenuItems();
        List<String> menulist=new ArrayList<>();
        String name;
        for(WebElement element:dropdownMenu){
            name=element.getText();
           menulist.add(name);
        }
        return menulist;
    }

    public MyProfilePage myProfile(){
        getusername().click();
        List<WebElement> dropdownMenu= getmenuItems();
        for(WebElement element:dropdownMenu){
            if(element.getText().equals("My Profile")){
                element.click();
                break;
            }
        }
        return new MyProfilePage(driver);
    }

}
