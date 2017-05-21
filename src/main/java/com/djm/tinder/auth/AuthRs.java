package com.djm.tinder.auth;

import com.djm.tinder.objects.AuthResponse;
import com.djm.tinder.objects.Token;
import com.djm.tinder.objects.TokenResponse;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;

public class AuthRs {

    public static final String TOKEN_KEY = "api_token";

    private String response = null;
    private Gson gson = new Gson();

    public AuthRs(@NotNull String res) {
        response = res;
    }

    public Token getToken() throws Exception {
        AuthResponse authResponse = gson.fromJson(response, AuthResponse.class);
        TokenResponse tokenResponse = authResponse.getData();
        Token token = tokenResponse.getApi_token();
        if (token == null) {
            throw new Exception("unable to retrieve access token");
        }

        return token;
    }
}
