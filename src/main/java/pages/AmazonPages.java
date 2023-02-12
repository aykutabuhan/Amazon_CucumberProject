package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPages extends BasePage{
    @FindBy(id = "sp-cc-accept")
    private static WebElement cookiesElement;
    @FindBy(id = "twotabsearchtextbox")
    private static WebElement searchField;
    @FindBy(id = "nav-search-submit-button")
    private static WebElement searchButton;
    @FindBy(css = "li[id='p_n_fulfilled_by_amazon/21345978031']")
    private static WebElement shippingAmazonBoxButton;
    @FindBy(css = "li[aria-label='Apple'] span")
    private static WebElement filterOnlyApple;
    @FindBy(css = "div[data-index='1']")
    private static WebElement firstProductIndex;
    @FindBy(css = "input[id='add-to-cart-button']")
    private static WebElement addToCartButton;
    @FindBy(id = "attach-close_sideSheet-link")
    private static WebElement closeButton;
    @FindBy(id = "nav-cart-text-container")
    private static WebElement cartField;
    @FindBy(id = "sc-subtotal-amount-activecart")
    private static WebElement amountofProduct;
    public AmazonPages(WebDriver driver) {
        super(driver);
    }
    public void gotoHomePage() {
    }
    public void acceptCookies() {
        click(cookiesElement);
    }
    public void writeProName(String productName) {
        sendKeys(searchField, productName);
    }
    public void clickSearch() {
        click(searchButton);
    }
    public void filterForAmazon() {
        click(shippingAmazonBoxButton);
    }
    public void filterForApple() {
        click(filterOnlyApple);
    }
    public void selectFirstProduct() {
        click(firstProductIndex);
    }
    public void addtoCart() {
        click(addToCartButton);
        click(closeButton);
        click(cartField);
    }
    public String checkCart() {
        return getText(amountofProduct);
    }
}
