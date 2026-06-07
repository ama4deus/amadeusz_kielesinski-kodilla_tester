Feature: Deposit validation

  Scenario Outline: User tries to deposit zero or negative amounts
    Given there is $100 in my wallet
    When I attempt to deposit $<amount>
    Then the balance of my wallet should be $100

    Examples:
      | amount |
      | 0      |
      | -50    |