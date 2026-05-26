Feature: Cash Withdrawal

  Scenario Outline: Different withdrawal scenarios including edge cases
    Given I have deposited $<deposited> in my wallet
    When I request $<requested>
    Then $<dispensed> should be dispensed
    And The balance of my wallet should be $<expectedBalance>

    Examples:
      | deposited | requested | dispensed | expectedBalance |
      | 200       | 30        | 30        | 170             |
      | 100       | 100       | 100       | 0               |
      | 50        | 100       | 0         | 50              |
      | 100       | -20       | 0         | 100             |