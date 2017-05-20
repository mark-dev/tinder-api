package com.djm.tinder.profile;

import com.djm.tinder.http.HttpGetRq;

public class ProfileRq implements HttpGetRq {
    public static final String URI = "/profile";

    private String url;

    public ProfileRq(String url) {
        this.url = url;
    }

    public String getUrl() {
       return url;
    }
}
