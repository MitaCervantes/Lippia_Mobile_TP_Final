package com.crowdar;


import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;


public class Hooks {
    @After(order = Integer.MAX_VALUE)
    public void afterScenario(Scenario scenario) {
        if(scenario.getName().equals("Add entry data")) {
            MobileActionManager.click(HomeConstants.BUTTON_MENU_ENTRY);
            MobileActionManager.click(HomeConstants.BUTTON_DELETE_ENTRY);
            MobileActionManager.waitVisibility(HomeConstants.NO_ENTRY);
        }
    }
}
