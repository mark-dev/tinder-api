package com.djm.tinder.profile;

import org.json.simple.parser.JSONParser;

public class ProfileRs {
    private String response;
    private JSONParser parser;

    public ProfileRs(String res) {
        response = res;
        parser = new JSONParser();
    }

    public Profile getProfile() {
        System.out.println(response);
        return new Profile();
    }
}
