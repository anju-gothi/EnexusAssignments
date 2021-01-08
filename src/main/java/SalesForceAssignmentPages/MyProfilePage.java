package SalesForceAssignmentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyProfilePage extends BasePage {
   By editLink=By.xpath("//div//a[@class='contactInfoLaunch editLink']//img");
    By editPopUPWindow=By.cssSelector("#contactInfo");

    public WebElement geteditLlink(){
        return getElement(editLink);
    }

    public WebElement geteditPopup(){
        return getElement(editPopUPWindow);
    }

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return driver.getTitle();
    }

  public void clickOnedditLink() throws InterruptedException {
        wait(geteditLlink());
        System.out.println(geteditLlink().isDisplayed());
       // geteditLlink().click();
        jsclick(geteditLlink());

  }

}
