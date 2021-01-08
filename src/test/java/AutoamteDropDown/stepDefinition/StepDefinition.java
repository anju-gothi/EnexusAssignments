package AutoamteDropDown.stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class StepDefinition {
     WebDriver driver;
    @Given("^set the browser in headless mode$")
    public void set_the_browser_in_headless_mode() throws Throwable {
        WebDriverManager.chromedriver().setup();
        //Run the test case in Headless mode
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        // option.addArguments("--headless");
        driver=new ChromeDriver(option);
    }

    @Given("^set the browser$")
    public void set_the_browser() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }

    @When("^User is sending request  \"(.*?)\"$")
    public void user_is_sending_request(String uri) throws Throwable {
              driver.get(uri);

    }

    @Then("^User select one option from dropdown$")
    public void user_select_one_option_from_dropdown() throws Throwable {
        WebElement dropButton=driver.findElement(By.xpath("(//div[@class='css-ty0g2a-control converterform-dropdown__control']//*[name()='svg' and @data-id='icon-chevron-down'])[1]"));
        dropButton.click();
        //collect all the drop down elements in the list
        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@id,'react-select')]/span"));
        for(WebElement ele:list){
            System.out.println(ele.getText());
            if(ele.getText().contains("HKD")){
                System.out.println("StrtsWith:"+ele.getText());
                ele.click();
                Thread.sleep(5000);
                break;
            }
        }

    }

    @Then("^option successfully get selected$")
    public void option_successfully_get_selected() throws Throwable {
          System.out.println("Successfully selected option");
          driver.close();
    }

}
