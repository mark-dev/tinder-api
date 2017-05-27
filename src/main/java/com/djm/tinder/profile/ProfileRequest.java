package com.djm.tinder.profile;

import com.djm.tinder.http.request.HttpGetRequest;

public class ProfileRequest implements HttpGetRequest {
    public static final String URI = "/profile";

    private String url;

    public ProfileRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
       return url;
    }
}
