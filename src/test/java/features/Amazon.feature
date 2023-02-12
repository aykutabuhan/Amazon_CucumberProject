Feature: Amazon.com Adding Product

  Scenario: User want to buy Apple Airpods
    Given User is on homepage
    And Click accept cookies
    And Write product name "Airpods"
    And Click search button
    And Filter for shipped by Amazon
    And Filter for Apple
    And Click to first product
    When Click to Add to cart
    Then Check to cart page