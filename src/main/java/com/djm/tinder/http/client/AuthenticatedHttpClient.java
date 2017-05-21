package com.djm.tinder.http.client;

import com.djm.tinder.http.request.HttpGetRq;
import com.djm.tinder.http.request.HttpPostRq;
import com.djm.tinder.objects.Token;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthenticatedHttpClient implements HttpClient {
    private AnonymousHttpClient http;
    private Token token;

    public AuthenticatedHttpClient(AnonymousHttpClient http, Token token) {
        this.http = http;
        this.token = token;
    }

    public String get(HttpGetRq rq) throws IOException {
        Headers headersBuilder = Headers.of(buildHeaders());
        Request req = new Request.Builder()
                .url(rq.getUrl())
                .headers(headersBuilder)
                .build();
        Response res = http.getHttp().newCall(req).execute();
        return res.body().string();
    }

    public String post(HttpPostRq rq) throws IOException {
        RequestBody body = RequestBody.create(AnonymousHttpClient.JSON, rq.getBody());
        Headers headersBuild = Headers.of(buildHeaders());
        Request req = new Request.Builder()
                .url(rq.getUrl())
                .post(body)
                .headers(headersBuild)
                .build();
        Response res = http.getHttp().newCall(req).execute();
        return res.body().string();
    }

    private Map<String, String> buildHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "Tinder/6.9.1 (iPhone; iOS 10.2; Scale/2.00)");
        headers.put("X-Auth-Token", token.getToken());
        headers.put("Host", "api.gotinder.com");
        headers.put("Authorization", String.format("Token token=\"%s\"", token.getToken()));

        return headers;
    }
}
