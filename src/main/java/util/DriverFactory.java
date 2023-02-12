package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    private static WebDriver ms_driver;

    public static WebDriver initializeDriver(String browser){
        Properties properties = ConfigReader.getProperties();

        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            ms_driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Safari")){
            ms_driver = new SafariDriver();
        }
        else if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver ", "src/main/resources/geckodriver");
            ms_driver = new FirefoxDriver();
        }

        String url = properties.getProperty("url");
        ms_driver.get(url);
        ms_driver.manage().window().maximize();
        ms_driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        ms_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return getDriver();
    }
    public static WebDriver getDriver(){
        return ms_driver;
    }
}
