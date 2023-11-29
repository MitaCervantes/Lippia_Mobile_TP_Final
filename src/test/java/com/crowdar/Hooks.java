package com.crowdar;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import java.io.IOException;
import java.util.List;


public class Hooks {

    private static final String CLOCKIFY_API_KEY = "MWQ4ODMwYmYtMGQyOC00OWYyLWIzYjAtYWEzNjI4MWM4ZmUx";
    private static final ClockifyAPI clockifyAPI = new ClockifyAPI(CLOCKIFY_API_KEY);

    @After(order = Integer.MAX_VALUE)
    public void afterScenario(Scenario scenario) {
        if(scenario.getName().equals("Add entry data") || scenario.getName().equals("Add date data")) {
            try {
                List<Workspace[]> workspaces = clockifyAPI.getWorkspaces();

                for (Workspace[] workspace : workspaces) {
                    String workspaceId = workspace[0].getId();
                    List<TimeEntry> timeEntries = clockifyAPI.getTimeEntry(workspaceId);

                    for (TimeEntry timeEntry : timeEntries) {
                        String timeEntryId = timeEntry.getId();
                        clockifyAPI.deleteTimeEntry(workspaceId, timeEntryId);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
