package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.SettingsConstants;
import org.testng.Assert;
import static com.crowdar.core.actions.ActionManager.getAttribute;

public class SettingsService {
    public static void clickMenuButton(){
        MobileActionManager.click(SettingsConstants.MENU_BUTTON);
    }

    public static void clickSettingsOption(){
        MobileActionManager.click(SettingsConstants.SETTING_BUTTON);
    }

    public static void chooseDarkMode(){
        MobileActionManager.click(SettingsConstants.DARK_MODE_SWITCH);
    }

    public static String checkedDarkModeAttribute;
    public static void verifyDarkMode(String locator){
        checkedDarkModeAttribute = getAttribute(locator, "checked");
        Assert.assertEquals(checkedDarkModeAttribute , "true");
    }
    public static void setNotifications(){
        MobileActionManager.click(SettingsConstants.SHOW_NOTIFIC_BUTTON);
    }

    public static String checkedNotificationsAtrribute;
    public static void verifyNotificationsState(String locator) {
        checkedNotificationsAtrribute = getAttribute(locator, "checked");
        if (checkedNotificationsAtrribute.equals("true")) {
            Assert.assertTrue(true, "Las notificaciones están habilitadas");
        } else {
            Assert.assertFalse(false, "Las notificaciones están deshabilitadas");
        }
    }


}
