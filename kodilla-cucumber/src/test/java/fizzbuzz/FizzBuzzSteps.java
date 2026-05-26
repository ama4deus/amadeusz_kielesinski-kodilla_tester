package fizzbuzz;

import fizzbuzz.FizzBuzzChecker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzSteps {

    private FizzBuzzChecker checker;
    private String actualResult;

    @Given("The FizzBuzz game is initialized")
    public void the_fizz_buzz_game_is_initialized() {
        this.checker = new FizzBuzzChecker();
    }

    @When("I submit the number {int} to the game")
    public void i_submit_the_number_to_the_game(int number) {
        this.actualResult = this.checker.check(number);
    }

    @Then("The returned text should be {string}")
    public void the_returned_text_should_be(String expectedResult) {
        assertEquals(expectedResult, this.actualResult);
    }
}