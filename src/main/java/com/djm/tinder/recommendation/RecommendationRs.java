package com.djm.tinder.recommendation;

import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class RecommendationRs {
    private String response;
    private JSONParser parser;

    public RecommendationRs(String res) {
        response = res;
        parser = new JSONParser();
    }

    public ArrayList<Recommendation> getRecommendations() {
        return new ArrayList<Recommendation>();
    }
}
