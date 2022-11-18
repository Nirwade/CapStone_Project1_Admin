Feature: Admin Operations

  Background: I open the website
    Given I login to the website

  @Sanity
  Scenario: I modify the med product
    When I click on manage products
    And I add below values adding using datatable
      | Himalaya wellness                                    |
      | Netmeds                                              |
      | Vitamin c capsules act as an antioxidant in the body |
      |                                                   20 |
      |                                                   40 |
    And Click on send button
    Then I verify the following items and message displayed
    Then I close the browser
