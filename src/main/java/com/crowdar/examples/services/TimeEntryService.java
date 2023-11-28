package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.TimeEntryConstants;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class TimeEntryService {

    public static void isViewLoaded() {
        MobileActionManager.waitVisibility(TimeEntryConstants.TIME_ENTRY_LIST);
        Assert.assertTrue(MobileActionManager.isVisible(TimeEntryConstants.ACTION_BUTTON), TimeEntryConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }

    public static void clickEntry(){
        MobileActionManager.click(TimeEntryConstants.ACTION_BUTTON);
        MobileActionManager.waitVisibility(TimeEntryConstants.DIV_SECTION_HOUR);
    }

    public static void clickButtonSave(){
        MobileActionManager.click(TimeEntryConstants.ACTION_BUTTON);
    }

    public static void inputHours(String hour, String minute) {
        MobileActionManager.click(TimeEntryConstants.INPUT_HOUR);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_HOUR, hour);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_HOUR, hour);

        MobileActionManager.click(TimeEntryConstants.INPUT_MINUTE);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_MINUTE, minute);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_MINUTE, minute);
    }
    public static void isTitleEntryLoaded(){
        MobileActionManager.waitVisibility(TimeEntryConstants.TITLE_TIME_ENTRY);
    }

    public static void isEntryLoaded(){
        Assert.assertTrue(MobileActionManager.isVisible(TimeEntryConstants.ENTRY));
    }



    public static void setHoraInicio(String hora, String min) {
        MobileActionManager.click(TimeEntryConstants.BTN_START);
        inputHours(hora, min);
    }

    public static void setHoraFin(String hora, String min) {
        MobileActionManager.click(TimeEntryConstants.BTN_END);
        inputHours(hora, min);
    }

    public static void cancelEntryAndReturn(){
        MobileActionManager.click(TimeEntryConstants.TOOLBAR_DISCARD_BUTTON);
        MobileActionManager.click(TimeEntryConstants.DISCARD_BUTTON);
        MobileActionManager.click(TimeEntryConstants.NAVIGATE_RETURN);
        MobileActionManager.click(TimeEntryConstants.DISCARD_BUTTON);
    }

}
