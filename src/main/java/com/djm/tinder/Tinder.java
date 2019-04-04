package com.djm.tinder;

import com.djm.tinder.auth.AuthRequest;
import com.djm.tinder.auth.AuthResponse;
import com.djm.tinder.http.client.AnonymousHttpClient;
import com.djm.tinder.http.client.AuthenticatedHttpClient;
import com.djm.tinder.http.request.HttpPostRequest;
import com.djm.tinder.like.*;
import com.djm.tinder.match.Match;
import com.djm.tinder.match.MatchRequest;
import com.djm.tinder.match.MatchResponse;
import com.djm.tinder.pass.Pass;
import com.djm.tinder.pass.PassRequest;
import com.djm.tinder.pass.PassResponse;
import com.djm.tinder.profile.Profile;
import com.djm.tinder.profile.ProfileRequest;
import com.djm.tinder.profile.ProfileResponse;
import com.djm.tinder.recommendation.RecommendationRequest;
import com.djm.tinder.recommendation.RecommendationResponse;
import com.djm.tinder.user.User;
import okhttp3.OkHttpClient;

import java.util.ArrayList;

/**
 * @author Diego Mariani
 * @since 05-2017
 */
public class Tinder {

    /**
     * Base url for the tinder apis
     */
    public static final String BASE_URL = "https://api.gotinder.com";

    /**
     * Non authenticated http client.
     */
    private AnonymousHttpClient anonymousHttpClient;

    /**
     * Authenticated http client. Can performs http request to the private tinder api endpoints.
     */
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
        RecommendationResponse recommendationResponse = new RecommendationResponse(
                authenticatedHttpClient.get(
                        new RecommendationRequest(BASE_URL + RecommendationRequest.URI)
                )
        );
        return recommendationResponse.getRecommendations();
    }

    /**
     * Returns the user profile information and settings.
     *
     * @return Profile
     */
    public Profile getProfile() throws Exception {
        ProfileResponse profileResponse = new ProfileResponse(authenticatedHttpClient.get(new ProfileRequest(BASE_URL + ProfileRequest.URI)));
        return profileResponse.getProfile();
    }

    /**
     * Likes a given user and returns a Like object
     *
     * @param user
     * @return Like
     */
    public Like like(User user) throws Exception {
        LikeResponse likeResponse = new LikeResponse(
                authenticatedHttpClient.get(
                        new LikeRequest(
                                BASE_URL + LikeRequest.URI,
                                user.getId(),
                                user.getContentHash(),
                                user.getsNumber()
                        )
                )
        );
        return likeResponse.getLike();
    }

    public Like like(String userId, String contentHash, String sNumber) throws Exception {
        User u = constructUserForLikeRequest(userId, contentHash, sNumber);
        return like(u);
    }

    public SuperLikeResponse superLike(String userId) throws Exception {
        SuperLikeRequest req = new SuperLikeRequest(BASE_URL + SuperLikeRequest.URI, userId);
        return new SuperLikeResponse(authenticatedHttpClient.post(req));
    }

    public Pass pass(User user) throws Exception {
        String response = authenticatedHttpClient.get(
                new PassRequest(
                        BASE_URL + PassRequest.URI,
                        user.getId(),
                        user.getContentHash(),
                        user.getsNumber())
        );
        PassResponse pr = new PassResponse(response);
        return pr.getPass();
    }

    public Pass pass(String userId, String contentHash, String sNumber) throws Exception {
        User u = constructUserForLikeRequest(userId, contentHash, sNumber);
        return pass(u);
    }

    /**
     * Return my tinder matches available until now as an array list
     *
     * @return my tinder matches
     * @throws Exception
     */
    public ArrayList<Match> getMatches() throws Exception {
        MatchResponse matchResponse = new MatchResponse(
                authenticatedHttpClient.post(new MatchRequest(BASE_URL + MatchRequest.URI))
        );
        return matchResponse.getMatches();
    }

    /**
     * Retrieve the tinder access token in order to query the tinder api, given the facebook access token.
     *
     * @param facebookAccessToken
     * @return accessToken
     * @throws Exception
     */
    private String getAccessToken(String facebookAccessToken) throws Exception {
        HttpPostRequest request = new AuthRequest(BASE_URL + AuthRequest.URI, facebookAccessToken);
        AuthResponse authResponse = new AuthResponse(anonymousHttpClient.post(request));
        return authResponse.getToken();
    }

    private User constructUserForLikeRequest(String userId, String contenthash, String sNumber) {
        User u = User.Builder();
        u.setId(userId);
        u.setContentHash(contenthash);
        u.setsNumber(sNumber);

        return u;
    }
}
