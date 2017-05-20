package com.djm.tinder.http;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthHttpRq {
    private HttpRq httpRq;
    private String token;

    public AuthHttpRq(HttpRq httpRq, String token) {
        this.httpRq = httpRq;
        this.token = token;
    }

    public String get(HttpGetRq rq) throws IOException {
        Headers headersBuilder = Headers.of(buildHeaders());
        Request req = new Request.Builder()
                .url(rq.getUrl())
                .headers(headersBuilder)
                .build();
        Response res = httpRq.getHttp().newCall(req).execute();
        return res.body().string();
    }

    public String post(HttpPostRq rq) throws IOException {
        RequestBody body = RequestBody.create(HttpRq.JSON, rq.getBody());
        Headers headersBuild = Headers.of(buildHeaders());
        Request req = new Request.Builder()
                .url(rq.getUrl())
                .post(body)
                .headers(headersBuild)
                .build();
        Response res = httpRq.getHttp().newCall(req).execute();
        return res.body().string();
    }

    private Map<String, String> buildHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "Tinder/6.9.1 (iPhone; iOS 10.2; Scale/2.00)");
        headers.put("X-Auth-Token", token);
        headers.put("Host", "api.gotinder.com");
        headers.put("Authorization", String.format("Token token=\"%s\"", token));

        return headers;
    }
}
