package com.djm.tinder.like;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LikeResponse {
    private JSONParser parser;
    private String response;

    public LikeResponse(String res) {
        response = res;
        parser = new JSONParser();
    }

    public Like getLike() throws Exception {
        JSONObject jsonObject = (JSONObject) parser.parse(response);
        //if like match JSONObject returned here
        Object match = jsonObject.get("match");

        Long likesRemaining = (Long) jsonObject.get("likes_remaining");
        if (likesRemaining == null)
            likesRemaining = 0L;
        Long status = (Long) jsonObject.get("status");
        if (status == null) {
            status = 200L;
        }
        boolean isMatch = false;
        if (match != null) {
            isMatch = match instanceof Boolean ? (Boolean) match : true;
        }
        return Like.Builder()
                .setLikesRemaining(likesRemaining.intValue())
                .setStatus(status.intValue())
                .setMatch(isMatch);
    }


}
