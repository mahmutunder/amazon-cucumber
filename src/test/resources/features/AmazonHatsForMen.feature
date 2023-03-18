Feature: Amazon  search hats for men

  Scenario: User search for hats for men
    Given user is on the amazon home page
    When user search for "hats for men"
    And user click the search button
    And users clicks first hat link
    And user make the first appearing hat quantity 2
    And user add hats to cart
    And user open cart and assert that the total price and quantity are correct
    And user reduce the quantity from two to one in Cart for the item selected
    Then Verify that the total price and quantity has been correctly changed