package com.djm.tinder.recommendation;

import com.djm.tinder.user.Photo;
import com.djm.tinder.user.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RecommendationResponse {
    private String response;
    private JSONParser parser;

    public RecommendationResponse(String res) {
        response = res;
        parser = new JSONParser();
    }

    public ArrayList<User> getRecommendations() throws Exception {
        JSONObject jsonRes = (JSONObject) parser.parse(response);
        JSONArray results = (JSONArray) jsonRes.get("results");
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < results.size(); i++) {
            JSONObject item = (JSONObject) results.get(i);
            if (item.get("name") == "Tinder Team") {
                throw new Exception("You reached your likes limit for today");
            }
            JSONArray jsonPhotos = (JSONArray) item.get("photos");
            ArrayList<Photo> photos = new ArrayList<Photo>();
            for (int j = 0; j < jsonPhotos.size(); j++) {
                JSONObject jsonPhoto = (JSONObject) jsonPhotos.get(j);
                Photo photo = Photo.Builder()
                        .setId((String) jsonPhoto.get("id"))
                        .setUrl((String) jsonPhoto.get("url"));
                photos.add(photo);

            }
            User rec = User.Builder()
                    .setId((String) item.get("_id"))
                    .setBirthDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse((String) item.get("birth_date")))
                    .setDistance((Long) item.get("distance_mi"))
                    .setName((String) item.get("name"))
                    .setContentHash((String) item.get("content_hash"))
                    .setPhotos(photos)
                    .setGender(Math.toIntExact((Long) item.get("gender")));
            users.add(rec);
        }

        return users;
    }
}
