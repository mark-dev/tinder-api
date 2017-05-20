package com.djm.tinder;

import com.djm.tinder.auth.AuthRq;
import com.djm.tinder.auth.AuthRs;
import com.djm.tinder.http.AuthHttpRq;
import com.djm.tinder.http.HttpPostRq;
import com.djm.tinder.http.HttpRq;
import com.djm.tinder.recommendation.Recommendation;
import com.djm.tinder.recommendation.RecommendationRq;
import com.djm.tinder.recommendation.RecommendationRs;
import com.djm.tinder.user.User;

import okhttp3.*;

import java.util.ArrayList;

public class Tinder {

    public static final String BASE_URL = "https://api.gotinder.com";

    private HttpRq httpRq;
    private AuthHttpRq authHttpRq;

    private Tinder(String facebookAccessToken) throws Exception {
        httpRq = new HttpRq(new OkHttpClient());
        authHttpRq = new AuthHttpRq(httpRq, getAccessToken(facebookAccessToken));
    }

    /**
     * Build the Tinder client given the access token.
     *
     * @param facebookAccessToken
     * @return Tinder
     * @throws Exception
     */
    public static Tinder fromAccessToken(String facebookAccessToken) throws Exception {
        return new Tinder(facebookAccessToken);
    }

    /**
     * Returns a list of recommendations.
     *
     * @return recommendations
     * @throws Exception
     */
    public ArrayList<Recommendation> getRecommendations() throws Exception {
        RecommendationRs recommendationRs = new RecommendationRs(
                authHttpRq.get(
                        new RecommendationRq(BASE_URL + RecommendationRq.URI)
                )
        );

        return recommendationRs.getRecommendations();
    }

    public User getUser() {
        return new User();
    }

    /**
     * Likes a given user and returns a boolean if there was a match.
     *
     * @param user
     * @return match
     */
    public boolean like(User user) {
        return true;
    }

    /**
     * Retrieve the tinder access token in order to query the tinder api, given the facebook access token.
     *
     * @param facebookAccessToken
     * @return accessToken
     * @throws Exception
     */
    private String getAccessToken(String facebookAccessToken) throws Exception {
        HttpPostRq rq = new AuthRq(BASE_URL + AuthRq.URI, facebookAccessToken);
        AuthRs authRs = new AuthRs(httpRq.post(rq));

        return authRs.getToken();
    }
}
