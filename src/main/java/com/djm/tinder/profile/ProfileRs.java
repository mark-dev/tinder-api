package com.djm.tinder.profile;

import com.google.gson.Gson;

public class ProfileRs {
    private String response;
    private Gson gson = new Gson();

    public ProfileRs(String res) {
        response = res;
    }

    public Profile getProfile() throws Exception {
        return gson.fromJson(response, Profile.class);
    }
}
