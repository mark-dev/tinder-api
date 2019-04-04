package com.djm.tinder.like;

import com.djm.tinder.http.request.HttpPostRequest;

public class SuperLikeRequest implements HttpPostRequest {
    public static final String URI = "/like/%s/super";
    private final String url;
    private final String userId;

    public SuperLikeRequest(String url, String userId) {
        this.url = url;
        this.userId = userId;
    }

    @Override
    public String getUrl() {
        return String.format(url, userId);
    }

    @Override
    public String getBody() {
        return new String(new byte[]{});
    }
}
