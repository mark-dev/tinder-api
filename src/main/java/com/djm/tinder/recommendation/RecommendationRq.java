package com.djm.tinder.recommendation;

import com.djm.tinder.http.request.HttpGetRq;

public class RecommendationRq implements HttpGetRq {
    public static final String URI = "/recs/core";

    private String url;

    public RecommendationRq(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
