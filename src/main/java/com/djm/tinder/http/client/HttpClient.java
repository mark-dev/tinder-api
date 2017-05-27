package com.djm.tinder.http.client;

import com.djm.tinder.http.request.HttpGetRequest;
import com.djm.tinder.http.request.HttpPostRequest;

import java.io.IOException;

public interface HttpClient {
    String post(HttpPostRequest httpPostRq) throws IOException;
    String get(HttpGetRequest httpGetRq) throws IOException;
}
