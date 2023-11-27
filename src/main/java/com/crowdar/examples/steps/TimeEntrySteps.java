package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import com.crowdar.examples.services.TimeEntryService;
import com.crowdar.examples.services.LoginService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button and it has nothing related to business logic, is correct to put here.
 */
public class TimeEntrySteps extends PageSteps {

    private final String email = PropertyManager.getProperty("email");
    private final String password = PropertyManager.getProperty("password");

    @Then("Home page is displayed")
    public void isHomePageVisible() {
        TimeEntryService.isViewLoaded();
    }

    @When("The logged-in user is in the time entry section")
    public void theLoggedInUserIsInTheTimeEntrySection() {
        LoginService.doLogin(email, password);
        TimeEntryService.isViewLoaded();
    }
    @When("click button add an entry")
    public void clickButtonAddAnEntry() {
        TimeEntryService.clickEntry();
    }

    @And("enter the hours worked: {string}:{string}")
    public void enterTheHoursWorked(String hour, String minute) {
        TimeEntryService.inputHours(hour, minute);
    }

    @And("click button save")
    public void clickButtonSave() {
        TimeEntryService.clickButtonSave();
    }

    @Then("redirect to the time entry section")
    public void redirectToTheTimeEntrySection() {
        TimeEntryService.isTitleEntryLoaded();
    }
    @And("the created entry appears")
    public void theCreatedEntryAppears() {
        TimeEntryService.isEntryLoaded();
    }

    @And("click in time range")
    public void clickInTimeRange() { TimeEntryService.clickTimeRange();  }

    @And("select the day {string}-{string}-{string}")
    public void selectTheDay(String dia, String mes, String anio) {
        TimeEntryService.chosseDate(dia,mes,anio);
    }
    @And("enter a start time: {string}:{string}")
    public void enterAStartTime(String hour, String minute) {
        TimeEntryService.setHoraInicio(hour, minute);
    }
    @And("end time: {string}:{string}")
    public void endTime(String hour, String minute) {
        TimeEntryService.setHoraFin(hour, minute);
    }
    @And("save the date and hours")
    public void saveTheDateAndHours() {
        TimeEntryService.clickButtonSave();
        TimeEntryService.clickButtonSave();
    }
}
