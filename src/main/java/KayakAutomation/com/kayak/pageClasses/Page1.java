package KayakAutomation.com.kayak.pageClasses;

import KayakAutomation.com.kayak.base.BaseClass;
import KayakAutomation.com.kayak.pageClasses.FlightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page1 extends BaseClass {
   private By flight = By.xpath("//div[@class='RVNB-menu-item-title' and contains(text(),'Flights')]");

    public Page1(WebDriver driver) {
        super(driver);
    }
    public WebElement getFlightButton(){
       return getElement(flight);
   }

   public FlightPage clickOnFlight(){
       getFlightButton().click();
       return new FlightPage(driver);
    }

}
