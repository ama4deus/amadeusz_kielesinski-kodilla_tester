package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class WalletSteps {

    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();
    private int checkedBalance;

    @Given("I have deposited ${int} in my wallet")
    public void i_have_deposited_in_my_wallet(int amount) {
        wallet.deposit(amount);
        Assertions.assertEquals(amount, wallet.getBalance(), "Incorrect wallet balance");
    }

    @When("I request ${int}")
    public void i_request(int amount) {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, amount);
    }

    @Then("${int} should be dispensed")
    public void should_be_dispensed(int amount) {
        Assertions.assertEquals(amount, cashSlot.getContents());
    }

    @Then("the balance of my wallet should be ${int}")
    @Then("The balance of my wallet should be ${int}")
    public void the_balance_of_my_wallet_should_be(int expectedBalance) {
        Assertions.assertEquals(expectedBalance, wallet.getBalance(), "Incorrect wallet balance");
    }

    @Given("there is ${int} in my wallet")
    public void there_is_money_in_my_wallet(int amount) {
        wallet.deposit(amount);
        Assertions.assertEquals(amount, wallet.getBalance(), "Incorrect wallet balance");
    }

    @When("I withdraw ${int}")
    public void i_withdraw(int amount) {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, amount);
    }

    @Then("nothing should be dispensed")
    public void nothing_should_be_dispensed() {
        Assertions.assertEquals(0, cashSlot.getContents());
    }

    @Then("I should be told that I don't have enough money in my wallet")
    public void i_should_be_told_that_i_don_t_have_enough_money_in_my_wallet() {
        Assertions.assertEquals("I don't have enough money in my wallet", wallet.getLastMessage());
    }

    @When("I check the balance of my wallet")
    public void i_check_the_balance_of_my_wallet() {
        this.checkedBalance = wallet.getBalance();
    }

    @Then("I should see that the balance is ${int}")
    public void i_should_see_that_the_balance_is(int expectedBalance) {
        Assertions.assertEquals(expectedBalance, this.checkedBalance);
    }

    @When("I attempt to deposit ${int}")
    public void i_attempt_to_deposit(int amount) {
        wallet.deposit(amount);
    }
}