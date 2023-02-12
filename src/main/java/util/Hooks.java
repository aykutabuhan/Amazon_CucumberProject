package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class Hooks {
    private WebDriver m_driver;

    @Before
    public void before(){
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        Properties properties = ConfigReader.initializeProperties();
        m_driver = DriverFactory.initializeDriver(browser);
    }
    @After
    public void after(){
        m_driver.quit();
    }
}
