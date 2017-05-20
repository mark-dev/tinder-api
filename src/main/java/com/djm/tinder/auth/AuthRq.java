package com.djm.tinder.auth;

import com.djm.tinder.http.request.HttpPostRq;
import org.json.simple.JSONObject;

public class AuthRq implements HttpPostRq {

    public static final String URI = "/v2/auth";

    private String url;
    private String token;

    public AuthRq(String url, String token) {
        this.url = url;
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        JSONObject obj = new JSONObject();
        obj.put("token", token);

        return obj.toString();
    }
}
