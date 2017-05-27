package com.djm.tinder.match;

import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class MatchResponse {
    private String response;
    private JSONParser parser;

    public MatchResponse(String res) {
        response = res;
        parser = new JSONParser();
    }

    public ArrayList<Match> getMatches() {
        return new ArrayList<Match>();
    }
}
