package com.djm.tinder.auth;

import com.djm.tinder.http.request.HttpPostRq;
import com.djm.tinder.objects.Token;
import com.google.gson.Gson;

public class AuthRq implements HttpPostRq {

    public static final String URI = "/v2/auth";

    private String url;
    private Token token;
    private Gson gson = new Gson();

    public AuthRq(String url, Token token) {
        this.url = url;
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        return gson.toJson(token);
    }
}
