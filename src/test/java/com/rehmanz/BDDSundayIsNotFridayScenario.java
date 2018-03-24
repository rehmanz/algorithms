package com.rehmanz;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

public class BDDSundayIsNotFridayScenario {
    private String today;
    private String actualAnswer;

    @Given("^today is Sunday$")
    public void today_is_Sunday() throws Exception {
        this.today = "Sunday";
    }

    @When("^I ask whether is's Friday yet$")
    public void i_ask_whether_is_s_Friday_yet() throws Exception {
        this.actualAnswer = "Nope";
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) throws Exception {
        assertEquals(expectedAnswer, actualAnswer);
    }
}