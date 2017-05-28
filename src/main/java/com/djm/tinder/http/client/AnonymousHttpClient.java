package com.djm.tinder.http.client;

import com.djm.tinder.http.request.HttpGetRequest;
import com.djm.tinder.http.request.HttpPostRequest;
import okhttp3.*;

import java.io.IOException;

/**
 * @author Diego Mariani
 * @since 05-2017
 */
public class AnonymousHttpClient implements HttpClient {

    /**
     * Json, this is the content type we are gonna use
     */
    public static MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * Http client client we use, OkHttpClient
     */
    private OkHttpClient http;

    /**
     * @param http OkHttpClient
     */
    public AnonymousHttpClient(OkHttpClient http) {
        this.http = http;
    }

    /**
     * Used to create a post request. Accepts HttpPostRequest instance.
     * @param request
     * @return
     * @throws IOException
     */
    public String post(HttpPostRequest request) throws IOException {
        RequestBody body = RequestBody.create(JSON, request.getBody());
        Request finalRequest = new Request.Builder()
                .url(request.getUrl())
                .post(body)
                .build();
        Response response = http.newCall(finalRequest).execute();
        return response.body().string();
    }

    /**
     * Used to create a get request. Accepts HttpPostRequest instance.
     * @param request
     * @return
     * @throws IOException
     */
    public String get(HttpGetRequest request) throws IOException {
        Request finalRequest = new Request.Builder()
                .url(request.getUrl())
                .build();
        Response response = http.newCall(finalRequest).execute();
        return response.body().string();
    }

    /**
     * @return the okHttpClient
     */
    public OkHttpClient getHttp() {
        return http;
    }
}
