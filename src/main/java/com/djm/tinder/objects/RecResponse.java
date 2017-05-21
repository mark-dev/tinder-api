package com.djm.tinder.objects;

import com.djm.tinder.recommendation.Recommendation;

import java.util.List;

/**
 * Created by lorenzo on 5/21/17.
 */
public class RecResponse {
    private List<Recommendation> results;

    public RecResponse(List<Recommendation> results) {
        this.results = results;
    }

    public List<Recommendation> getResults() {
        return results;
    }
}
