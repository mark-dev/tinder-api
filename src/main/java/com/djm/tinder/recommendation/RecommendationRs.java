package com.djm.tinder.recommendation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RecommendationRs {
    private String response;
    private JSONParser parser;

    public RecommendationRs(String res) {
        response = res;
        parser = new JSONParser();
    }

    public ArrayList<Recommendation> getRecommendations() throws Exception {
        JSONObject jsonRes = (JSONObject) parser.parse(response);
        JSONArray results = (JSONArray) jsonRes.get("results");
        ArrayList<Recommendation> recommendations = new ArrayList<Recommendation>();
        for (int i = 0; i < results.size(); i++) {
            JSONObject item = (JSONObject) results.get(i);
            Recommendation rec = Recommendation.Builder()
                    .setId((String) item.get("_id"))
                    .setBirthDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse((String) item.get("birth_date")))
                    .setDistance((Long) item.get("distance_mi"))
                    .setName((String) item.get("name"))
                    .setGender(Math.toIntExact((Long) item.get("gender")));
            recommendations.add(rec);
        }

        return recommendations;
    }
}
