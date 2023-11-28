package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LogInOutConstants;
import org.testng.Assert;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class LogInOutService {

    public static void doLogin(String email, String password){
        MobileActionManager.setInput(LogInOutConstants.EMAIL_INPUT_LOCATOR, email);
        MobileActionManager.setInput(LogInOutConstants.PASSWORD_INPUT_LOCATOR, password);
        MobileActionManager.click(LogInOutConstants.SIGN_IN_BUTTON_LOCATOR);
    }

    public static void isViewLoaded(){
        MobileActionManager.waitVisibility(LogInOutConstants.SIGN_IN_BUTTON_LOCATOR);
        Assert.assertTrue(MobileActionManager.isVisible(LogInOutConstants.EMAIL_INPUT_LOCATOR), LogInOutConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }

    public static void clickLogOut() {
        MobileActionManager.waitVisibility(LogInOutConstants.LOGOUT_BUTTON);
        MobileActionManager.click(LogInOutConstants.LOGOUT_BUTTON);
    }

    public static void confirmLogOut() {
        MobileActionManager.waitVisibility(LogInOutConstants.CONFIRM_LOGOUT_BUTTON);
        MobileActionManager.click(LogInOutConstants.CONFIRM_LOGOUT_BUTTON);
    }
}
