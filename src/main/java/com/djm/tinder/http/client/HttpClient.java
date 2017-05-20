package com.djm.tinder.http.client;

import com.djm.tinder.http.request.HttpGetRq;
import com.djm.tinder.http.request.HttpPostRq;

import java.io.IOException;

public interface HttpClient {
    String post(HttpPostRq httpPostRq) throws IOException;
    String get(HttpGetRq httpGetRq) throws IOException;
}
