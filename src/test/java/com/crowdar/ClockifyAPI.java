package com.crowdar;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ClockifyAPI {

    private final String apiKey;
    private final OkHttpClient httpClient;
    private static final String USER_ID = "6523381733ae762f43636496";


    public ClockifyAPI(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = new OkHttpClient();
    }

    public List<Workspace[]> getWorkspaces() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.clockify.me/api/v1/workspaces")
                .addHeader("X-Api-Key", apiKey)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error response code: " + response);
            }

            Gson gson = new Gson();
            Workspace[] workspaces = gson.fromJson(response.body().string(), Workspace[].class);

            List<Workspace[]> workspaceList = new ArrayList<>();
            workspaceList.add(workspaces);
            return workspaceList;
        }
    }


    public List<TimeEntry> getTimeEntry(String workspaceId) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.clockify.me/api/v1/workspaces/" + workspaceId + "/user/" + USER_ID + "/time-entries")
                .addHeader("X-Api-Key", apiKey)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error response code: " + response);
            }

            Gson gson = new Gson();
            TimeEntry[] timeEntries = gson.fromJson(response.body().string(), TimeEntry[].class);
            return List.of(timeEntries);
        }
    }


    public void deleteTimeEntry(String workspaceId, String timeEntryId) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.clockify.me/api/v1/workspaces/" + workspaceId + "/time-entries/" + timeEntryId)
                .addHeader("X-Api-Key", apiKey)
                .delete()
                .build();
        System.out.println("request = " + request);

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error response code: " + response);
            }
        }
    }
}
