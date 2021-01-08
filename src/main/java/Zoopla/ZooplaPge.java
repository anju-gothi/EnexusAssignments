package Zoopla;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/*
go to this url -https://www.zoopla.co.uk/
       1. Input location London and click submit
        2.You will get a list of properties on that page.
       3. Print all the price values in sorted order (descending order) on the console
       4. I need to select the 5th property on that list (its changing every minute, so it’s dynamic)
       5. On the next page, there is a logo, name and telephone no of the agent. I need to click on the name link to get into the agent’s page.
       6. Once on that page, I need to check that the the properties listed there belong to the same mentioned agent on the page.
*/



public class ZooplaPge extends BasePage{
    String cookie="//form//button[@class='ui-button-secondary']";
    String inputBox="#search-input-location";
    String submit="#search-submit";
    String priceContainer1="//div[@class='css-2119rz-PropertyDetails e1iw5dxq8']//p[@class='css-1d37cx5-Text-StyledPropertyPrice e1iw5dxq6']";
    String priceContainer2="//div[@class='css-1e28vvi-PriceContainer e2uk8e8']//p[@class='css-18tfumg-Text eczcs4p0']";
    String imageLink="//a[@data-testid='listing-details-image-link']";
    String agentName=".dp-sidebar-wrapper__contact  .ui-agent__text h4";
    //div[@class='css-1e28vvi-PriceContainer e2uk8e8']//p
    public ZooplaPge(WebDriver driver){
        super(driver);
       // PageFactory.initElements(driver,ZooplaPge.class);
    }
   /* @FindBy(css=".search-input-location-placeholder")
    WebElement inputBox;
    @FindBy(xpath = "//form[@id='cookie-consent-form']")
    WebElement form;
    @FindBy(xpath="//form//button[@class='ui-button-secondary']")
    WebElement cookie;
   */
//1. Input location London and click submit
    public void setInputBox(String country) throws InterruptedException {
        System.out.println(driver.findElement(By.xpath(cookie)).isDisplayed());
        //click on cookie form
        action.moveToElement(driver.findElement(By.xpath(cookie))).click().build().perform();
       WebElement input=driver.findElement(By.cssSelector(inputBox));
       input.sendKeys(country);
       input.sendKeys(Keys.ENTER);
    }

    //2.You will get a list of properties on that page.
    public String getTitle(){
        return driver.getTitle();
    }
      // 3. Print all the price values in sorted order (descending order) on the console
    public List<Integer> printPrice(){
         List<WebElement> priceList=driver.findElements(By.xpath(priceContainer1));
         priceList=driver.findElements(By.xpath(priceContainer2));
         List<Integer> list=new ArrayList<>();
         StringBuilder builder;
         for(WebElement price:priceList){
             System.out.println(price.getText());
            builder= new StringBuilder();
             String[] array=(price.getText().substring(1).split(","));
             for(String s:array){
                 builder.append(s);
             }
             list.add(Integer.parseInt(builder.toString()));
         }
        Collections.sort(list);
        return list;
    }

     //4. I need to select the 5th property on that list (its changing every minute, so it’s dynamic)
    public void selectProperty(int index){
       List<WebElement> imageList=driver.findElements(By.xpath(imageLink));
       System.out.println(imageList.size());
       if(imageList.size()>index)
       //imageList.get(index).click();
           js.executeScript("arguments[0].click()",imageList.get(index));
    }

    //    5. On the next page, there is a logo, name and telephone no of the agent. I need to click on the name link to get into the agent’s page.
public void clickOnAgentname(){
        WebElement agent=driver.findElement(By.cssSelector(agentName));
        if(agent.isDisplayed())
        agent.click();
}

 
}
