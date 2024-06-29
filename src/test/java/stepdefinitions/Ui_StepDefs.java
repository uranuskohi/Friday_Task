package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Ui_HomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.WaitUtils;

public class Ui_StepDefs {

    Ui_HomePage uiHomePage;


    @Given("user goes to the {string} homepage")
    public void user_goes_to_the_homepage(String url) {
        Driver.getDriver().get(url);
    }

    @Given("enter {string}")
    public void enter(String fullName) {
        uiHomePage = new Ui_HomePage();
        BrowserUtils.sendKeysWithTimeout(uiHomePage.username, fullName, 2);
    }

    @Given("enter the {string}")
    public void enter_the(String email) {
        BrowserUtils.sendKeysWithTimeout(uiHomePage.email, email, 2);
    }

    @Given("write the {string}")
    public void write_the(String currentAddress) {
        BrowserUtils.sendKeysWithTimeout(uiHomePage.currentAddress, currentAddress,2);
    }

    @Given("enter your {string}")
    public void enter_your(String permanentAddress) {
        BrowserUtils.sendKeysWithTimeout(uiHomePage.permanentAddress, permanentAddress,2);
    }

    @Given("click on Submit button")
    public void click_on_submit_button() {
        WaitUtils.waitFor(3);
        BrowserUtils.clickWithTimeOut(uiHomePage.submitButton, 2);
//        uiHomePage.submitButton.click();
    }

    @Then("verify the result contains the {string}")
    public void verify_the_result_contains_the(String data) {

        Assert.assertTrue(uiHomePage.assertion.isDisplayed());
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }



}
