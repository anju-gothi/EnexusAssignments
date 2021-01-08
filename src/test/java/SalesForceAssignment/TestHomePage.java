package SalesForceAssignment;

import SalesForceAssignmentPages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;

public class TestHomePage extends BaseTest{

   /* After salesforce application launch check for the user menu drop down on the web page	User menu drop down shpuld be available
    Click on the user menu for <username> drop down	Drop down with "My profile", "My Settings", "Developer Console","Logout" , "Switching to lightning Experience" is displayed*/
   @Test()
    public void verifyDropdown(){
    List<String> menuList=home.dropDown();
    System.out.println(menuList);
   }
}
