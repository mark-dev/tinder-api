package com.djm.tinder.http;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpRq {

    public static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient http;

    public HttpRq(OkHttpClient http) {
        this.http = http;
    }

    public String post(HttpPostRq rq) throws IOException {
        RequestBody body = RequestBody.create(JSON, rq.getBody());
        Request req = new Request.Builder()
                .url(rq.getUrl())
                .post(body)
                .build();
        Response res = http.newCall(req).execute();
        return res.body().string();
    }

    public OkHttpClient getHttp() {
        return http;
    }
}
