package com.djm.tinder.auth;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AuthRs {

    public static final String TOKEN_KEY = "api_token";

    private String response;
    private JSONParser parser;

    public AuthRs(String res) {
        response = res;
        parser = new JSONParser();
    }

    public String getToken() throws Exception {
        JSONObject jsonRes = (JSONObject) parser.parse(response);
        JSONObject tokenData = (JSONObject) jsonRes.get("data");
        if (tokenData == null) {
            throw new Exception("Unable to retrieve access token");
        }
        String token = (String) tokenData.get(TOKEN_KEY);
        if (token == null) {
            throw new Exception("Unable to retrieve access token");
        }

        return token;
    }
}
