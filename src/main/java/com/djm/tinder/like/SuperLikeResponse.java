package com.djm.tinder.like;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.time.Instant;
import java.util.Map;

public class SuperLikeResponse {

    private JSONParser parser;
    private String response;

    public SuperLikeResponse(String res) {
        response = res;
        parser = new JSONParser();
    }

    public SuperLike getSuperLike() throws Exception {

        JSONObject jsonObject = (JSONObject) parser.parse(response);
        SuperLike superLike = new SuperLike();
        Long status = (Long) jsonObject.get("status");
        if (status == null) {
            status = 200L;
        }
        superLike.setStatus(status.intValue());

        Boolean limitExceeded = (Boolean) jsonObject.get("limit_exceeded");
        if (limitExceeded != null) {
            superLike.setLimitExceeded(limitExceeded);
        } else {
            superLike.setLimitExceeded(false);
        }

        Object match = jsonObject.get("match");

        boolean isMatch = false;
        if (match != null) {
            isMatch = match instanceof Boolean ? (Boolean) match : true;
        }
        superLike.setMatch(isMatch);

        Object supedLikesInfo = jsonObject.get("super_likes");
        if (supedLikesInfo instanceof Map) {
            Map sli = (Map) supedLikesInfo;
            String resetTs = (String) sli.get("resets_at");
            if (resetTs != null) {
                Instant resetAt = Instant.parse(resetTs);
                superLike.setResetAt(resetAt);
            }
        }

        return superLike;
    }

}
