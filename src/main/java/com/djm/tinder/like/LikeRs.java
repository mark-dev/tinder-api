package com.djm.tinder.like;

import org.json.simple.parser.JSONParser;

public class LikeRs {
    private JSONParser parser;
    private String response;

    public LikeRs(String res) {
        response = res;
        parser = new JSONParser();
    }

    public Like getLike() {
        return Like.Builder().setLikesRemaining(0);
    }
}
