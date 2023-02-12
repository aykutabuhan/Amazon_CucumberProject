package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver m_driver;
    protected WebDriverWait m_wait;
    protected Actions m_action;
    private static final int DEFAULT_TIME_DURATION = 10;

    public BasePage(WebDriver driver){
        m_driver = driver;
        m_wait = new WebDriverWait(m_driver, Duration.ofSeconds(DEFAULT_TIME_DURATION));
        m_action = new Actions(m_driver); // birde m_driver referansı ile çalıştır!
        PageFactory.initElements(m_driver, this);
    }
    public WebElement centerElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) m_driver).executeScript(scrollElementIntoMiddle, element);
        return element;
    }
    public void click(WebElement element){
        m_wait.until(ExpectedConditions.elementToBeClickable(centerElement(element))).click();
    }
    public void sendKeys(WebElement element, String text){
        m_wait.until(ExpectedConditions.visibilityOf(centerElement(element))).sendKeys(text);
    }
    public String getText(WebElement element){
        return m_wait.until(ExpectedConditions.visibilityOf(centerElement(element))).getText();
    }
}
