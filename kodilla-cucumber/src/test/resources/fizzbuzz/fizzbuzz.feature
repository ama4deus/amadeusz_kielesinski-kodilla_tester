Feature: FizzBuzz Game Checker
  As a user of the FizzBuzz application
  I want to check the text returned for a given number
  So that I can verify the correctness of the game logic

  Scenario Outline: Verify FizzBuzz logic for different numbers
    Given The FizzBuzz game is initialized
    When I submit the number <number> to the game
    Then The returned text should be "<expectedResult>"

    Examples:
      | number | expectedResult |
      | 3      | Fizz           |
      | 6      | Fizz           |
      | 5      | Buzz           |
      | 10     | Buzz           |
      | 15     | FizzBuzz       |
      | 30     | FizzBuzz       |
      | 1      | None           |
      | 4      | None           |
      | 0      | FizzBuzz       |