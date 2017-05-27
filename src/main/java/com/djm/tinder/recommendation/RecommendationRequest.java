package com.djm.tinder.recommendation;

import com.djm.tinder.http.request.HttpGetRequest;

public class RecommendationRequest implements HttpGetRequest {
    public static final String URI = "/recs/core";

    private String url;

    public RecommendationRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
