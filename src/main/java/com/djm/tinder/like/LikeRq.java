package com.djm.tinder.like;

import com.djm.tinder.http.request.HttpGetRq;

public class LikeRq implements HttpGetRq {
    public static final String URI = "/like";

    private String url;
    private String userId;
    private String contentHash;
    private String userSNumber;

    public LikeRq(String url, String userId, String contentHash, String userSNumber) {
        this.url = url;
        this.userId = userId;
        this.contentHash = contentHash;
        this.userSNumber = userSNumber;
    }

    public String getUrl() {
        return String.format("%s/%s?content_hash=%s&s_number=%s", url, userId, contentHash, userSNumber);
    }
}
