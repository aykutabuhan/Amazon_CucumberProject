package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import pages.AmazonPages;
import util.DriverFactory;

public class AmazonSteps {

    private final WebDriver m_driver = DriverFactory.getDriver();
    private final AmazonPages m_amazonPages = new AmazonPages(m_driver);
    private final static String NOT_PRODUCT_AMOUNT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("amount");

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        m_amazonPages.gotoHomePage();
    }
    @And("Click accept cookies")
    public void clickAcceptCookies() {
        m_amazonPages.acceptCookies();
    }
    @And("Write product name{}")
    public void writeProductName(String productName) {
        m_amazonPages.writeProName(productName);
    }
    @And("Click search button")
    public void clickSearchButton() {
        m_amazonPages.clickSearch();
    }
    @And("Filter for shipped by Amazon")
    public void filterForShippedByAmazon() {
        m_amazonPages.filterForAmazon();
    }
    @And("Filter for Apple")
    public void filterForApple() {
        m_amazonPages.filterForApple();
    }
    @And("Click to first product")
    public void clickToFirstProduct() {
        m_amazonPages.selectFirstProduct();
    }
    @When("Click to Add to cart")
    public void clickToAddToCart() {
        m_amazonPages.addtoCart();
    }
    @Then("Check to cart page")
    public void checkToCartPage() {
        Assert.assertNotEquals(m_amazonPages.checkCart(), NOT_PRODUCT_AMOUNT);
    }
}