@deck
Feature: Deck

@NewDeck
  Scenario: Create a new deck of cards
    Given query parameter is jokers_enabled
    When user sends GET request
    Then user should be able to remaining cards as 54
    And user verifies that response status code is 200
    And user verifies that success in bosy is true


  @DrawCard
  Scenario: Draw one or more cards from a deck
    Given query parameter is jokers_enabled
    And query parameter is count
    When user sends GET request
    Then user should be able to remaining cards as 50
    And user verifies that response status code is 200
    And user verifies that success in bosy is true