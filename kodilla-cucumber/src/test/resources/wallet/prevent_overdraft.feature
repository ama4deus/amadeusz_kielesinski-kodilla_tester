Feature: Prevent users from taking out more money than their wallet contains

  Scenario Outline: User tries to take out more money than their balance
    Given there is $<balance> in my wallet
    When I withdraw $<withdrawal>
    Then nothing should be dispensed
    And I should be told that I don't have enough money in my wallet

    Examples:
      | balance | withdrawal |
      | 100     | 200        |
      | 0       | 50         |