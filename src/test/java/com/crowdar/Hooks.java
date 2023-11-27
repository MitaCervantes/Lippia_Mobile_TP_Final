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
                // Obtener los espacios de trabajo
                List<Workspace[]> workspaces = clockifyAPI.getWorkspaces();

                // Iterar sobre los workspaces obtenidos
                for (Workspace[] workspace : workspaces) {
                    // Obtener el ID del primer workspace
                    String workspaceId = workspace[0].getId();

                    // Obtener los timeEntries para el workspace obtenido
                    List<TimeEntry> timeEntries = clockifyAPI.getTimeEntry(workspaceId);

                    // Iterar sobre los timeEntries obtenidos
                    for (TimeEntry timeEntry : timeEntries) {
                        // Obtener el ID del primer timeEntry
                        String timeEntryId = timeEntry.getId();

                        //eliminar el timeEntry
                        clockifyAPI.deleteTimeEntry(workspaceId, timeEntryId);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
