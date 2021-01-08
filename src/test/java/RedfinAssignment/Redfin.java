package RedfinAssignment;

/*Testcase to Automate RedFin application
        Please complete the below Selenium test and share the test results
        Design and develop basic scenario for real estate portal redfin.com
        Use Case
        1. Go to https://www.redfin.com
        2. Enter Sunnyvale in the Search box and press the Enter Button
        3. Ensure a POP Up “ Did You Mean” appears
        4. On the pop Up select the entry “Sunnyvale, CA, USA and ensure we are
        navigated to Sunnyvale Real Estate page.
        5. On this page assert the Search box on the top left side has Sunnyvale
        6. Select the min price as 800 and max price as 950
        7. Verify all the homes listed are from Sunnyvale, CA, USA, if no homes listed
        throw an error saying there is no data to test.
        Parametrize this test by selecting “Sunnyvale, Dallas, TX, USA” in the did you mean
        pop up ,and on the search results page use the price range between 600-800.
        log All critical information for reporting
        Give details of the design*/

import com.google.gson.internal.$Gson$Preconditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Redfin {

    String searchBox = "//div[@id='homepageTabContainer']// input[@class='search-input-box'  and @id='search-box-input']";
    String title = "//h3[@data-rf-test-name='title']";
    String popUpList = "//div[@class='item-row clickable']";
    String searchBox2 = "//div[@class='textContent']";
    String minPriceContainer="(//span[@data-rf-test-name='Select'])[1]";
    String dropdown="//div[@class='flyout']//div[@class='option']/span";
    String maxPriceContainer="(//span[@data-rf-test-name='Select'])[3]";
    String homesummary="//div[@class='homes summary']";
    String homes="//div[@class='PhotosView bg-color-white above-the-fold']//div[@class='bottomV2']//a";
    String displayMessage="//div[@class='title']";

    WebDriver driver;

    @BeforeMethod
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //  1. Go to https://www.redfin.com
        driver.get("https://www.redfin.com");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }
   // @Test
    public void redfin() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath(searchBox));
        //  2. Enter Sunnyvale in the Search box and press the Enter Button
        search.sendKeys("Sunnyvale");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        // 3. Ensure a POP Up “ Did You Mean” appears
        WebElement titleOfpopup = driver.findElement(By.xpath(title));
        Assert.assertEquals(titleOfpopup.getText(), "Did You Mean");
        //4. On the pop Up select the entry “Sunnyvale, CA, USA and ensure we are
        //        navigated to Sunnyvale Real Estate page.
        List<WebElement> list = driver.findElements(By.xpath(popUpList));
       // list.get(0).click();
        for(int index=0;index<list.size();index++)
        System.out.println("selected from popupList:"+list.get(index).getText());
        System.out.println("Title of the page:"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Sunnyvale Homes for Sale: Sunnyvale, CA Real Estate | Redfin");
        //5. On this page assert the Search box on the top left side has Sunnyvale
        WebElement element = driver.findElement(By.xpath(searchBox2));
        // System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "Sunnyvale");
        //6. Select the min price as 800 and max price as 950
      WebElement container1= driver.findElement(By.xpath(minPriceContainer));
           container1.click();
        List<WebElement> priceList1=driver.findElements(By.xpath(dropdown));
        String number;
        for(int index=0;index<priceList1.size();index++){
           number= priceList1.get(index).getText();
        if(number.equals("$800k")){
            priceList1.get(index).click();
            break;}
        }
        Thread.sleep(5000);

        //select Max price
        WebElement container2=driver.findElement(By.xpath(maxPriceContainer));
        container2.click();
        List<WebElement> priceList2=driver.findElements(By.xpath(dropdown));
        String maxnum;
        for(int index=0;index<priceList2.size();index++){
            maxnum= priceList2.get(index).getText();
            if(maxnum.equals("$950k")){
                priceList2.get(index).click();
                break;}
        }
        Thread.sleep(5000);

        //7. Verify all the homes listed are from Sunnyvale, CA, USA, if no homes listed
        //        throw an error saying there is no data to test.


       String text= driver.findElement(By.xpath(homesummary)).getText();
       System.out.println(text);
       String[] array=text.split(" ");
       int homeListed=Integer.parseInt(array[1]);
       if(homeListed<=0){
           System.out.println("Error Message:No data to test");
       }
       List<WebElement> listOfHomes=driver.findElements(By.xpath(homes));
       String title;
       int count=0;
       System.out.println(listOfHomes.size());
       for(WebElement home:listOfHomes){
           title=home.getAttribute("title");
           System.out.println(title);
           if(title.contains("SUNNYVALE, CA"))
               count++;
       }
       System.out.println("There are "+count+" homes in Sunnyvale,CA USA");

        //8.        Parametrize this test by selecting “Sunnyvale, Dallas, TX, USA” in the did you mean
        //        pop up ,and on the search results page use the price range between 600-800.
        //        log All critical information for reporting
        //        Give details of the design
    }

    @Test(dataProvider = "findHome")
    public void redfin2(String location,String[] price) throws InterruptedException {
        String minPrice=price[0];
        String maxPrice=price[1];

        WebElement search = driver.findElement(By.xpath(searchBox));
        //  2. Enter Sunnyvale in the Search box and press the Enter Button
        search.sendKeys("Sunnyvale");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        // 3. Ensure a POP Up “ Did You Mean” appears
        WebElement titleOfpopup = driver.findElement(By.xpath(title));
        Assert.assertEquals(titleOfpopup.getText(), "Did You Mean");
        //4. On the pop Up select the entry “Sunnyvale, CA, USA and ensure we are
        //        navigated to Sunnyvale Real Estate page.
        List<WebElement> list = driver.findElements(By.xpath(popUpList));
        String locationText;
        for(int index=0;index<list.size();index++){
            locationText=list.get(index).getText();
            if(locationText.contains(location)){
                list.get(index).click();
                break;
            }
        }
        //5. On this page assert the Search box on the top left side has Sunnyvale
        WebElement element = driver.findElement(By.xpath(searchBox2));
        // System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "Sunnyvale");
        //6. Select the min price as 800 and max price as 950
        WebElement container1= driver.findElement(By.xpath(minPriceContainer));
        container1.click();
        List<WebElement> priceList1=driver.findElements(By.xpath(dropdown));
        String number;
        for(int index=0;index<priceList1.size();index++){
            number= priceList1.get(index).getText();
            if(number.equals(minPrice)){
                priceList1.get(index).click();
                break;}
        }
        Thread.sleep(5000);
        //select Max price
        WebElement container2=driver.findElement(By.xpath(maxPriceContainer));
        container2.click();
        List<WebElement> priceList2=driver.findElements(By.xpath(dropdown));
        String maxnum;
        for(int index=0;index<priceList2.size();index++){
            maxnum= priceList2.get(index).getText();
            if(maxnum.equals(maxPrice)){
                priceList2.get(index).click();
                break;}
        }
        Thread.sleep(5000);

        //7. Verify all the homes listed are from Sunnyvale, CA, USA, if no homes listed
        //        throw an error saying there is no data to test.
       List<WebElement> homeS=driver.findElements(By.xpath(homesummary));
       if(homeS.size()>=1) {
           String text = driver.findElement(By.xpath(homesummary)).getText();
           System.out.println(text);
           String[] array = text.split(" ");
           int homeListed = Integer.parseInt(array[1]);
           if (homeListed <= 0) {
               System.out.println("Error Message:No data to test");
           }
           List<WebElement> listOfHomes = driver.findElements(By.xpath(homes));
           String title;
           int count = 0;
           System.out.println(listOfHomes.size());
           for (WebElement home : listOfHomes) {
               title = home.getAttribute("title");
               System.out.println(title);
               if (title.contains("SUNNYVALE, CA"))
                   count++;
           }
           System.out.println("There are " + count + " homes in Sunnyvale,CA USA");
       }else //if(driver.findElement(By.xpath(displayMessage)).getText().contains("No results!")){
       {
           System.out.println(driver.findElement(By.xpath(displayMessage)).getText());
           System.out.println("No Home in the list");
       }

    }

    @DataProvider(name = "findHome")
    public Object[][] getData(){
        Object[][] obj= new Object[2][2];
        obj[0][0]="Sunnyvale, CA, USA";
        String[] array1={"$800k","$950k"};
        obj[0][1]=array1;
        obj[1][0]="Dallas, TX, USA";
        String[] array2={"$600k","$800k"};
        obj[1][1]=array2;
        return obj;
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
