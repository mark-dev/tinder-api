package djm.tinder.recommendation;

import djm.tinder.http.HttpGetRq;

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
