package com.djm.tinder.recommendation;

import com.djm.tinder.objects.RecResponse;
import com.google.gson.Gson;
import java.util.List;

public class RecommendationRs {
    private String response;
    private Gson gson = new Gson();

    public RecommendationRs(String res) {
        response = res;
    }

    public List<Recommendation> getRecommendations() throws Exception {
        RecResponse result = gson.fromJson(response, RecResponse.class);
        return result.getResults();
    }
}
