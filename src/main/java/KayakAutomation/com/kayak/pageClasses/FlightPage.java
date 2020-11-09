package KayakAutomation.com.kayak.pageClasses;

import KayakAutomation.com.kayak.base.BaseClass;
import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FlightPage extends BaseClass {
    //locator of cross button
    By crossButton = By.xpath("//button[@class='Button-No-Standard-Style js-remove-selection _iae _h-Y']");
    //locator of Origin
    By origin = By.xpath("(//input[@aria-label='Flight origin input'])[1]");
    //locator of Destination
    By destination = By.xpath("(//div[@aria-label='Flight destination input'])[1]");
    //locator for input Destination
    By destInput=By.xpath("(//input[@aria-label='Flight destination input'])[1]");
    //locator of Datepicker
    By dateInput = By.xpath("(//div[@class='_iaf _iEU _iam _iai'])[1]");
    //Locator of monthsName
    By month = By.xpath("//div[@class='_ijM _iAr _iaB _idE _iXr']");
    //locator for nextArrowOfMonth
    By arrowButton = By.cssSelector("#stl-jam-cal-nextMonth");
    //locator for Days
    By days = By.xpath("//div[@role='gridcell' and @tabindex='0']");
    //locator for plus sign, Nearby Airports
    By plusOrigin=By.xpath("//div[@aria-label='Flight origin input' and @data-placeholder='From?']/div[1]/div/div[1]");
    //loctor for NearByAirports popup
    By airportsPopup=By.xpath("//ul[@class='nearbyList']");
    //Locator for CheckBox Label
    By ckeckboxLabel = By.xpath("//div[contains(@class,'multi-select-container')]//div[@class='multiAirportCheckbox__code']");
    //locator for search Button
    By searchButton= By.xpath("(//span[@class='v-c-p centre '])[1]");

    public FlightPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getOrigin(){
        return getElement(origin);
    }

    public WebElement getCrossButton(){
         return getElement(crossButton);
    }

    public WebElement getDestination(){
        return getElement(destination);
    }

    public WebElement getDestInput(){
        return getElement(destInput);
    }

    public WebElement getDateInput(){
        return getElement(dateInput);
    }

    public List<WebElement> getMonth(){
        return getElementlist(month);
    }

    public WebElement getNextMonth(){
          return getElement(arrowButton);
    }

    public List<WebElement> getDays(){
        return getElementlist(days);
    }
    public WebElement getAirportPopup(){
        return getElement(airportsPopup);
    }

    public List<WebElement> getcheckBoxLabel(){
        return getElementlist(ckeckboxLabel);
    }

    public WebElement getPlus(){
     return getElement(plusOrigin);
    }

    public WebElement getsearchButton(){
        return getElement(searchButton);
    }



    //Enter city in the Origin box
    public void enterOrigin(String city){
        //clicking on cross
        js.executeScript("arguments[0].click()",getCrossButton());
        wait(getOrigin());
       //entering origin
        getOrigin().sendKeys(city);
        getOrigin().sendKeys(Keys.ENTER);

    }

    //Select Nearby Airports
    public void clickOnNearbyAirport(String airportName) throws InterruptedException {
        WebElement nearbyAirports=null;
        try {
             js.executeScript("arguments[0].click()",getPlus());
            // wait(getAirportPopup());
             nearbyAirports = getAirportPopup();
        }catch (Exception e)
        {
            if(nearbyAirports==null)
                System.out.println("not clicked");
        }
        //Thread.sleep(5000);
        if(getAirportPopup().isDisplayed()){
       List<WebElement> listOfName= getcheckBoxLabel();
       System.out.println("size of the list:"+listOfName.size());
       for(WebElement e:listOfName){
           System.out.println(e.getText());
           if(e.getText().equals(airportName))
           {
           js.executeScript("arguments[0].click()",e);
           driver.findElement(By.cssSelector("#eGMj")).click();
           }
       }
    }
    }

    //Enter city in the Destination box
    public void enterDestination(String city) throws InterruptedException {
        getDestination().click();
        getDestInput().sendKeys(city);
        getDestInput().sendKeys(Keys.ENTER);
        //Thread.sleep(2000);
    }

    //Enter Date in Date picker
    public void enterDate(String depDate,String returnDate) throws InterruptedException {

        getDateInput().click();
        Thread.sleep(2000);
        clickMonth(depDate);
        clickMonth(returnDate);
    }


//This method will check the date and get the attribute of the perticular date
    private void clickMonth(String date) throws InterruptedException {
       String[] array= date.split(" ");
       String monthName=array[0];
        List<WebElement> days = getDays();
        String aria=" ";
        for(WebElement d : days) {
            aria = d.getAttribute("aria-label");
            if (aria.contains(monthName)) {
               // System.out.println(aria);
                if(aria.contains(date)) {
                    d.click();
                    break;
                }
            }
        }
        if(!(aria.contains(monthName)))
        {
            getNextMonth().click();
            //Thread.sleep(2000);
            clickMonth(date);
        }
    }

    public void clickOnSearch(){
        getsearchButton().click();
    }

}
