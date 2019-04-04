package com.djm.tinder.pass;

import com.djm.tinder.http.request.HttpGetRequest;

public class PassRequest implements HttpGetRequest {
    public static final String URI = "/pass";

    private String url;
    private String userId;
    private String contentHash;
    private String userSNumber;

    public PassRequest(String url, String userId, String contentHash, String userSNumber) {
        this.url = url;
        this.userId = userId;
        this.contentHash = contentHash;
        this.userSNumber = userSNumber;
    }

    public String getUrl() {
        return String.format("%s/%s?content_hash=%s&s_number=%s", url, userId, contentHash, userSNumber);
    }
}
