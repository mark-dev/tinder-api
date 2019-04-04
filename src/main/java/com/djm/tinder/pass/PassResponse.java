package com.djm.tinder.pass;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PassResponse {
    private JSONParser parser;
    private String response;

    public PassResponse(String res) {
        response = res;
        parser = new JSONParser();
    }

    public Pass getPass() throws Exception {
        JSONObject jsonObject = (JSONObject) parser.parse(response);
        return Pass.Builder()
                .setStatus(((Long) jsonObject.get("status")).intValue());
    }
}
