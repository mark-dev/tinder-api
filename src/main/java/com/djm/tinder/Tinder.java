package com.djm.tinder;

import com.djm.tinder.auth.AuthRq;
import com.djm.tinder.auth.AuthRs;
import com.djm.tinder.http.AuthenticatedHttpClient;
import com.djm.tinder.http.HttpPostRq;
import com.djm.tinder.http.AnonymousHttpClient;
import com.djm.tinder.profile.Profile;
import com.djm.tinder.profile.ProfileRq;
import com.djm.tinder.profile.ProfileRs;
import com.djm.tinder.recommendation.Recommendation;
import com.djm.tinder.recommendation.RecommendationRq;
import com.djm.tinder.recommendation.RecommendationRs;
import com.djm.tinder.user.User;

import okhttp3.*;

import java.util.ArrayList;

public class Tinder {

    public static final String BASE_URL = "https://api.gotinder.com";

    private AnonymousHttpClient anonymousHttpClient;
    private AuthenticatedHttpClient authenticatedHttpClient;

    private Tinder(String facebookAccessToken) throws Exception {
        anonymousHttpClient = new AnonymousHttpClient(new OkHttpClient());
        authenticatedHttpClient = new AuthenticatedHttpClient(anonymousHttpClient, getAccessToken(facebookAccessToken));
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
                authenticatedHttpClient.get(
                        new RecommendationRq(BASE_URL + RecommendationRq.URI)
                )
        );

        return recommendationRs.getRecommendations();
    }

    /**
     * Returns the user profile information and settings.
     *
     * @return Profile
     */
    public Profile getProfile() throws Exception {
        ProfileRs profileRs = new ProfileRs(authenticatedHttpClient.get(new ProfileRq(BASE_URL + ProfileRq.URI)));

        return profileRs.getProfile();
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
        AuthRs authRs = new AuthRs(anonymousHttpClient.post(rq));

        return authRs.getToken();
    }
}
