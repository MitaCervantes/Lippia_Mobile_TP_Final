package com.crowdar.examples.steps;

import com.crowdar.examples.constants.SettingsConstants;
import com.crowdar.examples.services.SettingsService;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SettingsSteps {
    @And("click on menu button")
    public void clickMenuButton(){
        SettingsService.clickMenuButton();
    }
    @And("click on settings option")
    public void clickOnSettingsOption() {
        SettingsService.clickSettingsOption();
    }
    @And("choose enable dark mode")
    public void chooseEnableDarkMode() {
        SettingsService.chooseDarkMode();
    }
    @Then("the app changes its color")
    public void theAppChangesItsColor() {
        SettingsService.verifyDarkMode(SettingsConstants.DARK_MODE_SWITCH);
    }
    @And("choose enable notifications")
    public void chooseEnableNotifications() {
        SettingsService.setNotifications();
    }
    @Then("verify notifications are enabled or not")
    public void verifyNotificationsAreEnabledOrNot() {
        SettingsService.verifyNotificationsState(SettingsConstants.SHOW_NOTIFIC_BUTTON);
    }
}
