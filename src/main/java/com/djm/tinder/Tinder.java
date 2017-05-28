package com.djm.tinder;

import com.djm.tinder.auth.AuthRequest;
import com.djm.tinder.auth.AuthResponse;
import com.djm.tinder.http.client.AuthenticatedHttpClient;
import com.djm.tinder.http.request.HttpPostRequest;
import com.djm.tinder.http.client.AnonymousHttpClient;
import com.djm.tinder.like.Like;
import com.djm.tinder.like.LikeRequest;
import com.djm.tinder.like.LikeResponse;
import com.djm.tinder.profile.Profile;
import com.djm.tinder.profile.ProfileRequest;
import com.djm.tinder.profile.ProfileResponse;
import com.djm.tinder.user.User;
import com.djm.tinder.recommendation.RecommendationRequest;
import com.djm.tinder.recommendation.RecommendationResponse;

import okhttp3.*;

import java.util.ArrayList;

/**
 * @author Diego Mariani
 * @since 05-2017
 */
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
    public ArrayList<User> getRecommendations() throws Exception {
        RecommendationResponse recommendationRs = new RecommendationResponse(
                authenticatedHttpClient.get(
                        new RecommendationRequest(BASE_URL + RecommendationRequest.URI)
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
        ProfileResponse profileRs = new ProfileResponse(authenticatedHttpClient.get(new ProfileRequest(BASE_URL + ProfileRequest.URI)));

        return profileRs.getProfile();
    }

    /**
     * Likes a given user and returns a Like object
     *
     * @param user
     * @return Like
     */
    public Like like(User user) throws Exception {
        LikeResponse likeRs = new LikeResponse(
                authenticatedHttpClient.get(
                        new LikeRequest(
                            BASE_URL + LikeRequest.URI,
                            user.getId(),
                            user.getContentHash(),
                            user.getsNumber()
                        )
                )
        );

        return likeRs.getLike();
    }

    /**
     * Retrieve the tinder access token in order to query the tinder api, given the facebook access token.
     *
     * @param facebookAccessToken
     * @return accessToken
     * @throws Exception
     */
    private String getAccessToken(String facebookAccessToken) throws Exception {
        HttpPostRequest rq = new AuthRequest(BASE_URL + AuthRequest.URI, facebookAccessToken);
        AuthResponse authRs = new AuthResponse(anonymousHttpClient.post(rq));

        return authRs.getToken();
    }
}
