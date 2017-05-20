package com.djm.tinder.profile;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.SimpleDateFormat;

public class ProfileRs {
    private String response;
    private JSONParser parser;

    public ProfileRs(String res) {
        response = res;
        parser = new JSONParser();
    }

    public Profile getProfile() throws Exception {
        JSONObject jsonRes = (JSONObject) parser.parse(response);
        return Profile.Builder()
                .setName((String) jsonRes.get("name"))
                .setAgeFilterMax(Math.toIntExact((Long) jsonRes.get("age_filter_max")))
                .setAgeFilterMin(Math.toIntExact((Long) jsonRes.get("age_filter_min")))
                .setId((String) jsonRes.get("_id"))
                .setBio((String) jsonRes.get("bio"))
                .setBirthDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse((String) jsonRes.get("birth_date")))
                .setCreateDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse((String) jsonRes.get("create_date")))
                .setBlend((String) jsonRes.get("blend"))
                .setCanCreateSquad((Boolean) jsonRes.get("can_create_squad"))
                .setDiscoverable((Boolean) jsonRes.get("discoverable"))
                .setDistanceFilter(Math.toIntExact((Long) jsonRes.get("distance_filter")))
                .setFacebookId((String) jsonRes.get("facebook_id"));
    }
}
