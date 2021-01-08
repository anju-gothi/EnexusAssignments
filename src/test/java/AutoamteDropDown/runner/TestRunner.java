package AutoamteDropDown.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/java/AutoamteDropDown/dropdown.feature",
        glue = {"AutoamteDropDown/stepDefinition"},
        dryRun = false,
        strict = false,
        plugin= {"pretty","html:test-output","json:test-jason/cucumber.json","junit:test-junit/cucumber.junit"},
        monochrome = true,
        tags= {"@Headless"}
         )

public class TestRunner {
}
