package djm.tinder;

import djm.tinder.auth.AuthRq;
import djm.tinder.http.HttpRq;
import djm.tinder.recommendation.Recommendation;
import djm.tinder.recommendation.RecommendationRq;
import djm.tinder.user.User;

import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class Tinder {

    public static final String BASE_URL = "https://api.gotinder.com";

    private HttpRq http;

    public Tinder(String facebookAccessToken) throws Exception {
        http = new HttpRq(new OkHttpClient(), getAccessToken(facebookAccessToken));
    }

    public ArrayList<Recommendation> getRecommendations() throws Exception {
        String res = http.get(new RecommendationRq(BASE_URL + RecommendationRq.URI));

        System.out.println(res);
        return new ArrayList<Recommendation>();
    }

    public User getUser() {
        return new User();
    }

    public void like(User user) {
        return;
    }

    private String getAccessToken(String facebookAccessToken) throws Exception {
        String res = http.anonPost(new AuthRq(BASE_URL + AuthRq.URI, facebookAccessToken));
        JSONParser parser = new JSONParser();
        JSONObject jsonRes = (JSONObject) parser.parse(res);
        JSONObject tokenData = (JSONObject) jsonRes.get("data");
        String token = (String) tokenData.get("api_token");
        if (token == null) {
            throw new Exception("unable to retrieve access token");
        }

        return token;
    }
}
