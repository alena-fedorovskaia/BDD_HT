Feature: Amazon Test

  Scenario: Update Delivery Country

    Given User is on main Page

    When User clicks DeliveryTo Field

    And User selects country from drop down list and confirms it

    Then Selected delivery country is displayed on Main Page