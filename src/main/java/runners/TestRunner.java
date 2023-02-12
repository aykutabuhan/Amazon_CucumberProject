package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "util"},
        plugin = {"summary", "pretty", "html:Reports/CucumberReport/Report.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    private final WebDriver m_driver = DriverFactory.getDriver(); // static'de olabilir

}
