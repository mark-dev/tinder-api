package djm.tinder.http;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpRq {

    public static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient http;
    private String token;

    public HttpRq(OkHttpClient http, String token) {
        this.http = http;
        this.token = token;
    }

    public String get(HttpGetRq rq) throws IOException {
        Headers headersBuilder = Headers.of(buildHeaders());
        Request req = new Request.Builder()
                .url(rq.getUrl())
                .headers(headersBuilder)
                .build();
        Response res = http.newCall(req).execute();
        return res.body().string();
    }

    public String post(HttpPostRq rq) throws IOException {
        RequestBody body = RequestBody.create(JSON, rq.getBody());
        Headers headersBuild = Headers.of(buildHeaders());
        Request req = new Request.Builder()
                .url(rq.getUrl())
                .post(body)
                .headers(headersBuild)
                .build();
        Response res = http.newCall(req).execute();
        return res.body().string();
    }

    public String anonPost(HttpPostRq rq) throws IOException {
        RequestBody body = RequestBody.create(JSON, rq.getBody());
        Request req = new Request.Builder()
                .url(rq.getUrl())
                .post(body)
                .build();
        Response res = http.newCall(req).execute();
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
