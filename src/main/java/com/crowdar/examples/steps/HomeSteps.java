package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.services.HomeService;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button and it has nothing related to business logic, is correct to put here.
 */
public class HomeSteps extends PageSteps {

    private final String email = PropertyManager.getProperty("email");
    private final String password = PropertyManager.getProperty("password");

    @Then("Home page is displayed")
    public void isHomePageVisible() {
        HomeService.isViewLoaded();
    }

    @When("The logged-in user is in the time entry section")
    public void theLoggedInUserIsInTheTimeEntrySection() {
        LoginService.doLogin(email, password);
        HomeService.isViewLoaded();
    }
    @When("click button add an entry")
    public void clickButtonAddAnEntry() {
        HomeService.clickEntry();
    }

    @And("enter the hours worked: {string}:{string}")
    public void enterTheHoursWorked(String hour, String minute) {
        HomeService.inputHours(hour, minute);
    }

    @And("click button save")
    public void clickButtonSave() {
        MobileActionManager.click(HomeConstants.ACTION_BUTTON);
    }

    @Then("redirect to the time entry section")
    public void redirectToTheTimeEntrySection() {
        HomeService.isTitleEntryLoaded();
    }
    @And("the created entry appears")
    public void theCreatedEntryAppears() {
        HomeService.isEntryLoaded();
    }

}
