Feature: Test scenario for Amazon

  Scenario: Search and Add to Cart

    Given User is on Main Page

    When User enters item search value

    And User is navigated to SearchResults Page

    And User clicks on item and gets navigated to the Item Page

    And User adds item to the cart

    And User is navigated to Confirmation Page

    And User proceeds to check out

    Then User is successfully navigated to SignIn Page

