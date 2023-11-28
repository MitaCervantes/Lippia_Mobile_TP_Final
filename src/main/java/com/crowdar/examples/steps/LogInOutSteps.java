package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.LogInOutService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;


public class LogInOutSteps extends PageSteps {

    @Given("The app is loaded correctly")
    @Then("Login page is displayed")
    public void isLoginPageVisible() {
        LogInOutService.isViewLoaded();
    }


    @When("The user logs in the application with: (.*), (.*)")
    public void doLoginProcess(String email, String password) {
        LogInOutService.doLogin(email, password);
    }

    @And("click on the logout option")
    public void clickOnTheLogoutOption() {
        LogInOutService.clickLogOut();
    }
    @And("confirm this action to logout")
    public void confirmThisActionToLogout() {
        LogInOutService.confirmLogOut();
    }

}
