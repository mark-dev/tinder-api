package com.djm.tinder.match;

import com.djm.tinder.http.request.HttpPostRequest;
import org.json.simple.JSONObject;

import java.util.Date;

public class MatchRequest implements HttpPostRequest {

    public static final String URI = "/updates";

    private String url;

    public MatchRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("last_activity_date", new Date().toString());

        return requestBody.toString();
    }
}
